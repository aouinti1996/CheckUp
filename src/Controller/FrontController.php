<?php

namespace App\Controller;

use App\Repository\userRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\PieChart;

class FrontController extends AbstractController
{
    /**
     * @Route("/", name="front")
     */
    public function index(): Response
    {
        return $this->render('front/index.html.twig', [
            'controller_name' => 'FrontController',
        ]);
    }

    /**
     * @Route("/front/auth", name="authentification")
     */
    public function auth(): Response
    {

        return $this->render('front/auth.html.twig', [
            'controller_name' => 'FrontController',
        ]);
    }


    /**
     * @return Response
     * @Route("/formsignup", name="inscriptionup")
     */
    public function getrouteForm()
    {

        return $this->render('register/inscription.html.twig', [
            'controller_name' => 'RegisterController',
        ]);


    }



}
