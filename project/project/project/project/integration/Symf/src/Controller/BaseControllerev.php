<?php

namespace App\Controller;

use App\Entity\Commentaire;
use App\Entity\Evenement;
use App\Form\CommentaireType;
use App\Repository\EvenementRepository;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class BaseControllerev extends AbstractController
{
    /**
     * @Route("/baseevent", name="evenement_index")
     */
    public function index(EvenementRepository $repo, PaginatorInterface $paginator, Request $request): Response
    {
        $evenements = $repo->findAll();

        $paginatorProduits=$paginator->paginate(
            $evenements,
            /* query NOT result */
            $request->query->getInt('page', 1), /*numero de page en cours 1 par défaut*/
            3 /*limit per page*/
        );

        return $this->render('front/base.html.twig', [
            'evenements' => $evenements, "paginator"=>$paginatorProduits
        ]);
    }



}
