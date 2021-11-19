<?php

namespace App\Controller;

use App\Entity\RendezVous;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class AdminController extends AbstractController
{
    /**
     * @Route("/admin", name="admin")
     */
    public function index(): Response
    {
        #$entityManager = $this->getDoctrine()->getManager();

        return $this->render('back/base.html.twig', [
            'controller_name' => 'AdminController',
        ]);
    }
}
