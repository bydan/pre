/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.inventario.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.inventario.util.EmbarcadorConstantesFunciones;
import com.bydan.erp.inventario.util.EmbarcadorParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EmbarcadorParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EmbarcadorConstantesFunciones extends EmbarcadorConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="Embarcador";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Embarcador"+EmbarcadorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmbarcadorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmbarcadorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmbarcadorConstantesFunciones.SCHEMA+"_"+EmbarcadorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmbarcadorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmbarcadorConstantesFunciones.SCHEMA+"_"+EmbarcadorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmbarcadorConstantesFunciones.SCHEMA+"_"+EmbarcadorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmbarcadorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmbarcadorConstantesFunciones.SCHEMA+"_"+EmbarcadorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmbarcadorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmbarcadorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmbarcadorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmbarcadorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmbarcadorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmbarcadorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmbarcadorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmbarcadorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmbarcadorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmbarcadorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Embarcadores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Embarcador";
	public static final String SCLASSWEBTITULO_LOWER="Embarcador";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Embarcador";
	public static final String OBJECTNAME="embarcador";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="embarcador";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select embarcador from "+EmbarcadorConstantesFunciones.SPERSISTENCENAME+" embarcador";
	public static String QUERYSELECTNATIVE="select "+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".version_row,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id_empresa,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".nombre,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".ruc,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".direccion,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".telefono,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".contacto,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".e_mail,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".fax,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id_tipo_via_transporte,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id_puerto,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id_empleado,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id_pais,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id_ciudad from "+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME;//+" as "+EmbarcadorConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmbarcadorConstantesFuncionesAdditional embarcadorConstantesFuncionesAdditional=null;
	
	public EmbarcadorConstantesFuncionesAdditional getEmbarcadorConstantesFuncionesAdditional() {
		return this.embarcadorConstantesFuncionesAdditional;
	}
	
	public void setEmbarcadorConstantesFuncionesAdditional(EmbarcadorConstantesFuncionesAdditional embarcadorConstantesFuncionesAdditional) {
		try {
			this.embarcadorConstantesFuncionesAdditional=embarcadorConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String RUC= "ruc";
    public static final String DIRECCION= "direccion";
    public static final String TELEFONO= "telefono";
    public static final String CONTACTO= "contacto";
    public static final String EMAIL= "e_mail";
    public static final String FAX= "fax";
    public static final String IDTIPOVIATRANSPORTE= "id_tipo_via_transporte";
    public static final String IDPUERTO= "id_puerto";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_CONTACTO= "Contacto";
		public static final String LABEL_CONTACTO_LOWER= "Contacto";
    	public static final String LABEL_EMAIL= "E Mail";
		public static final String LABEL_EMAIL_LOWER= "E Mail";
    	public static final String LABEL_FAX= "Fax";
		public static final String LABEL_FAX_LOWER= "Fax";
    	public static final String LABEL_IDTIPOVIATRANSPORTE= "Tipo Via Transporte";
		public static final String LABEL_IDTIPOVIATRANSPORTE_LOWER= "Tipo Via Transporte";
    	public static final String LABEL_IDPUERTO= "Puerto";
		public static final String LABEL_IDPUERTO_LOWER= "Puerto";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXCONTACTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCONTACTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXE_MAIL=ConstantesValidacion.SREGEXCADENA_MAIL;
	public static final String SMENSAJEREGEXE_MAIL=ConstantesValidacion.SVALIDACIONCADENA_MAIL;	
	public static final String SREGEXFAX=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFAX=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getEmbarcadorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmbarcadorConstantesFunciones.IDEMPRESA)) {sLabelColumna=EmbarcadorConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EmbarcadorConstantesFunciones.NOMBRE)) {sLabelColumna=EmbarcadorConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EmbarcadorConstantesFunciones.RUC)) {sLabelColumna=EmbarcadorConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(EmbarcadorConstantesFunciones.DIRECCION)) {sLabelColumna=EmbarcadorConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(EmbarcadorConstantesFunciones.TELEFONO)) {sLabelColumna=EmbarcadorConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(EmbarcadorConstantesFunciones.CONTACTO)) {sLabelColumna=EmbarcadorConstantesFunciones.LABEL_CONTACTO;}
		if(sNombreColumna.equals(EmbarcadorConstantesFunciones.EMAIL)) {sLabelColumna=EmbarcadorConstantesFunciones.LABEL_EMAIL;}
		if(sNombreColumna.equals(EmbarcadorConstantesFunciones.FAX)) {sLabelColumna=EmbarcadorConstantesFunciones.LABEL_FAX;}
		if(sNombreColumna.equals(EmbarcadorConstantesFunciones.IDTIPOVIATRANSPORTE)) {sLabelColumna=EmbarcadorConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE;}
		if(sNombreColumna.equals(EmbarcadorConstantesFunciones.IDPUERTO)) {sLabelColumna=EmbarcadorConstantesFunciones.LABEL_IDPUERTO;}
		if(sNombreColumna.equals(EmbarcadorConstantesFunciones.IDEMPLEADO)) {sLabelColumna=EmbarcadorConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(EmbarcadorConstantesFunciones.IDPAIS)) {sLabelColumna=EmbarcadorConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(EmbarcadorConstantesFunciones.IDCIUDAD)) {sLabelColumna=EmbarcadorConstantesFunciones.LABEL_IDCIUDAD;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getEmbarcadorDescripcion(Embarcador embarcador) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(embarcador !=null/* && embarcador.getId()!=0*/) {
			sDescripcion=embarcador.getnombre();//embarcadorembarcador.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEmbarcadorDescripcionDetallado(Embarcador embarcador) {
		String sDescripcion="";
			
		sDescripcion+=EmbarcadorConstantesFunciones.ID+"=";
		sDescripcion+=embarcador.getId().toString()+",";
		sDescripcion+=EmbarcadorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=embarcador.getVersionRow().toString()+",";
		sDescripcion+=EmbarcadorConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=embarcador.getid_empresa().toString()+",";
		sDescripcion+=EmbarcadorConstantesFunciones.NOMBRE+"=";
		sDescripcion+=embarcador.getnombre()+",";
		sDescripcion+=EmbarcadorConstantesFunciones.RUC+"=";
		sDescripcion+=embarcador.getruc()+",";
		sDescripcion+=EmbarcadorConstantesFunciones.DIRECCION+"=";
		sDescripcion+=embarcador.getdireccion()+",";
		sDescripcion+=EmbarcadorConstantesFunciones.TELEFONO+"=";
		sDescripcion+=embarcador.gettelefono()+",";
		sDescripcion+=EmbarcadorConstantesFunciones.CONTACTO+"=";
		sDescripcion+=embarcador.getcontacto()+",";
		sDescripcion+=EmbarcadorConstantesFunciones.EMAIL+"=";
		sDescripcion+=embarcador.gete_mail()+",";
		sDescripcion+=EmbarcadorConstantesFunciones.FAX+"=";
		sDescripcion+=embarcador.getfax()+",";
		sDescripcion+=EmbarcadorConstantesFunciones.IDTIPOVIATRANSPORTE+"=";
		sDescripcion+=embarcador.getid_tipo_via_transporte().toString()+",";
		sDescripcion+=EmbarcadorConstantesFunciones.IDPUERTO+"=";
		sDescripcion+=embarcador.getid_puerto().toString()+",";
		sDescripcion+=EmbarcadorConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=embarcador.getid_empleado().toString()+",";
		sDescripcion+=EmbarcadorConstantesFunciones.IDPAIS+"=";
		sDescripcion+=embarcador.getid_pais().toString()+",";
		sDescripcion+=EmbarcadorConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=embarcador.getid_ciudad().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEmbarcadorDescripcion(Embarcador embarcador,String sValor) throws Exception {			
		if(embarcador !=null) {
			embarcador.setnombre(sValor);//embarcadorembarcador.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoViaTransporteDescripcion(TipoViaTransporte tipoviatransporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoviatransporte!=null/*&&tipoviatransporte.getId()>0*/) {
			sDescripcion=TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(tipoviatransporte);
		}

		return sDescripcion;
	}

	public static String getPuertoDescripcion(Puerto puerto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(puerto!=null/*&&puerto.getId()>0*/) {
			sDescripcion=PuertoConstantesFunciones.getPuertoDescripcion(puerto);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorContacto")) {
			sNombreIndice="Tipo=  Por Contacto";
		} else if(sNombreIndice.equals("BusquedaPorEMail")) {
			sNombreIndice="Tipo=  Por E Mail";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorRuc")) {
			sNombreIndice="Tipo=  Por Ruc";
		} else if(sNombreIndice.equals("BusquedaPorTelefono")) {
			sNombreIndice="Tipo=  Por Telefono";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdPuerto")) {
			sNombreIndice="Tipo=  Por Puerto";
		} else if(sNombreIndice.equals("FK_IdTipoViaTransporte")) {
			sNombreIndice="Tipo=  Por Tipo Via Transporte";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorContacto(String contacto) {
		String sDetalleIndice=" Parametros->";
		if(contacto!=null) {sDetalleIndice+=" Contacto="+contacto;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorEMail(String e_mail) {
		String sDetalleIndice=" Parametros->";
		if(e_mail!=null) {sDetalleIndice+=" E Mail="+e_mail;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorRuc(String ruc) {
		String sDetalleIndice=" Parametros->";
		if(ruc!=null) {sDetalleIndice+=" Ruc="+ruc;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorTelefono(String telefono) {
		String sDetalleIndice=" Parametros->";
		if(telefono!=null) {sDetalleIndice+=" Telefono="+telefono;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPuerto(Long id_puerto) {
		String sDetalleIndice=" Parametros->";
		if(id_puerto!=null) {sDetalleIndice+=" Codigo Unico De Puerto="+id_puerto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoViaTransporte(Long id_tipo_via_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_via_transporte!=null) {sDetalleIndice+=" Codigo Unico De Tipo Via Transporte="+id_tipo_via_transporte.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEmbarcador(Embarcador embarcador,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		embarcador.setnombre(embarcador.getnombre().trim());
		embarcador.setruc(embarcador.getruc().trim());
		embarcador.setdireccion(embarcador.getdireccion().trim());
		embarcador.settelefono(embarcador.gettelefono().trim());
		embarcador.setcontacto(embarcador.getcontacto().trim());
		embarcador.sete_mail(embarcador.gete_mail().trim());
		embarcador.setfax(embarcador.getfax().trim());
	}
	
	public static void quitarEspaciosEmbarcadors(List<Embarcador> embarcadors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Embarcador embarcador: embarcadors) {
			embarcador.setnombre(embarcador.getnombre().trim());
			embarcador.setruc(embarcador.getruc().trim());
			embarcador.setdireccion(embarcador.getdireccion().trim());
			embarcador.settelefono(embarcador.gettelefono().trim());
			embarcador.setcontacto(embarcador.getcontacto().trim());
			embarcador.sete_mail(embarcador.gete_mail().trim());
			embarcador.setfax(embarcador.getfax().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmbarcador(Embarcador embarcador,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && embarcador.getConCambioAuxiliar()) {
			embarcador.setIsDeleted(embarcador.getIsDeletedAuxiliar());	
			embarcador.setIsNew(embarcador.getIsNewAuxiliar());	
			embarcador.setIsChanged(embarcador.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			embarcador.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			embarcador.setIsDeletedAuxiliar(false);	
			embarcador.setIsNewAuxiliar(false);	
			embarcador.setIsChangedAuxiliar(false);
			
			embarcador.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmbarcadors(List<Embarcador> embarcadors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Embarcador embarcador : embarcadors) {
			if(conAsignarBase && embarcador.getConCambioAuxiliar()) {
				embarcador.setIsDeleted(embarcador.getIsDeletedAuxiliar());	
				embarcador.setIsNew(embarcador.getIsNewAuxiliar());	
				embarcador.setIsChanged(embarcador.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				embarcador.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				embarcador.setIsDeletedAuxiliar(false);	
				embarcador.setIsNewAuxiliar(false);	
				embarcador.setIsChangedAuxiliar(false);
				
				embarcador.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmbarcador(Embarcador embarcador,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEmbarcadors(List<Embarcador> embarcadors,Boolean conEnteros) throws Exception  {
		
		for(Embarcador embarcador: embarcadors) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmbarcador(List<Embarcador> embarcadors,Embarcador embarcadorAux) throws Exception  {
		EmbarcadorConstantesFunciones.InicializarValoresEmbarcador(embarcadorAux,true);
		
		for(Embarcador embarcador: embarcadors) {
			if(embarcador.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmbarcador(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmbarcadorConstantesFunciones.getArrayColumnasGlobalesEmbarcador(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmbarcador(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmbarcadorConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmbarcadorConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmbarcador(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Embarcador> embarcadors,Embarcador embarcador,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Embarcador embarcadorAux: embarcadors) {
			if(embarcadorAux!=null && embarcador!=null) {
				if((embarcadorAux.getId()==null && embarcador.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(embarcadorAux.getId()!=null && embarcador.getId()!=null){
					if(embarcadorAux.getId().equals(embarcador.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmbarcador(List<Embarcador> embarcadors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Embarcador embarcador: embarcadors) {			
			if(embarcador.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmbarcador() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_ID, EmbarcadorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_VERSIONROW, EmbarcadorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_IDEMPRESA, EmbarcadorConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_NOMBRE, EmbarcadorConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_RUC, EmbarcadorConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_DIRECCION, EmbarcadorConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_TELEFONO, EmbarcadorConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_CONTACTO, EmbarcadorConstantesFunciones.CONTACTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_EMAIL, EmbarcadorConstantesFunciones.EMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_FAX, EmbarcadorConstantesFunciones.FAX,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE, EmbarcadorConstantesFunciones.IDTIPOVIATRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_IDPUERTO, EmbarcadorConstantesFunciones.IDPUERTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_IDEMPLEADO, EmbarcadorConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_IDPAIS, EmbarcadorConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmbarcadorConstantesFunciones.LABEL_IDCIUDAD, EmbarcadorConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmbarcador() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.CONTACTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.EMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.FAX;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.IDTIPOVIATRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.IDPUERTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmbarcadorConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmbarcador() throws Exception  {
		return EmbarcadorConstantesFunciones.getTiposSeleccionarEmbarcador(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmbarcador(Boolean conFk) throws Exception  {
		return EmbarcadorConstantesFunciones.getTiposSeleccionarEmbarcador(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmbarcador(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmbarcadorConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EmbarcadorConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmbarcadorConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EmbarcadorConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmbarcadorConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(EmbarcadorConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmbarcadorConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(EmbarcadorConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmbarcadorConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(EmbarcadorConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmbarcadorConstantesFunciones.LABEL_CONTACTO);
			reporte.setsDescripcion(EmbarcadorConstantesFunciones.LABEL_CONTACTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmbarcadorConstantesFunciones.LABEL_EMAIL);
			reporte.setsDescripcion(EmbarcadorConstantesFunciones.LABEL_EMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmbarcadorConstantesFunciones.LABEL_FAX);
			reporte.setsDescripcion(EmbarcadorConstantesFunciones.LABEL_FAX);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmbarcadorConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);
			reporte.setsDescripcion(EmbarcadorConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmbarcadorConstantesFunciones.LABEL_IDPUERTO);
			reporte.setsDescripcion(EmbarcadorConstantesFunciones.LABEL_IDPUERTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmbarcadorConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(EmbarcadorConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmbarcadorConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(EmbarcadorConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmbarcadorConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(EmbarcadorConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmbarcador(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmbarcador(Embarcador embarcadorAux) throws Exception {
		
			embarcadorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(embarcadorAux.getEmpresa()));
			embarcadorAux.settipoviatransporte_descripcion(TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(embarcadorAux.getTipoViaTransporte()));
			embarcadorAux.setpuerto_descripcion(PuertoConstantesFunciones.getPuertoDescripcion(embarcadorAux.getPuerto()));
			embarcadorAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(embarcadorAux.getEmpleado()));
			embarcadorAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(embarcadorAux.getPais()));
			embarcadorAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(embarcadorAux.getCiudad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmbarcador(List<Embarcador> embarcadorsTemp) throws Exception {
		for(Embarcador embarcadorAux:embarcadorsTemp) {
			
			embarcadorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(embarcadorAux.getEmpresa()));
			embarcadorAux.settipoviatransporte_descripcion(TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(embarcadorAux.getTipoViaTransporte()));
			embarcadorAux.setpuerto_descripcion(PuertoConstantesFunciones.getPuertoDescripcion(embarcadorAux.getPuerto()));
			embarcadorAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(embarcadorAux.getEmpleado()));
			embarcadorAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(embarcadorAux.getPais()));
			embarcadorAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(embarcadorAux.getCiudad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmbarcador(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoViaTransporte.class));
				classes.add(new Classe(Puerto.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoViaTransporte.class)) {
						classes.add(new Classe(TipoViaTransporte.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Puerto.class)) {
						classes.add(new Classe(Puerto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmbarcador(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoViaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoViaTransporte.class)); continue;
					}

					if(Puerto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Puerto.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoViaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoViaTransporte.class)); continue;
					}

					if(Puerto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Puerto.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmbarcador(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmbarcadorConstantesFunciones.getClassesRelationshipsOfEmbarcador(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmbarcador(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PedidoCompraImpor.class));
				classes.add(new Classe(ParametroCompra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoCompraImpor.class)) {
						classes.add(new Classe(PedidoCompraImpor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCompra.class)) {
						classes.add(new Classe(ParametroCompra.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmbarcador(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmbarcadorConstantesFunciones.getClassesRelationshipsFromStringsOfEmbarcador(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmbarcador(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoCompraImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompraImpor.class)); continue;
					}

					if(ParametroCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCompra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoCompraImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompraImpor.class)); continue;
					}

					if(ParametroCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCompra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Embarcador embarcador,List<Embarcador> embarcadors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Embarcador embarcadorEncontrado=null;
			
			for(Embarcador embarcadorLocal:embarcadors) {
				if(embarcadorLocal.getId().equals(embarcador.getId())) {
					embarcadorEncontrado=embarcadorLocal;
					
					embarcadorLocal.setIsChanged(embarcador.getIsChanged());
					embarcadorLocal.setIsNew(embarcador.getIsNew());
					embarcadorLocal.setIsDeleted(embarcador.getIsDeleted());
					
					embarcadorLocal.setGeneralEntityOriginal(embarcador.getGeneralEntityOriginal());
					
					embarcadorLocal.setId(embarcador.getId());	
					embarcadorLocal.setVersionRow(embarcador.getVersionRow());	
					embarcadorLocal.setid_empresa(embarcador.getid_empresa());	
					embarcadorLocal.setnombre(embarcador.getnombre());	
					embarcadorLocal.setruc(embarcador.getruc());	
					embarcadorLocal.setdireccion(embarcador.getdireccion());	
					embarcadorLocal.settelefono(embarcador.gettelefono());	
					embarcadorLocal.setcontacto(embarcador.getcontacto());	
					embarcadorLocal.sete_mail(embarcador.gete_mail());	
					embarcadorLocal.setfax(embarcador.getfax());	
					embarcadorLocal.setid_tipo_via_transporte(embarcador.getid_tipo_via_transporte());	
					embarcadorLocal.setid_puerto(embarcador.getid_puerto());	
					embarcadorLocal.setid_empleado(embarcador.getid_empleado());	
					embarcadorLocal.setid_pais(embarcador.getid_pais());	
					embarcadorLocal.setid_ciudad(embarcador.getid_ciudad());	
					
					
					embarcadorLocal.setPedidoCompraImpors(embarcador.getPedidoCompraImpors());
					embarcadorLocal.setParametroCompras(embarcador.getParametroCompras());
					
					existe=true;
					break;
				}
			}
			
			if(!embarcador.getIsDeleted()) {
				if(!existe) {
					embarcadors.add(embarcador);
				}
			} else {
				if(embarcadorEncontrado!=null && permiteQuitar)  {
					embarcadors.remove(embarcadorEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Embarcador embarcador,List<Embarcador> embarcadors) throws Exception {
		try	{			
			for(Embarcador embarcadorLocal:embarcadors) {
				if(embarcadorLocal.getId().equals(embarcador.getId())) {
					embarcadorLocal.setIsSelected(embarcador.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmbarcador(List<Embarcador> embarcadorsAux) throws Exception {
		//this.embarcadorsAux=embarcadorsAux;
		
		for(Embarcador embarcadorAux:embarcadorsAux) {
			if(embarcadorAux.getIsChanged()) {
				embarcadorAux.setIsChanged(false);
			}		
			
			if(embarcadorAux.getIsNew()) {
				embarcadorAux.setIsNew(false);
			}	
			
			if(embarcadorAux.getIsDeleted()) {
				embarcadorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmbarcador(Embarcador embarcadorAux) throws Exception {
		//this.embarcadorAux=embarcadorAux;
		
			if(embarcadorAux.getIsChanged()) {
				embarcadorAux.setIsChanged(false);
			}		
			
			if(embarcadorAux.getIsNew()) {
				embarcadorAux.setIsNew(false);
			}	
			
			if(embarcadorAux.getIsDeleted()) {
				embarcadorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Embarcador embarcadorAsignar,Embarcador embarcador) throws Exception {
		embarcadorAsignar.setId(embarcador.getId());	
		embarcadorAsignar.setVersionRow(embarcador.getVersionRow());	
		embarcadorAsignar.setid_empresa(embarcador.getid_empresa());
		embarcadorAsignar.setempresa_descripcion(embarcador.getempresa_descripcion());	
		embarcadorAsignar.setnombre(embarcador.getnombre());	
		embarcadorAsignar.setruc(embarcador.getruc());	
		embarcadorAsignar.setdireccion(embarcador.getdireccion());	
		embarcadorAsignar.settelefono(embarcador.gettelefono());	
		embarcadorAsignar.setcontacto(embarcador.getcontacto());	
		embarcadorAsignar.sete_mail(embarcador.gete_mail());	
		embarcadorAsignar.setfax(embarcador.getfax());	
		embarcadorAsignar.setid_tipo_via_transporte(embarcador.getid_tipo_via_transporte());
		embarcadorAsignar.settipoviatransporte_descripcion(embarcador.gettipoviatransporte_descripcion());	
		embarcadorAsignar.setid_puerto(embarcador.getid_puerto());
		embarcadorAsignar.setpuerto_descripcion(embarcador.getpuerto_descripcion());	
		embarcadorAsignar.setid_empleado(embarcador.getid_empleado());
		embarcadorAsignar.setempleado_descripcion(embarcador.getempleado_descripcion());	
		embarcadorAsignar.setid_pais(embarcador.getid_pais());
		embarcadorAsignar.setpais_descripcion(embarcador.getpais_descripcion());	
		embarcadorAsignar.setid_ciudad(embarcador.getid_ciudad());
		embarcadorAsignar.setciudad_descripcion(embarcador.getciudad_descripcion());	
	}
	
	public static void inicializarEmbarcador(Embarcador embarcador) throws Exception {
		try {
				embarcador.setId(0L);	
					
				embarcador.setid_empresa(-1L);	
				embarcador.setnombre("");	
				embarcador.setruc("");	
				embarcador.setdireccion("");	
				embarcador.settelefono("");	
				embarcador.setcontacto("");	
				embarcador.sete_mail("");	
				embarcador.setfax("");	
				embarcador.setid_tipo_via_transporte(-1L);	
				embarcador.setid_puerto(-1L);	
				embarcador.setid_empleado(-1L);	
				embarcador.setid_pais(-1L);	
				embarcador.setid_ciudad(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmbarcador(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmbarcadorConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmbarcadorConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmbarcadorConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmbarcadorConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmbarcadorConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmbarcadorConstantesFunciones.LABEL_CONTACTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmbarcadorConstantesFunciones.LABEL_EMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmbarcadorConstantesFunciones.LABEL_FAX);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmbarcadorConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmbarcadorConstantesFunciones.LABEL_IDPUERTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmbarcadorConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmbarcadorConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmbarcadorConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmbarcador(String sTipo,Row row,Workbook workbook,Embarcador embarcador,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(embarcador.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(embarcador.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(embarcador.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(embarcador.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(embarcador.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(embarcador.getcontacto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(embarcador.gete_mail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(embarcador.getfax());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(embarcador.gettipoviatransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(embarcador.getpuerto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(embarcador.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(embarcador.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(embarcador.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmbarcador=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmbarcador() {
		return this.sFinalQueryEmbarcador;
	}
	
	public void setsFinalQueryEmbarcador(String sFinalQueryEmbarcador) {
		this.sFinalQueryEmbarcador= sFinalQueryEmbarcador;
	}
	
	public Border resaltarSeleccionarEmbarcador=null;
	
	public Border setResaltarSeleccionarEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmbarcador= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmbarcador() {
		return this.resaltarSeleccionarEmbarcador;
	}
	
	public void setResaltarSeleccionarEmbarcador(Border borderResaltarSeleccionarEmbarcador) {
		this.resaltarSeleccionarEmbarcador= borderResaltarSeleccionarEmbarcador;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmbarcador=null;
	public Boolean mostraridEmbarcador=true;
	public Boolean activaridEmbarcador=true;

	public Border resaltarid_empresaEmbarcador=null;
	public Boolean mostrarid_empresaEmbarcador=true;
	public Boolean activarid_empresaEmbarcador=true;
	public Boolean cargarid_empresaEmbarcador=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEmbarcador=false;//ConEventDepend=true

	public Border resaltarnombreEmbarcador=null;
	public Boolean mostrarnombreEmbarcador=true;
	public Boolean activarnombreEmbarcador=true;

	public Border resaltarrucEmbarcador=null;
	public Boolean mostrarrucEmbarcador=true;
	public Boolean activarrucEmbarcador=true;

	public Border resaltardireccionEmbarcador=null;
	public Boolean mostrardireccionEmbarcador=true;
	public Boolean activardireccionEmbarcador=true;

	public Border resaltartelefonoEmbarcador=null;
	public Boolean mostrartelefonoEmbarcador=true;
	public Boolean activartelefonoEmbarcador=true;

	public Border resaltarcontactoEmbarcador=null;
	public Boolean mostrarcontactoEmbarcador=true;
	public Boolean activarcontactoEmbarcador=true;

	public Border resaltare_mailEmbarcador=null;
	public Boolean mostrare_mailEmbarcador=true;
	public Boolean activare_mailEmbarcador=true;

	public Border resaltarfaxEmbarcador=null;
	public Boolean mostrarfaxEmbarcador=true;
	public Boolean activarfaxEmbarcador=true;

	public Border resaltarid_tipo_via_transporteEmbarcador=null;
	public Boolean mostrarid_tipo_via_transporteEmbarcador=true;
	public Boolean activarid_tipo_via_transporteEmbarcador=true;
	public Boolean cargarid_tipo_via_transporteEmbarcador=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_via_transporteEmbarcador=false;//ConEventDepend=true

	public Border resaltarid_puertoEmbarcador=null;
	public Boolean mostrarid_puertoEmbarcador=true;
	public Boolean activarid_puertoEmbarcador=true;
	public Boolean cargarid_puertoEmbarcador=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_puertoEmbarcador=false;//ConEventDepend=true

	public Border resaltarid_empleadoEmbarcador=null;
	public Boolean mostrarid_empleadoEmbarcador=true;
	public Boolean activarid_empleadoEmbarcador=true;
	public Boolean cargarid_empleadoEmbarcador=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoEmbarcador=false;//ConEventDepend=true

	public Border resaltarid_paisEmbarcador=null;
	public Boolean mostrarid_paisEmbarcador=true;
	public Boolean activarid_paisEmbarcador=true;
	public Boolean cargarid_paisEmbarcador=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisEmbarcador=false;//ConEventDepend=true

	public Border resaltarid_ciudadEmbarcador=null;
	public Boolean mostrarid_ciudadEmbarcador=true;
	public Boolean activarid_ciudadEmbarcador=true;
	public Boolean cargarid_ciudadEmbarcador=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadEmbarcador=true;//ConEventDepend=true

	
	

	public Border setResaltaridEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltaridEmbarcador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmbarcador() {
		return this.resaltaridEmbarcador;
	}

	public void setResaltaridEmbarcador(Border borderResaltar) {
		this.resaltaridEmbarcador= borderResaltar;
	}

	public Boolean getMostraridEmbarcador() {
		return this.mostraridEmbarcador;
	}

	public void setMostraridEmbarcador(Boolean mostraridEmbarcador) {
		this.mostraridEmbarcador= mostraridEmbarcador;
	}

	public Boolean getActivaridEmbarcador() {
		return this.activaridEmbarcador;
	}

	public void setActivaridEmbarcador(Boolean activaridEmbarcador) {
		this.activaridEmbarcador= activaridEmbarcador;
	}

	public Border setResaltarid_empresaEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltarid_empresaEmbarcador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEmbarcador() {
		return this.resaltarid_empresaEmbarcador;
	}

	public void setResaltarid_empresaEmbarcador(Border borderResaltar) {
		this.resaltarid_empresaEmbarcador= borderResaltar;
	}

	public Boolean getMostrarid_empresaEmbarcador() {
		return this.mostrarid_empresaEmbarcador;
	}

	public void setMostrarid_empresaEmbarcador(Boolean mostrarid_empresaEmbarcador) {
		this.mostrarid_empresaEmbarcador= mostrarid_empresaEmbarcador;
	}

	public Boolean getActivarid_empresaEmbarcador() {
		return this.activarid_empresaEmbarcador;
	}

	public void setActivarid_empresaEmbarcador(Boolean activarid_empresaEmbarcador) {
		this.activarid_empresaEmbarcador= activarid_empresaEmbarcador;
	}

	public Boolean getCargarid_empresaEmbarcador() {
		return this.cargarid_empresaEmbarcador;
	}

	public void setCargarid_empresaEmbarcador(Boolean cargarid_empresaEmbarcador) {
		this.cargarid_empresaEmbarcador= cargarid_empresaEmbarcador;
	}

	public Border setResaltarnombreEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltarnombreEmbarcador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEmbarcador() {
		return this.resaltarnombreEmbarcador;
	}

	public void setResaltarnombreEmbarcador(Border borderResaltar) {
		this.resaltarnombreEmbarcador= borderResaltar;
	}

	public Boolean getMostrarnombreEmbarcador() {
		return this.mostrarnombreEmbarcador;
	}

	public void setMostrarnombreEmbarcador(Boolean mostrarnombreEmbarcador) {
		this.mostrarnombreEmbarcador= mostrarnombreEmbarcador;
	}

	public Boolean getActivarnombreEmbarcador() {
		return this.activarnombreEmbarcador;
	}

	public void setActivarnombreEmbarcador(Boolean activarnombreEmbarcador) {
		this.activarnombreEmbarcador= activarnombreEmbarcador;
	}

	public Border setResaltarrucEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltarrucEmbarcador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucEmbarcador() {
		return this.resaltarrucEmbarcador;
	}

	public void setResaltarrucEmbarcador(Border borderResaltar) {
		this.resaltarrucEmbarcador= borderResaltar;
	}

	public Boolean getMostrarrucEmbarcador() {
		return this.mostrarrucEmbarcador;
	}

	public void setMostrarrucEmbarcador(Boolean mostrarrucEmbarcador) {
		this.mostrarrucEmbarcador= mostrarrucEmbarcador;
	}

	public Boolean getActivarrucEmbarcador() {
		return this.activarrucEmbarcador;
	}

	public void setActivarrucEmbarcador(Boolean activarrucEmbarcador) {
		this.activarrucEmbarcador= activarrucEmbarcador;
	}

	public Border setResaltardireccionEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltardireccionEmbarcador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionEmbarcador() {
		return this.resaltardireccionEmbarcador;
	}

	public void setResaltardireccionEmbarcador(Border borderResaltar) {
		this.resaltardireccionEmbarcador= borderResaltar;
	}

	public Boolean getMostrardireccionEmbarcador() {
		return this.mostrardireccionEmbarcador;
	}

	public void setMostrardireccionEmbarcador(Boolean mostrardireccionEmbarcador) {
		this.mostrardireccionEmbarcador= mostrardireccionEmbarcador;
	}

	public Boolean getActivardireccionEmbarcador() {
		return this.activardireccionEmbarcador;
	}

	public void setActivardireccionEmbarcador(Boolean activardireccionEmbarcador) {
		this.activardireccionEmbarcador= activardireccionEmbarcador;
	}

	public Border setResaltartelefonoEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltartelefonoEmbarcador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoEmbarcador() {
		return this.resaltartelefonoEmbarcador;
	}

	public void setResaltartelefonoEmbarcador(Border borderResaltar) {
		this.resaltartelefonoEmbarcador= borderResaltar;
	}

	public Boolean getMostrartelefonoEmbarcador() {
		return this.mostrartelefonoEmbarcador;
	}

	public void setMostrartelefonoEmbarcador(Boolean mostrartelefonoEmbarcador) {
		this.mostrartelefonoEmbarcador= mostrartelefonoEmbarcador;
	}

	public Boolean getActivartelefonoEmbarcador() {
		return this.activartelefonoEmbarcador;
	}

	public void setActivartelefonoEmbarcador(Boolean activartelefonoEmbarcador) {
		this.activartelefonoEmbarcador= activartelefonoEmbarcador;
	}

	public Border setResaltarcontactoEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltarcontactoEmbarcador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcontactoEmbarcador() {
		return this.resaltarcontactoEmbarcador;
	}

	public void setResaltarcontactoEmbarcador(Border borderResaltar) {
		this.resaltarcontactoEmbarcador= borderResaltar;
	}

	public Boolean getMostrarcontactoEmbarcador() {
		return this.mostrarcontactoEmbarcador;
	}

	public void setMostrarcontactoEmbarcador(Boolean mostrarcontactoEmbarcador) {
		this.mostrarcontactoEmbarcador= mostrarcontactoEmbarcador;
	}

	public Boolean getActivarcontactoEmbarcador() {
		return this.activarcontactoEmbarcador;
	}

	public void setActivarcontactoEmbarcador(Boolean activarcontactoEmbarcador) {
		this.activarcontactoEmbarcador= activarcontactoEmbarcador;
	}

	public Border setResaltare_mailEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltare_mailEmbarcador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltare_mailEmbarcador() {
		return this.resaltare_mailEmbarcador;
	}

	public void setResaltare_mailEmbarcador(Border borderResaltar) {
		this.resaltare_mailEmbarcador= borderResaltar;
	}

	public Boolean getMostrare_mailEmbarcador() {
		return this.mostrare_mailEmbarcador;
	}

	public void setMostrare_mailEmbarcador(Boolean mostrare_mailEmbarcador) {
		this.mostrare_mailEmbarcador= mostrare_mailEmbarcador;
	}

	public Boolean getActivare_mailEmbarcador() {
		return this.activare_mailEmbarcador;
	}

	public void setActivare_mailEmbarcador(Boolean activare_mailEmbarcador) {
		this.activare_mailEmbarcador= activare_mailEmbarcador;
	}

	public Border setResaltarfaxEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltarfaxEmbarcador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfaxEmbarcador() {
		return this.resaltarfaxEmbarcador;
	}

	public void setResaltarfaxEmbarcador(Border borderResaltar) {
		this.resaltarfaxEmbarcador= borderResaltar;
	}

	public Boolean getMostrarfaxEmbarcador() {
		return this.mostrarfaxEmbarcador;
	}

	public void setMostrarfaxEmbarcador(Boolean mostrarfaxEmbarcador) {
		this.mostrarfaxEmbarcador= mostrarfaxEmbarcador;
	}

	public Boolean getActivarfaxEmbarcador() {
		return this.activarfaxEmbarcador;
	}

	public void setActivarfaxEmbarcador(Boolean activarfaxEmbarcador) {
		this.activarfaxEmbarcador= activarfaxEmbarcador;
	}

	public Border setResaltarid_tipo_via_transporteEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltarid_tipo_via_transporteEmbarcador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_via_transporteEmbarcador() {
		return this.resaltarid_tipo_via_transporteEmbarcador;
	}

	public void setResaltarid_tipo_via_transporteEmbarcador(Border borderResaltar) {
		this.resaltarid_tipo_via_transporteEmbarcador= borderResaltar;
	}

	public Boolean getMostrarid_tipo_via_transporteEmbarcador() {
		return this.mostrarid_tipo_via_transporteEmbarcador;
	}

	public void setMostrarid_tipo_via_transporteEmbarcador(Boolean mostrarid_tipo_via_transporteEmbarcador) {
		this.mostrarid_tipo_via_transporteEmbarcador= mostrarid_tipo_via_transporteEmbarcador;
	}

	public Boolean getActivarid_tipo_via_transporteEmbarcador() {
		return this.activarid_tipo_via_transporteEmbarcador;
	}

	public void setActivarid_tipo_via_transporteEmbarcador(Boolean activarid_tipo_via_transporteEmbarcador) {
		this.activarid_tipo_via_transporteEmbarcador= activarid_tipo_via_transporteEmbarcador;
	}

	public Boolean getCargarid_tipo_via_transporteEmbarcador() {
		return this.cargarid_tipo_via_transporteEmbarcador;
	}

	public void setCargarid_tipo_via_transporteEmbarcador(Boolean cargarid_tipo_via_transporteEmbarcador) {
		this.cargarid_tipo_via_transporteEmbarcador= cargarid_tipo_via_transporteEmbarcador;
	}

	public Border setResaltarid_puertoEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltarid_puertoEmbarcador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_puertoEmbarcador() {
		return this.resaltarid_puertoEmbarcador;
	}

	public void setResaltarid_puertoEmbarcador(Border borderResaltar) {
		this.resaltarid_puertoEmbarcador= borderResaltar;
	}

	public Boolean getMostrarid_puertoEmbarcador() {
		return this.mostrarid_puertoEmbarcador;
	}

	public void setMostrarid_puertoEmbarcador(Boolean mostrarid_puertoEmbarcador) {
		this.mostrarid_puertoEmbarcador= mostrarid_puertoEmbarcador;
	}

	public Boolean getActivarid_puertoEmbarcador() {
		return this.activarid_puertoEmbarcador;
	}

	public void setActivarid_puertoEmbarcador(Boolean activarid_puertoEmbarcador) {
		this.activarid_puertoEmbarcador= activarid_puertoEmbarcador;
	}

	public Boolean getCargarid_puertoEmbarcador() {
		return this.cargarid_puertoEmbarcador;
	}

	public void setCargarid_puertoEmbarcador(Boolean cargarid_puertoEmbarcador) {
		this.cargarid_puertoEmbarcador= cargarid_puertoEmbarcador;
	}

	public Border setResaltarid_empleadoEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltarid_empleadoEmbarcador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoEmbarcador() {
		return this.resaltarid_empleadoEmbarcador;
	}

	public void setResaltarid_empleadoEmbarcador(Border borderResaltar) {
		this.resaltarid_empleadoEmbarcador= borderResaltar;
	}

	public Boolean getMostrarid_empleadoEmbarcador() {
		return this.mostrarid_empleadoEmbarcador;
	}

	public void setMostrarid_empleadoEmbarcador(Boolean mostrarid_empleadoEmbarcador) {
		this.mostrarid_empleadoEmbarcador= mostrarid_empleadoEmbarcador;
	}

	public Boolean getActivarid_empleadoEmbarcador() {
		return this.activarid_empleadoEmbarcador;
	}

	public void setActivarid_empleadoEmbarcador(Boolean activarid_empleadoEmbarcador) {
		this.activarid_empleadoEmbarcador= activarid_empleadoEmbarcador;
	}

	public Boolean getCargarid_empleadoEmbarcador() {
		return this.cargarid_empleadoEmbarcador;
	}

	public void setCargarid_empleadoEmbarcador(Boolean cargarid_empleadoEmbarcador) {
		this.cargarid_empleadoEmbarcador= cargarid_empleadoEmbarcador;
	}

	public Border setResaltarid_paisEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltarid_paisEmbarcador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisEmbarcador() {
		return this.resaltarid_paisEmbarcador;
	}

	public void setResaltarid_paisEmbarcador(Border borderResaltar) {
		this.resaltarid_paisEmbarcador= borderResaltar;
	}

	public Boolean getMostrarid_paisEmbarcador() {
		return this.mostrarid_paisEmbarcador;
	}

	public void setMostrarid_paisEmbarcador(Boolean mostrarid_paisEmbarcador) {
		this.mostrarid_paisEmbarcador= mostrarid_paisEmbarcador;
	}

	public Boolean getActivarid_paisEmbarcador() {
		return this.activarid_paisEmbarcador;
	}

	public void setActivarid_paisEmbarcador(Boolean activarid_paisEmbarcador) {
		this.activarid_paisEmbarcador= activarid_paisEmbarcador;
	}

	public Boolean getCargarid_paisEmbarcador() {
		return this.cargarid_paisEmbarcador;
	}

	public void setCargarid_paisEmbarcador(Boolean cargarid_paisEmbarcador) {
		this.cargarid_paisEmbarcador= cargarid_paisEmbarcador;
	}

	public Border setResaltarid_ciudadEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltar);
		
		this.resaltarid_ciudadEmbarcador= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadEmbarcador() {
		return this.resaltarid_ciudadEmbarcador;
	}

	public void setResaltarid_ciudadEmbarcador(Border borderResaltar) {
		this.resaltarid_ciudadEmbarcador= borderResaltar;
	}

	public Boolean getMostrarid_ciudadEmbarcador() {
		return this.mostrarid_ciudadEmbarcador;
	}

	public void setMostrarid_ciudadEmbarcador(Boolean mostrarid_ciudadEmbarcador) {
		this.mostrarid_ciudadEmbarcador= mostrarid_ciudadEmbarcador;
	}

	public Boolean getActivarid_ciudadEmbarcador() {
		return this.activarid_ciudadEmbarcador;
	}

	public void setActivarid_ciudadEmbarcador(Boolean activarid_ciudadEmbarcador) {
		this.activarid_ciudadEmbarcador= activarid_ciudadEmbarcador;
	}

	public Boolean getCargarid_ciudadEmbarcador() {
		return this.cargarid_ciudadEmbarcador;
	}

	public void setCargarid_ciudadEmbarcador(Boolean cargarid_ciudadEmbarcador) {
		this.cargarid_ciudadEmbarcador= cargarid_ciudadEmbarcador;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridEmbarcador(esInicial);
		this.setMostrarid_empresaEmbarcador(esInicial);
		this.setMostrarnombreEmbarcador(esInicial);
		this.setMostrarrucEmbarcador(esInicial);
		this.setMostrardireccionEmbarcador(esInicial);
		this.setMostrartelefonoEmbarcador(esInicial);
		this.setMostrarcontactoEmbarcador(esInicial);
		this.setMostrare_mailEmbarcador(esInicial);
		this.setMostrarfaxEmbarcador(esInicial);
		this.setMostrarid_tipo_via_transporteEmbarcador(esInicial);
		this.setMostrarid_puertoEmbarcador(esInicial);
		this.setMostrarid_empleadoEmbarcador(esInicial);
		this.setMostrarid_paisEmbarcador(esInicial);
		this.setMostrarid_ciudadEmbarcador(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmbarcadorConstantesFunciones.ID)) {
				this.setMostraridEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.RUC)) {
				this.setMostrarrucEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.CONTACTO)) {
				this.setMostrarcontactoEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.EMAIL)) {
				this.setMostrare_mailEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.FAX)) {
				this.setMostrarfaxEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setMostrarid_tipo_via_transporteEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDPUERTO)) {
				this.setMostrarid_puertoEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadEmbarcador(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridEmbarcador(esInicial);
		this.setActivarid_empresaEmbarcador(esInicial);
		this.setActivarnombreEmbarcador(esInicial);
		this.setActivarrucEmbarcador(esInicial);
		this.setActivardireccionEmbarcador(esInicial);
		this.setActivartelefonoEmbarcador(esInicial);
		this.setActivarcontactoEmbarcador(esInicial);
		this.setActivare_mailEmbarcador(esInicial);
		this.setActivarfaxEmbarcador(esInicial);
		this.setActivarid_tipo_via_transporteEmbarcador(esInicial);
		this.setActivarid_puertoEmbarcador(esInicial);
		this.setActivarid_empleadoEmbarcador(esInicial);
		this.setActivarid_paisEmbarcador(esInicial);
		this.setActivarid_ciudadEmbarcador(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmbarcadorConstantesFunciones.ID)) {
				this.setActivaridEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.RUC)) {
				this.setActivarrucEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.DIRECCION)) {
				this.setActivardireccionEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.CONTACTO)) {
				this.setActivarcontactoEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.EMAIL)) {
				this.setActivare_mailEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.FAX)) {
				this.setActivarfaxEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setActivarid_tipo_via_transporteEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDPUERTO)) {
				this.setActivarid_puertoEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadEmbarcador(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmbarcador(esInicial);
		this.setResaltarid_empresaEmbarcador(esInicial);
		this.setResaltarnombreEmbarcador(esInicial);
		this.setResaltarrucEmbarcador(esInicial);
		this.setResaltardireccionEmbarcador(esInicial);
		this.setResaltartelefonoEmbarcador(esInicial);
		this.setResaltarcontactoEmbarcador(esInicial);
		this.setResaltare_mailEmbarcador(esInicial);
		this.setResaltarfaxEmbarcador(esInicial);
		this.setResaltarid_tipo_via_transporteEmbarcador(esInicial);
		this.setResaltarid_puertoEmbarcador(esInicial);
		this.setResaltarid_empleadoEmbarcador(esInicial);
		this.setResaltarid_paisEmbarcador(esInicial);
		this.setResaltarid_ciudadEmbarcador(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmbarcadorConstantesFunciones.ID)) {
				this.setResaltaridEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.RUC)) {
				this.setResaltarrucEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.CONTACTO)) {
				this.setResaltarcontactoEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.EMAIL)) {
				this.setResaltare_mailEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.FAX)) {
				this.setResaltarfaxEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setResaltarid_tipo_via_transporteEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDPUERTO)) {
				this.setResaltarid_puertoEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisEmbarcador(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmbarcadorConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadEmbarcador(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPedidoCompraImporEmbarcador=null;

	public Border getResaltarPedidoCompraImporEmbarcador() {
		return this.resaltarPedidoCompraImporEmbarcador;
	}

	public void setResaltarPedidoCompraImporEmbarcador(Border borderResaltarPedidoCompraImpor) {
		if(borderResaltarPedidoCompraImpor!=null) {
			this.resaltarPedidoCompraImporEmbarcador= borderResaltarPedidoCompraImpor;
		}
	}

	public Border setResaltarPedidoCompraImporEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoCompraImpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltarPedidoCompraImpor);
			
		this.resaltarPedidoCompraImporEmbarcador= borderResaltarPedidoCompraImpor;

		 return borderResaltarPedidoCompraImpor;
	}



	public Boolean mostrarPedidoCompraImporEmbarcador=true;

	public Boolean getMostrarPedidoCompraImporEmbarcador() {
		return this.mostrarPedidoCompraImporEmbarcador;
	}

	public void setMostrarPedidoCompraImporEmbarcador(Boolean visibilidadResaltarPedidoCompraImpor) {
		this.mostrarPedidoCompraImporEmbarcador= visibilidadResaltarPedidoCompraImpor;
	}



	public Boolean activarPedidoCompraImporEmbarcador=true;

	public Boolean gethabilitarResaltarPedidoCompraImporEmbarcador() {
		return this.activarPedidoCompraImporEmbarcador;
	}

	public void setActivarPedidoCompraImporEmbarcador(Boolean habilitarResaltarPedidoCompraImpor) {
		this.activarPedidoCompraImporEmbarcador= habilitarResaltarPedidoCompraImpor;
	}


	public Border resaltarParametroCompraEmbarcador=null;

	public Border getResaltarParametroCompraEmbarcador() {
		return this.resaltarParametroCompraEmbarcador;
	}

	public void setResaltarParametroCompraEmbarcador(Border borderResaltarParametroCompra) {
		if(borderResaltarParametroCompra!=null) {
			this.resaltarParametroCompraEmbarcador= borderResaltarParametroCompra;
		}
	}

	public Border setResaltarParametroCompraEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//embarcadorBeanSwingJInternalFrame.jTtoolBarEmbarcador.setBorder(borderResaltarParametroCompra);
			
		this.resaltarParametroCompraEmbarcador= borderResaltarParametroCompra;

		 return borderResaltarParametroCompra;
	}



	public Boolean mostrarParametroCompraEmbarcador=true;

	public Boolean getMostrarParametroCompraEmbarcador() {
		return this.mostrarParametroCompraEmbarcador;
	}

	public void setMostrarParametroCompraEmbarcador(Boolean visibilidadResaltarParametroCompra) {
		this.mostrarParametroCompraEmbarcador= visibilidadResaltarParametroCompra;
	}



	public Boolean activarParametroCompraEmbarcador=true;

	public Boolean gethabilitarResaltarParametroCompraEmbarcador() {
		return this.activarParametroCompraEmbarcador;
	}

	public void setActivarParametroCompraEmbarcador(Boolean habilitarResaltarParametroCompra) {
		this.activarParametroCompraEmbarcador= habilitarResaltarParametroCompra;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarPedidoCompraImporEmbarcador(esInicial);
		this.setMostrarParametroCompraEmbarcador(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoCompraImpor.class)) {
				this.setMostrarPedidoCompraImporEmbarcador(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCompra.class)) {
				this.setMostrarParametroCompraEmbarcador(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarPedidoCompraImporEmbarcador(esInicial);
		this.setActivarParametroCompraEmbarcador(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoCompraImpor.class)) {
				this.setActivarPedidoCompraImporEmbarcador(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCompra.class)) {
				this.setActivarParametroCompraEmbarcador(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPedidoCompraImporEmbarcador(esInicial);
		this.setResaltarParametroCompraEmbarcador(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoCompraImpor.class)) {
				this.setResaltarPedidoCompraImporEmbarcador(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCompra.class)) {
				this.setResaltarParametroCompraEmbarcador(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorContactoEmbarcador=true;

	public Boolean getMostrarBusquedaPorContactoEmbarcador() {
		return this.mostrarBusquedaPorContactoEmbarcador;
	}

	public void setMostrarBusquedaPorContactoEmbarcador(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorContactoEmbarcador= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreEmbarcador=true;

	public Boolean getMostrarBusquedaPorNombreEmbarcador() {
		return this.mostrarBusquedaPorNombreEmbarcador;
	}

	public void setMostrarBusquedaPorNombreEmbarcador(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreEmbarcador= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorTelefonoEmbarcador=true;

	public Boolean getMostrarBusquedaPorTelefonoEmbarcador() {
		return this.mostrarBusquedaPorTelefonoEmbarcador;
	}

	public void setMostrarBusquedaPorTelefonoEmbarcador(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorTelefonoEmbarcador= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoEmbarcador=true;

	public Boolean getMostrarFK_IdEmpleadoEmbarcador() {
		return this.mostrarFK_IdEmpleadoEmbarcador;
	}

	public void setMostrarFK_IdEmpleadoEmbarcador(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEmbarcador= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEmbarcador=true;

	public Boolean getMostrarFK_IdEmpresaEmbarcador() {
		return this.mostrarFK_IdEmpresaEmbarcador;
	}

	public void setMostrarFK_IdEmpresaEmbarcador(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEmbarcador= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPuertoEmbarcador=true;

	public Boolean getMostrarFK_IdPuertoEmbarcador() {
		return this.mostrarFK_IdPuertoEmbarcador;
	}

	public void setMostrarFK_IdPuertoEmbarcador(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPuertoEmbarcador= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorContactoEmbarcador=true;

	public Boolean getActivarBusquedaPorContactoEmbarcador() {
		return this.activarBusquedaPorContactoEmbarcador;
	}

	public void setActivarBusquedaPorContactoEmbarcador(Boolean habilitarResaltar) {
		this.activarBusquedaPorContactoEmbarcador= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreEmbarcador=true;

	public Boolean getActivarBusquedaPorNombreEmbarcador() {
		return this.activarBusquedaPorNombreEmbarcador;
	}

	public void setActivarBusquedaPorNombreEmbarcador(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreEmbarcador= habilitarResaltar;
	}

	public Boolean activarBusquedaPorTelefonoEmbarcador=true;

	public Boolean getActivarBusquedaPorTelefonoEmbarcador() {
		return this.activarBusquedaPorTelefonoEmbarcador;
	}

	public void setActivarBusquedaPorTelefonoEmbarcador(Boolean habilitarResaltar) {
		this.activarBusquedaPorTelefonoEmbarcador= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoEmbarcador=true;

	public Boolean getActivarFK_IdEmpleadoEmbarcador() {
		return this.activarFK_IdEmpleadoEmbarcador;
	}

	public void setActivarFK_IdEmpleadoEmbarcador(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEmbarcador= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEmbarcador=true;

	public Boolean getActivarFK_IdEmpresaEmbarcador() {
		return this.activarFK_IdEmpresaEmbarcador;
	}

	public void setActivarFK_IdEmpresaEmbarcador(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEmbarcador= habilitarResaltar;
	}

	public Boolean activarFK_IdPuertoEmbarcador=true;

	public Boolean getActivarFK_IdPuertoEmbarcador() {
		return this.activarFK_IdPuertoEmbarcador;
	}

	public void setActivarFK_IdPuertoEmbarcador(Boolean habilitarResaltar) {
		this.activarFK_IdPuertoEmbarcador= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorContactoEmbarcador=null;

	public Border getResaltarBusquedaPorContactoEmbarcador() {
		return this.resaltarBusquedaPorContactoEmbarcador;
	}

	public void setResaltarBusquedaPorContactoEmbarcador(Border borderResaltar) {
		this.resaltarBusquedaPorContactoEmbarcador= borderResaltar;
	}

	public void setResaltarBusquedaPorContactoEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorContactoEmbarcador= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreEmbarcador=null;

	public Border getResaltarBusquedaPorNombreEmbarcador() {
		return this.resaltarBusquedaPorNombreEmbarcador;
	}

	public void setResaltarBusquedaPorNombreEmbarcador(Border borderResaltar) {
		this.resaltarBusquedaPorNombreEmbarcador= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreEmbarcador= borderResaltar;
	}

	public Border resaltarBusquedaPorTelefonoEmbarcador=null;

	public Border getResaltarBusquedaPorTelefonoEmbarcador() {
		return this.resaltarBusquedaPorTelefonoEmbarcador;
	}

	public void setResaltarBusquedaPorTelefonoEmbarcador(Border borderResaltar) {
		this.resaltarBusquedaPorTelefonoEmbarcador= borderResaltar;
	}

	public void setResaltarBusquedaPorTelefonoEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorTelefonoEmbarcador= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoEmbarcador=null;

	public Border getResaltarFK_IdEmpleadoEmbarcador() {
		return this.resaltarFK_IdEmpleadoEmbarcador;
	}

	public void setResaltarFK_IdEmpleadoEmbarcador(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEmbarcador= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEmbarcador= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEmbarcador=null;

	public Border getResaltarFK_IdEmpresaEmbarcador() {
		return this.resaltarFK_IdEmpresaEmbarcador;
	}

	public void setResaltarFK_IdEmpresaEmbarcador(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEmbarcador= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEmbarcador= borderResaltar;
	}

	public Border resaltarFK_IdPuertoEmbarcador=null;

	public Border getResaltarFK_IdPuertoEmbarcador() {
		return this.resaltarFK_IdPuertoEmbarcador;
	}

	public void setResaltarFK_IdPuertoEmbarcador(Border borderResaltar) {
		this.resaltarFK_IdPuertoEmbarcador= borderResaltar;
	}

	public void setResaltarFK_IdPuertoEmbarcador(ParametroGeneralUsuario parametroGeneralUsuario/*EmbarcadorBeanSwingJInternalFrame embarcadorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPuertoEmbarcador= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}