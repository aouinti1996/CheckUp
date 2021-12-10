<?php

namespace App\Controller;

use App\Entity\Formulaire;
use App\Entity\PropertySearch;
use App\Form\FormulaireType;
use App\Form\PropertySearchType;
use App\Repository\FormulaireRepository;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\PieChart;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/form")
 */
class FormController extends AbstractController
{
    /**
     * @param Request $request
     * @param FormulaireRepository $repository
     * @return Response
     * @Route ("/rechercheM",name="rechercheM")
     */

    function Recherche(Request $request,FormulaireRepository $repository,PaginatorInterface $paginator):Response
    {
        $data=$request->get('search');

        $formulaire=$repository->findBy(['Adresse'=>$data]);



        $a=$repository->filter("Homme");
        $i=0;
        foreach ($a as $row){
            $i++;
        }
        $b=$repository->filter("Femme");
        $j=0;
        foreach ($b as $row){
            $j++;
        }


        $pieChart = new PieChart();
        $pieChart->getData()->setArrayToDataTable(
            [
                ['Sexe', 'Son type'],
                ['Homme', $i],
                ['Femme', $j]
            ]
        );
        $pieChart->getOptions()->setPieSliceText('label');
        $pieChart->getOptions()->setTitle('un aperçu du type de notre contenu');
        $pieChart->getOptions()->setPieStartAngle(100);
        $pieChart->getOptions()->setHeight(500);
        $pieChart->getOptions()->setWidth(900);
        $pieChart->getOptions()->getLegend()->setPosition('none');




        $donnees = $this->getDoctrine()->getRepository(Formulaire::class)->findAll();
        $formulaires = $paginator->paginate(
            $donnees, // Requête contenant les données à paginer (ici nos articles)
            $request->query->getInt('page', 1), // Numéro de la page en cours, passé dans l'URL, 1 si aucune page
            3 // Nombre de résultats par page
        );

        return $this->render('form/index.html.twig',[
            'formulaires'=>$formulaire,
            'piechart' => $pieChart,
            'formulaire'=>$formulaires


        ]);

    }


    /**
     * @Route("/", name="form_index",methods={"GET","POST"})
     */
    public function index(FormulaireRepository $formulaireRepository, Request $request,PaginatorInterface $paginator):Response
    {
        $formulaire = new PropertySearch ();
        $form=$this -> createFormBuilder($formulaire)
            ->add('Adresse', TextType::class, array('attr'=>array('class'=>'form-control')))
            ->getForm();

        $form->handleRequest($request);

        if($form->isSubmitted()&& $form->isValid()){
            $term=$formulaire->getAdresse();
            $allformulaires=$formulaireRepository->search($term);
        }
        else
        {
            $allformulaires   = $formulaireRepository->findAll();
        }


        $em = $this->getDoctrine()->getManager();
        $formulaire = $em->getRepository(Formulaire::class)->findAll();


        //////////////////////////
        ///
        ///

        $a=$formulaireRepository->filter("Homme");
        $i=0;
        foreach ($a as $row){
            $i++;
        }
        $b=$formulaireRepository->filter("Femme");
        $j=0;
        foreach ($b as $row){
            $j++;
        }


        $pieChart = new PieChart();
        $pieChart->getData()->setArrayToDataTable(
            [
                ['Sexe', 'Son type'],
                ['Homme', $i],
                ['Femme', $j]
            ]
        );
        $pieChart->getOptions()->setPieSliceText('label');
        $pieChart->getOptions()->setTitle('un aperçu du type de notre contenu');
        $pieChart->getOptions()->setPieStartAngle(100);
        $pieChart->getOptions()->setHeight(500);
        $pieChart->getOptions()->setWidth(900);
        $pieChart->getOptions()->getLegend()->setPosition('none');


        /// /////////////////////
        ///
        ///
        ///
        $donnees = $this->getDoctrine()->getRepository(Formulaire::class)->findAll();
        $formulaire = $paginator->paginate(
            $donnees, // Requête contenant les données à paginer (ici nos articles)
            $request->query->getInt('page', 1), // Numéro de la page en cours, passé dans l'URL, 1 si aucune page
            3 // Nombre de résultats par page
        );

        return $this->render('form/index.html.twig', [
            'formulaires' => $formulaire,
           'piechart' => $pieChart,

        ]);
    }








    /**
     * @Route("/user", name="events_indexuser")
     */

    public function user(FormulaireRepository $eventsRespository, Request $request): Response
    {


        $propertySearch = new PropertySearch();
        $form = $this->createForm(PropertySearchType::class, $propertySearch);
        $form->handleRequest($request);
        //initialement le tableau des articles est vide,
        //c.a.d on affiche les articles que lorsque l'utilisateur clique sur le bouton rechercher
        $events = [];

        if ($form->isSubmitted() && $form->isValid()) {


            //on récupère le nom d'article tapé dans le formulaire
            $Sexe = $propertySearch->getSexe();
            //si si aucun nom n'est fourni on affiche tous les articles

            if ($Sexe != "")
                //si on a fourni un nom d'article on affiche tous les articles ayant ce usernamme
                $events = $this->getDoctrine()->getRepository(Formulaire::class)->findBy(['Sexe' => $Sexe]);
            else
                //si si aucun nom n'est fourni on affiche tous les articles
                $events = $this->getDoctrine()->getRepository(Formulaire::class)->findAll();
        }


        return $this->render('form/index.html.twig', ['form' => $form->createView(), 'sexe' => $Sexe]);
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
