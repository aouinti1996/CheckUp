<?php

namespace App\Controller;
use App\Entity\User;
use App\Form\ResetPassType;
use App\Form\UserFormType;
use App\Form\UserMFormType;
use App\Repository\UserRepository;
use App\Security\LoginAuthentificationAuthenticator;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Routing\Generator\UrlGeneratorInterface;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;
use Symfony\Component\Security\Csrf\TokenGenerator\TokenGeneratorInterface;
use Symfony\Component\Security\Guard\GuardAuthenticatorHandler;
use Symfony\Component\Security\Http\Authentication\AuthenticationUtils;

class UserController extends AbstractController
{
    /**
     * @Route("/user", name="user")
     */
    public function index(): Response
    {
        return $this->render('user/index.html.twig', [
            'controller_name' => 'UserController',
        ]);
    }

    /**
     * @param $id
     * @param UserRepository $rep
     * @param Request $request
     * @return Response
     * @throws \Exception
     * @Route("/user/update/{id}" , name="updateprofil")
     */
    public function updateprofil($id, UserRepository $rep, Request $request)
    {

        $user = $this->getDoctrine()->getRepository(User::class)->find($id);
        //var_dump($user);
        $nom = $request->get('name');
        $prenom = $request->get('prenom');
        $datenaissance = $request->get('datenaissance');
        //$email= $request->get('email');
        $numerotelephone = $request->get('numerotelephone');
        $adresse = $request->get('adresse');
        //var_dump($datenaissance);
        $datefinal = new \DateTime($datenaissance . "00:00:00");
        $error = "";

        $user->setNom($nom);
        $user->setPrenom($prenom);
        $user->setDatenaissance($datefinal);
        // $user->setEmail($email);
        $user->setNumerotelephone($numerotelephone);
        $user->setAdresse($adresse);

        if ($user->getRole() == "medecin") {
            $specialite = $request->get('specialite');
            $user->setSpecialite($specialite);

        }
        //var_dump($user->getNom());
        if ($request->getMethod() == Request::METHOD_POST) {
            $error = "Update with Success";
            $em = $this->getDoctrine()->getManager();
            $em->flush();
            return $this->redirectToRoute('front');
        }
        return $this->render('regestration/index.html.twig', [
            'name' => 'UserController',
            'error' => $error,'user' => $user
        ]);


        //  return $this->render('regestration/index.html.twig', ['last_username' => $lastUsername, 'error' => $error, 'user' => $user]);


    }

    /**
     * @param UserRepository $rep
     * @param Request $request
     * @param \Swift_Mailer $mailer
     * @return Response
     * @Route( "/sendmailmethod" , name="sendmail")
     */
    public function sendmail(UserRepository $rep, Request $request, \Swift_Mailer $mailer)
    {

        $mailler = $request->get('emailforget');
        // $message=$request->get('mailforget');
        $userfinal = $rep->findBy(['email' => $mailler]);
        $userutilise = $rep->findOneByEmail($mailler);
        // $input = 'Sending Mail!';
        //$this->addFlash('success', 'sending Mail!');

        if ($userutilise != null) {

            // $input = 'mail forget';
            // $this->addFlash('success', 'mail forget!');

            $pwd = $userutilise->getPassword();

            $message = (new \Swift_Message('Welcome! Check Your Password'));
//ajouter une image dans le mail
            $img = $message->embed(\Swift_Image::fromPath('images/bg-01.jpg'));
            $message->setFrom('douiri.arwa1998@gmail.com')->setTo($mailler)
//message simple
                ->setBody('Your Password is : ' . $pwd, 'text/html');
            $mailer->send($message);
            $this->addFlash('info', 'Sending Mail Success');
            //return $this->redirectToRoute('sendmail');
            $request->setMethod('mailforget', 'Sending Mail!');
            //$input= $request->get('mailforget');

        }
        return $this->render('security/forgetpwd.html.twig');


    }





