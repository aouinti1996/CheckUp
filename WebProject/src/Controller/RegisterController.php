<?php

namespace App\Controller;

use App\Entity\Classroom;
use App\Entity\User;
use App\Form\ClassroomType;
use App\Form\PatientType;
use App\Form\RegisterType;
use App\Repository\userRepository;
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
    public function index(Request $request, userRepository $rep)
    {
        $notification="";

        $role="";
        $user=new User();
        $form=$this->createForm(RegisterType::class,$user);
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
            if ($user_find==true){  $notification="failed authentification ";
            }
            //elseif  ($user_find==false){ $notification="success authentification ";}


elseif ($user_find==false){

            $em=$this->getDoctrine()->getManager();
            $em->persist($user);
            echo '*******'.$user->getEmail();
            $em->flush();

           //return $this->redirectToRoute('affichetabmedecin');
   $notification="success authentification ";
           // ;


        }


        }




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

    /**

     * @Route("/update/{id}",name="updateuser")

     */
    public function update(userRepository $repository, $id, Request $request){
        $patient=$repository->find($id);
        $form=$this->createForm(RegisterType::class,$patient);
        //$form->add('update',SubmitType::class);
        $form->handleRequest($request);
        if($form->isSubmitted() && $form->isValid()){
            $em=$this->getDoctrine()->getManager();

            $em->persist($patient);

            $em->flush();
            return $this->redirectToRoute('affichetabpatient');

        }
        return $this->render('register/inscription.html.twig',['form'=>$form->createView()]);

    }

}
