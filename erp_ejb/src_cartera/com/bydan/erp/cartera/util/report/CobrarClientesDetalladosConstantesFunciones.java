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
package com.bydan.erp.cartera.util.report;

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


import com.bydan.erp.cartera.util.report.CobrarClientesDetalladosConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarClientesDetalladosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarClientesDetalladosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



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
final public class CobrarClientesDetalladosConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="CobrarClientesDetallados";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarClientesDetallados"+CobrarClientesDetalladosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarClientesDetalladosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarClientesDetalladosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarClientesDetalladosConstantesFunciones.SCHEMA+"_"+CobrarClientesDetalladosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarClientesDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarClientesDetalladosConstantesFunciones.SCHEMA+"_"+CobrarClientesDetalladosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarClientesDetalladosConstantesFunciones.SCHEMA+"_"+CobrarClientesDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarClientesDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarClientesDetalladosConstantesFunciones.SCHEMA+"_"+CobrarClientesDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarClientesDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarClientesDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarClientesDetalladosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarClientesDetalladosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarClientesDetalladosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarClientesDetalladosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Clientes Detalladoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrar Clientes Detallados";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Clientes Detallados";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarClientesDetallados";
	public static final String OBJECTNAME="cobrarclientesdetallados";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_clientes_detallados";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrarclientesdetallados from "+CobrarClientesDetalladosConstantesFunciones.SPERSISTENCENAME+" cobrarclientesdetallados";
	public static String QUERYSELECTNATIVE="select "+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".id,"+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".version_row,"+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".id_empresa,"+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".nombre_ciudad,"+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".nombre_zona,"+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".nombre_grupo_cliente,"+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".nombre_titulo_cliente,"+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".codigo,"+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".nombre,"+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".apellido,"+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".ruc,"+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".nombre_contacto_cliente,"+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".direccion_direccion,"+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".e_mail_e_mail,"+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME+".telefono_telefono from "+CobrarClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarClientesDetalladosConstantesFunciones.TABLENAME;//+" as "+CobrarClientesDetalladosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRECIUDAD= "nombre_ciudad";
    public static final String NOMBREZONA= "nombre_zona";
    public static final String NOMBREGRUPOCLIENTE= "nombre_grupo_cliente";
    public static final String NOMBRETITULOCLIENTE= "nombre_titulo_cliente";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String APELLIDO= "apellido";
    public static final String RUC= "ruc";
    public static final String NOMBRECONTACTOCLIENTE= "nombre_contacto_cliente";
    public static final String DIRECCIONDIRECCION= "direccion_direccion";
    public static final String EMAILEMAIL= "e_mail_e_mail";
    public static final String TELEFONOTELEFONO= "telefono_telefono";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRECIUDAD= "Nombre Ciudad";
		public static final String LABEL_NOMBRECIUDAD_LOWER= "Nombre Ciudad";
    	public static final String LABEL_NOMBREZONA= "Nombre Zona";
		public static final String LABEL_NOMBREZONA_LOWER= "Nombre Zona";
    	public static final String LABEL_NOMBREGRUPOCLIENTE= "Nombre Grupo Cliente";
		public static final String LABEL_NOMBREGRUPOCLIENTE_LOWER= "Nombre Grupo Cliente";
    	public static final String LABEL_NOMBRETITULOCLIENTE= "Nombre Titulo Cliente";
		public static final String LABEL_NOMBRETITULOCLIENTE_LOWER= "Nombre Titulo Cliente";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_APELLIDO= "Apello";
		public static final String LABEL_APELLIDO_LOWER= "Apellido";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_NOMBRECONTACTOCLIENTE= "Nombre Contacto Cliente";
		public static final String LABEL_NOMBRECONTACTOCLIENTE_LOWER= "Nombre Contacto Cliente";
    	public static final String LABEL_DIRECCIONDIRECCION= "Direccion Direccion";
		public static final String LABEL_DIRECCIONDIRECCION_LOWER= "Direccion Direccion";
    	public static final String LABEL_EMAILEMAIL= "E Mail E Mail";
		public static final String LABEL_EMAILEMAIL_LOWER= "E Mail E Mail";
    	public static final String LABEL_TELEFONOTELEFONO= "Telefono Telefono";
		public static final String LABEL_TELEFONOTELEFONO_LOWER= "Telefono Telefono";
	
		
		
		
	public static final String SREGEXNOMBRE_CIUDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CIUDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_ZONA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ZONA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_GRUPO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GRUPO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TITULO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TITULO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CONTACTO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CONTACTO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION_DIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_DIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXE_MAIL_E_MAIL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXE_MAIL_E_MAIL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO_TELEFONO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONO_TELEFONO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCobrarClientesDetalladosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarClientesDetalladosConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarClientesDetalladosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRECIUDAD)) {sLabelColumna=CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRECIUDAD;}
		if(sNombreColumna.equals(CobrarClientesDetalladosConstantesFunciones.NOMBREZONA)) {sLabelColumna=CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBREZONA;}
		if(sNombreColumna.equals(CobrarClientesDetalladosConstantesFunciones.NOMBREGRUPOCLIENTE)) {sLabelColumna=CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE;}
		if(sNombreColumna.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRETITULOCLIENTE)) {sLabelColumna=CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRETITULOCLIENTE;}
		if(sNombreColumna.equals(CobrarClientesDetalladosConstantesFunciones.CODIGO)) {sLabelColumna=CobrarClientesDetalladosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRE)) {sLabelColumna=CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CobrarClientesDetalladosConstantesFunciones.APELLIDO)) {sLabelColumna=CobrarClientesDetalladosConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(CobrarClientesDetalladosConstantesFunciones.RUC)) {sLabelColumna=CobrarClientesDetalladosConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRECONTACTOCLIENTE)) {sLabelColumna=CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRECONTACTOCLIENTE;}
		if(sNombreColumna.equals(CobrarClientesDetalladosConstantesFunciones.DIRECCIONDIRECCION)) {sLabelColumna=CobrarClientesDetalladosConstantesFunciones.LABEL_DIRECCIONDIRECCION;}
		if(sNombreColumna.equals(CobrarClientesDetalladosConstantesFunciones.EMAILEMAIL)) {sLabelColumna=CobrarClientesDetalladosConstantesFunciones.LABEL_EMAILEMAIL;}
		if(sNombreColumna.equals(CobrarClientesDetalladosConstantesFunciones.TELEFONOTELEFONO)) {sLabelColumna=CobrarClientesDetalladosConstantesFunciones.LABEL_TELEFONOTELEFONO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCobrarClientesDetalladosDescripcion(CobrarClientesDetallados cobrarclientesdetallados) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrarclientesdetallados !=null/* && cobrarclientesdetallados.getId()!=0*/) {
			sDescripcion=cobrarclientesdetallados.getcodigo();//cobrarclientesdetalladoscobrarclientesdetallados.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarClientesDetalladosDescripcionDetallado(CobrarClientesDetallados cobrarclientesdetallados) {
		String sDescripcion="";
			
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.ID+"=";
		sDescripcion+=cobrarclientesdetallados.getId().toString()+",";
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrarclientesdetallados.getVersionRow().toString()+",";
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobrarclientesdetallados.getid_empresa().toString()+",";
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.NOMBRECIUDAD+"=";
		sDescripcion+=cobrarclientesdetallados.getnombre_ciudad()+",";
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.NOMBREZONA+"=";
		sDescripcion+=cobrarclientesdetallados.getnombre_zona()+",";
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.NOMBREGRUPOCLIENTE+"=";
		sDescripcion+=cobrarclientesdetallados.getnombre_grupo_cliente()+",";
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.NOMBRETITULOCLIENTE+"=";
		sDescripcion+=cobrarclientesdetallados.getnombre_titulo_cliente()+",";
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.CODIGO+"=";
		sDescripcion+=cobrarclientesdetallados.getcodigo()+",";
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cobrarclientesdetallados.getnombre()+",";
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.APELLIDO+"=";
		sDescripcion+=cobrarclientesdetallados.getapellido()+",";
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.RUC+"=";
		sDescripcion+=cobrarclientesdetallados.getruc()+",";
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.NOMBRECONTACTOCLIENTE+"=";
		sDescripcion+=cobrarclientesdetallados.getnombre_contacto_cliente()+",";
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.DIRECCIONDIRECCION+"=";
		sDescripcion+=cobrarclientesdetallados.getdireccion_direccion()+",";
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.EMAILEMAIL+"=";
		sDescripcion+=cobrarclientesdetallados.gete_mail_e_mail()+",";
		sDescripcion+=CobrarClientesDetalladosConstantesFunciones.TELEFONOTELEFONO+"=";
		sDescripcion+=cobrarclientesdetallados.gettelefono_telefono()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarClientesDetalladosDescripcion(CobrarClientesDetallados cobrarclientesdetallados,String sValor) throws Exception {			
		if(cobrarclientesdetallados !=null) {
			cobrarclientesdetallados.setcodigo(sValor);;//cobrarclientesdetalladoscobrarclientesdetallados.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCobrarClientesDetallados")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCobrarClientesDetallados(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" ="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCobrarClientesDetallados(CobrarClientesDetallados cobrarclientesdetallados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarclientesdetallados.setnombre_ciudad(cobrarclientesdetallados.getnombre_ciudad().trim());
		cobrarclientesdetallados.setnombre_zona(cobrarclientesdetallados.getnombre_zona().trim());
		cobrarclientesdetallados.setnombre_grupo_cliente(cobrarclientesdetallados.getnombre_grupo_cliente().trim());
		cobrarclientesdetallados.setnombre_titulo_cliente(cobrarclientesdetallados.getnombre_titulo_cliente().trim());
		cobrarclientesdetallados.setcodigo(cobrarclientesdetallados.getcodigo().trim());
		cobrarclientesdetallados.setnombre(cobrarclientesdetallados.getnombre().trim());
		cobrarclientesdetallados.setapellido(cobrarclientesdetallados.getapellido().trim());
		cobrarclientesdetallados.setruc(cobrarclientesdetallados.getruc().trim());
		cobrarclientesdetallados.setnombre_contacto_cliente(cobrarclientesdetallados.getnombre_contacto_cliente().trim());
		cobrarclientesdetallados.setdireccion_direccion(cobrarclientesdetallados.getdireccion_direccion().trim());
		cobrarclientesdetallados.sete_mail_e_mail(cobrarclientesdetallados.gete_mail_e_mail().trim());
		cobrarclientesdetallados.settelefono_telefono(cobrarclientesdetallados.gettelefono_telefono().trim());
	}
	
	public static void quitarEspaciosCobrarClientesDetalladoss(List<CobrarClientesDetallados> cobrarclientesdetalladoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarClientesDetallados cobrarclientesdetallados: cobrarclientesdetalladoss) {
			cobrarclientesdetallados.setnombre_ciudad(cobrarclientesdetallados.getnombre_ciudad().trim());
			cobrarclientesdetallados.setnombre_zona(cobrarclientesdetallados.getnombre_zona().trim());
			cobrarclientesdetallados.setnombre_grupo_cliente(cobrarclientesdetallados.getnombre_grupo_cliente().trim());
			cobrarclientesdetallados.setnombre_titulo_cliente(cobrarclientesdetallados.getnombre_titulo_cliente().trim());
			cobrarclientesdetallados.setcodigo(cobrarclientesdetallados.getcodigo().trim());
			cobrarclientesdetallados.setnombre(cobrarclientesdetallados.getnombre().trim());
			cobrarclientesdetallados.setapellido(cobrarclientesdetallados.getapellido().trim());
			cobrarclientesdetallados.setruc(cobrarclientesdetallados.getruc().trim());
			cobrarclientesdetallados.setnombre_contacto_cliente(cobrarclientesdetallados.getnombre_contacto_cliente().trim());
			cobrarclientesdetallados.setdireccion_direccion(cobrarclientesdetallados.getdireccion_direccion().trim());
			cobrarclientesdetallados.sete_mail_e_mail(cobrarclientesdetallados.gete_mail_e_mail().trim());
			cobrarclientesdetallados.settelefono_telefono(cobrarclientesdetallados.gettelefono_telefono().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarClientesDetallados(CobrarClientesDetallados cobrarclientesdetallados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrarclientesdetallados.getConCambioAuxiliar()) {
			cobrarclientesdetallados.setIsDeleted(cobrarclientesdetallados.getIsDeletedAuxiliar());	
			cobrarclientesdetallados.setIsNew(cobrarclientesdetallados.getIsNewAuxiliar());	
			cobrarclientesdetallados.setIsChanged(cobrarclientesdetallados.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrarclientesdetallados.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrarclientesdetallados.setIsDeletedAuxiliar(false);	
			cobrarclientesdetallados.setIsNewAuxiliar(false);	
			cobrarclientesdetallados.setIsChangedAuxiliar(false);
			
			cobrarclientesdetallados.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarClientesDetalladoss(List<CobrarClientesDetallados> cobrarclientesdetalladoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarClientesDetallados cobrarclientesdetallados : cobrarclientesdetalladoss) {
			if(conAsignarBase && cobrarclientesdetallados.getConCambioAuxiliar()) {
				cobrarclientesdetallados.setIsDeleted(cobrarclientesdetallados.getIsDeletedAuxiliar());	
				cobrarclientesdetallados.setIsNew(cobrarclientesdetallados.getIsNewAuxiliar());	
				cobrarclientesdetallados.setIsChanged(cobrarclientesdetallados.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrarclientesdetallados.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrarclientesdetallados.setIsDeletedAuxiliar(false);	
				cobrarclientesdetallados.setIsNewAuxiliar(false);	
				cobrarclientesdetallados.setIsChangedAuxiliar(false);
				
				cobrarclientesdetallados.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarClientesDetallados(CobrarClientesDetallados cobrarclientesdetallados,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCobrarClientesDetalladoss(List<CobrarClientesDetallados> cobrarclientesdetalladoss,Boolean conEnteros) throws Exception  {
		
		for(CobrarClientesDetallados cobrarclientesdetallados: cobrarclientesdetalladoss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarClientesDetallados(List<CobrarClientesDetallados> cobrarclientesdetalladoss,CobrarClientesDetallados cobrarclientesdetalladosAux) throws Exception  {
		CobrarClientesDetalladosConstantesFunciones.InicializarValoresCobrarClientesDetallados(cobrarclientesdetalladosAux,true);
		
		for(CobrarClientesDetallados cobrarclientesdetallados: cobrarclientesdetalladoss) {
			if(cobrarclientesdetallados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesDetallados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarClientesDetalladosConstantesFunciones.getArrayColumnasGlobalesCobrarClientesDetallados(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesDetallados(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarClientesDetalladosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarClientesDetalladosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarClientesDetallados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarClientesDetallados> cobrarclientesdetalladoss,CobrarClientesDetallados cobrarclientesdetallados,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarClientesDetallados cobrarclientesdetalladosAux: cobrarclientesdetalladoss) {
			if(cobrarclientesdetalladosAux!=null && cobrarclientesdetallados!=null) {
				if((cobrarclientesdetalladosAux.getId()==null && cobrarclientesdetallados.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobrarclientesdetalladosAux.getId()!=null && cobrarclientesdetallados.getId()!=null){
					if(cobrarclientesdetalladosAux.getId().equals(cobrarclientesdetallados.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarClientesDetallados(List<CobrarClientesDetallados> cobrarclientesdetalladoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CobrarClientesDetallados cobrarclientesdetallados: cobrarclientesdetalladoss) {			
			if(cobrarclientesdetallados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarClientesDetallados() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarClientesDetalladosConstantesFunciones.LABEL_VERSIONROW, CobrarClientesDetalladosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRECIUDAD, CobrarClientesDetalladosConstantesFunciones.NOMBRECIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBREZONA, CobrarClientesDetalladosConstantesFunciones.NOMBREZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE, CobrarClientesDetalladosConstantesFunciones.NOMBREGRUPOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRETITULOCLIENTE, CobrarClientesDetalladosConstantesFunciones.NOMBRETITULOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesDetalladosConstantesFunciones.LABEL_CODIGO, CobrarClientesDetalladosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRE, CobrarClientesDetalladosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesDetalladosConstantesFunciones.LABEL_APELLIDO, CobrarClientesDetalladosConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesDetalladosConstantesFunciones.LABEL_RUC, CobrarClientesDetalladosConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRECONTACTOCLIENTE, CobrarClientesDetalladosConstantesFunciones.NOMBRECONTACTOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesDetalladosConstantesFunciones.LABEL_DIRECCIONDIRECCION, CobrarClientesDetalladosConstantesFunciones.DIRECCIONDIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesDetalladosConstantesFunciones.LABEL_EMAILEMAIL, CobrarClientesDetalladosConstantesFunciones.EMAILEMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesDetalladosConstantesFunciones.LABEL_TELEFONOTELEFONO, CobrarClientesDetalladosConstantesFunciones.TELEFONOTELEFONO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarClientesDetallados() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesDetalladosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesDetalladosConstantesFunciones.NOMBRECIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesDetalladosConstantesFunciones.NOMBREZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesDetalladosConstantesFunciones.NOMBREGRUPOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesDetalladosConstantesFunciones.NOMBRETITULOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesDetalladosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesDetalladosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesDetalladosConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesDetalladosConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesDetalladosConstantesFunciones.NOMBRECONTACTOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesDetalladosConstantesFunciones.DIRECCIONDIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesDetalladosConstantesFunciones.EMAILEMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesDetalladosConstantesFunciones.TELEFONOTELEFONO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesDetallados() throws Exception  {
		return CobrarClientesDetalladosConstantesFunciones.getTiposSeleccionarCobrarClientesDetallados(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesDetallados(Boolean conFk) throws Exception  {
		return CobrarClientesDetalladosConstantesFunciones.getTiposSeleccionarCobrarClientesDetallados(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesDetallados(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesDetalladosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarClientesDetalladosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRECIUDAD);
			reporte.setsDescripcion(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRECIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBREZONA);
			reporte.setsDescripcion(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBREZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
			reporte.setsDescripcion(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRETITULOCLIENTE);
			reporte.setsDescripcion(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRETITULOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesDetalladosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CobrarClientesDetalladosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesDetalladosConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(CobrarClientesDetalladosConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesDetalladosConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(CobrarClientesDetalladosConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRECONTACTOCLIENTE);
			reporte.setsDescripcion(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRECONTACTOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesDetalladosConstantesFunciones.LABEL_DIRECCIONDIRECCION);
			reporte.setsDescripcion(CobrarClientesDetalladosConstantesFunciones.LABEL_DIRECCIONDIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesDetalladosConstantesFunciones.LABEL_EMAILEMAIL);
			reporte.setsDescripcion(CobrarClientesDetalladosConstantesFunciones.LABEL_EMAILEMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesDetalladosConstantesFunciones.LABEL_TELEFONOTELEFONO);
			reporte.setsDescripcion(CobrarClientesDetalladosConstantesFunciones.LABEL_TELEFONOTELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarClientesDetallados(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarClientesDetallados(CobrarClientesDetallados cobrarclientesdetalladosAux) throws Exception {
		
			cobrarclientesdetalladosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarclientesdetalladosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarClientesDetallados(List<CobrarClientesDetallados> cobrarclientesdetalladossTemp) throws Exception {
		for(CobrarClientesDetallados cobrarclientesdetalladosAux:cobrarclientesdetalladossTemp) {
			
			cobrarclientesdetalladosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarclientesdetalladosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarClientesDetallados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarClientesDetallados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarClientesDetallados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarClientesDetalladosConstantesFunciones.getClassesRelationshipsOfCobrarClientesDetallados(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarClientesDetallados(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarClientesDetallados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarClientesDetalladosConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarClientesDetallados(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarClientesDetallados(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CobrarClientesDetallados cobrarclientesdetallados,List<CobrarClientesDetallados> cobrarclientesdetalladoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarClientesDetallados cobrarclientesdetallados,List<CobrarClientesDetallados> cobrarclientesdetalladoss) throws Exception {
		try	{			
			for(CobrarClientesDetallados cobrarclientesdetalladosLocal:cobrarclientesdetalladoss) {
				if(cobrarclientesdetalladosLocal.getId().equals(cobrarclientesdetallados.getId())) {
					cobrarclientesdetalladosLocal.setIsSelected(cobrarclientesdetallados.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarClientesDetallados(List<CobrarClientesDetallados> cobrarclientesdetalladossAux) throws Exception {
		//this.cobrarclientesdetalladossAux=cobrarclientesdetalladossAux;
		
		for(CobrarClientesDetallados cobrarclientesdetalladosAux:cobrarclientesdetalladossAux) {
			if(cobrarclientesdetalladosAux.getIsChanged()) {
				cobrarclientesdetalladosAux.setIsChanged(false);
			}		
			
			if(cobrarclientesdetalladosAux.getIsNew()) {
				cobrarclientesdetalladosAux.setIsNew(false);
			}	
			
			if(cobrarclientesdetalladosAux.getIsDeleted()) {
				cobrarclientesdetalladosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarClientesDetallados(CobrarClientesDetallados cobrarclientesdetalladosAux) throws Exception {
		//this.cobrarclientesdetalladosAux=cobrarclientesdetalladosAux;
		
			if(cobrarclientesdetalladosAux.getIsChanged()) {
				cobrarclientesdetalladosAux.setIsChanged(false);
			}		
			
			if(cobrarclientesdetalladosAux.getIsNew()) {
				cobrarclientesdetalladosAux.setIsNew(false);
			}	
			
			if(cobrarclientesdetalladosAux.getIsDeleted()) {
				cobrarclientesdetalladosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarClientesDetallados cobrarclientesdetalladosAsignar,CobrarClientesDetallados cobrarclientesdetallados) throws Exception {
		cobrarclientesdetalladosAsignar.setVersionRow(cobrarclientesdetallados.getVersionRow());	
		cobrarclientesdetalladosAsignar.setnombre_ciudad(cobrarclientesdetallados.getnombre_ciudad());	
		cobrarclientesdetalladosAsignar.setnombre_zona(cobrarclientesdetallados.getnombre_zona());	
		cobrarclientesdetalladosAsignar.setnombre_grupo_cliente(cobrarclientesdetallados.getnombre_grupo_cliente());	
		cobrarclientesdetalladosAsignar.setnombre_titulo_cliente(cobrarclientesdetallados.getnombre_titulo_cliente());	
		cobrarclientesdetalladosAsignar.setcodigo(cobrarclientesdetallados.getcodigo());	
		cobrarclientesdetalladosAsignar.setnombre(cobrarclientesdetallados.getnombre());	
		cobrarclientesdetalladosAsignar.setapellido(cobrarclientesdetallados.getapellido());	
		cobrarclientesdetalladosAsignar.setruc(cobrarclientesdetallados.getruc());	
		cobrarclientesdetalladosAsignar.setnombre_contacto_cliente(cobrarclientesdetallados.getnombre_contacto_cliente());	
		cobrarclientesdetalladosAsignar.setdireccion_direccion(cobrarclientesdetallados.getdireccion_direccion());	
		cobrarclientesdetalladosAsignar.sete_mail_e_mail(cobrarclientesdetallados.gete_mail_e_mail());	
		cobrarclientesdetalladosAsignar.settelefono_telefono(cobrarclientesdetallados.gettelefono_telefono());	
	}
	
	public static void inicializarCobrarClientesDetallados(CobrarClientesDetallados cobrarclientesdetallados) throws Exception {
		try {
					
				cobrarclientesdetallados.setnombre_ciudad("");	
				cobrarclientesdetallados.setnombre_zona("");	
				cobrarclientesdetallados.setnombre_grupo_cliente("");	
				cobrarclientesdetallados.setnombre_titulo_cliente("");	
				cobrarclientesdetallados.setcodigo("");	
				cobrarclientesdetallados.setnombre("");	
				cobrarclientesdetallados.setapellido("");	
				cobrarclientesdetallados.setruc("");	
				cobrarclientesdetallados.setnombre_contacto_cliente("");	
				cobrarclientesdetallados.setdireccion_direccion("");	
				cobrarclientesdetallados.sete_mail_e_mail("");	
				cobrarclientesdetallados.settelefono_telefono("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarClientesDetallados(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesDetalladosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRECIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBREZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRETITULOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesDetalladosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesDetalladosConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesDetalladosConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesDetalladosConstantesFunciones.LABEL_NOMBRECONTACTOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesDetalladosConstantesFunciones.LABEL_DIRECCIONDIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesDetalladosConstantesFunciones.LABEL_EMAILEMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesDetalladosConstantesFunciones.LABEL_TELEFONOTELEFONO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarClientesDetallados(String sTipo,Row row,Workbook workbook,CobrarClientesDetallados cobrarclientesdetallados,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesdetallados.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesdetallados.getnombre_ciudad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesdetallados.getnombre_zona());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesdetallados.getnombre_grupo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesdetallados.getnombre_titulo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesdetallados.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesdetallados.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesdetallados.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesdetallados.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesdetallados.getnombre_contacto_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesdetallados.getdireccion_direccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesdetallados.gete_mail_e_mail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesdetallados.gettelefono_telefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarClientesDetallados="";
	
	public String getsFinalQueryCobrarClientesDetallados() {
		return this.sFinalQueryCobrarClientesDetallados;
	}
	
	public void setsFinalQueryCobrarClientesDetallados(String sFinalQueryCobrarClientesDetallados) {
		this.sFinalQueryCobrarClientesDetallados= sFinalQueryCobrarClientesDetallados;
	}
	
	public Border resaltarSeleccionarCobrarClientesDetallados=null;
	
	public Border setResaltarSeleccionarCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarClientesDetallados= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarClientesDetallados() {
		return this.resaltarSeleccionarCobrarClientesDetallados;
	}
	
	public void setResaltarSeleccionarCobrarClientesDetallados(Border borderResaltarSeleccionarCobrarClientesDetallados) {
		this.resaltarSeleccionarCobrarClientesDetallados= borderResaltarSeleccionarCobrarClientesDetallados;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarClientesDetallados=null;
	public Boolean mostraridCobrarClientesDetallados=true;
	public Boolean activaridCobrarClientesDetallados=true;

	public Border resaltarid_empresaCobrarClientesDetallados=null;
	public Boolean mostrarid_empresaCobrarClientesDetallados=true;
	public Boolean activarid_empresaCobrarClientesDetallados=true;
	public Boolean cargarid_empresaCobrarClientesDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCobrarClientesDetallados=false;//ConEventDepend=true

	public Border resaltarnombre_ciudadCobrarClientesDetallados=null;
	public Boolean mostrarnombre_ciudadCobrarClientesDetallados=true;
	public Boolean activarnombre_ciudadCobrarClientesDetallados=true;

	public Border resaltarnombre_zonaCobrarClientesDetallados=null;
	public Boolean mostrarnombre_zonaCobrarClientesDetallados=true;
	public Boolean activarnombre_zonaCobrarClientesDetallados=true;

	public Border resaltarnombre_grupo_clienteCobrarClientesDetallados=null;
	public Boolean mostrarnombre_grupo_clienteCobrarClientesDetallados=true;
	public Boolean activarnombre_grupo_clienteCobrarClientesDetallados=true;

	public Border resaltarnombre_titulo_clienteCobrarClientesDetallados=null;
	public Boolean mostrarnombre_titulo_clienteCobrarClientesDetallados=true;
	public Boolean activarnombre_titulo_clienteCobrarClientesDetallados=true;

	public Border resaltarcodigoCobrarClientesDetallados=null;
	public Boolean mostrarcodigoCobrarClientesDetallados=true;
	public Boolean activarcodigoCobrarClientesDetallados=true;

	public Border resaltarnombreCobrarClientesDetallados=null;
	public Boolean mostrarnombreCobrarClientesDetallados=true;
	public Boolean activarnombreCobrarClientesDetallados=true;

	public Border resaltarapellidoCobrarClientesDetallados=null;
	public Boolean mostrarapellidoCobrarClientesDetallados=true;
	public Boolean activarapellidoCobrarClientesDetallados=true;

	public Border resaltarrucCobrarClientesDetallados=null;
	public Boolean mostrarrucCobrarClientesDetallados=true;
	public Boolean activarrucCobrarClientesDetallados=true;

	public Border resaltarnombre_contacto_clienteCobrarClientesDetallados=null;
	public Boolean mostrarnombre_contacto_clienteCobrarClientesDetallados=true;
	public Boolean activarnombre_contacto_clienteCobrarClientesDetallados=true;

	public Border resaltardireccion_direccionCobrarClientesDetallados=null;
	public Boolean mostrardireccion_direccionCobrarClientesDetallados=true;
	public Boolean activardireccion_direccionCobrarClientesDetallados=true;

	public Border resaltare_mail_e_mailCobrarClientesDetallados=null;
	public Boolean mostrare_mail_e_mailCobrarClientesDetallados=true;
	public Boolean activare_mail_e_mailCobrarClientesDetallados=true;

	public Border resaltartelefono_telefonoCobrarClientesDetallados=null;
	public Boolean mostrartelefono_telefonoCobrarClientesDetallados=true;
	public Boolean activartelefono_telefonoCobrarClientesDetallados=true;

	
	

	public Border setResaltaridCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltaridCobrarClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarClientesDetallados() {
		return this.resaltaridCobrarClientesDetallados;
	}

	public void setResaltaridCobrarClientesDetallados(Border borderResaltar) {
		this.resaltaridCobrarClientesDetallados= borderResaltar;
	}

	public Boolean getMostraridCobrarClientesDetallados() {
		return this.mostraridCobrarClientesDetallados;
	}

	public void setMostraridCobrarClientesDetallados(Boolean mostraridCobrarClientesDetallados) {
		this.mostraridCobrarClientesDetallados= mostraridCobrarClientesDetallados;
	}

	public Boolean getActivaridCobrarClientesDetallados() {
		return this.activaridCobrarClientesDetallados;
	}

	public void setActivaridCobrarClientesDetallados(Boolean activaridCobrarClientesDetallados) {
		this.activaridCobrarClientesDetallados= activaridCobrarClientesDetallados;
	}

	public Border setResaltarid_empresaCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarClientesDetallados() {
		return this.resaltarid_empresaCobrarClientesDetallados;
	}

	public void setResaltarid_empresaCobrarClientesDetallados(Border borderResaltar) {
		this.resaltarid_empresaCobrarClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarClientesDetallados() {
		return this.mostrarid_empresaCobrarClientesDetallados;
	}

	public void setMostrarid_empresaCobrarClientesDetallados(Boolean mostrarid_empresaCobrarClientesDetallados) {
		this.mostrarid_empresaCobrarClientesDetallados= mostrarid_empresaCobrarClientesDetallados;
	}

	public Boolean getActivarid_empresaCobrarClientesDetallados() {
		return this.activarid_empresaCobrarClientesDetallados;
	}

	public void setActivarid_empresaCobrarClientesDetallados(Boolean activarid_empresaCobrarClientesDetallados) {
		this.activarid_empresaCobrarClientesDetallados= activarid_empresaCobrarClientesDetallados;
	}

	public Boolean getCargarid_empresaCobrarClientesDetallados() {
		return this.cargarid_empresaCobrarClientesDetallados;
	}

	public void setCargarid_empresaCobrarClientesDetallados(Boolean cargarid_empresaCobrarClientesDetallados) {
		this.cargarid_empresaCobrarClientesDetallados= cargarid_empresaCobrarClientesDetallados;
	}

	public Border setResaltarnombre_ciudadCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarnombre_ciudadCobrarClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_ciudadCobrarClientesDetallados() {
		return this.resaltarnombre_ciudadCobrarClientesDetallados;
	}

	public void setResaltarnombre_ciudadCobrarClientesDetallados(Border borderResaltar) {
		this.resaltarnombre_ciudadCobrarClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarnombre_ciudadCobrarClientesDetallados() {
		return this.mostrarnombre_ciudadCobrarClientesDetallados;
	}

	public void setMostrarnombre_ciudadCobrarClientesDetallados(Boolean mostrarnombre_ciudadCobrarClientesDetallados) {
		this.mostrarnombre_ciudadCobrarClientesDetallados= mostrarnombre_ciudadCobrarClientesDetallados;
	}

	public Boolean getActivarnombre_ciudadCobrarClientesDetallados() {
		return this.activarnombre_ciudadCobrarClientesDetallados;
	}

	public void setActivarnombre_ciudadCobrarClientesDetallados(Boolean activarnombre_ciudadCobrarClientesDetallados) {
		this.activarnombre_ciudadCobrarClientesDetallados= activarnombre_ciudadCobrarClientesDetallados;
	}

	public Border setResaltarnombre_zonaCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarnombre_zonaCobrarClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_zonaCobrarClientesDetallados() {
		return this.resaltarnombre_zonaCobrarClientesDetallados;
	}

	public void setResaltarnombre_zonaCobrarClientesDetallados(Border borderResaltar) {
		this.resaltarnombre_zonaCobrarClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarnombre_zonaCobrarClientesDetallados() {
		return this.mostrarnombre_zonaCobrarClientesDetallados;
	}

	public void setMostrarnombre_zonaCobrarClientesDetallados(Boolean mostrarnombre_zonaCobrarClientesDetallados) {
		this.mostrarnombre_zonaCobrarClientesDetallados= mostrarnombre_zonaCobrarClientesDetallados;
	}

	public Boolean getActivarnombre_zonaCobrarClientesDetallados() {
		return this.activarnombre_zonaCobrarClientesDetallados;
	}

	public void setActivarnombre_zonaCobrarClientesDetallados(Boolean activarnombre_zonaCobrarClientesDetallados) {
		this.activarnombre_zonaCobrarClientesDetallados= activarnombre_zonaCobrarClientesDetallados;
	}

	public Border setResaltarnombre_grupo_clienteCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarnombre_grupo_clienteCobrarClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_grupo_clienteCobrarClientesDetallados() {
		return this.resaltarnombre_grupo_clienteCobrarClientesDetallados;
	}

	public void setResaltarnombre_grupo_clienteCobrarClientesDetallados(Border borderResaltar) {
		this.resaltarnombre_grupo_clienteCobrarClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarnombre_grupo_clienteCobrarClientesDetallados() {
		return this.mostrarnombre_grupo_clienteCobrarClientesDetallados;
	}

	public void setMostrarnombre_grupo_clienteCobrarClientesDetallados(Boolean mostrarnombre_grupo_clienteCobrarClientesDetallados) {
		this.mostrarnombre_grupo_clienteCobrarClientesDetallados= mostrarnombre_grupo_clienteCobrarClientesDetallados;
	}

	public Boolean getActivarnombre_grupo_clienteCobrarClientesDetallados() {
		return this.activarnombre_grupo_clienteCobrarClientesDetallados;
	}

	public void setActivarnombre_grupo_clienteCobrarClientesDetallados(Boolean activarnombre_grupo_clienteCobrarClientesDetallados) {
		this.activarnombre_grupo_clienteCobrarClientesDetallados= activarnombre_grupo_clienteCobrarClientesDetallados;
	}

	public Border setResaltarnombre_titulo_clienteCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarnombre_titulo_clienteCobrarClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_titulo_clienteCobrarClientesDetallados() {
		return this.resaltarnombre_titulo_clienteCobrarClientesDetallados;
	}

	public void setResaltarnombre_titulo_clienteCobrarClientesDetallados(Border borderResaltar) {
		this.resaltarnombre_titulo_clienteCobrarClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarnombre_titulo_clienteCobrarClientesDetallados() {
		return this.mostrarnombre_titulo_clienteCobrarClientesDetallados;
	}

	public void setMostrarnombre_titulo_clienteCobrarClientesDetallados(Boolean mostrarnombre_titulo_clienteCobrarClientesDetallados) {
		this.mostrarnombre_titulo_clienteCobrarClientesDetallados= mostrarnombre_titulo_clienteCobrarClientesDetallados;
	}

	public Boolean getActivarnombre_titulo_clienteCobrarClientesDetallados() {
		return this.activarnombre_titulo_clienteCobrarClientesDetallados;
	}

	public void setActivarnombre_titulo_clienteCobrarClientesDetallados(Boolean activarnombre_titulo_clienteCobrarClientesDetallados) {
		this.activarnombre_titulo_clienteCobrarClientesDetallados= activarnombre_titulo_clienteCobrarClientesDetallados;
	}

	public Border setResaltarcodigoCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarcodigoCobrarClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCobrarClientesDetallados() {
		return this.resaltarcodigoCobrarClientesDetallados;
	}

	public void setResaltarcodigoCobrarClientesDetallados(Border borderResaltar) {
		this.resaltarcodigoCobrarClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarcodigoCobrarClientesDetallados() {
		return this.mostrarcodigoCobrarClientesDetallados;
	}

	public void setMostrarcodigoCobrarClientesDetallados(Boolean mostrarcodigoCobrarClientesDetallados) {
		this.mostrarcodigoCobrarClientesDetallados= mostrarcodigoCobrarClientesDetallados;
	}

	public Boolean getActivarcodigoCobrarClientesDetallados() {
		return this.activarcodigoCobrarClientesDetallados;
	}

	public void setActivarcodigoCobrarClientesDetallados(Boolean activarcodigoCobrarClientesDetallados) {
		this.activarcodigoCobrarClientesDetallados= activarcodigoCobrarClientesDetallados;
	}

	public Border setResaltarnombreCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarnombreCobrarClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCobrarClientesDetallados() {
		return this.resaltarnombreCobrarClientesDetallados;
	}

	public void setResaltarnombreCobrarClientesDetallados(Border borderResaltar) {
		this.resaltarnombreCobrarClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarnombreCobrarClientesDetallados() {
		return this.mostrarnombreCobrarClientesDetallados;
	}

	public void setMostrarnombreCobrarClientesDetallados(Boolean mostrarnombreCobrarClientesDetallados) {
		this.mostrarnombreCobrarClientesDetallados= mostrarnombreCobrarClientesDetallados;
	}

	public Boolean getActivarnombreCobrarClientesDetallados() {
		return this.activarnombreCobrarClientesDetallados;
	}

	public void setActivarnombreCobrarClientesDetallados(Boolean activarnombreCobrarClientesDetallados) {
		this.activarnombreCobrarClientesDetallados= activarnombreCobrarClientesDetallados;
	}

	public Border setResaltarapellidoCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarapellidoCobrarClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoCobrarClientesDetallados() {
		return this.resaltarapellidoCobrarClientesDetallados;
	}

	public void setResaltarapellidoCobrarClientesDetallados(Border borderResaltar) {
		this.resaltarapellidoCobrarClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarapellidoCobrarClientesDetallados() {
		return this.mostrarapellidoCobrarClientesDetallados;
	}

	public void setMostrarapellidoCobrarClientesDetallados(Boolean mostrarapellidoCobrarClientesDetallados) {
		this.mostrarapellidoCobrarClientesDetallados= mostrarapellidoCobrarClientesDetallados;
	}

	public Boolean getActivarapellidoCobrarClientesDetallados() {
		return this.activarapellidoCobrarClientesDetallados;
	}

	public void setActivarapellidoCobrarClientesDetallados(Boolean activarapellidoCobrarClientesDetallados) {
		this.activarapellidoCobrarClientesDetallados= activarapellidoCobrarClientesDetallados;
	}

	public Border setResaltarrucCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarrucCobrarClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucCobrarClientesDetallados() {
		return this.resaltarrucCobrarClientesDetallados;
	}

	public void setResaltarrucCobrarClientesDetallados(Border borderResaltar) {
		this.resaltarrucCobrarClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarrucCobrarClientesDetallados() {
		return this.mostrarrucCobrarClientesDetallados;
	}

	public void setMostrarrucCobrarClientesDetallados(Boolean mostrarrucCobrarClientesDetallados) {
		this.mostrarrucCobrarClientesDetallados= mostrarrucCobrarClientesDetallados;
	}

	public Boolean getActivarrucCobrarClientesDetallados() {
		return this.activarrucCobrarClientesDetallados;
	}

	public void setActivarrucCobrarClientesDetallados(Boolean activarrucCobrarClientesDetallados) {
		this.activarrucCobrarClientesDetallados= activarrucCobrarClientesDetallados;
	}

	public Border setResaltarnombre_contacto_clienteCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarnombre_contacto_clienteCobrarClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_contacto_clienteCobrarClientesDetallados() {
		return this.resaltarnombre_contacto_clienteCobrarClientesDetallados;
	}

	public void setResaltarnombre_contacto_clienteCobrarClientesDetallados(Border borderResaltar) {
		this.resaltarnombre_contacto_clienteCobrarClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarnombre_contacto_clienteCobrarClientesDetallados() {
		return this.mostrarnombre_contacto_clienteCobrarClientesDetallados;
	}

	public void setMostrarnombre_contacto_clienteCobrarClientesDetallados(Boolean mostrarnombre_contacto_clienteCobrarClientesDetallados) {
		this.mostrarnombre_contacto_clienteCobrarClientesDetallados= mostrarnombre_contacto_clienteCobrarClientesDetallados;
	}

	public Boolean getActivarnombre_contacto_clienteCobrarClientesDetallados() {
		return this.activarnombre_contacto_clienteCobrarClientesDetallados;
	}

	public void setActivarnombre_contacto_clienteCobrarClientesDetallados(Boolean activarnombre_contacto_clienteCobrarClientesDetallados) {
		this.activarnombre_contacto_clienteCobrarClientesDetallados= activarnombre_contacto_clienteCobrarClientesDetallados;
	}

	public Border setResaltardireccion_direccionCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltardireccion_direccionCobrarClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_direccionCobrarClientesDetallados() {
		return this.resaltardireccion_direccionCobrarClientesDetallados;
	}

	public void setResaltardireccion_direccionCobrarClientesDetallados(Border borderResaltar) {
		this.resaltardireccion_direccionCobrarClientesDetallados= borderResaltar;
	}

	public Boolean getMostrardireccion_direccionCobrarClientesDetallados() {
		return this.mostrardireccion_direccionCobrarClientesDetallados;
	}

	public void setMostrardireccion_direccionCobrarClientesDetallados(Boolean mostrardireccion_direccionCobrarClientesDetallados) {
		this.mostrardireccion_direccionCobrarClientesDetallados= mostrardireccion_direccionCobrarClientesDetallados;
	}

	public Boolean getActivardireccion_direccionCobrarClientesDetallados() {
		return this.activardireccion_direccionCobrarClientesDetallados;
	}

	public void setActivardireccion_direccionCobrarClientesDetallados(Boolean activardireccion_direccionCobrarClientesDetallados) {
		this.activardireccion_direccionCobrarClientesDetallados= activardireccion_direccionCobrarClientesDetallados;
	}

	public Border setResaltare_mail_e_mailCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltare_mail_e_mailCobrarClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltare_mail_e_mailCobrarClientesDetallados() {
		return this.resaltare_mail_e_mailCobrarClientesDetallados;
	}

	public void setResaltare_mail_e_mailCobrarClientesDetallados(Border borderResaltar) {
		this.resaltare_mail_e_mailCobrarClientesDetallados= borderResaltar;
	}

	public Boolean getMostrare_mail_e_mailCobrarClientesDetallados() {
		return this.mostrare_mail_e_mailCobrarClientesDetallados;
	}

	public void setMostrare_mail_e_mailCobrarClientesDetallados(Boolean mostrare_mail_e_mailCobrarClientesDetallados) {
		this.mostrare_mail_e_mailCobrarClientesDetallados= mostrare_mail_e_mailCobrarClientesDetallados;
	}

	public Boolean getActivare_mail_e_mailCobrarClientesDetallados() {
		return this.activare_mail_e_mailCobrarClientesDetallados;
	}

	public void setActivare_mail_e_mailCobrarClientesDetallados(Boolean activare_mail_e_mailCobrarClientesDetallados) {
		this.activare_mail_e_mailCobrarClientesDetallados= activare_mail_e_mailCobrarClientesDetallados;
	}

	public Border setResaltartelefono_telefonoCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarClientesDetallados.setBorder(borderResaltar);
		
		this.resaltartelefono_telefonoCobrarClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_telefonoCobrarClientesDetallados() {
		return this.resaltartelefono_telefonoCobrarClientesDetallados;
	}

	public void setResaltartelefono_telefonoCobrarClientesDetallados(Border borderResaltar) {
		this.resaltartelefono_telefonoCobrarClientesDetallados= borderResaltar;
	}

	public Boolean getMostrartelefono_telefonoCobrarClientesDetallados() {
		return this.mostrartelefono_telefonoCobrarClientesDetallados;
	}

	public void setMostrartelefono_telefonoCobrarClientesDetallados(Boolean mostrartelefono_telefonoCobrarClientesDetallados) {
		this.mostrartelefono_telefonoCobrarClientesDetallados= mostrartelefono_telefonoCobrarClientesDetallados;
	}

	public Boolean getActivartelefono_telefonoCobrarClientesDetallados() {
		return this.activartelefono_telefonoCobrarClientesDetallados;
	}

	public void setActivartelefono_telefonoCobrarClientesDetallados(Boolean activartelefono_telefonoCobrarClientesDetallados) {
		this.activartelefono_telefonoCobrarClientesDetallados= activartelefono_telefonoCobrarClientesDetallados;
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
		
		
		this.setMostraridCobrarClientesDetallados(esInicial);
		this.setMostrarid_empresaCobrarClientesDetallados(esInicial);
		this.setMostrarnombre_ciudadCobrarClientesDetallados(esInicial);
		this.setMostrarnombre_zonaCobrarClientesDetallados(esInicial);
		this.setMostrarnombre_grupo_clienteCobrarClientesDetallados(esInicial);
		this.setMostrarnombre_titulo_clienteCobrarClientesDetallados(esInicial);
		this.setMostrarcodigoCobrarClientesDetallados(esInicial);
		this.setMostrarnombreCobrarClientesDetallados(esInicial);
		this.setMostrarapellidoCobrarClientesDetallados(esInicial);
		this.setMostrarrucCobrarClientesDetallados(esInicial);
		this.setMostrarnombre_contacto_clienteCobrarClientesDetallados(esInicial);
		this.setMostrardireccion_direccionCobrarClientesDetallados(esInicial);
		this.setMostrare_mail_e_mailCobrarClientesDetallados(esInicial);
		this.setMostrartelefono_telefonoCobrarClientesDetallados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.ID)) {
				this.setMostraridCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRECIUDAD)) {
				this.setMostrarnombre_ciudadCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBREZONA)) {
				this.setMostrarnombre_zonaCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setMostrarnombre_grupo_clienteCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRETITULOCLIENTE)) {
				this.setMostrarnombre_titulo_clienteCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.RUC)) {
				this.setMostrarrucCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRECONTACTOCLIENTE)) {
				this.setMostrarnombre_contacto_clienteCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setMostrardireccion_direccionCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.EMAILEMAIL)) {
				this.setMostrare_mail_e_mailCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.TELEFONOTELEFONO)) {
				this.setMostrartelefono_telefonoCobrarClientesDetallados(esAsigna);
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
		
		
		this.setActivaridCobrarClientesDetallados(esInicial);
		this.setActivarid_empresaCobrarClientesDetallados(esInicial);
		this.setActivarnombre_ciudadCobrarClientesDetallados(esInicial);
		this.setActivarnombre_zonaCobrarClientesDetallados(esInicial);
		this.setActivarnombre_grupo_clienteCobrarClientesDetallados(esInicial);
		this.setActivarnombre_titulo_clienteCobrarClientesDetallados(esInicial);
		this.setActivarcodigoCobrarClientesDetallados(esInicial);
		this.setActivarnombreCobrarClientesDetallados(esInicial);
		this.setActivarapellidoCobrarClientesDetallados(esInicial);
		this.setActivarrucCobrarClientesDetallados(esInicial);
		this.setActivarnombre_contacto_clienteCobrarClientesDetallados(esInicial);
		this.setActivardireccion_direccionCobrarClientesDetallados(esInicial);
		this.setActivare_mail_e_mailCobrarClientesDetallados(esInicial);
		this.setActivartelefono_telefonoCobrarClientesDetallados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.ID)) {
				this.setActivaridCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRECIUDAD)) {
				this.setActivarnombre_ciudadCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBREZONA)) {
				this.setActivarnombre_zonaCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setActivarnombre_grupo_clienteCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRETITULOCLIENTE)) {
				this.setActivarnombre_titulo_clienteCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.RUC)) {
				this.setActivarrucCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRECONTACTOCLIENTE)) {
				this.setActivarnombre_contacto_clienteCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setActivardireccion_direccionCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.EMAILEMAIL)) {
				this.setActivare_mail_e_mailCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.TELEFONOTELEFONO)) {
				this.setActivartelefono_telefonoCobrarClientesDetallados(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarClientesDetallados(esInicial);
		this.setResaltarid_empresaCobrarClientesDetallados(esInicial);
		this.setResaltarnombre_ciudadCobrarClientesDetallados(esInicial);
		this.setResaltarnombre_zonaCobrarClientesDetallados(esInicial);
		this.setResaltarnombre_grupo_clienteCobrarClientesDetallados(esInicial);
		this.setResaltarnombre_titulo_clienteCobrarClientesDetallados(esInicial);
		this.setResaltarcodigoCobrarClientesDetallados(esInicial);
		this.setResaltarnombreCobrarClientesDetallados(esInicial);
		this.setResaltarapellidoCobrarClientesDetallados(esInicial);
		this.setResaltarrucCobrarClientesDetallados(esInicial);
		this.setResaltarnombre_contacto_clienteCobrarClientesDetallados(esInicial);
		this.setResaltardireccion_direccionCobrarClientesDetallados(esInicial);
		this.setResaltare_mail_e_mailCobrarClientesDetallados(esInicial);
		this.setResaltartelefono_telefonoCobrarClientesDetallados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.ID)) {
				this.setResaltaridCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRECIUDAD)) {
				this.setResaltarnombre_ciudadCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBREZONA)) {
				this.setResaltarnombre_zonaCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setResaltarnombre_grupo_clienteCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRETITULOCLIENTE)) {
				this.setResaltarnombre_titulo_clienteCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.RUC)) {
				this.setResaltarrucCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.NOMBRECONTACTOCLIENTE)) {
				this.setResaltarnombre_contacto_clienteCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setResaltardireccion_direccionCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.EMAILEMAIL)) {
				this.setResaltare_mail_e_mailCobrarClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesDetalladosConstantesFunciones.TELEFONOTELEFONO)) {
				this.setResaltartelefono_telefonoCobrarClientesDetallados(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCobrarClientesDetalladosCobrarClientesDetallados=true;

	public Boolean getMostrarBusquedaCobrarClientesDetalladosCobrarClientesDetallados() {
		return this.mostrarBusquedaCobrarClientesDetalladosCobrarClientesDetallados;
	}

	public void setMostrarBusquedaCobrarClientesDetalladosCobrarClientesDetallados(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarClientesDetalladosCobrarClientesDetallados= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarClientesDetalladosCobrarClientesDetallados=true;

	public Boolean getActivarBusquedaCobrarClientesDetalladosCobrarClientesDetallados() {
		return this.activarBusquedaCobrarClientesDetalladosCobrarClientesDetallados;
	}

	public void setActivarBusquedaCobrarClientesDetalladosCobrarClientesDetallados(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarClientesDetalladosCobrarClientesDetallados= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarClientesDetalladosCobrarClientesDetallados=null;

	public Border getResaltarBusquedaCobrarClientesDetalladosCobrarClientesDetallados() {
		return this.resaltarBusquedaCobrarClientesDetalladosCobrarClientesDetallados;
	}

	public void setResaltarBusquedaCobrarClientesDetalladosCobrarClientesDetallados(Border borderResaltar) {
		this.resaltarBusquedaCobrarClientesDetalladosCobrarClientesDetallados= borderResaltar;
	}

	public void setResaltarBusquedaCobrarClientesDetalladosCobrarClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesDetalladosBeanSwingJInternalFrame cobrarclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarClientesDetalladosCobrarClientesDetallados= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}