    /**
     * @Route("/user/add", name="addpatient")
     */
    public function addUser(Request $request ,UserPasswordEncoderInterface $userPasswordEncoder, GuardAuthenticatorHandler $guardHandler, LoginAuthentificationAuthenticator $authenticator, EntityManagerInterface $em): Response

    {
        $user=new User();
        $notification='';
        $formulaire=$this->createForm(UserFormType::class,$user);
        //$formulaire->add('Ajouter',SubmitType::class);
        $formulaire->handleRequest($request);
        if($formulaire->isSubmitted() && $formulaire->isValid()) {
            $user->setPassword(
                $userPasswordEncoder->encodePassword(
                    $user,
                    $formulaire->get('password')->getData()
                )
            );
            $user->setActivationToken(md5(uniqid()));

            $user_find = $this->getDoctrine()->getRepository(User::class)->findBy(['email' => $user->getEmail()]);
            if ($user_find == true) {
                $this->addFlash('success', 'failed patient  exist!');

            } else {
                //$user->setActivationToken(md5(uniqid()));
                $em = $this->getDoctrine()->getManager();
                $user->setSpecialite("Null");
                $user->setRole("patient");
                $em->persist($user);
                $em->flush();
                $message = (new \Swift_Message('Nouveau compte'))
                    // On attribue l'expéditeur
                    ->setFrom('votre@adresse.fr')
                    // On attribue le destinataire
                    ->setTo($user->getEmail())
                    // On crée le texte avec la vue
                    ->setBody(
                        $this->renderView(
                            'registration/activation.html.twig', ['token' => $user->getActivationToken()]
                        ),
                        'text/html'
                    )
                ;
                $mailer->send($message);
                return $guardHandler->authenticateUserAndHandleSuccess(
                    $user,
                    $request,
                    $authenticator,
                    'main' // firewall name in security.yaml
                );
                $this->addFlash('success', 'patient created with sucess!');
                return $this->redirectToRoute('app_login');

            }

        }

        return $this->render('regestration/inscriptionProfil.html.twig', array('form' => $formulaire->createView()));
    }
    /**
     * @Route("/userM/add", name="addmedecin")
     *
     */
    public function addUserM(Request $request,UserPasswordEncoderInterface $userPasswordEncoder, GuardAuthenticatorHandler $guardHandler, LoginAuthentificationAuthenticator $authenticator, EntityManagerInterface $em): Response
    {
        $user=new User();
        $formulaire=$this->createForm(UserMFormType::class,$user);
        //$formulaire->add('Ajouter',SubmitType::class);
        $formulaire->handleRequest($request);
        if($formulaire->isSubmitted() && $formulaire->isValid()){
            $user->setPassword(
                $userPasswordEncoder->encodePassword(
                    $user,
                    $formulaire->get('password')->getData()
                )
            );
            $user_find=$this->getDoctrine()->getRepository(User::class)->findBy(['email'=>$user->getEmail()]);
            if ($user_find==true){
                $this->addFlash('failed inscription', 'medecin  exist!');
            }
            else{
                $em=$this->getDoctrine()->getManager();

                $user->setRole("medecin");
                $em->persist($user);
                $em->flush();
                return $guardHandler->authenticateUserAndHandleSuccess(
                    $user,
                    $request,
                    $authenticator,
                    'main' // firewall name in security.yaml
                );

            }return $this->redirectToRoute('app_login');}

        return $this->render('regestration/inscriptionM.html.twig', [
            'form' => $formulaire->createView(),

        ]);

    }



    /**
     * @route("/activation/{token}",name="activation")
     */
    public function activation ($token,UserRepository $userrep){
        //on verifie si un utilisateur a ce token

        $user=$userrep->findOneBy(['activation_token'=>$token]);
        if(!$user){
            throw $this->createNotFoundException('cet utilisateur  n\'existe pas');
        }

//on supprime le token
        $user->setActivationToken(null);
        $entityManager=$this->getDoctrine()->getManager();
        $entityManager->persist($user);
        $entityManager->flush();
        //on envoi un message flash
        $this->addFlash('messsage','vous avez bien activer votre compte');
        //on retour a l'acceuil
        return  $this->redirectToRoute('app_login');
    }

