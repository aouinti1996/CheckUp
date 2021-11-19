<?php

namespace App\Controller;

use App\Entity\Evenement;
use App\Form\EvenementType;
use App\Repository\EvenementRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class AdminController extends AbstractController
{
    /**
     * @Route("/admin", name="admin")
     */
    public function index(): Response
    {

        return $this->render('back/base.html.twig', [
            'controller_name' => 'AdminController',
        ]);
    }

    /**
     * @Route("/createEvent", name="createEvent")
     */
    public function createEvent(Request $request): Response
    {

        $evenement = new Evenement();
        $form = $this->createForm(EvenementType::class, $evenement);
        $form->add('Enregistrer', SubmitType::class);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($evenement);
            $entityManager->flush();

            return $this->redirectToRoute('listEvents');
        }

        return $this->render('back/cree_evenement.html.twig', [
            'evenement' => $evenement,
            'form' => $form->createView(),
        ]);
    }

    /**
        * @Route("/listEvents", name="listEvents")
    */
    public function listEvents(EvenementRepository $repo)
    {
        $evenements = $repo->findAll();

        return $this->render('back/afficher_evenements.html.twig', [
            'evenements' => $evenements,
        ]);
    }

    /**
     * @Route("/edit={id}", name="evenement_edit")
     */
    public function edit(EvenementRepository $repo, Request $request, $id)
    {
        $evenement = $repo->find($id);
        $form = $this->createForm(EvenementType::class, $evenement);
        $form->add('Enregistrer', SubmitType::class);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('listEvents');
        }

        return $this->render('back/update_event.html.twig', [
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="evenement_delete")
     */
    public function delete(EvenementRepository $repo, $id)
    {
        $evenement = $repo->find($id);
        $em = $this->getDoctrine()->getManager();
        $em->remove($evenement);
        $em->flush();

        return $this->redirectToRoute('listEvents');
    }
}
