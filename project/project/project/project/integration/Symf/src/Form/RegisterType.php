<?php

namespace App\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\DateType;
use Symfony\Component\Form\Extension\Core\Type\EmailType;
use Symfony\Component\Form\Extension\Core\Type\NumberType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\RepeatedType;
use Symfony\Component\Form\Extension\Core\Type\PasswordType;
use Symfony\Component\Form\Extension\Core\Type\HiddenType;
class RegisterType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('nom')
            ->add('prenom')
            ->add('Email',EmailType::class,["label"=>'Email'])

            ->add('datenaissance',DateType::class)
            ->add('password',PasswordType::class)
            ->add('numerotelephone',NumberType::class)
            ->add('adresse',TextareaType::class)



            ->add('password',RepeatedType::class,[
        'type' => PasswordType::class,
        'invalid_message' => 'The password fields must match.',
        'options' => ['attr' => ['class' => 'password-field']],
        'required' => true,
        'first_options'  => ['label' => 'Password','attr' => [
            'class' => 'password-field',
            'placeholder' => 'merci de saisir votre mot de passe',

        ]
            ],


        'second_options' => ['label' => 'Repeat Password',
                'attr' => [
                    'class' => 'password-field',
                    'placeholder' => 'merci de confirmer votre mot de passe ',

                ]],
    ])

        ->add('role',HiddenType::class, [
        'data' => 'patient',
    ])
        ->add('specialite',HiddenType::class, [
            'data' => 'medecin',
        ])

        ->add('Enregistrer',SubmitType::class);
        //->add('Modifier',SubmitType::class);
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            // Configure your form options here
        ]);
    }
}
