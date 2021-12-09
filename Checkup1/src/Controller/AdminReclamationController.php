<?php

namespace App\Controller;

use App\Entity\Reclamation;
use App\Entity\Reponse;
use App\Form\Reclamation1Type;
use App\Form\ReponseType;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/admin")
 */
class AdminReclamationController extends AbstractController
{
    /**
     * @Route("/reclamation", name="admin_reclamation")
     */
    public function index(EntityManagerInterface $entityManager): Response
    {
        $reclamations = $entityManager
            ->getRepository(Reclamation::class)
            ->findAll();

        return $this->render('admin_reclamation/index.html.twig', [
            'reclamations' => $reclamations,
        ]);
    }

    /**
     * @Route("reclamation/{id}", name="reclamation_show_admin", methods={"GET"})
     */
    public function show(Reclamation $reclamation): Response
    {
        $rep = "";
        if ($reclamation->getIdReponse()){
            $rep = $this->getDoctrine()->getRepository(Reponse::class)->find($reclamation->getIdReponse())->getText();
        }
        return $this->render('admin_reclamation/show.html.twig', [
            'reclamation' => $reclamation, 'rep'=>$rep,
        ]);
    }

    /**
     * @Route("/reclamation/{id}/edit", name="reclamation_reply", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager, int $id,\Swift_Mailer $mailer): Response
    {
        $reponse = new Reponse();
        $form = $this->createForm(ReponseType::class, $reponse);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($reponse);
            $entityManager->flush();
            $reclamation = $this->getDoctrine()->getRepository(Reclamation::class)->find($id);
            $reclamation->setIdReponse($reponse);
            $reclamation->setStatus("traiter");
            $entityManager->persist($reclamation);
            $entityManager->flush();
            $message=(new \Swift_Message('Reclamation'))
                ->setFrom(['theoptimizers7@gmail.com' => 'the optimizers'])
                ->setTo('houssem095@gmail.com')
                ->setBody($this->renderView(
                    'emails/emailrep.html.twig', compact('reponse','reclamation')
                ),'text/html'
                );
            $mailer->send($message);
            return $this->redirectToRoute('admin_reclamation', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('admin_reclamation/reply.html.twig', [
            'reponse' => $reponse,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}/edit", name="reponse_update", methods={"GET", "POST"})
     */
    public function edit(Request $request, Reponse $reponse, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(ReponseType::class, $reponse);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('admin_reclamation', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('admin_reclamation/edit.html.twig', [
            'reponse' => $reponse,
            'form' => $form->createView(),
        ]);
    }

}
