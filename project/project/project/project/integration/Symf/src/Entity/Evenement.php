<?php

namespace App\Entity;

use App\Repository\EvenementRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\HttpFoundation\File\File;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\Validator\Constraints as Assert;
use Vich\UploaderBundle\Mapping\Annotation as Vich;

/**
 * @ORM\Entity(repositoryClass=EvenementRepository::class)
 * @Vich\Uploadable
 */
class Evenement
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(name="titreeven",type="string", length=255)
     * @Assert\NotBlank(message="Le champ ne doit pas être vide")
     */
    private $titreeven;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank(message="Le champ ne doit pas être vide")
     * @Assert\Length(
     *     min=4,
     *     max=50,
     *     minMessage="La description doit etre au minimum {{limit}}",
     *     maxMessage="La description doit etre au maximum {{limit}}",
     *     allowEmptyString = false
     * )
     */
    private $descriptioneven;

    /**
     * @ORM\Column(type="date")
     */
    private $dateFin;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank(message="Le champ ne doit pas être vide")
     */
    private $lieuEven;

    /**
     * @ORM\Column(type="integer", length=255)
     * @Assert\NotBlank(message="Le champ ne doit pas être vide")
     */
    private $invites;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank(message="Le champ ne doit pas être vide")
     */
    private $responsable;

    /**
     * @ORM\Column(type="date")
     */
    private $dateDebut;

    /**
     * @var File|null
     * @Vich\UploadableField(mapping="event_image", fileNameProperty="filename")
     */
    private $imageFile;

    /**
     * @ORM\Column(type="string", length=255, nullable=true)
     */
    private $filename;

    /**
     * @ORM\Column(type="datetime", nullable=true)
     */
    private $updated_at;

    /**
     * @ORM\ManyToMany(targetEntity=Userevent::class, inversedBy="evenements")
     */
    private $participants;

    public function __construct()
    {
        $this->participants = new ArrayCollection();
    }


    public function getId(): ?int
    {
        return $this->id;
    }

    public function getTitreeven(): ?string
    {
        return $this->titreeven;
    }

    public function setTitreeven(string $titreeven): self
    {
        $this->titreeven = $titreeven;

        return $this;
    }

    public function getDescriptioneven(): ?string
    {
        return $this->descriptioneven;
    }

    public function setDescriptioneven(string $descriptioneven): self
    {
        $this->descriptioneven = $descriptioneven;

        return $this;
    }

    public function getDateFin(): ?\DateTimeInterface
    {
        return $this->dateFin;
    }

    public function setDateFin(\DateTimeInterface $dateFin): self
    {
        $this->dateFin = $dateFin;

        return $this;
    }

    public function getLieuEven(): ?string
    {
        return $this->lieuEven;
    }

    public function setLieuEven(string $lieuEven): self
    {
        $this->lieuEven = $lieuEven;

        return $this;
    }

    public function getInvites(): ?int
    {
        return $this->invites;
    }

    public function setInvites(int $invites): self
    {
        $this->invites = $invites;

        return $this;
    }

    public function getResponsable(): ?string
    {
        return $this->responsable;
    }

    public function setResponsable(string $responsable): self
    {
        $this->responsable = $responsable;

        return $this;
    }

    public function getDateDebut(): ?\DateTimeInterface
    {
        return $this->dateDebut;
    }

    public function setDateDebut(\DateTimeInterface $dateDebut): self
    {
        $this->dateDebut = $dateDebut;

        return $this;
    }


// Image
    public function getFilename(): ?string
    {
        return $this->filename;
    }

    public function setFilename(?string $filename): self
    {
        $this->filename = $filename;

        return $this;
    }

    /**
     * @return File|null
     */
    public function getImageFile(): ?File
    {
        return $this->imageFile;
    }

    /**
     * @param File|null $imageFile
     * @return Evenement
     */
    public function setImageFile(?File $imageFile): Evenement
    {
        $this->imageFile = $imageFile;
        if($this->imageFile instanceof UploadedFile)
        {
            $this->updated_at = new \DateTime('now');
        }
        return $this;
    }

    public function getUpdatedAt(): ?\DateTimeInterface
    {
        return $this->updated_at;
    }

    public function setUpdatedAt(?\DateTimeInterface $updated_at): self
    {
        $this->updated_at = $updated_at;

        return $this;
    }

    /**
     * @return Collection|Userevent[]
     */
    public function getParticipants(): Collection
    {
        return $this->participants;
    }

    public function addParticipant(Userevent $participant): self
    {
        if (!$this->participants->contains($participant)) {
            $this->participants[] = $participant;
        }

        return $this;
    }

    public function removeParticipant(Userevent $participant): self
    {
        $this->participants->removeElement($participant);

        return $this;
    }
}
