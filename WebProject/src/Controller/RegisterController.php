<?php

namespace App\Controller;

use App\Entity\Classroom;
use App\Entity\User;
use App\Form\ClassroomType;
use App\Form\PatientType;
use App\Form\RegisterType;
use App\Repository\UserRepository;
use phpDocumentor\Reflection\Types\Boolean;
use phpDocumentor\Reflection\Types\Null_;
use phpDocumentor\Reflection\Types\True_;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\SubmitButton;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class RegisterController extends AbstractController

{

    /**
     * @Route("/register", name="inscription")
     */
    public function index(Request $request,UserRepository $rep)
    {  $notification=Null;

        $role="";
        $user=new User();
        $form=$this->createForm(RegisterType::class,$user);
        $form->add('Enregistrer',SubmitType::class);
        //$role=$this->getDoctrine()->getRepository(User::class)->findOneByEmail($user);
        // return $this->render("Classroom/add.html.twig",array('f'=>$form->createview()));
       // $form = $request->request->get('form');
        //$name = $form('role');
        //$role=$Request->get(key:'role');
        $user->setRole("patient");
        $user->setSpecialite(" ");
        $form->handlerequest($request);
        if ($form->isSubmitted()&& $form->isValid()){
           /* $user=$form->getData();
            //$user_find=$this->getDoctrine()->getRepository(User::class)->findOneByEmail($user);*/
            $user_find=$this->getDoctrine()->getRepository(User::class)->findBy(['email'=>$user->getEmail()]);
            if ($user_find==true){  echo '***';}
else{

            $em=$this->getDoctrine()->getManager();
            $em->persist($user);
            echo '*******'.$user->getEmail();
            $em->flush();
            //$notification="succes";
            return $this->redirectToRoute('affichetabmedecin');
           // ;

        }$notification=" sucess authentification";}




        return $this->render("register/inscription.html.twig",array('form'=>$form->createView(),'notification'=>$notification,'role'=>$role));

    }

    /**
     * @return Response
     * @Route("/formsignup", name="inscriptionup")
     */
    public function GetForm():Response
    {

        return $this->render('register/inscription.html.twig', [
            'controller_name' => 'RegisterController',
        ]);


    }
}
