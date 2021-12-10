<?php

namespace App\Controller;

use App\Repository\UserRepository;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\ColumnChart;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\Diff\DiffColumnChart;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\PieChart;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class TemplateController extends AbstractController
{
    /**
     * @Route("/template", name="template")
     */
    public function index(userRepository $rep): Response
    {

        $customers = $rep->findtotal();
        $medecins=$rep->findnbmedecin();
        $patients = $rep->findnbpatient();
        $percentM=($medecins*100)/$customers;
        $percentP=($patients*100)/$customers;
        return $this->render('template/index.html.twig', [
            'customers' => $customers,'medecins'=>$medecins,'patient'=>$patients,'percentM'=> $percentM,'percentP'=>$percentP,

        ]);
    }


    /**
     * @Route("/chart", name="chart")
     */
    public function TestChart(userRepository $rep): Response
    {

        $nbtotal = $rep->findtotal();
        $nbmedecin = $rep->findnbmedecin();
        $nbpatient = $rep->findnbpatient();
        //$date=$rep->date();
        //$nbgynecologue=
        // $nbbiologiste=$rep->findbiologiste();
        $pieChart = new PieChart();
        $pieChart->getData()->setArrayToDataTable(
            [['Task', 'Hours per Day'],
                ['Medecin', $nbmedecin / $nbtotal],

                ['Patient', $nbpatient / $nbtotal]

            ]
        );

        $pieChart->getOptions()->setTitle('Our Customers= ' . $nbtotal);
        $pieChart->getOptions()->setHeight(500);
        $pieChart->getOptions()->setWidth(900);
        $pieChart->getOptions()->getTitleTextStyle()->setBold(true);
        $pieChart->getOptions()->getTitleTextStyle()->setColor('#009900');
        $pieChart->getOptions()->getTitleTextStyle()->setItalic(true);
        $pieChart->getOptions()->getTitleTextStyle()->setFontName('Arial');
        $pieChart->getOptions()->getTitleTextStyle()->setFontSize(20);

        //return $this->render('AppBundle::index.html.twig', array('piechart' => $pieChart));
        return $this->render('back/chart.html.twig', array('piechart' => $pieChart));
    }


    /**
     * @Route("/chart1", name="chart1")
     */
    public function indexAction(userRepository $rep): Response
    {
        $nbtotal = $rep->findnbmedecin();
        $nbbiologiste = $rep->findbiologiste();

        $nbgynecologue = $rep->findGynecologue();
        $nbtotal = $rep->findtotal();
        $oldColumnChart = new ColumnChart();
        $oldColumnChart->getData()->setArrayToDataTable(
            [
                ['Name', 'Popularity'],
                ['Medecin', $nbtotal * 1000],
                ['Biologiste', ($nbbiologiste * 1000)],
                ['Gynecologue', $nbgynecologue * 1000],
                ['Autres', 0]
            ]
        );
        $oldColumnChart->getOptions()->getLegend()->setPosition('top');
        $oldColumnChart->getOptions()->setWidth(450);
        $oldColumnChart->getOptions()->setHeight(250);

        $newColumnChart = new ColumnChart();
        $newColumnChart->getData()->setArrayToDataTable(
            [
                ['Name', 'Popularity'],
                ['Cesar', 370],
                ['Rachel', 600],
                ['Patrick', 700],
                ['Eric', 1500]
            ]
        );
        $newColumnChart->setOptions($oldColumnChart->getOptions());

        $diffColumnChart = new DiffColumnChart($oldColumnChart, $newColumnChart);
        $diffColumnChart->getOptions()->getLegend()->setPosition('top');
        $diffColumnChart->getOptions()->setWidth(450);
        $diffColumnChart->getOptions()->setHeight(250);
        $diffColumnChart->getOptions()->getDiff()->getNewData()->setWidthFactor(0.1);


        /* return $this->render('AppBundle::diffcol.html.twig', array(
             'oldColumnChart' => $oldColumnChart,
             'newColumnChart' => $newColumnChart,
             'diffColumnChart' => $diffColumnChart
         ));*/
        return $this->render('back/columnchart.html.twig', array('oldColumnChart' => $oldColumnChart, 'newColumnChart' => $newColumnChart, 'diffColumnChart' => $diffColumnChart));
    }

    /**
     * @Route("/chart3", name="chart2")
     */
    public function TestChartline(UserRepository $rep): Response
    {

        $nbmedecin = $rep->findnbmedecin();
        $nbgynecologue = $rep->findGynecologue();
        $nbbiologiste = $rep->findbiologiste();

        $nbgynecologue = $rep->findGynecologue();
        return $this->render('back/chartline.html.twig', array('medecins' => $nbmedecin,'gyn'=>$nbgynecologue,'biologiste'=>$nbbiologiste));
    }



}
