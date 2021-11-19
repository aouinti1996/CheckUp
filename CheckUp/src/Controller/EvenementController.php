<?php

namespace App\Controller;

use App\Entity\Evenement;
use App\Form\EvenementType;
use App\Repository\EvenementRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/evenement")
 */
class EvenementController extends AbstractController
{
//    /**
//     * @Route("/", name="evenement_index", methods={"GET"})
//     */
//    public function index(): Response
//    {
//        $evenements = $this->getDoctrine()
//            ->getRepository(Evenement::class)
//            ->findAll();
//
//        return $this->render('front/base.html.twig', [
//            'evenements' => $evenements,
//        ]);
//    }

    /**
     * @Route("/new", name="evenement_new", methods={"GET","POST"})
     */
    public function new(Request $request)
    {
        $evenement = new Evenement();
        $form = $this->createForm(EvenementType::class, $evenement);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($evenement);
            $entityManager->flush();

            return $this->redirectToRoute('evenement_index');
        }

        return $this->render('evenement/new.html.twig', [
            'evenement' => $evenement,
            'form' => $form->createView(),
        ]);
    }

//    /**
//     * @Route("/{ideven}", name="evenement_show", methods={"GET"})
//     */
//    public function show(EvenementRepository $repo, $ideven): Response
//    {
//        $evenement = $repo->find($ideven);
//        return $this->render('evenement/show.html.twig', [
//            'evenement' => $evenement,
//        ]);
//    }


    /**
     * @Route("/eventDetails={id}", name="eventDetails")
     */
    public function eventDetails(EvenementRepository $repo, $id)
    {
        $event = $repo->find($id);
        return $this->render("front/event_details.html.twig", ['event'=>$event]);
    }
}
