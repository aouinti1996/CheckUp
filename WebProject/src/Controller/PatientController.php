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
use App\Repository\userRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

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
    public function afficherPatients(userRepository $rep): Response
    {
  // $listepatients=$rep->findAll();
        $listepatients=$rep->findBy(['role'=>'patient']);
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
    public function delete($id, userRepository $repository){


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
     * @Route ("/patient/addpatient",name="addpatient")
     */
    function Ajouter(Request $request){
        $patient=new User();
        $formulaire=$this->createForm(PatientType::class,$patient);
        //$formulaire->add('Ajouter',SubmitType::class);
        $formulaire->handleRequest($request);
        if($formulaire->isSubmitted() && $formulaire->isValid()){
            $user_find=$this->getDoctrine()->getRepository(User::class)->findBy(['email'=>$patient->getEmail()]);
            if ($user_find==true){ echo 'failed authentification';
            }
            else{
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


}
