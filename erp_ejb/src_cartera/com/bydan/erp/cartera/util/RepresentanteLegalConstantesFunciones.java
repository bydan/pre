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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.RepresentanteLegalConstantesFunciones;
import com.bydan.erp.cartera.util.RepresentanteLegalParameterReturnGeneral;
//import com.bydan.erp.cartera.util.RepresentanteLegalParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RepresentanteLegalConstantesFunciones extends RepresentanteLegalConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="RepresentanteLegal";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RepresentanteLegal"+RepresentanteLegalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RepresentanteLegalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RepresentanteLegalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RepresentanteLegalConstantesFunciones.SCHEMA+"_"+RepresentanteLegalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RepresentanteLegalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RepresentanteLegalConstantesFunciones.SCHEMA+"_"+RepresentanteLegalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RepresentanteLegalConstantesFunciones.SCHEMA+"_"+RepresentanteLegalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RepresentanteLegalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RepresentanteLegalConstantesFunciones.SCHEMA+"_"+RepresentanteLegalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RepresentanteLegalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RepresentanteLegalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RepresentanteLegalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RepresentanteLegalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RepresentanteLegalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RepresentanteLegalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RepresentanteLegalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RepresentanteLegalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RepresentanteLegalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RepresentanteLegalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Representante Legales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Representante Legal";
	public static final String SCLASSWEBTITULO_LOWER="Representante Legal";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RepresentanteLegal";
	public static final String OBJECTNAME="representantelegal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="representantelegal";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select representantelegal from "+RepresentanteLegalConstantesFunciones.SPERSISTENCENAME+" representantelegal";
	public static String QUERYSELECTNATIVE="select "+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".id,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".version_row,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".idcliente,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".idvalorclientedocumento,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".id_pais,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".idciudad,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".identificacion,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".apellidopaterno,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".apellidomaterno,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".primernombre,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".segundonombre,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".direccion,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".telefono,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".telefonocodigoarea,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".extension,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".telefonomovil,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".montoaurorizado,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".email,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".estaactivo from "+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME;//+" as "+RepresentanteLegalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RepresentanteLegalConstantesFuncionesAdditional representantelegalConstantesFuncionesAdditional=null;
	
	public RepresentanteLegalConstantesFuncionesAdditional getRepresentanteLegalConstantesFuncionesAdditional() {
		return this.representantelegalConstantesFuncionesAdditional;
	}
	
	public void setRepresentanteLegalConstantesFuncionesAdditional(RepresentanteLegalConstantesFuncionesAdditional representantelegalConstantesFuncionesAdditional) {
		try {
			this.representantelegalConstantesFuncionesAdditional=representantelegalConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCLIENTE= "idcliente";
    public static final String IDTIPOIDENTIFICACION= "idvalorclientedocumento";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "idciudad";
    public static final String IDENTIFICACION= "identificacion";
    public static final String APELLIDOPATERNO= "apellidopaterno";
    public static final String APELLIDOMATERNO= "apellidomaterno";
    public static final String PRIMERNOMBRE= "primernombre";
    public static final String SEGUNDONOMBRE= "segundonombre";
    public static final String DIRECCION= "direccion";
    public static final String TELEFONO= "telefono";
    public static final String TELEFONOCODIGOAREA= "telefonocodigoarea";
    public static final String EXTENSION= "extension";
    public static final String TELEFONOMOVIL= "telefonomovil";
    public static final String MONTOAURORIZADO= "montoaurorizado";
    public static final String EMAIL= "email";
    public static final String ESTAACTIVO= "estaactivo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOIDENTIFICACION= "Tipo Identificacion";
		public static final String LABEL_IDTIPOIDENTIFICACION_LOWER= "Tipo Identificacion";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDENTIFICACION= "Identificacion";
		public static final String LABEL_IDENTIFICACION_LOWER= "Identificacion";
    	public static final String LABEL_APELLIDOPATERNO= "Apellido Paterno";
		public static final String LABEL_APELLIDOPATERNO_LOWER= "Apellido Paterno";
    	public static final String LABEL_APELLIDOMATERNO= "Apellido Materno";
		public static final String LABEL_APELLIDOMATERNO_LOWER= "Apellido Materno";
    	public static final String LABEL_PRIMERNOMBRE= "Primer Nombre";
		public static final String LABEL_PRIMERNOMBRE_LOWER= "Primer Nombre";
    	public static final String LABEL_SEGUNDONOMBRE= "Segundo Nombre";
		public static final String LABEL_SEGUNDONOMBRE_LOWER= "Segundo Nombre";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_TELEFONOCODIGOAREA= "Telefono Codigo Area";
		public static final String LABEL_TELEFONOCODIGOAREA_LOWER= "Telefono Codigo Area";
    	public static final String LABEL_EXTENSION= "Extension";
		public static final String LABEL_EXTENSION_LOWER= "Extension";
    	public static final String LABEL_TELEFONOMOVIL= "Telefono Movil";
		public static final String LABEL_TELEFONOMOVIL_LOWER= "Telefono Movil";
    	public static final String LABEL_MONTOAURORIZADO= "Monto Aurorizado";
		public static final String LABEL_MONTOAURORIZADO_LOWER= "Monto Aurorizado";
    	public static final String LABEL_EMAIL= "Email";
		public static final String LABEL_EMAIL_LOWER= "Email";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
	public static final String SREGEXIDENTIFICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXIDENTIFICACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDOPATERNO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDOPATERNO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDOMATERNO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDOMATERNO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPRIMERNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPRIMERNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSEGUNDONOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSEGUNDONOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXTELEFONOCODIGOAREA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONOCODIGOAREA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXEXTENSION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEXTENSION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONOMOVIL=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONOMOVIL=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
		
	public static final String SREGEXEMAIL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEMAIL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getRepresentanteLegalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.IDCLIENTE)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.IDTIPOIDENTIFICACION)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_IDTIPOIDENTIFICACION;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.IDPAIS)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.IDCIUDAD)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.IDENTIFICACION)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_IDENTIFICACION;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.APELLIDOPATERNO)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_APELLIDOPATERNO;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.APELLIDOMATERNO)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_APELLIDOMATERNO;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.PRIMERNOMBRE)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_PRIMERNOMBRE;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.SEGUNDONOMBRE)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_SEGUNDONOMBRE;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.DIRECCION)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.TELEFONO)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.TELEFONOCODIGOAREA)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_TELEFONOCODIGOAREA;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.EXTENSION)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_EXTENSION;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.TELEFONOMOVIL)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_TELEFONOMOVIL;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.MONTOAURORIZADO)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_MONTOAURORIZADO;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.EMAIL)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_EMAIL;}
		if(sNombreColumna.equals(RepresentanteLegalConstantesFunciones.ESTAACTIVO)) {sLabelColumna=RepresentanteLegalConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getestaactivoDescripcion(RepresentanteLegal representantelegal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!representantelegal.getestaactivo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getestaactivoHtmlDescripcion(RepresentanteLegal representantelegal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(representantelegal.getId(),representantelegal.getestaactivo());

		return sDescripcion;
	}	
	
	public static String getRepresentanteLegalDescripcion(RepresentanteLegal representantelegal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(representantelegal !=null/* && representantelegal.getId()!=0*/) {
			if(representantelegal.getId()!=null) {
				sDescripcion=representantelegal.getId().toString();
			}//representantelegalrepresentantelegal.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRepresentanteLegalDescripcionDetallado(RepresentanteLegal representantelegal) {
		String sDescripcion="";
			
		sDescripcion+=RepresentanteLegalConstantesFunciones.ID+"=";
		sDescripcion+=representantelegal.getId().toString()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=representantelegal.getVersionRow().toString()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=representantelegal.getidcliente().toString()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.IDTIPOIDENTIFICACION+"=";
		sDescripcion+=representantelegal.getidvalorclientedocumento().toString()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.IDPAIS+"=";
		sDescripcion+=representantelegal.getid_pais().toString()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=representantelegal.getidciudad().toString()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.IDENTIFICACION+"=";
		sDescripcion+=representantelegal.getidentificacion()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.APELLIDOPATERNO+"=";
		sDescripcion+=representantelegal.getapellidopaterno()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.APELLIDOMATERNO+"=";
		sDescripcion+=representantelegal.getapellidomaterno()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.PRIMERNOMBRE+"=";
		sDescripcion+=representantelegal.getprimernombre()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.SEGUNDONOMBRE+"=";
		sDescripcion+=representantelegal.getsegundonombre()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.DIRECCION+"=";
		sDescripcion+=representantelegal.getdireccion()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.TELEFONO+"=";
		sDescripcion+=representantelegal.gettelefono()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.TELEFONOCODIGOAREA+"=";
		sDescripcion+=representantelegal.gettelefonocodigoarea()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.EXTENSION+"=";
		sDescripcion+=representantelegal.getextension()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.TELEFONOMOVIL+"=";
		sDescripcion+=representantelegal.gettelefonomovil()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.MONTOAURORIZADO+"=";
		sDescripcion+=representantelegal.getmontoaurorizado().toString()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.EMAIL+"=";
		sDescripcion+=representantelegal.getemail()+",";
		sDescripcion+=RepresentanteLegalConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=representantelegal.getestaactivo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRepresentanteLegalDescripcion(RepresentanteLegal representantelegal,String sValor) throws Exception {			
		if(representantelegal !=null) {
			//representantelegalrepresentantelegal.getId().toString();
		}		
	}
	
		

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoIdentificacionDescripcion(TipoIdentificacion tipoidentificacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoidentificacion!=null/*&&tipoidentificacion.getId()>0*/) {
			sDescripcion=TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(tipoidentificacion);
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
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdValorClienteDocumento")) {
			sNombreIndice="Tipo=  Por Tipo Identificacion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCiudad(Long idciudad) {
		String sDetalleIndice=" Parametros->";
		if(idciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+idciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long idcliente) {
		String sDetalleIndice=" Parametros->";
		if(idcliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+idcliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdValorClienteDocumento(Long idvalorclientedocumento) {
		String sDetalleIndice=" Parametros->";
		if(idvalorclientedocumento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Identificacion="+idvalorclientedocumento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRepresentanteLegal(RepresentanteLegal representantelegal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		representantelegal.setidentificacion(representantelegal.getidentificacion().trim());
		representantelegal.setapellidopaterno(representantelegal.getapellidopaterno().trim());
		representantelegal.setapellidomaterno(representantelegal.getapellidomaterno().trim());
		representantelegal.setprimernombre(representantelegal.getprimernombre().trim());
		representantelegal.setsegundonombre(representantelegal.getsegundonombre().trim());
		representantelegal.setdireccion(representantelegal.getdireccion().trim());
		representantelegal.settelefono(representantelegal.gettelefono().trim());
		representantelegal.settelefonocodigoarea(representantelegal.gettelefonocodigoarea().trim());
		representantelegal.setextension(representantelegal.getextension().trim());
		representantelegal.settelefonomovil(representantelegal.gettelefonomovil().trim());
		representantelegal.setemail(representantelegal.getemail().trim());
	}
	
	public static void quitarEspaciosRepresentanteLegals(List<RepresentanteLegal> representantelegals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RepresentanteLegal representantelegal: representantelegals) {
			representantelegal.setidentificacion(representantelegal.getidentificacion().trim());
			representantelegal.setapellidopaterno(representantelegal.getapellidopaterno().trim());
			representantelegal.setapellidomaterno(representantelegal.getapellidomaterno().trim());
			representantelegal.setprimernombre(representantelegal.getprimernombre().trim());
			representantelegal.setsegundonombre(representantelegal.getsegundonombre().trim());
			representantelegal.setdireccion(representantelegal.getdireccion().trim());
			representantelegal.settelefono(representantelegal.gettelefono().trim());
			representantelegal.settelefonocodigoarea(representantelegal.gettelefonocodigoarea().trim());
			representantelegal.setextension(representantelegal.getextension().trim());
			representantelegal.settelefonomovil(representantelegal.gettelefonomovil().trim());
			representantelegal.setemail(representantelegal.getemail().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRepresentanteLegal(RepresentanteLegal representantelegal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && representantelegal.getConCambioAuxiliar()) {
			representantelegal.setIsDeleted(representantelegal.getIsDeletedAuxiliar());	
			representantelegal.setIsNew(representantelegal.getIsNewAuxiliar());	
			representantelegal.setIsChanged(representantelegal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			representantelegal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			representantelegal.setIsDeletedAuxiliar(false);	
			representantelegal.setIsNewAuxiliar(false);	
			representantelegal.setIsChangedAuxiliar(false);
			
			representantelegal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRepresentanteLegals(List<RepresentanteLegal> representantelegals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RepresentanteLegal representantelegal : representantelegals) {
			if(conAsignarBase && representantelegal.getConCambioAuxiliar()) {
				representantelegal.setIsDeleted(representantelegal.getIsDeletedAuxiliar());	
				representantelegal.setIsNew(representantelegal.getIsNewAuxiliar());	
				representantelegal.setIsChanged(representantelegal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				representantelegal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				representantelegal.setIsDeletedAuxiliar(false);	
				representantelegal.setIsNewAuxiliar(false);	
				representantelegal.setIsChangedAuxiliar(false);
				
				representantelegal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRepresentanteLegal(RepresentanteLegal representantelegal,Boolean conEnteros) throws Exception  {
		representantelegal.setmontoaurorizado(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRepresentanteLegals(List<RepresentanteLegal> representantelegals,Boolean conEnteros) throws Exception  {
		
		for(RepresentanteLegal representantelegal: representantelegals) {
			representantelegal.setmontoaurorizado(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRepresentanteLegal(List<RepresentanteLegal> representantelegals,RepresentanteLegal representantelegalAux) throws Exception  {
		RepresentanteLegalConstantesFunciones.InicializarValoresRepresentanteLegal(representantelegalAux,true);
		
		for(RepresentanteLegal representantelegal: representantelegals) {
			if(representantelegal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			representantelegalAux.setmontoaurorizado(representantelegalAux.getmontoaurorizado()+representantelegal.getmontoaurorizado());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRepresentanteLegal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RepresentanteLegalConstantesFunciones.getArrayColumnasGlobalesRepresentanteLegal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRepresentanteLegal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRepresentanteLegal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RepresentanteLegal> representantelegals,RepresentanteLegal representantelegal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RepresentanteLegal representantelegalAux: representantelegals) {
			if(representantelegalAux!=null && representantelegal!=null) {
				if((representantelegalAux.getId()==null && representantelegal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(representantelegalAux.getId()!=null && representantelegal.getId()!=null){
					if(representantelegalAux.getId().equals(representantelegal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRepresentanteLegal(List<RepresentanteLegal> representantelegals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoaurorizadoTotal=0.0;
	
		for(RepresentanteLegal representantelegal: representantelegals) {			
			if(representantelegal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			montoaurorizadoTotal+=representantelegal.getmontoaurorizado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RepresentanteLegalConstantesFunciones.MONTOAURORIZADO);
		datoGeneral.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_MONTOAURORIZADO);
		datoGeneral.setdValorDouble(montoaurorizadoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRepresentanteLegal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_ID, RepresentanteLegalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_VERSIONROW, RepresentanteLegalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_IDCLIENTE, RepresentanteLegalConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_IDTIPOIDENTIFICACION, RepresentanteLegalConstantesFunciones.IDTIPOIDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_IDPAIS, RepresentanteLegalConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_IDCIUDAD, RepresentanteLegalConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_IDENTIFICACION, RepresentanteLegalConstantesFunciones.IDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_APELLIDOPATERNO, RepresentanteLegalConstantesFunciones.APELLIDOPATERNO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_APELLIDOMATERNO, RepresentanteLegalConstantesFunciones.APELLIDOMATERNO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_PRIMERNOMBRE, RepresentanteLegalConstantesFunciones.PRIMERNOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_SEGUNDONOMBRE, RepresentanteLegalConstantesFunciones.SEGUNDONOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_DIRECCION, RepresentanteLegalConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_TELEFONO, RepresentanteLegalConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_TELEFONOCODIGOAREA, RepresentanteLegalConstantesFunciones.TELEFONOCODIGOAREA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_EXTENSION, RepresentanteLegalConstantesFunciones.EXTENSION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_TELEFONOMOVIL, RepresentanteLegalConstantesFunciones.TELEFONOMOVIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_MONTOAURORIZADO, RepresentanteLegalConstantesFunciones.MONTOAURORIZADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_EMAIL, RepresentanteLegalConstantesFunciones.EMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RepresentanteLegalConstantesFunciones.LABEL_ESTAACTIVO, RepresentanteLegalConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRepresentanteLegal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.IDTIPOIDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.IDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.APELLIDOPATERNO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.APELLIDOMATERNO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.PRIMERNOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.SEGUNDONOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.TELEFONOCODIGOAREA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.EXTENSION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.TELEFONOMOVIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.MONTOAURORIZADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.EMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RepresentanteLegalConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRepresentanteLegal() throws Exception  {
		return RepresentanteLegalConstantesFunciones.getTiposSeleccionarRepresentanteLegal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRepresentanteLegal(Boolean conFk) throws Exception  {
		return RepresentanteLegalConstantesFunciones.getTiposSeleccionarRepresentanteLegal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRepresentanteLegal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_IDENTIFICACION);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_IDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_APELLIDOPATERNO);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_APELLIDOPATERNO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_APELLIDOMATERNO);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_APELLIDOMATERNO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_PRIMERNOMBRE);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_PRIMERNOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_SEGUNDONOMBRE);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_SEGUNDONOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_TELEFONOCODIGOAREA);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_TELEFONOCODIGOAREA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_EXTENSION);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_EXTENSION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_TELEFONOMOVIL);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_TELEFONOMOVIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_MONTOAURORIZADO);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_MONTOAURORIZADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_EMAIL);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_EMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RepresentanteLegalConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(RepresentanteLegalConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRepresentanteLegal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRepresentanteLegal(RepresentanteLegal representantelegalAux) throws Exception {
		
			representantelegalAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(representantelegalAux.getCliente()));
			representantelegalAux.settipoidentificacion_descripcion(TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(representantelegalAux.getTipoIdentificacion()));
			representantelegalAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(representantelegalAux.getPais()));
			representantelegalAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(representantelegalAux.getCiudad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRepresentanteLegal(List<RepresentanteLegal> representantelegalsTemp) throws Exception {
		for(RepresentanteLegal representantelegalAux:representantelegalsTemp) {
			
			representantelegalAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(representantelegalAux.getCliente()));
			representantelegalAux.settipoidentificacion_descripcion(TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(representantelegalAux.getTipoIdentificacion()));
			representantelegalAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(representantelegalAux.getPais()));
			representantelegalAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(representantelegalAux.getCiudad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRepresentanteLegal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoIdentificacion.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIdentificacion.class)) {
						classes.add(new Classe(TipoIdentificacion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRepresentanteLegal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoIdentificacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIdentificacion.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoIdentificacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIdentificacion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRepresentanteLegal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RepresentanteLegalConstantesFunciones.getClassesRelationshipsOfRepresentanteLegal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRepresentanteLegal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRepresentanteLegal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RepresentanteLegalConstantesFunciones.getClassesRelationshipsFromStringsOfRepresentanteLegal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRepresentanteLegal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(RepresentanteLegal representantelegal,List<RepresentanteLegal> representantelegals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RepresentanteLegal representantelegalEncontrado=null;
			
			for(RepresentanteLegal representantelegalLocal:representantelegals) {
				if(representantelegalLocal.getId().equals(representantelegal.getId())) {
					representantelegalEncontrado=representantelegalLocal;
					
					representantelegalLocal.setIsChanged(representantelegal.getIsChanged());
					representantelegalLocal.setIsNew(representantelegal.getIsNew());
					representantelegalLocal.setIsDeleted(representantelegal.getIsDeleted());
					
					representantelegalLocal.setGeneralEntityOriginal(representantelegal.getGeneralEntityOriginal());
					
					representantelegalLocal.setId(representantelegal.getId());	
					representantelegalLocal.setVersionRow(representantelegal.getVersionRow());	
					representantelegalLocal.setidcliente(representantelegal.getidcliente());	
					representantelegalLocal.setidvalorclientedocumento(representantelegal.getidvalorclientedocumento());	
					representantelegalLocal.setid_pais(representantelegal.getid_pais());	
					representantelegalLocal.setidciudad(representantelegal.getidciudad());	
					representantelegalLocal.setidentificacion(representantelegal.getidentificacion());	
					representantelegalLocal.setapellidopaterno(representantelegal.getapellidopaterno());	
					representantelegalLocal.setapellidomaterno(representantelegal.getapellidomaterno());	
					representantelegalLocal.setprimernombre(representantelegal.getprimernombre());	
					representantelegalLocal.setsegundonombre(representantelegal.getsegundonombre());	
					representantelegalLocal.setdireccion(representantelegal.getdireccion());	
					representantelegalLocal.settelefono(representantelegal.gettelefono());	
					representantelegalLocal.settelefonocodigoarea(representantelegal.gettelefonocodigoarea());	
					representantelegalLocal.setextension(representantelegal.getextension());	
					representantelegalLocal.settelefonomovil(representantelegal.gettelefonomovil());	
					representantelegalLocal.setmontoaurorizado(representantelegal.getmontoaurorizado());	
					representantelegalLocal.setemail(representantelegal.getemail());	
					representantelegalLocal.setestaactivo(representantelegal.getestaactivo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!representantelegal.getIsDeleted()) {
				if(!existe) {
					representantelegals.add(representantelegal);
				}
			} else {
				if(representantelegalEncontrado!=null && permiteQuitar)  {
					representantelegals.remove(representantelegalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RepresentanteLegal representantelegal,List<RepresentanteLegal> representantelegals) throws Exception {
		try	{			
			for(RepresentanteLegal representantelegalLocal:representantelegals) {
				if(representantelegalLocal.getId().equals(representantelegal.getId())) {
					representantelegalLocal.setIsSelected(representantelegal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRepresentanteLegal(List<RepresentanteLegal> representantelegalsAux) throws Exception {
		//this.representantelegalsAux=representantelegalsAux;
		
		for(RepresentanteLegal representantelegalAux:representantelegalsAux) {
			if(representantelegalAux.getIsChanged()) {
				representantelegalAux.setIsChanged(false);
			}		
			
			if(representantelegalAux.getIsNew()) {
				representantelegalAux.setIsNew(false);
			}	
			
			if(representantelegalAux.getIsDeleted()) {
				representantelegalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRepresentanteLegal(RepresentanteLegal representantelegalAux) throws Exception {
		//this.representantelegalAux=representantelegalAux;
		
			if(representantelegalAux.getIsChanged()) {
				representantelegalAux.setIsChanged(false);
			}		
			
			if(representantelegalAux.getIsNew()) {
				representantelegalAux.setIsNew(false);
			}	
			
			if(representantelegalAux.getIsDeleted()) {
				representantelegalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RepresentanteLegal representantelegalAsignar,RepresentanteLegal representantelegal) throws Exception {
		representantelegalAsignar.setId(representantelegal.getId());	
		representantelegalAsignar.setVersionRow(representantelegal.getVersionRow());	
		representantelegalAsignar.setidcliente(representantelegal.getidcliente());
		representantelegalAsignar.setcliente_descripcion(representantelegal.getcliente_descripcion());	
		representantelegalAsignar.setidvalorclientedocumento(representantelegal.getidvalorclientedocumento());
		representantelegalAsignar.settipoidentificacion_descripcion(representantelegal.gettipoidentificacion_descripcion());	
		representantelegalAsignar.setid_pais(representantelegal.getid_pais());
		representantelegalAsignar.setpais_descripcion(representantelegal.getpais_descripcion());	
		representantelegalAsignar.setidciudad(representantelegal.getidciudad());
		representantelegalAsignar.setciudad_descripcion(representantelegal.getciudad_descripcion());	
		representantelegalAsignar.setidentificacion(representantelegal.getidentificacion());	
		representantelegalAsignar.setapellidopaterno(representantelegal.getapellidopaterno());	
		representantelegalAsignar.setapellidomaterno(representantelegal.getapellidomaterno());	
		representantelegalAsignar.setprimernombre(representantelegal.getprimernombre());	
		representantelegalAsignar.setsegundonombre(representantelegal.getsegundonombre());	
		representantelegalAsignar.setdireccion(representantelegal.getdireccion());	
		representantelegalAsignar.settelefono(representantelegal.gettelefono());	
		representantelegalAsignar.settelefonocodigoarea(representantelegal.gettelefonocodigoarea());	
		representantelegalAsignar.setextension(representantelegal.getextension());	
		representantelegalAsignar.settelefonomovil(representantelegal.gettelefonomovil());	
		representantelegalAsignar.setmontoaurorizado(representantelegal.getmontoaurorizado());	
		representantelegalAsignar.setemail(representantelegal.getemail());	
		representantelegalAsignar.setestaactivo(representantelegal.getestaactivo());	
	}
	
	public static void inicializarRepresentanteLegal(RepresentanteLegal representantelegal) throws Exception {
		try {
				representantelegal.setId(0L);	
					
				representantelegal.setidcliente(-1L);	
				representantelegal.setidvalorclientedocumento(-1L);	
				representantelegal.setid_pais(-1L);	
				representantelegal.setidciudad(-1L);	
				representantelegal.setidentificacion("");	
				representantelegal.setapellidopaterno("");	
				representantelegal.setapellidomaterno("");	
				representantelegal.setprimernombre("");	
				representantelegal.setsegundonombre("");	
				representantelegal.setdireccion("");	
				representantelegal.settelefono("");	
				representantelegal.settelefonocodigoarea("");	
				representantelegal.setextension("");	
				representantelegal.settelefonomovil("");	
				representantelegal.setmontoaurorizado(0.0);	
				representantelegal.setemail("");	
				representantelegal.setestaactivo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRepresentanteLegal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_IDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_APELLIDOPATERNO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_APELLIDOMATERNO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_PRIMERNOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_SEGUNDONOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_TELEFONOCODIGOAREA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_EXTENSION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_TELEFONOMOVIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_MONTOAURORIZADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_EMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RepresentanteLegalConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRepresentanteLegal(String sTipo,Row row,Workbook workbook,RepresentanteLegal representantelegal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.gettipoidentificacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.getidentificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.getapellidopaterno());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.getapellidomaterno());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.getprimernombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.getsegundonombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.gettelefonocodigoarea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.getextension());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.gettelefonomovil());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.getmontoaurorizado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(representantelegal.getemail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(representantelegal.getestaactivo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRepresentanteLegal=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRepresentanteLegal() {
		return this.sFinalQueryRepresentanteLegal;
	}
	
	public void setsFinalQueryRepresentanteLegal(String sFinalQueryRepresentanteLegal) {
		this.sFinalQueryRepresentanteLegal= sFinalQueryRepresentanteLegal;
	}
	
	public Border resaltarSeleccionarRepresentanteLegal=null;
	
	public Border setResaltarSeleccionarRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRepresentanteLegal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRepresentanteLegal() {
		return this.resaltarSeleccionarRepresentanteLegal;
	}
	
	public void setResaltarSeleccionarRepresentanteLegal(Border borderResaltarSeleccionarRepresentanteLegal) {
		this.resaltarSeleccionarRepresentanteLegal= borderResaltarSeleccionarRepresentanteLegal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRepresentanteLegal=null;
	public Boolean mostraridRepresentanteLegal=true;
	public Boolean activaridRepresentanteLegal=true;

	public Border resaltaridclienteRepresentanteLegal=null;
	public Boolean mostraridclienteRepresentanteLegal=true;
	public Boolean activaridclienteRepresentanteLegal=true;
	public Boolean cargaridclienteRepresentanteLegal=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidclienteRepresentanteLegal=false;//ConEventDepend=true

	public Border resaltaridvalorclientedocumentoRepresentanteLegal=null;
	public Boolean mostraridvalorclientedocumentoRepresentanteLegal=true;
	public Boolean activaridvalorclientedocumentoRepresentanteLegal=true;
	public Boolean cargaridvalorclientedocumentoRepresentanteLegal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvalorclientedocumentoRepresentanteLegal=false;//ConEventDepend=true

	public Border resaltarid_paisRepresentanteLegal=null;
	public Boolean mostrarid_paisRepresentanteLegal=true;
	public Boolean activarid_paisRepresentanteLegal=true;
	public Boolean cargarid_paisRepresentanteLegal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisRepresentanteLegal=false;//ConEventDepend=true

	public Border resaltaridciudadRepresentanteLegal=null;
	public Boolean mostraridciudadRepresentanteLegal=true;
	public Boolean activaridciudadRepresentanteLegal=true;
	public Boolean cargaridciudadRepresentanteLegal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidciudadRepresentanteLegal=true;//ConEventDepend=true

	public Border resaltaridentificacionRepresentanteLegal=null;
	public Boolean mostraridentificacionRepresentanteLegal=true;
	public Boolean activaridentificacionRepresentanteLegal=true;

	public Border resaltarapellidopaternoRepresentanteLegal=null;
	public Boolean mostrarapellidopaternoRepresentanteLegal=true;
	public Boolean activarapellidopaternoRepresentanteLegal=true;

	public Border resaltarapellidomaternoRepresentanteLegal=null;
	public Boolean mostrarapellidomaternoRepresentanteLegal=true;
	public Boolean activarapellidomaternoRepresentanteLegal=true;

	public Border resaltarprimernombreRepresentanteLegal=null;
	public Boolean mostrarprimernombreRepresentanteLegal=true;
	public Boolean activarprimernombreRepresentanteLegal=true;

	public Border resaltarsegundonombreRepresentanteLegal=null;
	public Boolean mostrarsegundonombreRepresentanteLegal=true;
	public Boolean activarsegundonombreRepresentanteLegal=true;

	public Border resaltardireccionRepresentanteLegal=null;
	public Boolean mostrardireccionRepresentanteLegal=true;
	public Boolean activardireccionRepresentanteLegal=true;

	public Border resaltartelefonoRepresentanteLegal=null;
	public Boolean mostrartelefonoRepresentanteLegal=true;
	public Boolean activartelefonoRepresentanteLegal=true;

	public Border resaltartelefonocodigoareaRepresentanteLegal=null;
	public Boolean mostrartelefonocodigoareaRepresentanteLegal=true;
	public Boolean activartelefonocodigoareaRepresentanteLegal=true;

	public Border resaltarextensionRepresentanteLegal=null;
	public Boolean mostrarextensionRepresentanteLegal=true;
	public Boolean activarextensionRepresentanteLegal=true;

	public Border resaltartelefonomovilRepresentanteLegal=null;
	public Boolean mostrartelefonomovilRepresentanteLegal=true;
	public Boolean activartelefonomovilRepresentanteLegal=true;

	public Border resaltarmontoaurorizadoRepresentanteLegal=null;
	public Boolean mostrarmontoaurorizadoRepresentanteLegal=true;
	public Boolean activarmontoaurorizadoRepresentanteLegal=true;

	public Border resaltaremailRepresentanteLegal=null;
	public Boolean mostraremailRepresentanteLegal=true;
	public Boolean activaremailRepresentanteLegal=true;

	public Border resaltarestaactivoRepresentanteLegal=null;
	public Boolean mostrarestaactivoRepresentanteLegal=true;
	public Boolean activarestaactivoRepresentanteLegal=true;

	
	

	public Border setResaltaridRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltaridRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRepresentanteLegal() {
		return this.resaltaridRepresentanteLegal;
	}

	public void setResaltaridRepresentanteLegal(Border borderResaltar) {
		this.resaltaridRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostraridRepresentanteLegal() {
		return this.mostraridRepresentanteLegal;
	}

	public void setMostraridRepresentanteLegal(Boolean mostraridRepresentanteLegal) {
		this.mostraridRepresentanteLegal= mostraridRepresentanteLegal;
	}

	public Boolean getActivaridRepresentanteLegal() {
		return this.activaridRepresentanteLegal;
	}

	public void setActivaridRepresentanteLegal(Boolean activaridRepresentanteLegal) {
		this.activaridRepresentanteLegal= activaridRepresentanteLegal;
	}

	public Border setResaltaridclienteRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltaridclienteRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridclienteRepresentanteLegal() {
		return this.resaltaridclienteRepresentanteLegal;
	}

	public void setResaltaridclienteRepresentanteLegal(Border borderResaltar) {
		this.resaltaridclienteRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostraridclienteRepresentanteLegal() {
		return this.mostraridclienteRepresentanteLegal;
	}

	public void setMostraridclienteRepresentanteLegal(Boolean mostraridclienteRepresentanteLegal) {
		this.mostraridclienteRepresentanteLegal= mostraridclienteRepresentanteLegal;
	}

	public Boolean getActivaridclienteRepresentanteLegal() {
		return this.activaridclienteRepresentanteLegal;
	}

	public void setActivaridclienteRepresentanteLegal(Boolean activaridclienteRepresentanteLegal) {
		this.activaridclienteRepresentanteLegal= activaridclienteRepresentanteLegal;
	}

	public Boolean getCargaridclienteRepresentanteLegal() {
		return this.cargaridclienteRepresentanteLegal;
	}

	public void setCargaridclienteRepresentanteLegal(Boolean cargaridclienteRepresentanteLegal) {
		this.cargaridclienteRepresentanteLegal= cargaridclienteRepresentanteLegal;
	}

	public Border setResaltaridvalorclientedocumentoRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltaridvalorclientedocumentoRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvalorclientedocumentoRepresentanteLegal() {
		return this.resaltaridvalorclientedocumentoRepresentanteLegal;
	}

	public void setResaltaridvalorclientedocumentoRepresentanteLegal(Border borderResaltar) {
		this.resaltaridvalorclientedocumentoRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostraridvalorclientedocumentoRepresentanteLegal() {
		return this.mostraridvalorclientedocumentoRepresentanteLegal;
	}

	public void setMostraridvalorclientedocumentoRepresentanteLegal(Boolean mostraridvalorclientedocumentoRepresentanteLegal) {
		this.mostraridvalorclientedocumentoRepresentanteLegal= mostraridvalorclientedocumentoRepresentanteLegal;
	}

	public Boolean getActivaridvalorclientedocumentoRepresentanteLegal() {
		return this.activaridvalorclientedocumentoRepresentanteLegal;
	}

	public void setActivaridvalorclientedocumentoRepresentanteLegal(Boolean activaridvalorclientedocumentoRepresentanteLegal) {
		this.activaridvalorclientedocumentoRepresentanteLegal= activaridvalorclientedocumentoRepresentanteLegal;
	}

	public Boolean getCargaridvalorclientedocumentoRepresentanteLegal() {
		return this.cargaridvalorclientedocumentoRepresentanteLegal;
	}

	public void setCargaridvalorclientedocumentoRepresentanteLegal(Boolean cargaridvalorclientedocumentoRepresentanteLegal) {
		this.cargaridvalorclientedocumentoRepresentanteLegal= cargaridvalorclientedocumentoRepresentanteLegal;
	}

	public Border setResaltarid_paisRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltarid_paisRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisRepresentanteLegal() {
		return this.resaltarid_paisRepresentanteLegal;
	}

	public void setResaltarid_paisRepresentanteLegal(Border borderResaltar) {
		this.resaltarid_paisRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostrarid_paisRepresentanteLegal() {
		return this.mostrarid_paisRepresentanteLegal;
	}

	public void setMostrarid_paisRepresentanteLegal(Boolean mostrarid_paisRepresentanteLegal) {
		this.mostrarid_paisRepresentanteLegal= mostrarid_paisRepresentanteLegal;
	}

	public Boolean getActivarid_paisRepresentanteLegal() {
		return this.activarid_paisRepresentanteLegal;
	}

	public void setActivarid_paisRepresentanteLegal(Boolean activarid_paisRepresentanteLegal) {
		this.activarid_paisRepresentanteLegal= activarid_paisRepresentanteLegal;
	}

	public Boolean getCargarid_paisRepresentanteLegal() {
		return this.cargarid_paisRepresentanteLegal;
	}

	public void setCargarid_paisRepresentanteLegal(Boolean cargarid_paisRepresentanteLegal) {
		this.cargarid_paisRepresentanteLegal= cargarid_paisRepresentanteLegal;
	}

	public Border setResaltaridciudadRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltaridciudadRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridciudadRepresentanteLegal() {
		return this.resaltaridciudadRepresentanteLegal;
	}

	public void setResaltaridciudadRepresentanteLegal(Border borderResaltar) {
		this.resaltaridciudadRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostraridciudadRepresentanteLegal() {
		return this.mostraridciudadRepresentanteLegal;
	}

	public void setMostraridciudadRepresentanteLegal(Boolean mostraridciudadRepresentanteLegal) {
		this.mostraridciudadRepresentanteLegal= mostraridciudadRepresentanteLegal;
	}

	public Boolean getActivaridciudadRepresentanteLegal() {
		return this.activaridciudadRepresentanteLegal;
	}

	public void setActivaridciudadRepresentanteLegal(Boolean activaridciudadRepresentanteLegal) {
		this.activaridciudadRepresentanteLegal= activaridciudadRepresentanteLegal;
	}

	public Boolean getCargaridciudadRepresentanteLegal() {
		return this.cargaridciudadRepresentanteLegal;
	}

	public void setCargaridciudadRepresentanteLegal(Boolean cargaridciudadRepresentanteLegal) {
		this.cargaridciudadRepresentanteLegal= cargaridciudadRepresentanteLegal;
	}

	public Border setResaltaridentificacionRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltaridentificacionRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridentificacionRepresentanteLegal() {
		return this.resaltaridentificacionRepresentanteLegal;
	}

	public void setResaltaridentificacionRepresentanteLegal(Border borderResaltar) {
		this.resaltaridentificacionRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostraridentificacionRepresentanteLegal() {
		return this.mostraridentificacionRepresentanteLegal;
	}

	public void setMostraridentificacionRepresentanteLegal(Boolean mostraridentificacionRepresentanteLegal) {
		this.mostraridentificacionRepresentanteLegal= mostraridentificacionRepresentanteLegal;
	}

	public Boolean getActivaridentificacionRepresentanteLegal() {
		return this.activaridentificacionRepresentanteLegal;
	}

	public void setActivaridentificacionRepresentanteLegal(Boolean activaridentificacionRepresentanteLegal) {
		this.activaridentificacionRepresentanteLegal= activaridentificacionRepresentanteLegal;
	}

	public Border setResaltarapellidopaternoRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltarapellidopaternoRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidopaternoRepresentanteLegal() {
		return this.resaltarapellidopaternoRepresentanteLegal;
	}

	public void setResaltarapellidopaternoRepresentanteLegal(Border borderResaltar) {
		this.resaltarapellidopaternoRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostrarapellidopaternoRepresentanteLegal() {
		return this.mostrarapellidopaternoRepresentanteLegal;
	}

	public void setMostrarapellidopaternoRepresentanteLegal(Boolean mostrarapellidopaternoRepresentanteLegal) {
		this.mostrarapellidopaternoRepresentanteLegal= mostrarapellidopaternoRepresentanteLegal;
	}

	public Boolean getActivarapellidopaternoRepresentanteLegal() {
		return this.activarapellidopaternoRepresentanteLegal;
	}

	public void setActivarapellidopaternoRepresentanteLegal(Boolean activarapellidopaternoRepresentanteLegal) {
		this.activarapellidopaternoRepresentanteLegal= activarapellidopaternoRepresentanteLegal;
	}

	public Border setResaltarapellidomaternoRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltarapellidomaternoRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidomaternoRepresentanteLegal() {
		return this.resaltarapellidomaternoRepresentanteLegal;
	}

	public void setResaltarapellidomaternoRepresentanteLegal(Border borderResaltar) {
		this.resaltarapellidomaternoRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostrarapellidomaternoRepresentanteLegal() {
		return this.mostrarapellidomaternoRepresentanteLegal;
	}

	public void setMostrarapellidomaternoRepresentanteLegal(Boolean mostrarapellidomaternoRepresentanteLegal) {
		this.mostrarapellidomaternoRepresentanteLegal= mostrarapellidomaternoRepresentanteLegal;
	}

	public Boolean getActivarapellidomaternoRepresentanteLegal() {
		return this.activarapellidomaternoRepresentanteLegal;
	}

	public void setActivarapellidomaternoRepresentanteLegal(Boolean activarapellidomaternoRepresentanteLegal) {
		this.activarapellidomaternoRepresentanteLegal= activarapellidomaternoRepresentanteLegal;
	}

	public Border setResaltarprimernombreRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltarprimernombreRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprimernombreRepresentanteLegal() {
		return this.resaltarprimernombreRepresentanteLegal;
	}

	public void setResaltarprimernombreRepresentanteLegal(Border borderResaltar) {
		this.resaltarprimernombreRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostrarprimernombreRepresentanteLegal() {
		return this.mostrarprimernombreRepresentanteLegal;
	}

	public void setMostrarprimernombreRepresentanteLegal(Boolean mostrarprimernombreRepresentanteLegal) {
		this.mostrarprimernombreRepresentanteLegal= mostrarprimernombreRepresentanteLegal;
	}

	public Boolean getActivarprimernombreRepresentanteLegal() {
		return this.activarprimernombreRepresentanteLegal;
	}

	public void setActivarprimernombreRepresentanteLegal(Boolean activarprimernombreRepresentanteLegal) {
		this.activarprimernombreRepresentanteLegal= activarprimernombreRepresentanteLegal;
	}

	public Border setResaltarsegundonombreRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltarsegundonombreRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsegundonombreRepresentanteLegal() {
		return this.resaltarsegundonombreRepresentanteLegal;
	}

	public void setResaltarsegundonombreRepresentanteLegal(Border borderResaltar) {
		this.resaltarsegundonombreRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostrarsegundonombreRepresentanteLegal() {
		return this.mostrarsegundonombreRepresentanteLegal;
	}

	public void setMostrarsegundonombreRepresentanteLegal(Boolean mostrarsegundonombreRepresentanteLegal) {
		this.mostrarsegundonombreRepresentanteLegal= mostrarsegundonombreRepresentanteLegal;
	}

	public Boolean getActivarsegundonombreRepresentanteLegal() {
		return this.activarsegundonombreRepresentanteLegal;
	}

	public void setActivarsegundonombreRepresentanteLegal(Boolean activarsegundonombreRepresentanteLegal) {
		this.activarsegundonombreRepresentanteLegal= activarsegundonombreRepresentanteLegal;
	}

	public Border setResaltardireccionRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltardireccionRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionRepresentanteLegal() {
		return this.resaltardireccionRepresentanteLegal;
	}

	public void setResaltardireccionRepresentanteLegal(Border borderResaltar) {
		this.resaltardireccionRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostrardireccionRepresentanteLegal() {
		return this.mostrardireccionRepresentanteLegal;
	}

	public void setMostrardireccionRepresentanteLegal(Boolean mostrardireccionRepresentanteLegal) {
		this.mostrardireccionRepresentanteLegal= mostrardireccionRepresentanteLegal;
	}

	public Boolean getActivardireccionRepresentanteLegal() {
		return this.activardireccionRepresentanteLegal;
	}

	public void setActivardireccionRepresentanteLegal(Boolean activardireccionRepresentanteLegal) {
		this.activardireccionRepresentanteLegal= activardireccionRepresentanteLegal;
	}

	public Border setResaltartelefonoRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltartelefonoRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoRepresentanteLegal() {
		return this.resaltartelefonoRepresentanteLegal;
	}

	public void setResaltartelefonoRepresentanteLegal(Border borderResaltar) {
		this.resaltartelefonoRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostrartelefonoRepresentanteLegal() {
		return this.mostrartelefonoRepresentanteLegal;
	}

	public void setMostrartelefonoRepresentanteLegal(Boolean mostrartelefonoRepresentanteLegal) {
		this.mostrartelefonoRepresentanteLegal= mostrartelefonoRepresentanteLegal;
	}

	public Boolean getActivartelefonoRepresentanteLegal() {
		return this.activartelefonoRepresentanteLegal;
	}

	public void setActivartelefonoRepresentanteLegal(Boolean activartelefonoRepresentanteLegal) {
		this.activartelefonoRepresentanteLegal= activartelefonoRepresentanteLegal;
	}

	public Border setResaltartelefonocodigoareaRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltartelefonocodigoareaRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonocodigoareaRepresentanteLegal() {
		return this.resaltartelefonocodigoareaRepresentanteLegal;
	}

	public void setResaltartelefonocodigoareaRepresentanteLegal(Border borderResaltar) {
		this.resaltartelefonocodigoareaRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostrartelefonocodigoareaRepresentanteLegal() {
		return this.mostrartelefonocodigoareaRepresentanteLegal;
	}

	public void setMostrartelefonocodigoareaRepresentanteLegal(Boolean mostrartelefonocodigoareaRepresentanteLegal) {
		this.mostrartelefonocodigoareaRepresentanteLegal= mostrartelefonocodigoareaRepresentanteLegal;
	}

	public Boolean getActivartelefonocodigoareaRepresentanteLegal() {
		return this.activartelefonocodigoareaRepresentanteLegal;
	}

	public void setActivartelefonocodigoareaRepresentanteLegal(Boolean activartelefonocodigoareaRepresentanteLegal) {
		this.activartelefonocodigoareaRepresentanteLegal= activartelefonocodigoareaRepresentanteLegal;
	}

	public Border setResaltarextensionRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltarextensionRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarextensionRepresentanteLegal() {
		return this.resaltarextensionRepresentanteLegal;
	}

	public void setResaltarextensionRepresentanteLegal(Border borderResaltar) {
		this.resaltarextensionRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostrarextensionRepresentanteLegal() {
		return this.mostrarextensionRepresentanteLegal;
	}

	public void setMostrarextensionRepresentanteLegal(Boolean mostrarextensionRepresentanteLegal) {
		this.mostrarextensionRepresentanteLegal= mostrarextensionRepresentanteLegal;
	}

	public Boolean getActivarextensionRepresentanteLegal() {
		return this.activarextensionRepresentanteLegal;
	}

	public void setActivarextensionRepresentanteLegal(Boolean activarextensionRepresentanteLegal) {
		this.activarextensionRepresentanteLegal= activarextensionRepresentanteLegal;
	}

	public Border setResaltartelefonomovilRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltartelefonomovilRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonomovilRepresentanteLegal() {
		return this.resaltartelefonomovilRepresentanteLegal;
	}

	public void setResaltartelefonomovilRepresentanteLegal(Border borderResaltar) {
		this.resaltartelefonomovilRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostrartelefonomovilRepresentanteLegal() {
		return this.mostrartelefonomovilRepresentanteLegal;
	}

	public void setMostrartelefonomovilRepresentanteLegal(Boolean mostrartelefonomovilRepresentanteLegal) {
		this.mostrartelefonomovilRepresentanteLegal= mostrartelefonomovilRepresentanteLegal;
	}

	public Boolean getActivartelefonomovilRepresentanteLegal() {
		return this.activartelefonomovilRepresentanteLegal;
	}

	public void setActivartelefonomovilRepresentanteLegal(Boolean activartelefonomovilRepresentanteLegal) {
		this.activartelefonomovilRepresentanteLegal= activartelefonomovilRepresentanteLegal;
	}

	public Border setResaltarmontoaurorizadoRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltarmontoaurorizadoRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoaurorizadoRepresentanteLegal() {
		return this.resaltarmontoaurorizadoRepresentanteLegal;
	}

	public void setResaltarmontoaurorizadoRepresentanteLegal(Border borderResaltar) {
		this.resaltarmontoaurorizadoRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostrarmontoaurorizadoRepresentanteLegal() {
		return this.mostrarmontoaurorizadoRepresentanteLegal;
	}

	public void setMostrarmontoaurorizadoRepresentanteLegal(Boolean mostrarmontoaurorizadoRepresentanteLegal) {
		this.mostrarmontoaurorizadoRepresentanteLegal= mostrarmontoaurorizadoRepresentanteLegal;
	}

	public Boolean getActivarmontoaurorizadoRepresentanteLegal() {
		return this.activarmontoaurorizadoRepresentanteLegal;
	}

	public void setActivarmontoaurorizadoRepresentanteLegal(Boolean activarmontoaurorizadoRepresentanteLegal) {
		this.activarmontoaurorizadoRepresentanteLegal= activarmontoaurorizadoRepresentanteLegal;
	}

	public Border setResaltaremailRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltaremailRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaremailRepresentanteLegal() {
		return this.resaltaremailRepresentanteLegal;
	}

	public void setResaltaremailRepresentanteLegal(Border borderResaltar) {
		this.resaltaremailRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostraremailRepresentanteLegal() {
		return this.mostraremailRepresentanteLegal;
	}

	public void setMostraremailRepresentanteLegal(Boolean mostraremailRepresentanteLegal) {
		this.mostraremailRepresentanteLegal= mostraremailRepresentanteLegal;
	}

	public Boolean getActivaremailRepresentanteLegal() {
		return this.activaremailRepresentanteLegal;
	}

	public void setActivaremailRepresentanteLegal(Boolean activaremailRepresentanteLegal) {
		this.activaremailRepresentanteLegal= activaremailRepresentanteLegal;
	}

	public Border setResaltarestaactivoRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//representantelegalBeanSwingJInternalFrame.jTtoolBarRepresentanteLegal.setBorder(borderResaltar);
		
		this.resaltarestaactivoRepresentanteLegal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestaactivoRepresentanteLegal() {
		return this.resaltarestaactivoRepresentanteLegal;
	}

	public void setResaltarestaactivoRepresentanteLegal(Border borderResaltar) {
		this.resaltarestaactivoRepresentanteLegal= borderResaltar;
	}

	public Boolean getMostrarestaactivoRepresentanteLegal() {
		return this.mostrarestaactivoRepresentanteLegal;
	}

	public void setMostrarestaactivoRepresentanteLegal(Boolean mostrarestaactivoRepresentanteLegal) {
		this.mostrarestaactivoRepresentanteLegal= mostrarestaactivoRepresentanteLegal;
	}

	public Boolean getActivarestaactivoRepresentanteLegal() {
		return this.activarestaactivoRepresentanteLegal;
	}

	public void setActivarestaactivoRepresentanteLegal(Boolean activarestaactivoRepresentanteLegal) {
		this.activarestaactivoRepresentanteLegal= activarestaactivoRepresentanteLegal;
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
		
		
		this.setMostraridRepresentanteLegal(esInicial);
		this.setMostraridclienteRepresentanteLegal(esInicial);
		this.setMostraridvalorclientedocumentoRepresentanteLegal(esInicial);
		this.setMostrarid_paisRepresentanteLegal(esInicial);
		this.setMostraridciudadRepresentanteLegal(esInicial);
		this.setMostraridentificacionRepresentanteLegal(esInicial);
		this.setMostrarapellidopaternoRepresentanteLegal(esInicial);
		this.setMostrarapellidomaternoRepresentanteLegal(esInicial);
		this.setMostrarprimernombreRepresentanteLegal(esInicial);
		this.setMostrarsegundonombreRepresentanteLegal(esInicial);
		this.setMostrardireccionRepresentanteLegal(esInicial);
		this.setMostrartelefonoRepresentanteLegal(esInicial);
		this.setMostrartelefonocodigoareaRepresentanteLegal(esInicial);
		this.setMostrarextensionRepresentanteLegal(esInicial);
		this.setMostrartelefonomovilRepresentanteLegal(esInicial);
		this.setMostrarmontoaurorizadoRepresentanteLegal(esInicial);
		this.setMostraremailRepresentanteLegal(esInicial);
		this.setMostrarestaactivoRepresentanteLegal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.ID)) {
				this.setMostraridRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDCLIENTE)) {
				this.setMostraridclienteRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setMostraridvalorclientedocumentoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDCIUDAD)) {
				this.setMostraridciudadRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDENTIFICACION)) {
				this.setMostraridentificacionRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.APELLIDOPATERNO)) {
				this.setMostrarapellidopaternoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.APELLIDOMATERNO)) {
				this.setMostrarapellidomaternoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.PRIMERNOMBRE)) {
				this.setMostrarprimernombreRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.SEGUNDONOMBRE)) {
				this.setMostrarsegundonombreRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.TELEFONOCODIGOAREA)) {
				this.setMostrartelefonocodigoareaRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.EXTENSION)) {
				this.setMostrarextensionRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.TELEFONOMOVIL)) {
				this.setMostrartelefonomovilRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.MONTOAURORIZADO)) {
				this.setMostrarmontoaurorizadoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.EMAIL)) {
				this.setMostraremailRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.ESTAACTIVO)) {
				this.setMostrarestaactivoRepresentanteLegal(esAsigna);
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
		
		
		this.setActivaridRepresentanteLegal(esInicial);
		this.setActivaridclienteRepresentanteLegal(esInicial);
		this.setActivaridvalorclientedocumentoRepresentanteLegal(esInicial);
		this.setActivarid_paisRepresentanteLegal(esInicial);
		this.setActivaridciudadRepresentanteLegal(esInicial);
		this.setActivaridentificacionRepresentanteLegal(esInicial);
		this.setActivarapellidopaternoRepresentanteLegal(esInicial);
		this.setActivarapellidomaternoRepresentanteLegal(esInicial);
		this.setActivarprimernombreRepresentanteLegal(esInicial);
		this.setActivarsegundonombreRepresentanteLegal(esInicial);
		this.setActivardireccionRepresentanteLegal(esInicial);
		this.setActivartelefonoRepresentanteLegal(esInicial);
		this.setActivartelefonocodigoareaRepresentanteLegal(esInicial);
		this.setActivarextensionRepresentanteLegal(esInicial);
		this.setActivartelefonomovilRepresentanteLegal(esInicial);
		this.setActivarmontoaurorizadoRepresentanteLegal(esInicial);
		this.setActivaremailRepresentanteLegal(esInicial);
		this.setActivarestaactivoRepresentanteLegal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.ID)) {
				this.setActivaridRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDCLIENTE)) {
				this.setActivaridclienteRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setActivaridvalorclientedocumentoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDCIUDAD)) {
				this.setActivaridciudadRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDENTIFICACION)) {
				this.setActivaridentificacionRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.APELLIDOPATERNO)) {
				this.setActivarapellidopaternoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.APELLIDOMATERNO)) {
				this.setActivarapellidomaternoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.PRIMERNOMBRE)) {
				this.setActivarprimernombreRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.SEGUNDONOMBRE)) {
				this.setActivarsegundonombreRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.DIRECCION)) {
				this.setActivardireccionRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.TELEFONOCODIGOAREA)) {
				this.setActivartelefonocodigoareaRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.EXTENSION)) {
				this.setActivarextensionRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.TELEFONOMOVIL)) {
				this.setActivartelefonomovilRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.MONTOAURORIZADO)) {
				this.setActivarmontoaurorizadoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.EMAIL)) {
				this.setActivaremailRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.ESTAACTIVO)) {
				this.setActivarestaactivoRepresentanteLegal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRepresentanteLegal(esInicial);
		this.setResaltaridclienteRepresentanteLegal(esInicial);
		this.setResaltaridvalorclientedocumentoRepresentanteLegal(esInicial);
		this.setResaltarid_paisRepresentanteLegal(esInicial);
		this.setResaltaridciudadRepresentanteLegal(esInicial);
		this.setResaltaridentificacionRepresentanteLegal(esInicial);
		this.setResaltarapellidopaternoRepresentanteLegal(esInicial);
		this.setResaltarapellidomaternoRepresentanteLegal(esInicial);
		this.setResaltarprimernombreRepresentanteLegal(esInicial);
		this.setResaltarsegundonombreRepresentanteLegal(esInicial);
		this.setResaltardireccionRepresentanteLegal(esInicial);
		this.setResaltartelefonoRepresentanteLegal(esInicial);
		this.setResaltartelefonocodigoareaRepresentanteLegal(esInicial);
		this.setResaltarextensionRepresentanteLegal(esInicial);
		this.setResaltartelefonomovilRepresentanteLegal(esInicial);
		this.setResaltarmontoaurorizadoRepresentanteLegal(esInicial);
		this.setResaltaremailRepresentanteLegal(esInicial);
		this.setResaltarestaactivoRepresentanteLegal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.ID)) {
				this.setResaltaridRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDCLIENTE)) {
				this.setResaltaridclienteRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setResaltaridvalorclientedocumentoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDCIUDAD)) {
				this.setResaltaridciudadRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.IDENTIFICACION)) {
				this.setResaltaridentificacionRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.APELLIDOPATERNO)) {
				this.setResaltarapellidopaternoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.APELLIDOMATERNO)) {
				this.setResaltarapellidomaternoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.PRIMERNOMBRE)) {
				this.setResaltarprimernombreRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.SEGUNDONOMBRE)) {
				this.setResaltarsegundonombreRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.TELEFONOCODIGOAREA)) {
				this.setResaltartelefonocodigoareaRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.EXTENSION)) {
				this.setResaltarextensionRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.TELEFONOMOVIL)) {
				this.setResaltartelefonomovilRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.MONTOAURORIZADO)) {
				this.setResaltarmontoaurorizadoRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.EMAIL)) {
				this.setResaltaremailRepresentanteLegal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RepresentanteLegalConstantesFunciones.ESTAACTIVO)) {
				this.setResaltarestaactivoRepresentanteLegal(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdCiudadRepresentanteLegal=true;

	public Boolean getMostrarFK_IdCiudadRepresentanteLegal() {
		return this.mostrarFK_IdCiudadRepresentanteLegal;
	}

	public void setMostrarFK_IdCiudadRepresentanteLegal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadRepresentanteLegal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteRepresentanteLegal=true;

	public Boolean getMostrarFK_IdClienteRepresentanteLegal() {
		return this.mostrarFK_IdClienteRepresentanteLegal;
	}

	public void setMostrarFK_IdClienteRepresentanteLegal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteRepresentanteLegal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisRepresentanteLegal=true;

	public Boolean getMostrarFK_IdPaisRepresentanteLegal() {
		return this.mostrarFK_IdPaisRepresentanteLegal;
	}

	public void setMostrarFK_IdPaisRepresentanteLegal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisRepresentanteLegal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorClienteDocumentoRepresentanteLegal=true;

	public Boolean getMostrarFK_IdValorClienteDocumentoRepresentanteLegal() {
		return this.mostrarFK_IdValorClienteDocumentoRepresentanteLegal;
	}

	public void setMostrarFK_IdValorClienteDocumentoRepresentanteLegal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorClienteDocumentoRepresentanteLegal= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadRepresentanteLegal=true;

	public Boolean getActivarFK_IdCiudadRepresentanteLegal() {
		return this.activarFK_IdCiudadRepresentanteLegal;
	}

	public void setActivarFK_IdCiudadRepresentanteLegal(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadRepresentanteLegal= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteRepresentanteLegal=true;

	public Boolean getActivarFK_IdClienteRepresentanteLegal() {
		return this.activarFK_IdClienteRepresentanteLegal;
	}

	public void setActivarFK_IdClienteRepresentanteLegal(Boolean habilitarResaltar) {
		this.activarFK_IdClienteRepresentanteLegal= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisRepresentanteLegal=true;

	public Boolean getActivarFK_IdPaisRepresentanteLegal() {
		return this.activarFK_IdPaisRepresentanteLegal;
	}

	public void setActivarFK_IdPaisRepresentanteLegal(Boolean habilitarResaltar) {
		this.activarFK_IdPaisRepresentanteLegal= habilitarResaltar;
	}

	public Boolean activarFK_IdValorClienteDocumentoRepresentanteLegal=true;

	public Boolean getActivarFK_IdValorClienteDocumentoRepresentanteLegal() {
		return this.activarFK_IdValorClienteDocumentoRepresentanteLegal;
	}

	public void setActivarFK_IdValorClienteDocumentoRepresentanteLegal(Boolean habilitarResaltar) {
		this.activarFK_IdValorClienteDocumentoRepresentanteLegal= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadRepresentanteLegal=null;

	public Border getResaltarFK_IdCiudadRepresentanteLegal() {
		return this.resaltarFK_IdCiudadRepresentanteLegal;
	}

	public void setResaltarFK_IdCiudadRepresentanteLegal(Border borderResaltar) {
		this.resaltarFK_IdCiudadRepresentanteLegal= borderResaltar;
	}

	public void setResaltarFK_IdCiudadRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadRepresentanteLegal= borderResaltar;
	}

	public Border resaltarFK_IdClienteRepresentanteLegal=null;

	public Border getResaltarFK_IdClienteRepresentanteLegal() {
		return this.resaltarFK_IdClienteRepresentanteLegal;
	}

	public void setResaltarFK_IdClienteRepresentanteLegal(Border borderResaltar) {
		this.resaltarFK_IdClienteRepresentanteLegal= borderResaltar;
	}

	public void setResaltarFK_IdClienteRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteRepresentanteLegal= borderResaltar;
	}

	public Border resaltarFK_IdPaisRepresentanteLegal=null;

	public Border getResaltarFK_IdPaisRepresentanteLegal() {
		return this.resaltarFK_IdPaisRepresentanteLegal;
	}

	public void setResaltarFK_IdPaisRepresentanteLegal(Border borderResaltar) {
		this.resaltarFK_IdPaisRepresentanteLegal= borderResaltar;
	}

	public void setResaltarFK_IdPaisRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisRepresentanteLegal= borderResaltar;
	}

	public Border resaltarFK_IdValorClienteDocumentoRepresentanteLegal=null;

	public Border getResaltarFK_IdValorClienteDocumentoRepresentanteLegal() {
		return this.resaltarFK_IdValorClienteDocumentoRepresentanteLegal;
	}

	public void setResaltarFK_IdValorClienteDocumentoRepresentanteLegal(Border borderResaltar) {
		this.resaltarFK_IdValorClienteDocumentoRepresentanteLegal= borderResaltar;
	}

	public void setResaltarFK_IdValorClienteDocumentoRepresentanteLegal(ParametroGeneralUsuario parametroGeneralUsuario/*RepresentanteLegalBeanSwingJInternalFrame representantelegalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorClienteDocumentoRepresentanteLegal= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}