<?php

namespace App\Controller;

use App\Entity\Reclamation;
use App\Entity\Reponse;
use App\Form\Reclamation1Type;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/reclamation")
 */
class ReclamationController extends AbstractController
{
    /**
     * @Route("/", name="reclamation_index", methods={"GET"})
     */
    public function index(EntityManagerInterface $entityManager): Response
    {
        $reclamations = $entityManager
            ->getRepository(Reclamation::class)
            ->findAll();

        return $this->redirectToRoute('reclamation_new');
    }

    /**
     * @Route("/new", name="reclamation_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager,\Swift_Mailer $mailer): Response
    {
        $reclamation = new Reclamation();
        $reclamation1 = new Reclamation();

        $form = $this->createForm(Reclamation1Type::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $reclamation1->setObject($reclamation->getObject());
            $reclamation1->setDescription($reclamation->getDescription());
            $reclamation1->setScreenshot($reclamation->getScreenshot());
            $reclamation1->setCategory($reclamation->getCategory());
            $reclamation1->setStatus("non traiter");
            $reclamation1->setEmail("houssem095@gmail.com");
            $reclamation1->setIdUser("1");
            $entityManager->persist($reclamation1);
            $entityManager->flush();
            //email
            $message=(new \Swift_Message('Reclamation'))
                ->setFrom(['theoptimizers7@gmail.com' => 'the optimizers'])
                ->setTo('houssem095@gmail.com')
                ->setBody($this->renderView(
                    'emails/email.html.twig', compact('reclamation1')
                ),'text/html'
                );
            $mailer->send($message);
            return $this->redirectToRoute('reclamation_index', [], Response::HTTP_SEE_OTHER);

        }


        return $this->render('reclamation/new.html.twig', [
            'reclamation' => $reclamation,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="reclamation_show", methods={"GET"})
     */
    public function show(Reclamation $reclamation): Response
    {
        $rep = "";
        if ($reclamation->getIdReponse()){
            $rep = $this->getDoctrine()->getRepository(Reponse::class)->find($reclamation->getIdReponse())->getText();
        }
        return $this->render('reclamation/show.html.twig', [
            'reclamation' => $reclamation, 'rep'=>$rep,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="reclamation_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Reclamation $reclamation, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(Reclamation1Type::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('reclamation_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('reclamation/edit.html.twig', [
            'reclamation' => $reclamation,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="reclamation_delete", methods={"POST"})
     */
    public function delete(Request $request, Reclamation $reclamation, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$reclamation->getId(), $request->request->get('_token'))) {
            $entityManager->remove($reclamation);
            $entityManager->flush();
        }

        return $this->redirectToRoute('reclamation_index', [], Response::HTTP_SEE_OTHER);
    }
}
