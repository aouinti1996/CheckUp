<?php

namespace App\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\DateType;
use Symfony\Component\Form\Extension\Core\Type\NumberType;
use Symfony\Component\Form\Extension\Core\Type\PasswordType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\HiddenType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class MedecinType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('nom')
            ->add('prenom')
            ->add('datenaissance',DateType::class)
            ->add('email')
            ->add('password',PasswordType::class)
            ->add('numerotelephone',NumberType::class)
            ->add('adresse',TextareaType::class)

            ->add('specialite', ChoiceType::class, [
                'choices'  => [
                    'Biologiste' => 'biologiste',
                    'Gynecologue' => 'gynecologue',

                ],
            ])
            ->add('role',HiddenType::class, [
                'data' => 'medecin',
            ])
            ->add('Enregistrer',SubmitType::class,);
        ;
        ;

    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            // Configure your form options here
        ]);
    }
}
