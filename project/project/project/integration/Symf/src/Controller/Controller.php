<?php

namespace App\Controller;

use App\Entity\User;
use App\Repository\UserRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Security\Http\Authentication\AuthenticationUtils;

class Controller extends AbstractController
{
    /**
     * @Route("/profil", name="profil")
     */
    public function index(AuthenticationUtils $authenticationUtils,UserRepository $repository,UserRepository  $rep): Response
    {
        $user = $this->getUser();
        if($user!=null)
       // $user1= $rep->findBy(['email'=>'asma@gmail.com']);
        {
            $error = $authenticationUtils->getLastAuthenticationError();
            // last username entered by the user
            $lastUsername = $authenticationUtils->getLastUsername();


            return $this->render('regestration/index.html.twig', ['last_username' => $lastUsername, 'error' => $error, 'user' => $user]);
        }
        else
            return $this->redirectToRoute('app_login');
    }
    /**
     * @Route("/", name="front")
     */
    public function index_(): Response
    {
        return $this->render('front/front.html.twig', [
            'controller_name' => 'FrontController',
        ]);
    }
}
