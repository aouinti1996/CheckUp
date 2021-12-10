<?php

namespace App\Controller;

use App\Entity\CategorieEvenement;
use App\Entity\Commentaire;
use App\Entity\Evenement;
use App\Form\CategorieEvenementType;
use App\Form\CommentaireType;
use App\Form\EvenementType;
use App\Repository\CommentaireRepository;
use App\Repository\EvenementRepository;
use App\Repository\UserevRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Security\Core\Security;

/**
 * @Route("/evenement")
 */
class EvenementController extends AbstractController
{

// commentaires
    /**
     * @Route("/eventDetails={id}", name="eventDetails")
     */
    public function eventDetails(EvenementRepository $repo, CommentaireRepository $commentRepo, UserevRepository $userRepo, Request $request, $id)
    {
        $user = $userRepo->find(1);
        $event = $repo->find($id);

        $commentaire = new Commentaire();
        $commentaire->setDate(new \DateTime('now'));
        $commentaire->setCommentateur($user);
        $commentaire->setEventId($id);
        $form = $this->createForm(CommentaireType::class, $commentaire);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($commentaire);
            $entityManager->flush();

            return $this->redirectToRoute('eventDetails', ['id'=> $id]);
        }

        $comments = $commentRepo->geEventComments($id);

        return $this->render("front/event_details.html.twig", ['event'=>$event, 'user'=>$user,
            'comments'=>$comments, 'form'=>$form->createView()]);
    }


// Boutton Réserver
    /**
     * @Route("/reserverEvenement/{id}", name="reserverEvenement")
     */
    public function reserverEvenement(EvenementRepository $eventRepo, UserevRepository $userRepo, $id): Response
    {
        $user = $userRepo->find(1);
        $event = $eventRepo->find($id);

        $user->addEvenement($event);
        $event->addParticipant($user);
        $event->setInvites($event->getInvites()-1);

        $entityManager = $this->getDoctrine()->getManager();
        $entityManager->persist($user);
        $entityManager->persist($event);
        $entityManager->flush();

        $evenements = $this->getDoctrine()
            ->getRepository(Evenement::class)
            ->findAll();

        return $this->redirectToRoute('evenement_index');
 //       return $this->render('front/base.html.twig', ['evenements' => $evenements]);
    }

    /**
     * @Route("/createCategory", name="createCategory")
     */
    public function createCategory(Request $request): Response
    {
        $categorie = new CategorieEvenement();
        $form = $this->createForm(CategorieEvenementType::class, $categorie);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($categorie);
            $entityManager->flush();

            return $this->redirectToRoute('listEvents');
        }

        return $this->render('back/cree_categorie.html.twig', [
            'form' => $form->createView(),
        ]);
    }
}
