<?php

namespace App\Repository;

use App\Entity\User;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method User|null find($id, $lockMode = null, $lockVersion = null)
 * @method User|null findOneBy(array $criteria, array $orderBy = null)
 * @method User[]    findAll()
 * @method User[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class userRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, User::class);
    }

    // /**
    //  * @return User[] Returns an array of User objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('u')
            ->andWhere('u.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('u.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?User
    {
        return $this->createQueryBuilder('u')
            ->andWhere('u.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */

    public function findnbmedecin()
    {
        $q = $this-> createQueryBuilder('a')
            // Filter by some parameter if you want
            // ->where('a.published = 1')
            ->select('count(a.role)')
            ->where('a.role= :role')
            ->setParameter('role', 'medecin')
            ->getQuery();



        return $q->getSingleScalarResult();// will return only one result or null 'getResult' will return a collection
    }


    public function findbiologiste()
    {
        $q = $this-> createQueryBuilder('a')
            // Filter by some parameter if you want
            // ->where('a.published = 1')
            ->select('count(a.specialite)')
            ->where('a.specialite= :specialite')
            ->setParameter('specialite', 'biologiste')
            ->getQuery();



        return $q->getSingleScalarResult();// will return only one result or null 'getResult' will return a collection
    }

    public function findnbpatient()
    {
        $q = $this-> createQueryBuilder('a')
            // Filter by some parameter if you want
            // ->where('a.published = 1')
            ->select('count(a.role)')
            ->where('a.role= :role')
            ->setParameter('role', 'patient')
            ->getQuery();



        return $q->getSingleScalarResult();// will return only one result or null 'getResult' will return a collection
    }

    public function findtotal()
    {

        $q = $this-> createQueryBuilder('a')
            // Filter by some parameter if you want
            // ->where('a.published = 1')
            ->select('count(a.id)')

            ->getQuery();



        return $q->getSingleScalarResult();// will return only one result or null 'getResult' will return a collection
    }



    public function findGynecologue()

      {
          $q = $this-> createQueryBuilder('a')
              // Filter by some parameter if you want
              // ->where('a.published = 1')
              ->select('count(a.specialite)')
              ->where('a.specialite= :specialite')
              ->setParameter('specialite', 'gynecologue')
              ->getQuery();



          return $q->getSingleScalarResult();// will return only one result or null 'getResult' will return a collection
      }

      /*public function date()
      {
          $criteria = new Criteria();
          $criteria->andWhere(
              $criteria::expr()->eq('from', new DateTime('now'))
          );

          return $this->matching($criteria);
      }*/
}
