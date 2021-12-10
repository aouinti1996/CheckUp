<?php

namespace App\Controller;

use App\Entity\CategorieEvenement;
use App\Entity\Evenement;
use App\Form\CategorieEvenementType;
use App\Form\EvenementType;
use App\Repository\CategorieEvenementRepository;
use App\Repository\EvenementRepository;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\PieChart;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class AdminControllerev extends AbstractController
{
    /**
     * @Route("/adminin", name="adminin")
     */
    public function index(): Response
    {

        return $this->render('back/base.html.twig', [
            'controller_name' => 'AdminControllerev',
        ]);
    }

    /**
     * @Route("/createEvent", name="createEvent")
     */
    public function createEvent(Request $request): Response
    {

        $evenement = new Evenement();
        $form = $this->createForm(EvenementType::class, $evenement);
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





        $a=$repo->filter("sport");
        $i=0;
        foreach ($a as $row){
            $i++;
        }
        $b=$repo->filter("sante");
        $j=0;
        foreach ($b as $row){
            $j++;
        }


        $pieChart = new PieChart();
        $pieChart->getData()->setArrayToDataTable(
            [
                ['type', 'Son type'],
                ['sport', $i],
                ['sante', $j]
            ]
        );
        $pieChart->getOptions()->setPieSliceText('label');
        $pieChart->getOptions()->setTitle('un aperçu du type de notre contenu');
        $pieChart->getOptions()->setPieStartAngle(100);
        $pieChart->getOptions()->setHeight(500);
        $pieChart->getOptions()->setWidth(900);
        $pieChart->getOptions()->getLegend()->setPosition('none');





        return $this->render('back/afficher_evenements.html.twig', [
            'evenements' => $evenements,
            'piechart' => $pieChart,
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






}
