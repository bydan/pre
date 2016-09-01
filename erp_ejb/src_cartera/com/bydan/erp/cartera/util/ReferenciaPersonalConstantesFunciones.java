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


import com.bydan.erp.cartera.util.ReferenciaPersonalConstantesFunciones;
import com.bydan.erp.cartera.util.ReferenciaPersonalParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ReferenciaPersonalParameterGeneral;

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
final public class ReferenciaPersonalConstantesFunciones extends ReferenciaPersonalConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ReferenciaPersonal";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ReferenciaPersonal"+ReferenciaPersonalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ReferenciaPersonalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ReferenciaPersonalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ReferenciaPersonalConstantesFunciones.SCHEMA+"_"+ReferenciaPersonalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ReferenciaPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ReferenciaPersonalConstantesFunciones.SCHEMA+"_"+ReferenciaPersonalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ReferenciaPersonalConstantesFunciones.SCHEMA+"_"+ReferenciaPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ReferenciaPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ReferenciaPersonalConstantesFunciones.SCHEMA+"_"+ReferenciaPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ReferenciaPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ReferenciaPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ReferenciaPersonalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ReferenciaPersonalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ReferenciaPersonalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ReferenciaPersonalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Referencia Personales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Referencia Personal";
	public static final String SCLASSWEBTITULO_LOWER="Referencia Personal";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ReferenciaPersonal";
	public static final String OBJECTNAME="referenciapersonal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="referenciapersonal";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select referenciapersonal from "+ReferenciaPersonalConstantesFunciones.SPERSISTENCENAME+" referenciapersonal";
	public static String QUERYSELECTNATIVE="select "+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".id,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".version_row,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".id_empresa,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".idcliente,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".idvalorclientereferenciapersonal,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".id_pais,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".idciudad,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".nombre,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".identificacion,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".fecha_nacimiento,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".direccion,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".telefono,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".telefonomovil,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".telefonocodigoarea,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".preferencia,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".email,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".observacion,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".esta_trabajando,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".empresa_trabajo,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".direccion_trabajo,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".telefono_trabajo,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".esactivo from "+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME;//+" as "+ReferenciaPersonalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ReferenciaPersonalConstantesFuncionesAdditional referenciapersonalConstantesFuncionesAdditional=null;
	
	public ReferenciaPersonalConstantesFuncionesAdditional getReferenciaPersonalConstantesFuncionesAdditional() {
		return this.referenciapersonalConstantesFuncionesAdditional;
	}
	
	public void setReferenciaPersonalConstantesFuncionesAdditional(ReferenciaPersonalConstantesFuncionesAdditional referenciapersonalConstantesFuncionesAdditional) {
		try {
			this.referenciapersonalConstantesFuncionesAdditional=referenciapersonalConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "idcliente";
    public static final String IDTIPOREFEPERSO= "idvalorclientereferenciapersonal";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "idciudad";
    public static final String NOMBRE= "nombre";
    public static final String IDENTIFICACION= "identificacion";
    public static final String FECHANACIMIENTO= "fecha_nacimiento";
    public static final String DIRECCION= "direccion";
    public static final String TELEFONO= "telefono";
    public static final String TELEFONOMOVIL= "telefonomovil";
    public static final String TELEFONOCODIGOAREA= "telefonocodigoarea";
    public static final String PREFERENCIA= "preferencia";
    public static final String EMAIL= "email";
    public static final String OBSERVACION= "observacion";
    public static final String ESTATRABAJANDO= "esta_trabajando";
    public static final String EMPRESATRABAJO= "empresa_trabajo";
    public static final String DIRECCIONTRABAJO= "direccion_trabajo";
    public static final String TELEFONOTRABAJO= "telefono_trabajo";
    public static final String ESACTIVO= "esactivo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOREFEPERSO= "Tipo Refe Perso";
		public static final String LABEL_IDTIPOREFEPERSO_LOWER= "Tipo Refe Perso";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDENTIFICACION= "Identificacion";
		public static final String LABEL_IDENTIFICACION_LOWER= "Identificacion";
    	public static final String LABEL_FECHANACIMIENTO= "Fecha Nacimiento";
		public static final String LABEL_FECHANACIMIENTO_LOWER= "Fecha Nacimiento";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_TELEFONOMOVIL= "Telefono Movil";
		public static final String LABEL_TELEFONOMOVIL_LOWER= "Telefono Movil";
    	public static final String LABEL_TELEFONOCODIGOAREA= "Telefono Codigo Area";
		public static final String LABEL_TELEFONOCODIGOAREA_LOWER= "Telefono Codigo Area";
    	public static final String LABEL_PREFERENCIA= "Preferencia";
		public static final String LABEL_PREFERENCIA_LOWER= "Preferencia";
    	public static final String LABEL_EMAIL= "Email";
		public static final String LABEL_EMAIL_LOWER= "Email";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
    	public static final String LABEL_ESTATRABAJANDO= "Esta Trabajando";
		public static final String LABEL_ESTATRABAJANDO_LOWER= "Esta Trabajando";
    	public static final String LABEL_EMPRESATRABAJO= "Empresa Trabajo";
		public static final String LABEL_EMPRESATRABAJO_LOWER= "Empresa Trabajo";
    	public static final String LABEL_DIRECCIONTRABAJO= "Direccion Trabajo";
		public static final String LABEL_DIRECCIONTRABAJO_LOWER= "Direccion Trabajo";
    	public static final String LABEL_TELEFONOTRABAJO= "Telefono Trabajo";
		public static final String LABEL_TELEFONOTRABAJO_LOWER= "Telefono Trabajo";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXIDENTIFICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXIDENTIFICACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXTELEFONOMOVIL=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONOMOVIL=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXTELEFONOCODIGOAREA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONOCODIGOAREA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPREFERENCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPREFERENCIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXEMAIL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEMAIL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXEMPRESA_TRABAJO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEMPRESA_TRABAJO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION_TRABAJO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_TRABAJO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO_TRABAJO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO_TRABAJO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
		
	
	public static String getReferenciaPersonalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.IDEMPRESA)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.IDCLIENTE)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.IDTIPOREFEPERSO)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_IDTIPOREFEPERSO;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.IDPAIS)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.IDCIUDAD)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.NOMBRE)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.IDENTIFICACION)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_IDENTIFICACION;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.FECHANACIMIENTO)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_FECHANACIMIENTO;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.DIRECCION)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.TELEFONO)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.TELEFONOMOVIL)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOMOVIL;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.TELEFONOCODIGOAREA)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOCODIGOAREA;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.PREFERENCIA)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_PREFERENCIA;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.EMAIL)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_EMAIL;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.OBSERVACION)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_OBSERVACION;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.ESTATRABAJANDO)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_ESTATRABAJANDO;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.EMPRESATRABAJO)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_EMPRESATRABAJO;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.DIRECCIONTRABAJO)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_DIRECCIONTRABAJO;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.TELEFONOTRABAJO)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOTRABAJO;}
		if(sNombreColumna.equals(ReferenciaPersonalConstantesFunciones.ESACTIVO)) {sLabelColumna=ReferenciaPersonalConstantesFunciones.LABEL_ESACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_trabajandoDescripcion(ReferenciaPersonal referenciapersonal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!referenciapersonal.getesta_trabajando()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_trabajandoHtmlDescripcion(ReferenciaPersonal referenciapersonal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(referenciapersonal.getId(),referenciapersonal.getesta_trabajando());

		return sDescripcion;
	}	
			
			
			
		
	public static String getesactivoDescripcion(ReferenciaPersonal referenciapersonal) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!referenciapersonal.getesactivo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesactivoHtmlDescripcion(ReferenciaPersonal referenciapersonal) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(referenciapersonal.getId(),referenciapersonal.getesactivo());

		return sDescripcion;
	}	
	
	public static String getReferenciaPersonalDescripcion(ReferenciaPersonal referenciapersonal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(referenciapersonal !=null/* && referenciapersonal.getId()!=0*/) {
			sDescripcion=referenciapersonal.getnombre();//referenciapersonalreferenciapersonal.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getReferenciaPersonalDescripcionDetallado(ReferenciaPersonal referenciapersonal) {
		String sDescripcion="";
			
		sDescripcion+=ReferenciaPersonalConstantesFunciones.ID+"=";
		sDescripcion+=referenciapersonal.getId().toString()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=referenciapersonal.getVersionRow().toString()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=referenciapersonal.getid_empresa().toString()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=referenciapersonal.getidcliente().toString()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.IDTIPOREFEPERSO+"=";
		sDescripcion+=referenciapersonal.getidvalorclientereferenciapersonal().toString()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.IDPAIS+"=";
		sDescripcion+=referenciapersonal.getid_pais().toString()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=referenciapersonal.getidciudad().toString()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.NOMBRE+"=";
		sDescripcion+=referenciapersonal.getnombre()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.IDENTIFICACION+"=";
		sDescripcion+=referenciapersonal.getidentificacion()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.FECHANACIMIENTO+"=";
		sDescripcion+=referenciapersonal.getfecha_nacimiento().toString()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.DIRECCION+"=";
		sDescripcion+=referenciapersonal.getdireccion()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.TELEFONO+"=";
		sDescripcion+=referenciapersonal.gettelefono()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.TELEFONOMOVIL+"=";
		sDescripcion+=referenciapersonal.gettelefonomovil()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.TELEFONOCODIGOAREA+"=";
		sDescripcion+=referenciapersonal.gettelefonocodigoarea()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.PREFERENCIA+"=";
		sDescripcion+=referenciapersonal.getpreferencia()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.EMAIL+"=";
		sDescripcion+=referenciapersonal.getemail()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=referenciapersonal.getobservacion()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.ESTATRABAJANDO+"=";
		sDescripcion+=referenciapersonal.getesta_trabajando().toString()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.EMPRESATRABAJO+"=";
		sDescripcion+=referenciapersonal.getempresa_trabajo()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.DIRECCIONTRABAJO+"=";
		sDescripcion+=referenciapersonal.getdireccion_trabajo()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.TELEFONOTRABAJO+"=";
		sDescripcion+=referenciapersonal.gettelefono_trabajo()+",";
		sDescripcion+=ReferenciaPersonalConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=referenciapersonal.getesactivo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setReferenciaPersonalDescripcion(ReferenciaPersonal referenciapersonal,String sValor) throws Exception {			
		if(referenciapersonal !=null) {
			referenciapersonal.setnombre(sValor);;//referenciapersonalreferenciapersonal.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoRefePersoDescripcion(TipoRefePerso tiporefeperso) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporefeperso!=null/*&&tiporefeperso.getId()>0*/) {
			sDescripcion=TipoRefePersoConstantesFunciones.getTipoRefePersoDescripcion(tiporefeperso);
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdTipoReferenciaPersonal")) {
			sNombreIndice="Tipo=  Por Tipo Refe Perso";
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

	public static String getDetalleIndiceFK_IdTipoReferenciaPersonal(Long idvalorclientereferenciapersonal) {
		String sDetalleIndice=" Parametros->";
		if(idvalorclientereferenciapersonal!=null) {sDetalleIndice+=" Codigo Unico De Tipo Refe Perso="+idvalorclientereferenciapersonal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosReferenciaPersonal(ReferenciaPersonal referenciapersonal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		referenciapersonal.setnombre(referenciapersonal.getnombre().trim());
		referenciapersonal.setidentificacion(referenciapersonal.getidentificacion().trim());
		referenciapersonal.setdireccion(referenciapersonal.getdireccion().trim());
		referenciapersonal.settelefono(referenciapersonal.gettelefono().trim());
		referenciapersonal.settelefonomovil(referenciapersonal.gettelefonomovil().trim());
		referenciapersonal.settelefonocodigoarea(referenciapersonal.gettelefonocodigoarea().trim());
		referenciapersonal.setpreferencia(referenciapersonal.getpreferencia().trim());
		referenciapersonal.setemail(referenciapersonal.getemail().trim());
		referenciapersonal.setobservacion(referenciapersonal.getobservacion().trim());
		referenciapersonal.setempresa_trabajo(referenciapersonal.getempresa_trabajo().trim());
		referenciapersonal.setdireccion_trabajo(referenciapersonal.getdireccion_trabajo().trim());
		referenciapersonal.settelefono_trabajo(referenciapersonal.gettelefono_trabajo().trim());
	}
	
	public static void quitarEspaciosReferenciaPersonals(List<ReferenciaPersonal> referenciapersonals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ReferenciaPersonal referenciapersonal: referenciapersonals) {
			referenciapersonal.setnombre(referenciapersonal.getnombre().trim());
			referenciapersonal.setidentificacion(referenciapersonal.getidentificacion().trim());
			referenciapersonal.setdireccion(referenciapersonal.getdireccion().trim());
			referenciapersonal.settelefono(referenciapersonal.gettelefono().trim());
			referenciapersonal.settelefonomovil(referenciapersonal.gettelefonomovil().trim());
			referenciapersonal.settelefonocodigoarea(referenciapersonal.gettelefonocodigoarea().trim());
			referenciapersonal.setpreferencia(referenciapersonal.getpreferencia().trim());
			referenciapersonal.setemail(referenciapersonal.getemail().trim());
			referenciapersonal.setobservacion(referenciapersonal.getobservacion().trim());
			referenciapersonal.setempresa_trabajo(referenciapersonal.getempresa_trabajo().trim());
			referenciapersonal.setdireccion_trabajo(referenciapersonal.getdireccion_trabajo().trim());
			referenciapersonal.settelefono_trabajo(referenciapersonal.gettelefono_trabajo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresReferenciaPersonal(ReferenciaPersonal referenciapersonal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && referenciapersonal.getConCambioAuxiliar()) {
			referenciapersonal.setIsDeleted(referenciapersonal.getIsDeletedAuxiliar());	
			referenciapersonal.setIsNew(referenciapersonal.getIsNewAuxiliar());	
			referenciapersonal.setIsChanged(referenciapersonal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			referenciapersonal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			referenciapersonal.setIsDeletedAuxiliar(false);	
			referenciapersonal.setIsNewAuxiliar(false);	
			referenciapersonal.setIsChangedAuxiliar(false);
			
			referenciapersonal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresReferenciaPersonals(List<ReferenciaPersonal> referenciapersonals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ReferenciaPersonal referenciapersonal : referenciapersonals) {
			if(conAsignarBase && referenciapersonal.getConCambioAuxiliar()) {
				referenciapersonal.setIsDeleted(referenciapersonal.getIsDeletedAuxiliar());	
				referenciapersonal.setIsNew(referenciapersonal.getIsNewAuxiliar());	
				referenciapersonal.setIsChanged(referenciapersonal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				referenciapersonal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				referenciapersonal.setIsDeletedAuxiliar(false);	
				referenciapersonal.setIsNewAuxiliar(false);	
				referenciapersonal.setIsChangedAuxiliar(false);
				
				referenciapersonal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresReferenciaPersonal(ReferenciaPersonal referenciapersonal,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresReferenciaPersonals(List<ReferenciaPersonal> referenciapersonals,Boolean conEnteros) throws Exception  {
		
		for(ReferenciaPersonal referenciapersonal: referenciapersonals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaReferenciaPersonal(List<ReferenciaPersonal> referenciapersonals,ReferenciaPersonal referenciapersonalAux) throws Exception  {
		ReferenciaPersonalConstantesFunciones.InicializarValoresReferenciaPersonal(referenciapersonalAux,true);
		
		for(ReferenciaPersonal referenciapersonal: referenciapersonals) {
			if(referenciapersonal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesReferenciaPersonal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ReferenciaPersonalConstantesFunciones.getArrayColumnasGlobalesReferenciaPersonal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesReferenciaPersonal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ReferenciaPersonalConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ReferenciaPersonalConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoReferenciaPersonal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ReferenciaPersonal> referenciapersonals,ReferenciaPersonal referenciapersonal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ReferenciaPersonal referenciapersonalAux: referenciapersonals) {
			if(referenciapersonalAux!=null && referenciapersonal!=null) {
				if((referenciapersonalAux.getId()==null && referenciapersonal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(referenciapersonalAux.getId()!=null && referenciapersonal.getId()!=null){
					if(referenciapersonalAux.getId().equals(referenciapersonal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaReferenciaPersonal(List<ReferenciaPersonal> referenciapersonals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ReferenciaPersonal referenciapersonal: referenciapersonals) {			
			if(referenciapersonal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaReferenciaPersonal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_ID, ReferenciaPersonalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_VERSIONROW, ReferenciaPersonalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_IDEMPRESA, ReferenciaPersonalConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_IDCLIENTE, ReferenciaPersonalConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_IDTIPOREFEPERSO, ReferenciaPersonalConstantesFunciones.IDTIPOREFEPERSO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_IDPAIS, ReferenciaPersonalConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_IDCIUDAD, ReferenciaPersonalConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_NOMBRE, ReferenciaPersonalConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_IDENTIFICACION, ReferenciaPersonalConstantesFunciones.IDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_FECHANACIMIENTO, ReferenciaPersonalConstantesFunciones.FECHANACIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_DIRECCION, ReferenciaPersonalConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_TELEFONO, ReferenciaPersonalConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOMOVIL, ReferenciaPersonalConstantesFunciones.TELEFONOMOVIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOCODIGOAREA, ReferenciaPersonalConstantesFunciones.TELEFONOCODIGOAREA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_PREFERENCIA, ReferenciaPersonalConstantesFunciones.PREFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_EMAIL, ReferenciaPersonalConstantesFunciones.EMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_OBSERVACION, ReferenciaPersonalConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_ESTATRABAJANDO, ReferenciaPersonalConstantesFunciones.ESTATRABAJANDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_EMPRESATRABAJO, ReferenciaPersonalConstantesFunciones.EMPRESATRABAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_DIRECCIONTRABAJO, ReferenciaPersonalConstantesFunciones.DIRECCIONTRABAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOTRABAJO, ReferenciaPersonalConstantesFunciones.TELEFONOTRABAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaPersonalConstantesFunciones.LABEL_ESACTIVO, ReferenciaPersonalConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasReferenciaPersonal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.IDTIPOREFEPERSO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.IDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.FECHANACIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.TELEFONOMOVIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.TELEFONOCODIGOAREA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.PREFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.EMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.ESTATRABAJANDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.EMPRESATRABAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.DIRECCIONTRABAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.TELEFONOTRABAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaPersonalConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReferenciaPersonal() throws Exception  {
		return ReferenciaPersonalConstantesFunciones.getTiposSeleccionarReferenciaPersonal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReferenciaPersonal(Boolean conFk) throws Exception  {
		return ReferenciaPersonalConstantesFunciones.getTiposSeleccionarReferenciaPersonal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReferenciaPersonal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_IDTIPOREFEPERSO);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_IDTIPOREFEPERSO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_IDENTIFICACION);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_IDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_FECHANACIMIENTO);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_FECHANACIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOMOVIL);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOMOVIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOCODIGOAREA);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOCODIGOAREA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_PREFERENCIA);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_PREFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_EMAIL);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_EMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_ESTATRABAJANDO);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_ESTATRABAJANDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_EMPRESATRABAJO);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_EMPRESATRABAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_DIRECCIONTRABAJO);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_DIRECCIONTRABAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOTRABAJO);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOTRABAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaPersonalConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(ReferenciaPersonalConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesReferenciaPersonal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesReferenciaPersonal(ReferenciaPersonal referenciapersonalAux) throws Exception {
		
			referenciapersonalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(referenciapersonalAux.getEmpresa()));
			referenciapersonalAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(referenciapersonalAux.getCliente()));
			referenciapersonalAux.settiporefeperso_descripcion(TipoRefePersoConstantesFunciones.getTipoRefePersoDescripcion(referenciapersonalAux.getTipoRefePerso()));
			referenciapersonalAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(referenciapersonalAux.getPais()));
			referenciapersonalAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(referenciapersonalAux.getCiudad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesReferenciaPersonal(List<ReferenciaPersonal> referenciapersonalsTemp) throws Exception {
		for(ReferenciaPersonal referenciapersonalAux:referenciapersonalsTemp) {
			
			referenciapersonalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(referenciapersonalAux.getEmpresa()));
			referenciapersonalAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(referenciapersonalAux.getCliente()));
			referenciapersonalAux.settiporefeperso_descripcion(TipoRefePersoConstantesFunciones.getTipoRefePersoDescripcion(referenciapersonalAux.getTipoRefePerso()));
			referenciapersonalAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(referenciapersonalAux.getPais()));
			referenciapersonalAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(referenciapersonalAux.getCiudad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfReferenciaPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoRefePerso.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRefePerso.class)) {
						classes.add(new Classe(TipoRefePerso.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfReferenciaPersonal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoRefePerso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRefePerso.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoRefePerso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRefePerso.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfReferenciaPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ReferenciaPersonalConstantesFunciones.getClassesRelationshipsOfReferenciaPersonal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfReferenciaPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfReferenciaPersonal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ReferenciaPersonalConstantesFunciones.getClassesRelationshipsFromStringsOfReferenciaPersonal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfReferenciaPersonal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ReferenciaPersonal referenciapersonal,List<ReferenciaPersonal> referenciapersonals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ReferenciaPersonal referenciapersonalEncontrado=null;
			
			for(ReferenciaPersonal referenciapersonalLocal:referenciapersonals) {
				if(referenciapersonalLocal.getId().equals(referenciapersonal.getId())) {
					referenciapersonalEncontrado=referenciapersonalLocal;
					
					referenciapersonalLocal.setIsChanged(referenciapersonal.getIsChanged());
					referenciapersonalLocal.setIsNew(referenciapersonal.getIsNew());
					referenciapersonalLocal.setIsDeleted(referenciapersonal.getIsDeleted());
					
					referenciapersonalLocal.setGeneralEntityOriginal(referenciapersonal.getGeneralEntityOriginal());
					
					referenciapersonalLocal.setId(referenciapersonal.getId());	
					referenciapersonalLocal.setVersionRow(referenciapersonal.getVersionRow());	
					referenciapersonalLocal.setid_empresa(referenciapersonal.getid_empresa());	
					referenciapersonalLocal.setidcliente(referenciapersonal.getidcliente());	
					referenciapersonalLocal.setidvalorclientereferenciapersonal(referenciapersonal.getidvalorclientereferenciapersonal());	
					referenciapersonalLocal.setid_pais(referenciapersonal.getid_pais());	
					referenciapersonalLocal.setidciudad(referenciapersonal.getidciudad());	
					referenciapersonalLocal.setnombre(referenciapersonal.getnombre());	
					referenciapersonalLocal.setidentificacion(referenciapersonal.getidentificacion());	
					referenciapersonalLocal.setfecha_nacimiento(referenciapersonal.getfecha_nacimiento());	
					referenciapersonalLocal.setdireccion(referenciapersonal.getdireccion());	
					referenciapersonalLocal.settelefono(referenciapersonal.gettelefono());	
					referenciapersonalLocal.settelefonomovil(referenciapersonal.gettelefonomovil());	
					referenciapersonalLocal.settelefonocodigoarea(referenciapersonal.gettelefonocodigoarea());	
					referenciapersonalLocal.setpreferencia(referenciapersonal.getpreferencia());	
					referenciapersonalLocal.setemail(referenciapersonal.getemail());	
					referenciapersonalLocal.setobservacion(referenciapersonal.getobservacion());	
					referenciapersonalLocal.setesta_trabajando(referenciapersonal.getesta_trabajando());	
					referenciapersonalLocal.setempresa_trabajo(referenciapersonal.getempresa_trabajo());	
					referenciapersonalLocal.setdireccion_trabajo(referenciapersonal.getdireccion_trabajo());	
					referenciapersonalLocal.settelefono_trabajo(referenciapersonal.gettelefono_trabajo());	
					referenciapersonalLocal.setesactivo(referenciapersonal.getesactivo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!referenciapersonal.getIsDeleted()) {
				if(!existe) {
					referenciapersonals.add(referenciapersonal);
				}
			} else {
				if(referenciapersonalEncontrado!=null && permiteQuitar)  {
					referenciapersonals.remove(referenciapersonalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ReferenciaPersonal referenciapersonal,List<ReferenciaPersonal> referenciapersonals) throws Exception {
		try	{			
			for(ReferenciaPersonal referenciapersonalLocal:referenciapersonals) {
				if(referenciapersonalLocal.getId().equals(referenciapersonal.getId())) {
					referenciapersonalLocal.setIsSelected(referenciapersonal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesReferenciaPersonal(List<ReferenciaPersonal> referenciapersonalsAux) throws Exception {
		//this.referenciapersonalsAux=referenciapersonalsAux;
		
		for(ReferenciaPersonal referenciapersonalAux:referenciapersonalsAux) {
			if(referenciapersonalAux.getIsChanged()) {
				referenciapersonalAux.setIsChanged(false);
			}		
			
			if(referenciapersonalAux.getIsNew()) {
				referenciapersonalAux.setIsNew(false);
			}	
			
			if(referenciapersonalAux.getIsDeleted()) {
				referenciapersonalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesReferenciaPersonal(ReferenciaPersonal referenciapersonalAux) throws Exception {
		//this.referenciapersonalAux=referenciapersonalAux;
		
			if(referenciapersonalAux.getIsChanged()) {
				referenciapersonalAux.setIsChanged(false);
			}		
			
			if(referenciapersonalAux.getIsNew()) {
				referenciapersonalAux.setIsNew(false);
			}	
			
			if(referenciapersonalAux.getIsDeleted()) {
				referenciapersonalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ReferenciaPersonal referenciapersonalAsignar,ReferenciaPersonal referenciapersonal) throws Exception {
		referenciapersonalAsignar.setId(referenciapersonal.getId());	
		referenciapersonalAsignar.setVersionRow(referenciapersonal.getVersionRow());	
		referenciapersonalAsignar.setid_empresa(referenciapersonal.getid_empresa());
		referenciapersonalAsignar.setempresa_descripcion(referenciapersonal.getempresa_descripcion());	
		referenciapersonalAsignar.setidcliente(referenciapersonal.getidcliente());
		referenciapersonalAsignar.setcliente_descripcion(referenciapersonal.getcliente_descripcion());	
		referenciapersonalAsignar.setidvalorclientereferenciapersonal(referenciapersonal.getidvalorclientereferenciapersonal());
		referenciapersonalAsignar.settiporefeperso_descripcion(referenciapersonal.gettiporefeperso_descripcion());	
		referenciapersonalAsignar.setid_pais(referenciapersonal.getid_pais());
		referenciapersonalAsignar.setpais_descripcion(referenciapersonal.getpais_descripcion());	
		referenciapersonalAsignar.setidciudad(referenciapersonal.getidciudad());
		referenciapersonalAsignar.setciudad_descripcion(referenciapersonal.getciudad_descripcion());	
		referenciapersonalAsignar.setnombre(referenciapersonal.getnombre());	
		referenciapersonalAsignar.setidentificacion(referenciapersonal.getidentificacion());	
		referenciapersonalAsignar.setfecha_nacimiento(referenciapersonal.getfecha_nacimiento());	
		referenciapersonalAsignar.setdireccion(referenciapersonal.getdireccion());	
		referenciapersonalAsignar.settelefono(referenciapersonal.gettelefono());	
		referenciapersonalAsignar.settelefonomovil(referenciapersonal.gettelefonomovil());	
		referenciapersonalAsignar.settelefonocodigoarea(referenciapersonal.gettelefonocodigoarea());	
		referenciapersonalAsignar.setpreferencia(referenciapersonal.getpreferencia());	
		referenciapersonalAsignar.setemail(referenciapersonal.getemail());	
		referenciapersonalAsignar.setobservacion(referenciapersonal.getobservacion());	
		referenciapersonalAsignar.setesta_trabajando(referenciapersonal.getesta_trabajando());	
		referenciapersonalAsignar.setempresa_trabajo(referenciapersonal.getempresa_trabajo());	
		referenciapersonalAsignar.setdireccion_trabajo(referenciapersonal.getdireccion_trabajo());	
		referenciapersonalAsignar.settelefono_trabajo(referenciapersonal.gettelefono_trabajo());	
		referenciapersonalAsignar.setesactivo(referenciapersonal.getesactivo());	
	}
	
	public static void inicializarReferenciaPersonal(ReferenciaPersonal referenciapersonal) throws Exception {
		try {
				referenciapersonal.setId(0L);	
					
				referenciapersonal.setid_empresa(-1L);	
				referenciapersonal.setidcliente(-1L);	
				referenciapersonal.setidvalorclientereferenciapersonal(-1L);	
				referenciapersonal.setid_pais(-1L);	
				referenciapersonal.setidciudad(-1L);	
				referenciapersonal.setnombre("");	
				referenciapersonal.setidentificacion("");	
				referenciapersonal.setfecha_nacimiento(new Date());	
				referenciapersonal.setdireccion("");	
				referenciapersonal.settelefono("");	
				referenciapersonal.settelefonomovil("");	
				referenciapersonal.settelefonocodigoarea("");	
				referenciapersonal.setpreferencia("");	
				referenciapersonal.setemail("");	
				referenciapersonal.setobservacion("");	
				referenciapersonal.setesta_trabajando(false);	
				referenciapersonal.setempresa_trabajo("");	
				referenciapersonal.setdireccion_trabajo("");	
				referenciapersonal.settelefono_trabajo("");	
				referenciapersonal.setesactivo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderReferenciaPersonal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_IDTIPOREFEPERSO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_IDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_FECHANACIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOMOVIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOCODIGOAREA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_PREFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_EMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_ESTATRABAJANDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_EMPRESATRABAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_DIRECCIONTRABAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_TELEFONOTRABAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaPersonalConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataReferenciaPersonal(String sTipo,Row row,Workbook workbook,ReferenciaPersonal referenciapersonal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.gettiporefeperso_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.getidentificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.getfecha_nacimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.gettelefonomovil());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.gettelefonocodigoarea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.getpreferencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.getemail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(referenciapersonal.getesta_trabajando()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.getempresa_trabajo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.getdireccion_trabajo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciapersonal.gettelefono_trabajo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(referenciapersonal.getesactivo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryReferenciaPersonal=Constantes.SFINALQUERY;
	
	public String getsFinalQueryReferenciaPersonal() {
		return this.sFinalQueryReferenciaPersonal;
	}
	
	public void setsFinalQueryReferenciaPersonal(String sFinalQueryReferenciaPersonal) {
		this.sFinalQueryReferenciaPersonal= sFinalQueryReferenciaPersonal;
	}
	
	public Border resaltarSeleccionarReferenciaPersonal=null;
	
	public Border setResaltarSeleccionarReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarReferenciaPersonal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarReferenciaPersonal() {
		return this.resaltarSeleccionarReferenciaPersonal;
	}
	
	public void setResaltarSeleccionarReferenciaPersonal(Border borderResaltarSeleccionarReferenciaPersonal) {
		this.resaltarSeleccionarReferenciaPersonal= borderResaltarSeleccionarReferenciaPersonal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridReferenciaPersonal=null;
	public Boolean mostraridReferenciaPersonal=true;
	public Boolean activaridReferenciaPersonal=true;

	public Border resaltarid_empresaReferenciaPersonal=null;
	public Boolean mostrarid_empresaReferenciaPersonal=true;
	public Boolean activarid_empresaReferenciaPersonal=true;
	public Boolean cargarid_empresaReferenciaPersonal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaReferenciaPersonal=false;//ConEventDepend=true

	public Border resaltaridclienteReferenciaPersonal=null;
	public Boolean mostraridclienteReferenciaPersonal=true;
	public Boolean activaridclienteReferenciaPersonal=true;
	public Boolean cargaridclienteReferenciaPersonal=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidclienteReferenciaPersonal=false;//ConEventDepend=true

	public Border resaltaridvalorclientereferenciapersonalReferenciaPersonal=null;
	public Boolean mostraridvalorclientereferenciapersonalReferenciaPersonal=true;
	public Boolean activaridvalorclientereferenciapersonalReferenciaPersonal=true;
	public Boolean cargaridvalorclientereferenciapersonalReferenciaPersonal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvalorclientereferenciapersonalReferenciaPersonal=false;//ConEventDepend=true

	public Border resaltarid_paisReferenciaPersonal=null;
	public Boolean mostrarid_paisReferenciaPersonal=true;
	public Boolean activarid_paisReferenciaPersonal=true;
	public Boolean cargarid_paisReferenciaPersonal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisReferenciaPersonal=false;//ConEventDepend=true

	public Border resaltaridciudadReferenciaPersonal=null;
	public Boolean mostraridciudadReferenciaPersonal=true;
	public Boolean activaridciudadReferenciaPersonal=true;
	public Boolean cargaridciudadReferenciaPersonal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidciudadReferenciaPersonal=true;//ConEventDepend=true

	public Border resaltarnombreReferenciaPersonal=null;
	public Boolean mostrarnombreReferenciaPersonal=true;
	public Boolean activarnombreReferenciaPersonal=true;

	public Border resaltaridentificacionReferenciaPersonal=null;
	public Boolean mostraridentificacionReferenciaPersonal=true;
	public Boolean activaridentificacionReferenciaPersonal=true;

	public Border resaltarfecha_nacimientoReferenciaPersonal=null;
	public Boolean mostrarfecha_nacimientoReferenciaPersonal=true;
	public Boolean activarfecha_nacimientoReferenciaPersonal=false;

	public Border resaltardireccionReferenciaPersonal=null;
	public Boolean mostrardireccionReferenciaPersonal=true;
	public Boolean activardireccionReferenciaPersonal=true;

	public Border resaltartelefonoReferenciaPersonal=null;
	public Boolean mostrartelefonoReferenciaPersonal=true;
	public Boolean activartelefonoReferenciaPersonal=true;

	public Border resaltartelefonomovilReferenciaPersonal=null;
	public Boolean mostrartelefonomovilReferenciaPersonal=true;
	public Boolean activartelefonomovilReferenciaPersonal=true;

	public Border resaltartelefonocodigoareaReferenciaPersonal=null;
	public Boolean mostrartelefonocodigoareaReferenciaPersonal=true;
	public Boolean activartelefonocodigoareaReferenciaPersonal=true;

	public Border resaltarpreferenciaReferenciaPersonal=null;
	public Boolean mostrarpreferenciaReferenciaPersonal=true;
	public Boolean activarpreferenciaReferenciaPersonal=true;

	public Border resaltaremailReferenciaPersonal=null;
	public Boolean mostraremailReferenciaPersonal=true;
	public Boolean activaremailReferenciaPersonal=true;

	public Border resaltarobservacionReferenciaPersonal=null;
	public Boolean mostrarobservacionReferenciaPersonal=true;
	public Boolean activarobservacionReferenciaPersonal=true;

	public Border resaltaresta_trabajandoReferenciaPersonal=null;
	public Boolean mostraresta_trabajandoReferenciaPersonal=true;
	public Boolean activaresta_trabajandoReferenciaPersonal=true;

	public Border resaltarempresa_trabajoReferenciaPersonal=null;
	public Boolean mostrarempresa_trabajoReferenciaPersonal=true;
	public Boolean activarempresa_trabajoReferenciaPersonal=true;

	public Border resaltardireccion_trabajoReferenciaPersonal=null;
	public Boolean mostrardireccion_trabajoReferenciaPersonal=true;
	public Boolean activardireccion_trabajoReferenciaPersonal=true;

	public Border resaltartelefono_trabajoReferenciaPersonal=null;
	public Boolean mostrartelefono_trabajoReferenciaPersonal=true;
	public Boolean activartelefono_trabajoReferenciaPersonal=true;

	public Border resaltaresactivoReferenciaPersonal=null;
	public Boolean mostraresactivoReferenciaPersonal=true;
	public Boolean activaresactivoReferenciaPersonal=true;

	
	

	public Border setResaltaridReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltaridReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridReferenciaPersonal() {
		return this.resaltaridReferenciaPersonal;
	}

	public void setResaltaridReferenciaPersonal(Border borderResaltar) {
		this.resaltaridReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostraridReferenciaPersonal() {
		return this.mostraridReferenciaPersonal;
	}

	public void setMostraridReferenciaPersonal(Boolean mostraridReferenciaPersonal) {
		this.mostraridReferenciaPersonal= mostraridReferenciaPersonal;
	}

	public Boolean getActivaridReferenciaPersonal() {
		return this.activaridReferenciaPersonal;
	}

	public void setActivaridReferenciaPersonal(Boolean activaridReferenciaPersonal) {
		this.activaridReferenciaPersonal= activaridReferenciaPersonal;
	}

	public Border setResaltarid_empresaReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltarid_empresaReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaReferenciaPersonal() {
		return this.resaltarid_empresaReferenciaPersonal;
	}

	public void setResaltarid_empresaReferenciaPersonal(Border borderResaltar) {
		this.resaltarid_empresaReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostrarid_empresaReferenciaPersonal() {
		return this.mostrarid_empresaReferenciaPersonal;
	}

	public void setMostrarid_empresaReferenciaPersonal(Boolean mostrarid_empresaReferenciaPersonal) {
		this.mostrarid_empresaReferenciaPersonal= mostrarid_empresaReferenciaPersonal;
	}

	public Boolean getActivarid_empresaReferenciaPersonal() {
		return this.activarid_empresaReferenciaPersonal;
	}

	public void setActivarid_empresaReferenciaPersonal(Boolean activarid_empresaReferenciaPersonal) {
		this.activarid_empresaReferenciaPersonal= activarid_empresaReferenciaPersonal;
	}

	public Boolean getCargarid_empresaReferenciaPersonal() {
		return this.cargarid_empresaReferenciaPersonal;
	}

	public void setCargarid_empresaReferenciaPersonal(Boolean cargarid_empresaReferenciaPersonal) {
		this.cargarid_empresaReferenciaPersonal= cargarid_empresaReferenciaPersonal;
	}

	public Border setResaltaridclienteReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltaridclienteReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridclienteReferenciaPersonal() {
		return this.resaltaridclienteReferenciaPersonal;
	}

	public void setResaltaridclienteReferenciaPersonal(Border borderResaltar) {
		this.resaltaridclienteReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostraridclienteReferenciaPersonal() {
		return this.mostraridclienteReferenciaPersonal;
	}

	public void setMostraridclienteReferenciaPersonal(Boolean mostraridclienteReferenciaPersonal) {
		this.mostraridclienteReferenciaPersonal= mostraridclienteReferenciaPersonal;
	}

	public Boolean getActivaridclienteReferenciaPersonal() {
		return this.activaridclienteReferenciaPersonal;
	}

	public void setActivaridclienteReferenciaPersonal(Boolean activaridclienteReferenciaPersonal) {
		this.activaridclienteReferenciaPersonal= activaridclienteReferenciaPersonal;
	}

	public Boolean getCargaridclienteReferenciaPersonal() {
		return this.cargaridclienteReferenciaPersonal;
	}

	public void setCargaridclienteReferenciaPersonal(Boolean cargaridclienteReferenciaPersonal) {
		this.cargaridclienteReferenciaPersonal= cargaridclienteReferenciaPersonal;
	}

	public Border setResaltaridvalorclientereferenciapersonalReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltaridvalorclientereferenciapersonalReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvalorclientereferenciapersonalReferenciaPersonal() {
		return this.resaltaridvalorclientereferenciapersonalReferenciaPersonal;
	}

	public void setResaltaridvalorclientereferenciapersonalReferenciaPersonal(Border borderResaltar) {
		this.resaltaridvalorclientereferenciapersonalReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostraridvalorclientereferenciapersonalReferenciaPersonal() {
		return this.mostraridvalorclientereferenciapersonalReferenciaPersonal;
	}

	public void setMostraridvalorclientereferenciapersonalReferenciaPersonal(Boolean mostraridvalorclientereferenciapersonalReferenciaPersonal) {
		this.mostraridvalorclientereferenciapersonalReferenciaPersonal= mostraridvalorclientereferenciapersonalReferenciaPersonal;
	}

	public Boolean getActivaridvalorclientereferenciapersonalReferenciaPersonal() {
		return this.activaridvalorclientereferenciapersonalReferenciaPersonal;
	}

	public void setActivaridvalorclientereferenciapersonalReferenciaPersonal(Boolean activaridvalorclientereferenciapersonalReferenciaPersonal) {
		this.activaridvalorclientereferenciapersonalReferenciaPersonal= activaridvalorclientereferenciapersonalReferenciaPersonal;
	}

	public Boolean getCargaridvalorclientereferenciapersonalReferenciaPersonal() {
		return this.cargaridvalorclientereferenciapersonalReferenciaPersonal;
	}

	public void setCargaridvalorclientereferenciapersonalReferenciaPersonal(Boolean cargaridvalorclientereferenciapersonalReferenciaPersonal) {
		this.cargaridvalorclientereferenciapersonalReferenciaPersonal= cargaridvalorclientereferenciapersonalReferenciaPersonal;
	}

	public Border setResaltarid_paisReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltarid_paisReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisReferenciaPersonal() {
		return this.resaltarid_paisReferenciaPersonal;
	}

	public void setResaltarid_paisReferenciaPersonal(Border borderResaltar) {
		this.resaltarid_paisReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostrarid_paisReferenciaPersonal() {
		return this.mostrarid_paisReferenciaPersonal;
	}

	public void setMostrarid_paisReferenciaPersonal(Boolean mostrarid_paisReferenciaPersonal) {
		this.mostrarid_paisReferenciaPersonal= mostrarid_paisReferenciaPersonal;
	}

	public Boolean getActivarid_paisReferenciaPersonal() {
		return this.activarid_paisReferenciaPersonal;
	}

	public void setActivarid_paisReferenciaPersonal(Boolean activarid_paisReferenciaPersonal) {
		this.activarid_paisReferenciaPersonal= activarid_paisReferenciaPersonal;
	}

	public Boolean getCargarid_paisReferenciaPersonal() {
		return this.cargarid_paisReferenciaPersonal;
	}

	public void setCargarid_paisReferenciaPersonal(Boolean cargarid_paisReferenciaPersonal) {
		this.cargarid_paisReferenciaPersonal= cargarid_paisReferenciaPersonal;
	}

	public Border setResaltaridciudadReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltaridciudadReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridciudadReferenciaPersonal() {
		return this.resaltaridciudadReferenciaPersonal;
	}

	public void setResaltaridciudadReferenciaPersonal(Border borderResaltar) {
		this.resaltaridciudadReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostraridciudadReferenciaPersonal() {
		return this.mostraridciudadReferenciaPersonal;
	}

	public void setMostraridciudadReferenciaPersonal(Boolean mostraridciudadReferenciaPersonal) {
		this.mostraridciudadReferenciaPersonal= mostraridciudadReferenciaPersonal;
	}

	public Boolean getActivaridciudadReferenciaPersonal() {
		return this.activaridciudadReferenciaPersonal;
	}

	public void setActivaridciudadReferenciaPersonal(Boolean activaridciudadReferenciaPersonal) {
		this.activaridciudadReferenciaPersonal= activaridciudadReferenciaPersonal;
	}

	public Boolean getCargaridciudadReferenciaPersonal() {
		return this.cargaridciudadReferenciaPersonal;
	}

	public void setCargaridciudadReferenciaPersonal(Boolean cargaridciudadReferenciaPersonal) {
		this.cargaridciudadReferenciaPersonal= cargaridciudadReferenciaPersonal;
	}

	public Border setResaltarnombreReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltarnombreReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreReferenciaPersonal() {
		return this.resaltarnombreReferenciaPersonal;
	}

	public void setResaltarnombreReferenciaPersonal(Border borderResaltar) {
		this.resaltarnombreReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostrarnombreReferenciaPersonal() {
		return this.mostrarnombreReferenciaPersonal;
	}

	public void setMostrarnombreReferenciaPersonal(Boolean mostrarnombreReferenciaPersonal) {
		this.mostrarnombreReferenciaPersonal= mostrarnombreReferenciaPersonal;
	}

	public Boolean getActivarnombreReferenciaPersonal() {
		return this.activarnombreReferenciaPersonal;
	}

	public void setActivarnombreReferenciaPersonal(Boolean activarnombreReferenciaPersonal) {
		this.activarnombreReferenciaPersonal= activarnombreReferenciaPersonal;
	}

	public Border setResaltaridentificacionReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltaridentificacionReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridentificacionReferenciaPersonal() {
		return this.resaltaridentificacionReferenciaPersonal;
	}

	public void setResaltaridentificacionReferenciaPersonal(Border borderResaltar) {
		this.resaltaridentificacionReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostraridentificacionReferenciaPersonal() {
		return this.mostraridentificacionReferenciaPersonal;
	}

	public void setMostraridentificacionReferenciaPersonal(Boolean mostraridentificacionReferenciaPersonal) {
		this.mostraridentificacionReferenciaPersonal= mostraridentificacionReferenciaPersonal;
	}

	public Boolean getActivaridentificacionReferenciaPersonal() {
		return this.activaridentificacionReferenciaPersonal;
	}

	public void setActivaridentificacionReferenciaPersonal(Boolean activaridentificacionReferenciaPersonal) {
		this.activaridentificacionReferenciaPersonal= activaridentificacionReferenciaPersonal;
	}

	public Border setResaltarfecha_nacimientoReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltarfecha_nacimientoReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_nacimientoReferenciaPersonal() {
		return this.resaltarfecha_nacimientoReferenciaPersonal;
	}

	public void setResaltarfecha_nacimientoReferenciaPersonal(Border borderResaltar) {
		this.resaltarfecha_nacimientoReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostrarfecha_nacimientoReferenciaPersonal() {
		return this.mostrarfecha_nacimientoReferenciaPersonal;
	}

	public void setMostrarfecha_nacimientoReferenciaPersonal(Boolean mostrarfecha_nacimientoReferenciaPersonal) {
		this.mostrarfecha_nacimientoReferenciaPersonal= mostrarfecha_nacimientoReferenciaPersonal;
	}

	public Boolean getActivarfecha_nacimientoReferenciaPersonal() {
		return this.activarfecha_nacimientoReferenciaPersonal;
	}

	public void setActivarfecha_nacimientoReferenciaPersonal(Boolean activarfecha_nacimientoReferenciaPersonal) {
		this.activarfecha_nacimientoReferenciaPersonal= activarfecha_nacimientoReferenciaPersonal;
	}

	public Border setResaltardireccionReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltardireccionReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionReferenciaPersonal() {
		return this.resaltardireccionReferenciaPersonal;
	}

	public void setResaltardireccionReferenciaPersonal(Border borderResaltar) {
		this.resaltardireccionReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostrardireccionReferenciaPersonal() {
		return this.mostrardireccionReferenciaPersonal;
	}

	public void setMostrardireccionReferenciaPersonal(Boolean mostrardireccionReferenciaPersonal) {
		this.mostrardireccionReferenciaPersonal= mostrardireccionReferenciaPersonal;
	}

	public Boolean getActivardireccionReferenciaPersonal() {
		return this.activardireccionReferenciaPersonal;
	}

	public void setActivardireccionReferenciaPersonal(Boolean activardireccionReferenciaPersonal) {
		this.activardireccionReferenciaPersonal= activardireccionReferenciaPersonal;
	}

	public Border setResaltartelefonoReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltartelefonoReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoReferenciaPersonal() {
		return this.resaltartelefonoReferenciaPersonal;
	}

	public void setResaltartelefonoReferenciaPersonal(Border borderResaltar) {
		this.resaltartelefonoReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostrartelefonoReferenciaPersonal() {
		return this.mostrartelefonoReferenciaPersonal;
	}

	public void setMostrartelefonoReferenciaPersonal(Boolean mostrartelefonoReferenciaPersonal) {
		this.mostrartelefonoReferenciaPersonal= mostrartelefonoReferenciaPersonal;
	}

	public Boolean getActivartelefonoReferenciaPersonal() {
		return this.activartelefonoReferenciaPersonal;
	}

	public void setActivartelefonoReferenciaPersonal(Boolean activartelefonoReferenciaPersonal) {
		this.activartelefonoReferenciaPersonal= activartelefonoReferenciaPersonal;
	}

	public Border setResaltartelefonomovilReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltartelefonomovilReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonomovilReferenciaPersonal() {
		return this.resaltartelefonomovilReferenciaPersonal;
	}

	public void setResaltartelefonomovilReferenciaPersonal(Border borderResaltar) {
		this.resaltartelefonomovilReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostrartelefonomovilReferenciaPersonal() {
		return this.mostrartelefonomovilReferenciaPersonal;
	}

	public void setMostrartelefonomovilReferenciaPersonal(Boolean mostrartelefonomovilReferenciaPersonal) {
		this.mostrartelefonomovilReferenciaPersonal= mostrartelefonomovilReferenciaPersonal;
	}

	public Boolean getActivartelefonomovilReferenciaPersonal() {
		return this.activartelefonomovilReferenciaPersonal;
	}

	public void setActivartelefonomovilReferenciaPersonal(Boolean activartelefonomovilReferenciaPersonal) {
		this.activartelefonomovilReferenciaPersonal= activartelefonomovilReferenciaPersonal;
	}

	public Border setResaltartelefonocodigoareaReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltartelefonocodigoareaReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonocodigoareaReferenciaPersonal() {
		return this.resaltartelefonocodigoareaReferenciaPersonal;
	}

	public void setResaltartelefonocodigoareaReferenciaPersonal(Border borderResaltar) {
		this.resaltartelefonocodigoareaReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostrartelefonocodigoareaReferenciaPersonal() {
		return this.mostrartelefonocodigoareaReferenciaPersonal;
	}

	public void setMostrartelefonocodigoareaReferenciaPersonal(Boolean mostrartelefonocodigoareaReferenciaPersonal) {
		this.mostrartelefonocodigoareaReferenciaPersonal= mostrartelefonocodigoareaReferenciaPersonal;
	}

	public Boolean getActivartelefonocodigoareaReferenciaPersonal() {
		return this.activartelefonocodigoareaReferenciaPersonal;
	}

	public void setActivartelefonocodigoareaReferenciaPersonal(Boolean activartelefonocodigoareaReferenciaPersonal) {
		this.activartelefonocodigoareaReferenciaPersonal= activartelefonocodigoareaReferenciaPersonal;
	}

	public Border setResaltarpreferenciaReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltarpreferenciaReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpreferenciaReferenciaPersonal() {
		return this.resaltarpreferenciaReferenciaPersonal;
	}

	public void setResaltarpreferenciaReferenciaPersonal(Border borderResaltar) {
		this.resaltarpreferenciaReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostrarpreferenciaReferenciaPersonal() {
		return this.mostrarpreferenciaReferenciaPersonal;
	}

	public void setMostrarpreferenciaReferenciaPersonal(Boolean mostrarpreferenciaReferenciaPersonal) {
		this.mostrarpreferenciaReferenciaPersonal= mostrarpreferenciaReferenciaPersonal;
	}

	public Boolean getActivarpreferenciaReferenciaPersonal() {
		return this.activarpreferenciaReferenciaPersonal;
	}

	public void setActivarpreferenciaReferenciaPersonal(Boolean activarpreferenciaReferenciaPersonal) {
		this.activarpreferenciaReferenciaPersonal= activarpreferenciaReferenciaPersonal;
	}

	public Border setResaltaremailReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltaremailReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaremailReferenciaPersonal() {
		return this.resaltaremailReferenciaPersonal;
	}

	public void setResaltaremailReferenciaPersonal(Border borderResaltar) {
		this.resaltaremailReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostraremailReferenciaPersonal() {
		return this.mostraremailReferenciaPersonal;
	}

	public void setMostraremailReferenciaPersonal(Boolean mostraremailReferenciaPersonal) {
		this.mostraremailReferenciaPersonal= mostraremailReferenciaPersonal;
	}

	public Boolean getActivaremailReferenciaPersonal() {
		return this.activaremailReferenciaPersonal;
	}

	public void setActivaremailReferenciaPersonal(Boolean activaremailReferenciaPersonal) {
		this.activaremailReferenciaPersonal= activaremailReferenciaPersonal;
	}

	public Border setResaltarobservacionReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltarobservacionReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionReferenciaPersonal() {
		return this.resaltarobservacionReferenciaPersonal;
	}

	public void setResaltarobservacionReferenciaPersonal(Border borderResaltar) {
		this.resaltarobservacionReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostrarobservacionReferenciaPersonal() {
		return this.mostrarobservacionReferenciaPersonal;
	}

	public void setMostrarobservacionReferenciaPersonal(Boolean mostrarobservacionReferenciaPersonal) {
		this.mostrarobservacionReferenciaPersonal= mostrarobservacionReferenciaPersonal;
	}

	public Boolean getActivarobservacionReferenciaPersonal() {
		return this.activarobservacionReferenciaPersonal;
	}

	public void setActivarobservacionReferenciaPersonal(Boolean activarobservacionReferenciaPersonal) {
		this.activarobservacionReferenciaPersonal= activarobservacionReferenciaPersonal;
	}

	public Border setResaltaresta_trabajandoReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltaresta_trabajandoReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_trabajandoReferenciaPersonal() {
		return this.resaltaresta_trabajandoReferenciaPersonal;
	}

	public void setResaltaresta_trabajandoReferenciaPersonal(Border borderResaltar) {
		this.resaltaresta_trabajandoReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostraresta_trabajandoReferenciaPersonal() {
		return this.mostraresta_trabajandoReferenciaPersonal;
	}

	public void setMostraresta_trabajandoReferenciaPersonal(Boolean mostraresta_trabajandoReferenciaPersonal) {
		this.mostraresta_trabajandoReferenciaPersonal= mostraresta_trabajandoReferenciaPersonal;
	}

	public Boolean getActivaresta_trabajandoReferenciaPersonal() {
		return this.activaresta_trabajandoReferenciaPersonal;
	}

	public void setActivaresta_trabajandoReferenciaPersonal(Boolean activaresta_trabajandoReferenciaPersonal) {
		this.activaresta_trabajandoReferenciaPersonal= activaresta_trabajandoReferenciaPersonal;
	}

	public Border setResaltarempresa_trabajoReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltarempresa_trabajoReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarempresa_trabajoReferenciaPersonal() {
		return this.resaltarempresa_trabajoReferenciaPersonal;
	}

	public void setResaltarempresa_trabajoReferenciaPersonal(Border borderResaltar) {
		this.resaltarempresa_trabajoReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostrarempresa_trabajoReferenciaPersonal() {
		return this.mostrarempresa_trabajoReferenciaPersonal;
	}

	public void setMostrarempresa_trabajoReferenciaPersonal(Boolean mostrarempresa_trabajoReferenciaPersonal) {
		this.mostrarempresa_trabajoReferenciaPersonal= mostrarempresa_trabajoReferenciaPersonal;
	}

	public Boolean getActivarempresa_trabajoReferenciaPersonal() {
		return this.activarempresa_trabajoReferenciaPersonal;
	}

	public void setActivarempresa_trabajoReferenciaPersonal(Boolean activarempresa_trabajoReferenciaPersonal) {
		this.activarempresa_trabajoReferenciaPersonal= activarempresa_trabajoReferenciaPersonal;
	}

	public Border setResaltardireccion_trabajoReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltardireccion_trabajoReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_trabajoReferenciaPersonal() {
		return this.resaltardireccion_trabajoReferenciaPersonal;
	}

	public void setResaltardireccion_trabajoReferenciaPersonal(Border borderResaltar) {
		this.resaltardireccion_trabajoReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostrardireccion_trabajoReferenciaPersonal() {
		return this.mostrardireccion_trabajoReferenciaPersonal;
	}

	public void setMostrardireccion_trabajoReferenciaPersonal(Boolean mostrardireccion_trabajoReferenciaPersonal) {
		this.mostrardireccion_trabajoReferenciaPersonal= mostrardireccion_trabajoReferenciaPersonal;
	}

	public Boolean getActivardireccion_trabajoReferenciaPersonal() {
		return this.activardireccion_trabajoReferenciaPersonal;
	}

	public void setActivardireccion_trabajoReferenciaPersonal(Boolean activardireccion_trabajoReferenciaPersonal) {
		this.activardireccion_trabajoReferenciaPersonal= activardireccion_trabajoReferenciaPersonal;
	}

	public Border setResaltartelefono_trabajoReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltartelefono_trabajoReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_trabajoReferenciaPersonal() {
		return this.resaltartelefono_trabajoReferenciaPersonal;
	}

	public void setResaltartelefono_trabajoReferenciaPersonal(Border borderResaltar) {
		this.resaltartelefono_trabajoReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostrartelefono_trabajoReferenciaPersonal() {
		return this.mostrartelefono_trabajoReferenciaPersonal;
	}

	public void setMostrartelefono_trabajoReferenciaPersonal(Boolean mostrartelefono_trabajoReferenciaPersonal) {
		this.mostrartelefono_trabajoReferenciaPersonal= mostrartelefono_trabajoReferenciaPersonal;
	}

	public Boolean getActivartelefono_trabajoReferenciaPersonal() {
		return this.activartelefono_trabajoReferenciaPersonal;
	}

	public void setActivartelefono_trabajoReferenciaPersonal(Boolean activartelefono_trabajoReferenciaPersonal) {
		this.activartelefono_trabajoReferenciaPersonal= activartelefono_trabajoReferenciaPersonal;
	}

	public Border setResaltaresactivoReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciapersonalBeanSwingJInternalFrame.jTtoolBarReferenciaPersonal.setBorder(borderResaltar);
		
		this.resaltaresactivoReferenciaPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresactivoReferenciaPersonal() {
		return this.resaltaresactivoReferenciaPersonal;
	}

	public void setResaltaresactivoReferenciaPersonal(Border borderResaltar) {
		this.resaltaresactivoReferenciaPersonal= borderResaltar;
	}

	public Boolean getMostraresactivoReferenciaPersonal() {
		return this.mostraresactivoReferenciaPersonal;
	}

	public void setMostraresactivoReferenciaPersonal(Boolean mostraresactivoReferenciaPersonal) {
		this.mostraresactivoReferenciaPersonal= mostraresactivoReferenciaPersonal;
	}

	public Boolean getActivaresactivoReferenciaPersonal() {
		return this.activaresactivoReferenciaPersonal;
	}

	public void setActivaresactivoReferenciaPersonal(Boolean activaresactivoReferenciaPersonal) {
		this.activaresactivoReferenciaPersonal= activaresactivoReferenciaPersonal;
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
		
		
		this.setMostraridReferenciaPersonal(esInicial);
		this.setMostrarid_empresaReferenciaPersonal(esInicial);
		this.setMostraridclienteReferenciaPersonal(esInicial);
		this.setMostraridvalorclientereferenciapersonalReferenciaPersonal(esInicial);
		this.setMostrarid_paisReferenciaPersonal(esInicial);
		this.setMostraridciudadReferenciaPersonal(esInicial);
		this.setMostrarnombreReferenciaPersonal(esInicial);
		this.setMostraridentificacionReferenciaPersonal(esInicial);
		this.setMostrarfecha_nacimientoReferenciaPersonal(esInicial);
		this.setMostrardireccionReferenciaPersonal(esInicial);
		this.setMostrartelefonoReferenciaPersonal(esInicial);
		this.setMostrartelefonomovilReferenciaPersonal(esInicial);
		this.setMostrartelefonocodigoareaReferenciaPersonal(esInicial);
		this.setMostrarpreferenciaReferenciaPersonal(esInicial);
		this.setMostraremailReferenciaPersonal(esInicial);
		this.setMostrarobservacionReferenciaPersonal(esInicial);
		this.setMostraresta_trabajandoReferenciaPersonal(esInicial);
		this.setMostrarempresa_trabajoReferenciaPersonal(esInicial);
		this.setMostrardireccion_trabajoReferenciaPersonal(esInicial);
		this.setMostrartelefono_trabajoReferenciaPersonal(esInicial);
		this.setMostraresactivoReferenciaPersonal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.ID)) {
				this.setMostraridReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDCLIENTE)) {
				this.setMostraridclienteReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDTIPOREFEPERSO)) {
				this.setMostraridvalorclientereferenciapersonalReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDCIUDAD)) {
				this.setMostraridciudadReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDENTIFICACION)) {
				this.setMostraridentificacionReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.FECHANACIMIENTO)) {
				this.setMostrarfecha_nacimientoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.TELEFONOMOVIL)) {
				this.setMostrartelefonomovilReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.TELEFONOCODIGOAREA)) {
				this.setMostrartelefonocodigoareaReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.PREFERENCIA)) {
				this.setMostrarpreferenciaReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.EMAIL)) {
				this.setMostraremailReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.ESTATRABAJANDO)) {
				this.setMostraresta_trabajandoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.EMPRESATRABAJO)) {
				this.setMostrarempresa_trabajoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.DIRECCIONTRABAJO)) {
				this.setMostrardireccion_trabajoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.TELEFONOTRABAJO)) {
				this.setMostrartelefono_trabajoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.ESACTIVO)) {
				this.setMostraresactivoReferenciaPersonal(esAsigna);
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
		
		
		this.setActivaridReferenciaPersonal(esInicial);
		this.setActivarid_empresaReferenciaPersonal(esInicial);
		this.setActivaridclienteReferenciaPersonal(esInicial);
		this.setActivaridvalorclientereferenciapersonalReferenciaPersonal(esInicial);
		this.setActivarid_paisReferenciaPersonal(esInicial);
		this.setActivaridciudadReferenciaPersonal(esInicial);
		this.setActivarnombreReferenciaPersonal(esInicial);
		this.setActivaridentificacionReferenciaPersonal(esInicial);
		this.setActivarfecha_nacimientoReferenciaPersonal(esInicial);
		this.setActivardireccionReferenciaPersonal(esInicial);
		this.setActivartelefonoReferenciaPersonal(esInicial);
		this.setActivartelefonomovilReferenciaPersonal(esInicial);
		this.setActivartelefonocodigoareaReferenciaPersonal(esInicial);
		this.setActivarpreferenciaReferenciaPersonal(esInicial);
		this.setActivaremailReferenciaPersonal(esInicial);
		this.setActivarobservacionReferenciaPersonal(esInicial);
		this.setActivaresta_trabajandoReferenciaPersonal(esInicial);
		this.setActivarempresa_trabajoReferenciaPersonal(esInicial);
		this.setActivardireccion_trabajoReferenciaPersonal(esInicial);
		this.setActivartelefono_trabajoReferenciaPersonal(esInicial);
		this.setActivaresactivoReferenciaPersonal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.ID)) {
				this.setActivaridReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDCLIENTE)) {
				this.setActivaridclienteReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDTIPOREFEPERSO)) {
				this.setActivaridvalorclientereferenciapersonalReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDCIUDAD)) {
				this.setActivaridciudadReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.NOMBRE)) {
				this.setActivarnombreReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDENTIFICACION)) {
				this.setActivaridentificacionReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.FECHANACIMIENTO)) {
				this.setActivarfecha_nacimientoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.DIRECCION)) {
				this.setActivardireccionReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.TELEFONOMOVIL)) {
				this.setActivartelefonomovilReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.TELEFONOCODIGOAREA)) {
				this.setActivartelefonocodigoareaReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.PREFERENCIA)) {
				this.setActivarpreferenciaReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.EMAIL)) {
				this.setActivaremailReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.ESTATRABAJANDO)) {
				this.setActivaresta_trabajandoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.EMPRESATRABAJO)) {
				this.setActivarempresa_trabajoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.DIRECCIONTRABAJO)) {
				this.setActivardireccion_trabajoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.TELEFONOTRABAJO)) {
				this.setActivartelefono_trabajoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.ESACTIVO)) {
				this.setActivaresactivoReferenciaPersonal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridReferenciaPersonal(esInicial);
		this.setResaltarid_empresaReferenciaPersonal(esInicial);
		this.setResaltaridclienteReferenciaPersonal(esInicial);
		this.setResaltaridvalorclientereferenciapersonalReferenciaPersonal(esInicial);
		this.setResaltarid_paisReferenciaPersonal(esInicial);
		this.setResaltaridciudadReferenciaPersonal(esInicial);
		this.setResaltarnombreReferenciaPersonal(esInicial);
		this.setResaltaridentificacionReferenciaPersonal(esInicial);
		this.setResaltarfecha_nacimientoReferenciaPersonal(esInicial);
		this.setResaltardireccionReferenciaPersonal(esInicial);
		this.setResaltartelefonoReferenciaPersonal(esInicial);
		this.setResaltartelefonomovilReferenciaPersonal(esInicial);
		this.setResaltartelefonocodigoareaReferenciaPersonal(esInicial);
		this.setResaltarpreferenciaReferenciaPersonal(esInicial);
		this.setResaltaremailReferenciaPersonal(esInicial);
		this.setResaltarobservacionReferenciaPersonal(esInicial);
		this.setResaltaresta_trabajandoReferenciaPersonal(esInicial);
		this.setResaltarempresa_trabajoReferenciaPersonal(esInicial);
		this.setResaltardireccion_trabajoReferenciaPersonal(esInicial);
		this.setResaltartelefono_trabajoReferenciaPersonal(esInicial);
		this.setResaltaresactivoReferenciaPersonal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.ID)) {
				this.setResaltaridReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDCLIENTE)) {
				this.setResaltaridclienteReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDTIPOREFEPERSO)) {
				this.setResaltaridvalorclientereferenciapersonalReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDCIUDAD)) {
				this.setResaltaridciudadReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.IDENTIFICACION)) {
				this.setResaltaridentificacionReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.FECHANACIMIENTO)) {
				this.setResaltarfecha_nacimientoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.TELEFONOMOVIL)) {
				this.setResaltartelefonomovilReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.TELEFONOCODIGOAREA)) {
				this.setResaltartelefonocodigoareaReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.PREFERENCIA)) {
				this.setResaltarpreferenciaReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.EMAIL)) {
				this.setResaltaremailReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.ESTATRABAJANDO)) {
				this.setResaltaresta_trabajandoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.EMPRESATRABAJO)) {
				this.setResaltarempresa_trabajoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.DIRECCIONTRABAJO)) {
				this.setResaltardireccion_trabajoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.TELEFONOTRABAJO)) {
				this.setResaltartelefono_trabajoReferenciaPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaPersonalConstantesFunciones.ESACTIVO)) {
				this.setResaltaresactivoReferenciaPersonal(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCiudadReferenciaPersonal=true;

	public Boolean getMostrarFK_IdCiudadReferenciaPersonal() {
		return this.mostrarFK_IdCiudadReferenciaPersonal;
	}

	public void setMostrarFK_IdCiudadReferenciaPersonal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadReferenciaPersonal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteReferenciaPersonal=true;

	public Boolean getMostrarFK_IdClienteReferenciaPersonal() {
		return this.mostrarFK_IdClienteReferenciaPersonal;
	}

	public void setMostrarFK_IdClienteReferenciaPersonal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteReferenciaPersonal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaReferenciaPersonal=true;

	public Boolean getMostrarFK_IdEmpresaReferenciaPersonal() {
		return this.mostrarFK_IdEmpresaReferenciaPersonal;
	}

	public void setMostrarFK_IdEmpresaReferenciaPersonal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaReferenciaPersonal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisReferenciaPersonal=true;

	public Boolean getMostrarFK_IdPaisReferenciaPersonal() {
		return this.mostrarFK_IdPaisReferenciaPersonal;
	}

	public void setMostrarFK_IdPaisReferenciaPersonal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisReferenciaPersonal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoReferenciaPersonalReferenciaPersonal=true;

	public Boolean getMostrarFK_IdTipoReferenciaPersonalReferenciaPersonal() {
		return this.mostrarFK_IdTipoReferenciaPersonalReferenciaPersonal;
	}

	public void setMostrarFK_IdTipoReferenciaPersonalReferenciaPersonal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoReferenciaPersonalReferenciaPersonal= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadReferenciaPersonal=true;

	public Boolean getActivarFK_IdCiudadReferenciaPersonal() {
		return this.activarFK_IdCiudadReferenciaPersonal;
	}

	public void setActivarFK_IdCiudadReferenciaPersonal(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadReferenciaPersonal= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteReferenciaPersonal=true;

	public Boolean getActivarFK_IdClienteReferenciaPersonal() {
		return this.activarFK_IdClienteReferenciaPersonal;
	}

	public void setActivarFK_IdClienteReferenciaPersonal(Boolean habilitarResaltar) {
		this.activarFK_IdClienteReferenciaPersonal= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaReferenciaPersonal=true;

	public Boolean getActivarFK_IdEmpresaReferenciaPersonal() {
		return this.activarFK_IdEmpresaReferenciaPersonal;
	}

	public void setActivarFK_IdEmpresaReferenciaPersonal(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaReferenciaPersonal= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisReferenciaPersonal=true;

	public Boolean getActivarFK_IdPaisReferenciaPersonal() {
		return this.activarFK_IdPaisReferenciaPersonal;
	}

	public void setActivarFK_IdPaisReferenciaPersonal(Boolean habilitarResaltar) {
		this.activarFK_IdPaisReferenciaPersonal= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoReferenciaPersonalReferenciaPersonal=true;

	public Boolean getActivarFK_IdTipoReferenciaPersonalReferenciaPersonal() {
		return this.activarFK_IdTipoReferenciaPersonalReferenciaPersonal;
	}

	public void setActivarFK_IdTipoReferenciaPersonalReferenciaPersonal(Boolean habilitarResaltar) {
		this.activarFK_IdTipoReferenciaPersonalReferenciaPersonal= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadReferenciaPersonal=null;

	public Border getResaltarFK_IdCiudadReferenciaPersonal() {
		return this.resaltarFK_IdCiudadReferenciaPersonal;
	}

	public void setResaltarFK_IdCiudadReferenciaPersonal(Border borderResaltar) {
		this.resaltarFK_IdCiudadReferenciaPersonal= borderResaltar;
	}

	public void setResaltarFK_IdCiudadReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadReferenciaPersonal= borderResaltar;
	}

	public Border resaltarFK_IdClienteReferenciaPersonal=null;

	public Border getResaltarFK_IdClienteReferenciaPersonal() {
		return this.resaltarFK_IdClienteReferenciaPersonal;
	}

	public void setResaltarFK_IdClienteReferenciaPersonal(Border borderResaltar) {
		this.resaltarFK_IdClienteReferenciaPersonal= borderResaltar;
	}

	public void setResaltarFK_IdClienteReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteReferenciaPersonal= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaReferenciaPersonal=null;

	public Border getResaltarFK_IdEmpresaReferenciaPersonal() {
		return this.resaltarFK_IdEmpresaReferenciaPersonal;
	}

	public void setResaltarFK_IdEmpresaReferenciaPersonal(Border borderResaltar) {
		this.resaltarFK_IdEmpresaReferenciaPersonal= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaReferenciaPersonal= borderResaltar;
	}

	public Border resaltarFK_IdPaisReferenciaPersonal=null;

	public Border getResaltarFK_IdPaisReferenciaPersonal() {
		return this.resaltarFK_IdPaisReferenciaPersonal;
	}

	public void setResaltarFK_IdPaisReferenciaPersonal(Border borderResaltar) {
		this.resaltarFK_IdPaisReferenciaPersonal= borderResaltar;
	}

	public void setResaltarFK_IdPaisReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisReferenciaPersonal= borderResaltar;
	}

	public Border resaltarFK_IdTipoReferenciaPersonalReferenciaPersonal=null;

	public Border getResaltarFK_IdTipoReferenciaPersonalReferenciaPersonal() {
		return this.resaltarFK_IdTipoReferenciaPersonalReferenciaPersonal;
	}

	public void setResaltarFK_IdTipoReferenciaPersonalReferenciaPersonal(Border borderResaltar) {
		this.resaltarFK_IdTipoReferenciaPersonalReferenciaPersonal= borderResaltar;
	}

	public void setResaltarFK_IdTipoReferenciaPersonalReferenciaPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaPersonalBeanSwingJInternalFrame referenciapersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoReferenciaPersonalReferenciaPersonal= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}