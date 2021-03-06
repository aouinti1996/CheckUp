<?php

namespace App\Form;

use App\Entity\User;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\BirthdayType;
use Symfony\Component\Form\Extension\Core\Type\HiddenType;
use Symfony\Component\Form\Extension\Core\Type\NumberType;
use Symfony\Component\Form\Extension\Core\Type\PasswordType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\DateType;

use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Vich\UploaderBundle\Form\Type\VichImageType;

class PatientType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('nom')
            ->add('prenom')
            ->add('datenaissance', BirthdayType::class, [
                'widget' => 'single_text',
                'format' => 'yyyy-MM-dd',
            ])
            ->add('email')
            ->add('password',PasswordType::class)
            ->add('numerotelephone',NumberType::class)
            ->add('imageFile',VichImageType::class)
            ->add('adresse',TextareaType::class)

            ->add('Enregistrer',SubmitType::class)
        ->add('role',HiddenType::class, [
        'data' => 'patient',
    ])
            ->add('specialite',HiddenType::class, [
                'data' => 'medecin',
            ])
        ;

    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => User::class,
        ]);
    }
}
