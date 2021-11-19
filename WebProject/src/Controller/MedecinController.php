<?php

namespace App\Controller;

use App\Entity\User;
use App\Repository\MedecinRepository;
use App\Repository\UserRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class MedecinController extends AbstractController
{
    /**
     * @Route("/medecin", name="medecin")
     */
    public function index(): Response
    {
        return $this->render('medecin/inscription.html.twig', [
            'controller_name' => 'MedecinController',
        ]);
    }
    /**
     * @Route("/medecin/tabmedecin", name="affichetabmedecin")
     */
    public function afficherMedecins(UserRepository $rep): Response
    {
        // $listepatients=$rep->findAll();
        $listemedecins=$rep->findBy(['role'=>'medecin']);
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
}