    /**
     * @Route("/reset_pass/{token}", name="app_reset_password")
     */

  public function resetPassword(Request $request, string $token, UserPasswordEncoderInterface $passwordEncoder)
  {
// On cherche un utilisateur avec le token donné
      $user = $this->getDoctrine()->getRepository(User::class)->findOneBy(['reset_token' => $token]);
      $error=null;
      $last_username=null;
      // Si l'utilisateur n'existe pas
      if ($user === null) {
          // On affiche une erreur
          $this->addFlash('danger', 'Token Inconnu');
          return $this->redirectToRoute('app_login');
      }

      // Si le formulaire est envoyé en méthode post
      if ($request->isMethod('POST')) {
          // On supprime le token
          $user->setResetToken(null);

          // On chiffre le mot de passe
          $user->setPassword($passwordEncoder->encodePassword($user, $request->request->get('password')));

          // On stocke
          $entityManager = $this->getDoctrine()->getManager();
          $entityManager->persist($user);
          $entityManager->flush();

          // On crée le message flash
          $this->addFlash('message', 'Mot de passe mis à jour');

          // On redirige vers la page de connexion
          return $this->redirectToRoute('app_login');
      }else {
          // Si on n'a pas reçu les données, on affiche le formulaire
          return $this->render('security/resetPassword.html.twig', ['token' => $token,'error'=>$error,'last_username'=>$last_username]);
      }

  }
/////////////////////////////
    /**
     * @Route("/oubli-pass", name="app_forgotten_password")
     */
    public function oubliPass(Request $request, UserRepository $users, \Swift_Mailer $mailer, TokenGeneratorInterface $tokenGenerator
    ): Response
    {
        $user=new User();

        // On initialise le formulaire
        $form = $this->createForm(ResetPassType::class);

        // On traite le formulaire
        $form->handleRequest($request);

        // Si le formulaire est valide
        if ($form->isSubmitted() && $form->isValid()) {
            // On récupère les données
            echo '*****';

            $donnees = $form->getData();

            // On cherche un utilisateur ayant cet e-mail
            $user = $users->findOneByEmail($donnees['Email']);
            var_dump($user);
            // Si l'utilisateur n'existe pas
            if ($user === null) {
                echo '********';
                // On envoie une alerte disant que l'adresse e-mail est inconnue
                $this->addFlash('danger', 'Cette adresse e-mail est inconnue');

                // On retourne sur la page de connexion
                return $this->redirectToRoute('app_login');
            }

            // On génère un token
            $token = $tokenGenerator->generateToken();
            echo 'true';
            // On essaie d'écrire le token en base de données
            try {
                $user->setResetToken($token);
                $entityManager = $this->getDoctrine()->getManager();
                $entityManager->persist($user);
                $entityManager->flush();
            } catch (\Exception $e) {
                $this->addFlash('warning', $e->getMessage());
                return $this->redirectToRoute('app_login');
            }
            // On génère l'URL de réinitialisation de mot de passe
            $url = $this->generateUrl('app_reset_password', array('token' => $token), UrlGeneratorInterface::ABSOLUTE_URL);

            // On génère l'e-mail
            $message = (new \Swift_Message('Mot de passe oublié'))
                ->setFrom('votre@adresse.fr')
                ->setTo($user->getEmail())
                ->setBody(
                    "Bonjour,<br><br>Une demande de réinitialisation de mot de passe a été effectuée pour le site Nouvelle-Techno.fr. Veuillez cliquer sur le lien suivant : " . $url,
                    'text/html'
                )
            ;

            // On envoie l'e-mail
            $mailer->send($message);

            // On crée le message flash de confirmation
            $this->addFlash('message', 'E-mail de réinitialisation du mot de passe envoyé !');

            // On redirige vers la page de login
            return $this->redirectToRoute('app_login');
        }

        // On envoie le formulaire à la vue
        return $this->render('security/forgotten_password.html.twig',['emailForm' => $form->createView()]);
    }

}
