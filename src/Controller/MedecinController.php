<?php

namespace App\Controller;

use App\Entity\User;
use App\Form\MedecinType;
use App\Form\PatientType;
use App\Repository\MedecinRepository;

use App\Repository\ActiviteRepository;
use App\Repository\userRepository;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class MedecinController extends AbstractController
{
    /**
     * @Route("/medecin", name="medecin")
     */
    public function index( userRepository $rep): Response
    {
        // $listepatients=$rep->findAll();
        $listemedecins=$rep->findBy(['role'=>'medecin']);
        return $this->render('medecin/tabmedecin.html.twig', [
            'tabmedecins' => $listemedecins,
        ]);
    }
    /**
     * @Route("/medecin/tabmedecin", name="affichetabmedecin")
     */
    public function afficherMedecins(Request $req,PaginatorInterface $paginator): Response
    {
        $data=$this->getDoctrine()->getRepository(User::class)->findBy(['role'=>'medecin']);
        $listemedecins=$paginator->paginate($data,$req->query->getInt('page',1),4);
        return $this->render('medecin/tabmedecin.html.twig', [
            'tabmedecins' => $listemedecins,
        ]);
    }
    /**
     * @Route("/listmedecins", name="addmedecin")
     */
public function listmedecin()
{
    $medecin=$this->getDoctrine()
    ->getRepository(User::class)
        ->findAll();
    return $this->render('medecin/addmedecin.html.twig',array("form"=>$medecin));
}

    /**
     * @param $id
     * @param ActiviteRepository $repository
     * @return \Symfony\Component\HttpFoundation\RedirectResponse
     * @Route("/medecin/supp/{id}", name ="deletemedecin")
     */
    public function delete($id, userRepository $repository){


        $patient=$repository->find($id);
        $am=$this->getDoctrine()->getManager();
        $am->remove($patient);
        $am->flush();
        return $this->redirectToRoute("affichetabmedecin");



    }
    /**

     * @Route("medecin/update/{id}",name="updatemedecin")

     */

    public function update(userRepository $repository, $id, Request $request){
        $medecin=$repository->find($id);
        $form=$this->createForm(MedecinType::class,$medecin);
        //$form->add('update',SubmitType::class);
        $form->handleRequest($request);
        if($form->isSubmitted() && $form->isValid()){
            $em=$this->getDoctrine()->getManager();

            $em->persist($medecin);

            $em->flush();
            return $this->redirectToRoute('affichetabmedecin');

        }
        return $this->render('medecin/updatemedecin.html.twig',['form'=>$form->createView()]);

    }


    /**
     * @param Request $request
     * @return Response
     * @Route ("/medecin/addmedecin",name="addmedecin")
     */
    function Ajouter(Request $request){
        $medecin=new User();
        $formulaire=$this->createForm(MedecinType::class,$medecin);
        $formulaire->handleRequest($request);
        if($formulaire->isSubmitted() && $formulaire->isValid()){
            $user_find=$this->getDoctrine()->getRepository(User::class)->findBy(['email'=>$medecin->getEmail()]);
            if ($user_find==true){ echo 'failed authentification';
            }
            else{
            $em=$this->getDoctrine()->getManager();

           $medecin->setRole("medecin");
            $em->persist($medecin);
            $em->flush();
            return $this->redirectToRoute('affichetabmedecin');
        }}
        return $this->render('medecin/addmedecin.html.twig',
            ['form'=>$formulaire->createView()]);



}}
