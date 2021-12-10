<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class BacklogController extends AbstractController
{
    /**
     * @Route("/backlog", name="backlog")
     */
    public function index(): Response
    {
        return $this->render('Back/Back.html.twig', [
            'controller_name' => 'BacklogController',
        ]);
    }
}
