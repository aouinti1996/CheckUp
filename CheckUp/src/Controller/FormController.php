<?php

namespace App\Controller;

use App\Entity\Formulaire;
use App\Form\FormulaireType;
use App\Repository\FormulaireRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/form")
 */
class FormController extends AbstractController
{
    /**
     * @Route("/", name="form_index", methods={"GET"})
     */
    public function index(FormulaireRepository $formulaireRepository): Response
    {
        return $this->render('form/index.html.twig', [
            'formulaires' => $formulaireRepository->findAll(),
        ]);
    }

    /**
     * @Route("/new", name="form_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $formulaire = new Formulaire();
        $form = $this->createForm(FormulaireType::class, $formulaire);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($formulaire);
            $entityManager->flush();

            return $this->redirectToRoute('salutation', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('form/new.html.twig', [
            'formulaire' => $formulaire,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="form_show", methods={"GET"})
     */
    public function show(Formulaire $formulaire): Response
    {
        return $this->render('form/show.html.twig', [
            'formulaire' => $formulaire,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="form_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Formulaire $formulaire): Response
    {
        $form = $this->createForm(FormulaireType::class, $formulaire);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('form_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('form/edit.html.twig', [
            'formulaire' => $formulaire,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="form_delete", methods={"POST"})
     */
    public function delete(Request $request, Formulaire $formulaire): Response
    {
        if ($this->isCsrfTokenValid('delete'.$formulaire->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($formulaire);
            $entityManager->flush();
        }

        return $this->redirectToRoute('form_index', [], Response::HTTP_SEE_OTHER);
    }
}
