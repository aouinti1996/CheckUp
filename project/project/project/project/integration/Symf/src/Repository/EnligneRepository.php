<?php

namespace App\Repository;

use App\Entity\Enligne;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Enligne|null find($id, $lockMode = null, $lockVersion = null)
 * @method Enligne|null findOneBy(array $criteria, array $orderBy = null)
 * @method Enligne[]    findAll()
 * @method Enligne[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class EnligneRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Enligne::class);
    }

    // /**
    //  * @return Enligne[] Returns an array of Enligne objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('e')
            ->andWhere('e.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('e.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Enligne
    {
        return $this->createQueryBuilder('e')
            ->andWhere('e.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
