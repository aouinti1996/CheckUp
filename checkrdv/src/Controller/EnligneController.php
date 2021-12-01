<?php

namespace App\Controller;

use App\Entity\Enligne;
use App\Form\EnligneType;
use App\Repository\EnligneRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/enligne")
 */
class EnligneController extends AbstractController
{
    /**
     * @Route("/", name="enligne_index", methods={"GET"})
     */
    public function index(EnligneRepository $enligneRepository): Response
    {
        return $this->render('enligne/index.html.twig', [
            'enlignes' => $enligneRepository->findAll(),
        ]);
    }

    /**
     * @Route("/new", name="enligne_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $enligne = new Enligne();
        $form = $this->createForm(EnligneType::class, $enligne);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($enligne);
            $entityManager->flush();

            return $this->redirectToRoute('enligne_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('enligne/new.html.twig', [
            'enligne' => $enligne,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="enligne_show", methods={"GET"})
     */
    public function show(Enligne $enligne): Response
    {
        return $this->render('enligne/show.html.twig', [
            'enligne' => $enligne,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="enligne_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Enligne $enligne, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(EnligneType::class, $enligne);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('enligne_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('enligne/edit.html.twig', [
            'enligne' => $enligne,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="enligne_delete", methods={"POST"})
     */
    public function delete(Request $request, Enligne $enligne, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$enligne->getId(), $request->request->get('_token'))) {
            $entityManager->remove($enligne);
            $entityManager->flush();
        }

        return $this->redirectToRoute('enligne_index', [], Response::HTTP_SEE_OTHER);
    }
}
