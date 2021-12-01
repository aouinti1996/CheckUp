<?php

namespace App\Controller;

use App\Form\RdvmailType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class RdvmailController extends AbstractController
{
    /**
     * @Route("/rdvmail", name="rdvmail")
     */
    public function index(Request $request, \Swift_Mailer $mailer)
    {

        $form = $this->createForm(RdvmailType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $rdvmail = $form->getData();
            // ici on enverrons le mail
            $message = (new \Swift_Message("Nouvelle Rdvmail"))
                // ici on l'expéditeur
                ->setFrom($rdvmail['email'])
                // ici on le destinataire
                ->setTo('salem.majdeddine@gmail.com')
                //message avec twig
                ->setBody(
                    $this->renderView(
                        'emails/rdvmail.html.twig', compact('rdvmail')

                    ),
                    'text/html'
                );
            //envoi de message
            $mailer->send($message);
            $this->addFlash('message', 'Le rdvmail a bien été envoyée');
            return $this->redirectToRoute('rendez_vous_index', [], Response::HTTP_SEE_OTHER);

        }

        return $this->render('rdvmail/index.html.twig', [
            'rdvmailForm' => $form->createView()
        ]);
    }
}
