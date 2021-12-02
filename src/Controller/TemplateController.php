<?php

namespace App\Controller;

use App\Repository\userRepository;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\LineChart;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\PieChart;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\ColumnChart;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\Diff\DiffColumnChart;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\AreaChart;


class TemplateController extends AbstractController
{
    /**
     * @Route("/template", name="template")
     */
    public function index(userRepository $rep): Response
    {
        $tab[]=array();
        //$tailleLegumes = sizeof($tab);
        for($i=1; $i<2; $i++)

        {   $date = date('Y-m-d h:i:s ', time());

            //$tab[0]=date('Y-m-d H:i:s',strtotime('+0 hour',strtotime($date)));
            $tab[0]=date('Y-m-d H:i:s',strtotime('+0 hour',strtotime($date)));
            $tab[$i]=date('Y-m-d H:i:s',strtotime('+1 hour',strtotime($tab[($i-1)])));
        }
        for($i=0; $i<2; $i++)
        {echo 'tab['.$i.']='. $tab[$i];}
        /*$date = date('Y-m-d h:i:s ', time());

        $tab[]=array(2);
        $tab[0] = date('Y-m-d H:i:s',strtotime('+1 hour',strtotime($date)));
        $tab[1]=date('Y-m-d H:i:s',strtotime('+1 hour',strtotime($tab[0])));
        echo $tab[0];
        echo $tab[1];*/
       // $date= date('Y-m-d').'T'.date("H:i:s").'.'.date("v").'Z';
       // echo $date. "\n";
        //$jour = date("Y-m-d");
       // $maDate = strtotime($date."+ 2 days"). "\n";
        //echo date("Y-m-d",$maDate);
        //$maDate = strtotime($jour."+ 2 days");
        //$date=date('Y-m-d\TH:i:sO', strtotime($strDate));
       //$date =  "2021-11-28T00:00:00.000Z";
//echo $date;
        $d=strtotime("10:30 April 15 2014");
       //$date= date("d/M/y h:i:sa", $d);

       //echo $date;
        //echo date('Y-m-d\TH:i:sO');
        //$$date=ISODate("2012-11-02T08:40:12.569Z");

        //$dateTimestamp = strtotime('2012-01-15 12:13:07');
        //$date=date( 'Y-m-d\TH:i:sO', $dateTimestamp );
     //$date=date(DATE_ISO8601, strtotime('2010-12-30 23:21:46'));
        $customers = $rep->findtotal();
        $medecins=$rep->findnbmedecin();
        $patients = $rep->findnbpatient();
        $percentM=($medecins*100)/$customers;
        $percentP=($patients*100)/$customers;
        return $this->render('template/index.html.twig', [
            'customers' => $customers,'medecins'=>$medecins,'patient'=>$patients,'percentM'=> $percentM,'percentP'=>$percentP,'date'=>$tab,

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
     * @Route("/chart3", name="chart3")
     */
    public function TestChartline(userRepository $rep): Response
    { $date = date("D M d, Y G:i", time());
        $tab[]=array();

        for($i=1; $i<3; $i++) {
            $date = date('Y-m-d h:i:s ', time());

            //$tab[0]=date('Y-m-d H:i:s',strtotime('+0 hour',strtotime($date)));
            $tab[0] = date('Y-m-d H:i:s', strtotime('+0 hour', strtotime($date)));
            $tab[$i] = date('Y-m-d H:i:s', strtotime('+1 hour', strtotime($tab[($i - 1)])));

            // echo $date->format('D M d, Y G:i');

            $nbtotal = $rep->findtotal();
            $area = new AreaChart();
            $area->getData()->setArrayToDataTable([
                ['date', 'account'],
                [$tab[0], $nbtotal * 100],
                [$tab[$i], 0],
                [$tab[$i], 0],
                //[$tab[3], 0],
               // [$tab[$i], 0],
               // [$tab[$i], 0]
            ]);
        }
        $area->getOptions()->setTitle('suivi des comptes');
        $area->getOptions()->getHAxis()->setTitle('Year');
        $area->getOptions()->getHAxis()->getTitleTextStyle()->setColor('#333');
        $area->getOptions()->getVAxis()->setMinValue(0);
        return $this->render('back/chartline.html.twig', array('area' => $area));
    }


}