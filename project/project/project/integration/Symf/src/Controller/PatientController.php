<?php

namespace App\Controller;

use App\Entity\Classroom;
use App\Entity\Student;
use App\Entity\User;
use App\Form\ActiviteFormType;
use App\Form\ClassroomType;
use App\Form\PatientType;
use App\Form\StudentType;
use App\Repository\ActiviteRepository;
use App\Repository\UserRepository;
use App\Security\LoginAuthentificationAuthenticator;
use ContainerDugz0c7\PaginatorInterface_82dac15;

use Doctrine\ORM\EntityManagerInterface;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;
use Symfony\Component\Security\Guard\GuardAuthenticatorHandler;


class PatientController extends AbstractController
{
    /**
     * @Route("/patient", name="patient")
     */
    public function index(): Response
    {
        return $this->render('patient/tabpatient.html.twig', [
            'controller_name' => 'PatientController',
        ]);
    }
    /**
     * @Route("/patient/tabpatient", name="affichetabpatient")
     */
    public function afficherPatients(Request $req,PaginatorInterface $paginator,UserRepository $userrep): Response
    {
        $data=$req->get('search');
        $data=$userrep->findBySearch($data);


        $listepatients=$this->getDoctrine()->getRepository(User::class)->findBy(['role'=>'patient']);
        $listepatients=$paginator->paginate($data,$req->query->getInt('page',1),10);

        //on pasee le numero page dont il se trouve
        return $this->render('patient/tabpatient.html.twig', [
            'tabpatients' => $listepatients,
        ]);
    }


    /**
     * @param $id
     * @param ActiviteRepository $repository
     * @return \Symfony\Component\HttpFoundation\RedirectResponse
     * @Route("/patient/supp/{id}", name ="deletepatient")
     */
    public function delete($id, UserRepository $repository){


        $patient=$repository->find($id);
        $am=$this->getDoctrine()->getManager();
        $am->remove($patient);
        $am->flush();
        return $this->redirectToRoute("affichetabpatient");



    }
    /**

     * @Route("patient/update/{id}",name="updatepatient")

     */

    public function update(userRepository $repository, $id, Request $request){
        $patient=$repository->find($id);
        $form=$this->createForm(PatientType::class,$patient);
        //$form->add('update',SubmitType::class);
        $form->handleRequest($request);
        if($form->isSubmitted() && $form->isValid()){
            $em=$this->getDoctrine()->getManager();

            $em->persist($patient);

            $em->flush();
            return $this->redirectToRoute('affichetabpatient');

        }
        return $this->render('patient/updatepatient.html.twig',['form'=>$form->createView()]);

    }
    /**
     * @param Request $request
     * @return Response
     * @Route ("/patient/addpatient",name="Adminaddpatient")
     */
    function Ajouter(Request $request,UserPasswordEncoderInterface $userPasswordEncoder, GuardAuthenticatorHandler $guardHandler, LoginAuthentificationAuthenticator $authenticator, EntityManagerInterface $em): Response
    {
        $user=new User();
        $patient=new User();
        $formulaire=$this->createForm(PatientType::class,$patient);
        //$formulaire->add('Ajouter',SubmitType::class);
        $formulaire->handleRequest($request);
        if($formulaire->isSubmitted() && $formulaire->isValid()){
            $user_find=$this->getDoctrine()->getRepository(User::class)->findBy(['email'=>$patient->getEmail()]);
            if ($user_find==true){ echo 'failed authentification';
            }
            else{
                $user->setPassword(
                    $userPasswordEncoder->encodePassword(
                        $user,
                        $formulaire->get('password')->getData()
                    )
                );
            $em=$this->getDoctrine()->getManager();
            $patient->setSpecialite("");
            $patient->setRole("patient");
            $em->persist($patient);
            $em->flush();


            return $this->redirectToRoute('affichetabpatient');
        }}
        return $this->render('patient/addpatient.html.twig',
            ['form'=>$formulaire->createView()]);

    }


    /**
     * @param Request $req
     * @param userRepository $userrep
     * @return Response
     * @Route("/patient/serach" , name="seraching")
     */

    /*public function search (Request  $req,userRepository $userrep)
    {

        $data=$req->get('search');



        $listepatients=$userrep->findBySearch($data);
        return $this->render('patient/tabpatient.html.twig', [
            'tabpatients' => $listepatients,
        ]);

    }*/

    /**
     * @param Request $req
     * @param userRepository $userrep
     * @return Response
     * @Route("/trier" , name="trierpatient")
     */
   /*public function Trier (Request  $req,userRepository $userrep)
    {

        $data=$req->get('choix_trie');



        $listepatients=$userrep->findBytrier($data);
        return $this->render('patient/tabpatient.html.twig', [
            'tabpatients' => $listepatients,
        ]);

    }*/

    public function Trier (Request $req,PaginatorInterface $paginator,UserRepository $userrep): Response
    {

        $data = $req->get('choix_trie');
        $listepatients = $userrep->findBytrier($data);

        $listepatients = $this->getDoctrine()->getRepository(User::class)->findBy(['role' => 'patient']);
        $listepatients = $paginator->paginate($data, $req->query->getInt('page', 1), 10);

        //on pasee le numero page dont il se trouve
       return $this->redirectToRoute('affichetabpatient');


    }

}
