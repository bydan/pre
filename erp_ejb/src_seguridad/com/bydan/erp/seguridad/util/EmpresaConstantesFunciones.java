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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.EmpresaConstantesFunciones;
import com.bydan.erp.seguridad.util.EmpresaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.EmpresaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EmpresaConstantesFunciones extends EmpresaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Empresa";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Empresa"+EmpresaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpresaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpresaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpresaConstantesFunciones.SCHEMA+"_"+EmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpresaConstantesFunciones.SCHEMA+"_"+EmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpresaConstantesFunciones.SCHEMA+"_"+EmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpresaConstantesFunciones.SCHEMA+"_"+EmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpresaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpresaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpresaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpresaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empresas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Empresa";
	public static final String SCLASSWEBTITULO_LOWER="Empresa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Empresa";
	public static final String OBJECTNAME="empresa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="empresa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empresa from "+EmpresaConstantesFunciones.SPERSISTENCENAME+" empresa";
	public static String QUERYSELECTNATIVE="select "+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".id,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".version_row,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".id_pais,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".id_ciudad,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".id_tipo_empresa,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".nombre,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".direccion,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".ruc,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".mail,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".telefono,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".fax,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".codigo_postal,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".iva,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".actividad_principal,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".actividad_secundaria,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".contador_nombre,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".contador_ruc,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".contador_licencia,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".representante_nombre,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".representante_cedula from "+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME;//+" as "+EmpresaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpresaConstantesFuncionesAdditional empresaConstantesFuncionesAdditional=null;
	
	public EmpresaConstantesFuncionesAdditional getEmpresaConstantesFuncionesAdditional() {
		return this.empresaConstantesFuncionesAdditional;
	}
	
	public void setEmpresaConstantesFuncionesAdditional(EmpresaConstantesFuncionesAdditional empresaConstantesFuncionesAdditional) {
		try {
			this.empresaConstantesFuncionesAdditional=empresaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDTIPOEMPRESA= "id_tipo_empresa";
    public static final String NOMBRE= "nombre";
    public static final String DIRECCION= "direccion";
    public static final String RUC= "ruc";
    public static final String MAIL= "mail";
    public static final String TELEFONO= "telefono";
    public static final String FAX= "fax";
    public static final String CODIGOPOSTAL= "codigo_postal";
    public static final String IVA= "iva";
    public static final String ACTIVIDADPRINCIPAL= "actividad_principal";
    public static final String ACTIVIDADSECUNDARIA= "actividad_secundaria";
    public static final String CONTADORNOMBRE= "contador_nombre";
    public static final String CONTADORRUC= "contador_ruc";
    public static final String CONTADORLICENCIA= "contador_licencia";
    public static final String REPRESENTANTENOMBRE= "representante_nombre";
    public static final String REPRESENTANTECEDULA= "representante_cedula";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDTIPOEMPRESA= "Tipo Empresa";
		public static final String LABEL_IDTIPOEMPRESA_LOWER= "Tipo Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_MAIL= "Mail";
		public static final String LABEL_MAIL_LOWER= "Mail";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_FAX= "Fax";
		public static final String LABEL_FAX_LOWER= "Fax";
    	public static final String LABEL_CODIGOPOSTAL= "Codigo Postal";
		public static final String LABEL_CODIGOPOSTAL_LOWER= "Codigo Postal";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_ACTIVIDADPRINCIPAL= "Actividad Principal";
		public static final String LABEL_ACTIVIDADPRINCIPAL_LOWER= "Actividad Principal";
    	public static final String LABEL_ACTIVIDADSECUNDARIA= "Actividad Secundaria";
		public static final String LABEL_ACTIVIDADSECUNDARIA_LOWER= "Actividad Secundaria";
    	public static final String LABEL_CONTADORNOMBRE= "Nombre.";
		public static final String LABEL_CONTADORNOMBRE_LOWER= "Contador Nombre";
    	public static final String LABEL_CONTADORRUC= "Ruc.";
		public static final String LABEL_CONTADORRUC_LOWER= "Contador Ruc";
    	public static final String LABEL_CONTADORLICENCIA= "Licencia";
		public static final String LABEL_CONTADORLICENCIA_LOWER= "Contador Licencia";
    	public static final String LABEL_REPRESENTANTENOMBRE= "Nombre .";
		public static final String LABEL_REPRESENTANTENOMBRE_LOWER= "Representante Nombre";
    	public static final String LABEL_REPRESENTANTECEDULA= "Cedula";
		public static final String LABEL_REPRESENTANTECEDULA_LOWER= "Representante Cedula";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMAIL=ConstantesValidacion.SREGEXCADENA_MAIL;
	public static final String SMENSAJEREGEXMAIL=ConstantesValidacion.SVALIDACIONCADENA_MAIL;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXFAX=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFAX=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_POSTAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_POSTAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXACTIVIDAD_PRINCIPAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXACTIVIDAD_PRINCIPAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXACTIVIDAD_SECUNDARIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXACTIVIDAD_SECUNDARIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCONTADOR_NOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCONTADOR_NOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCONTADOR_RUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCONTADOR_RUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCONTADOR_LICENCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCONTADOR_LICENCIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXREPRESENTANTE_NOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXREPRESENTANTE_NOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXREPRESENTANTE_CEDULA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXREPRESENTANTE_CEDULA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEmpresaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpresaConstantesFunciones.IDPAIS)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.IDCIUDAD)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.IDTIPOEMPRESA)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_IDTIPOEMPRESA;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.NOMBRE)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.DIRECCION)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.RUC)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.MAIL)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_MAIL;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.TELEFONO)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.FAX)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_FAX;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.CODIGOPOSTAL)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_CODIGOPOSTAL;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.IVA)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.ACTIVIDADPRINCIPAL)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_ACTIVIDADPRINCIPAL;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.ACTIVIDADSECUNDARIA)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_ACTIVIDADSECUNDARIA;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.CONTADORNOMBRE)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_CONTADORNOMBRE;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.CONTADORRUC)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_CONTADORRUC;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.CONTADORLICENCIA)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_CONTADORLICENCIA;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.REPRESENTANTENOMBRE)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_REPRESENTANTENOMBRE;}
		if(sNombreColumna.equals(EmpresaConstantesFunciones.REPRESENTANTECEDULA)) {sLabelColumna=EmpresaConstantesFunciones.LABEL_REPRESENTANTECEDULA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empresa !=null/* && empresa.getId()!=0*/) {
			sDescripcion=empresa.getnombre();//empresaempresa.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpresaDescripcionDetallado(Empresa empresa) {
		String sDescripcion="";
			
		sDescripcion+=EmpresaConstantesFunciones.ID+"=";
		sDescripcion+=empresa.getId().toString()+",";
		sDescripcion+=EmpresaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empresa.getVersionRow().toString()+",";
		sDescripcion+=EmpresaConstantesFunciones.IDPAIS+"=";
		sDescripcion+=empresa.getid_pais().toString()+",";
		sDescripcion+=EmpresaConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=empresa.getid_ciudad().toString()+",";
		sDescripcion+=EmpresaConstantesFunciones.IDTIPOEMPRESA+"=";
		sDescripcion+=empresa.getid_tipo_empresa().toString()+",";
		sDescripcion+=EmpresaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=empresa.getnombre()+",";
		sDescripcion+=EmpresaConstantesFunciones.DIRECCION+"=";
		sDescripcion+=empresa.getdireccion()+",";
		sDescripcion+=EmpresaConstantesFunciones.RUC+"=";
		sDescripcion+=empresa.getruc()+",";
		sDescripcion+=EmpresaConstantesFunciones.MAIL+"=";
		sDescripcion+=empresa.getmail()+",";
		sDescripcion+=EmpresaConstantesFunciones.TELEFONO+"=";
		sDescripcion+=empresa.gettelefono()+",";
		sDescripcion+=EmpresaConstantesFunciones.FAX+"=";
		sDescripcion+=empresa.getfax()+",";
		sDescripcion+=EmpresaConstantesFunciones.CODIGOPOSTAL+"=";
		sDescripcion+=empresa.getcodigo_postal()+",";
		sDescripcion+=EmpresaConstantesFunciones.IVA+"=";
		sDescripcion+=empresa.getiva().toString()+",";
		sDescripcion+=EmpresaConstantesFunciones.ACTIVIDADPRINCIPAL+"=";
		sDescripcion+=empresa.getactividad_principal()+",";
		sDescripcion+=EmpresaConstantesFunciones.ACTIVIDADSECUNDARIA+"=";
		sDescripcion+=empresa.getactividad_secundaria()+",";
		sDescripcion+=EmpresaConstantesFunciones.CONTADORNOMBRE+"=";
		sDescripcion+=empresa.getcontador_nombre()+",";
		sDescripcion+=EmpresaConstantesFunciones.CONTADORRUC+"=";
		sDescripcion+=empresa.getcontador_ruc()+",";
		sDescripcion+=EmpresaConstantesFunciones.CONTADORLICENCIA+"=";
		sDescripcion+=empresa.getcontador_licencia()+",";
		sDescripcion+=EmpresaConstantesFunciones.REPRESENTANTENOMBRE+"=";
		sDescripcion+=empresa.getrepresentante_nombre()+",";
		sDescripcion+=EmpresaConstantesFunciones.REPRESENTANTECEDULA+"=";
		sDescripcion+=empresa.getrepresentante_cedula()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpresaDescripcion(Empresa empresa,String sValor) throws Exception {			
		if(empresa !=null) {
			empresa.setnombre(sValor);;//empresaempresa.getnombre().trim();
		}		
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

	public static String getTipoEmpresaDescripcion(TipoEmpresa tipoempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoempresa!=null/*&&tipoempresa.getId()>0*/) {
			sDescripcion=TipoEmpresaConstantesFunciones.getTipoEmpresaDescripcion(tipoempresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdPaisPorNombre")) {
			sNombreIndice="Tipo=  Por Pais Por Nombre";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdTipoEmpresa")) {
			sNombreIndice="Tipo=  Por Tipo Empresa";
		} else if(sNombreIndice.equals("PorIdPaisPorNombre")) {
			sNombreIndice="Tipo=  Por Pais Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdPaisPorNombre(Long id_pais,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoEmpresa(Long id_tipo_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_empresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Empresa="+id_tipo_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPaisPorNombre(Long id_pais,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEmpresa(Empresa empresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		empresa.setnombre(empresa.getnombre().trim());
		empresa.setdireccion(empresa.getdireccion().trim());
		empresa.setruc(empresa.getruc().trim());
		empresa.setmail(empresa.getmail().trim());
		empresa.settelefono(empresa.gettelefono().trim());
		empresa.setfax(empresa.getfax().trim());
		empresa.setcodigo_postal(empresa.getcodigo_postal().trim());
		empresa.setactividad_principal(empresa.getactividad_principal().trim());
		empresa.setactividad_secundaria(empresa.getactividad_secundaria().trim());
		empresa.setcontador_nombre(empresa.getcontador_nombre().trim());
		empresa.setcontador_ruc(empresa.getcontador_ruc().trim());
		empresa.setcontador_licencia(empresa.getcontador_licencia().trim());
		empresa.setrepresentante_nombre(empresa.getrepresentante_nombre().trim());
		empresa.setrepresentante_cedula(empresa.getrepresentante_cedula().trim());
	}
	
	public static void quitarEspaciosEmpresas(List<Empresa> empresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Empresa empresa: empresas) {
			empresa.setnombre(empresa.getnombre().trim());
			empresa.setdireccion(empresa.getdireccion().trim());
			empresa.setruc(empresa.getruc().trim());
			empresa.setmail(empresa.getmail().trim());
			empresa.settelefono(empresa.gettelefono().trim());
			empresa.setfax(empresa.getfax().trim());
			empresa.setcodigo_postal(empresa.getcodigo_postal().trim());
			empresa.setactividad_principal(empresa.getactividad_principal().trim());
			empresa.setactividad_secundaria(empresa.getactividad_secundaria().trim());
			empresa.setcontador_nombre(empresa.getcontador_nombre().trim());
			empresa.setcontador_ruc(empresa.getcontador_ruc().trim());
			empresa.setcontador_licencia(empresa.getcontador_licencia().trim());
			empresa.setrepresentante_nombre(empresa.getrepresentante_nombre().trim());
			empresa.setrepresentante_cedula(empresa.getrepresentante_cedula().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpresa(Empresa empresa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empresa.getConCambioAuxiliar()) {
			empresa.setIsDeleted(empresa.getIsDeletedAuxiliar());	
			empresa.setIsNew(empresa.getIsNewAuxiliar());	
			empresa.setIsChanged(empresa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empresa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empresa.setIsDeletedAuxiliar(false);	
			empresa.setIsNewAuxiliar(false);	
			empresa.setIsChangedAuxiliar(false);
			
			empresa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpresas(List<Empresa> empresas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Empresa empresa : empresas) {
			if(conAsignarBase && empresa.getConCambioAuxiliar()) {
				empresa.setIsDeleted(empresa.getIsDeletedAuxiliar());	
				empresa.setIsNew(empresa.getIsNewAuxiliar());	
				empresa.setIsChanged(empresa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empresa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empresa.setIsDeletedAuxiliar(false);	
				empresa.setIsNewAuxiliar(false);	
				empresa.setIsChangedAuxiliar(false);
				
				empresa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpresa(Empresa empresa,Boolean conEnteros) throws Exception  {
		empresa.setiva(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEmpresas(List<Empresa> empresas,Boolean conEnteros) throws Exception  {
		
		for(Empresa empresa: empresas) {
			empresa.setiva(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpresa(List<Empresa> empresas,Empresa empresaAux) throws Exception  {
		EmpresaConstantesFunciones.InicializarValoresEmpresa(empresaAux,true);
		
		for(Empresa empresa: empresas) {
			if(empresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			empresaAux.setiva(empresaAux.getiva()+empresa.getiva());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpresaConstantesFunciones.getArrayColumnasGlobalesEmpresa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpresa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Empresa> empresas,Empresa empresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Empresa empresaAux: empresas) {
			if(empresaAux!=null && empresa!=null) {
				if((empresaAux.getId()==null && empresa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empresaAux.getId()!=null && empresa.getId()!=null){
					if(empresaAux.getId().equals(empresa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpresa(List<Empresa> empresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ivaTotal=0.0;
	
		for(Empresa empresa: empresas) {			
			if(empresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ivaTotal+=empresa.getiva();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EmpresaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(EmpresaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpresa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_ID, EmpresaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_VERSIONROW, EmpresaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_IDPAIS, EmpresaConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_IDCIUDAD, EmpresaConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_IDTIPOEMPRESA, EmpresaConstantesFunciones.IDTIPOEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_NOMBRE, EmpresaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_DIRECCION, EmpresaConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_RUC, EmpresaConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_MAIL, EmpresaConstantesFunciones.MAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_TELEFONO, EmpresaConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_FAX, EmpresaConstantesFunciones.FAX,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_CODIGOPOSTAL, EmpresaConstantesFunciones.CODIGOPOSTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_IVA, EmpresaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_ACTIVIDADPRINCIPAL, EmpresaConstantesFunciones.ACTIVIDADPRINCIPAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_ACTIVIDADSECUNDARIA, EmpresaConstantesFunciones.ACTIVIDADSECUNDARIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_CONTADORNOMBRE, EmpresaConstantesFunciones.CONTADORNOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_CONTADORRUC, EmpresaConstantesFunciones.CONTADORRUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_CONTADORLICENCIA, EmpresaConstantesFunciones.CONTADORLICENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_REPRESENTANTENOMBRE, EmpresaConstantesFunciones.REPRESENTANTENOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaConstantesFunciones.LABEL_REPRESENTANTECEDULA, EmpresaConstantesFunciones.REPRESENTANTECEDULA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpresa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.IDTIPOEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.MAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.FAX;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.CODIGOPOSTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.ACTIVIDADPRINCIPAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.ACTIVIDADSECUNDARIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.CONTADORNOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.CONTADORRUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.CONTADORLICENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.REPRESENTANTENOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaConstantesFunciones.REPRESENTANTECEDULA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpresa() throws Exception  {
		return EmpresaConstantesFunciones.getTiposSeleccionarEmpresa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpresa(Boolean conFk) throws Exception  {
		return EmpresaConstantesFunciones.getTiposSeleccionarEmpresa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpresa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_IDTIPOEMPRESA);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_IDTIPOEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_MAIL);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_MAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_FAX);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_FAX);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_CODIGOPOSTAL);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_CODIGOPOSTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_ACTIVIDADPRINCIPAL);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_ACTIVIDADPRINCIPAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_ACTIVIDADSECUNDARIA);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_ACTIVIDADSECUNDARIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_CONTADORNOMBRE);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_CONTADORNOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_CONTADORRUC);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_CONTADORRUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_CONTADORLICENCIA);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_CONTADORLICENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_REPRESENTANTENOMBRE);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_REPRESENTANTENOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaConstantesFunciones.LABEL_REPRESENTANTECEDULA);
			reporte.setsDescripcion(EmpresaConstantesFunciones.LABEL_REPRESENTANTECEDULA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpresa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpresa(Empresa empresaAux) throws Exception {
		
			empresaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(empresaAux.getPais()));
			empresaAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(empresaAux.getCiudad()));
			empresaAux.settipoempresa_descripcion(TipoEmpresaConstantesFunciones.getTipoEmpresaDescripcion(empresaAux.getTipoEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmpresa(List<Empresa> empresasTemp) throws Exception {
		for(Empresa empresaAux:empresasTemp) {
			
			empresaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(empresaAux.getPais()));
			empresaAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(empresaAux.getCiudad()));
			empresaAux.settipoempresa_descripcion(TipoEmpresaConstantesFunciones.getTipoEmpresaDescripcion(empresaAux.getTipoEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(TipoEmpresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoEmpresa.class)) {
						classes.add(new Classe(TipoEmpresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(TipoEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoEmpresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(TipoEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoEmpresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpresaConstantesFunciones.getClassesRelationshipsOfEmpresa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Sucursal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpresaConstantesFunciones.getClassesRelationshipsFromStringsOfEmpresa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	public static void actualizarLista(Empresa empresa,List<Empresa> empresas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Empresa empresaEncontrado=null;
			
			for(Empresa empresaLocal:empresas) {
				if(empresaLocal.getId().equals(empresa.getId())) {
					empresaEncontrado=empresaLocal;
					
					empresaLocal.setIsChanged(empresa.getIsChanged());
					empresaLocal.setIsNew(empresa.getIsNew());
					empresaLocal.setIsDeleted(empresa.getIsDeleted());
					
					empresaLocal.setGeneralEntityOriginal(empresa.getGeneralEntityOriginal());
					
					empresaLocal.setId(empresa.getId());	
					empresaLocal.setVersionRow(empresa.getVersionRow());	
					empresaLocal.setid_pais(empresa.getid_pais());	
					empresaLocal.setid_ciudad(empresa.getid_ciudad());	
					empresaLocal.setid_tipo_empresa(empresa.getid_tipo_empresa());	
					empresaLocal.setnombre(empresa.getnombre());	
					empresaLocal.setdireccion(empresa.getdireccion());	
					empresaLocal.setruc(empresa.getruc());	
					empresaLocal.setmail(empresa.getmail());	
					empresaLocal.settelefono(empresa.gettelefono());	
					empresaLocal.setfax(empresa.getfax());	
					empresaLocal.setcodigo_postal(empresa.getcodigo_postal());	
					empresaLocal.setiva(empresa.getiva());	
					empresaLocal.setactividad_principal(empresa.getactividad_principal());	
					empresaLocal.setactividad_secundaria(empresa.getactividad_secundaria());	
					empresaLocal.setcontador_nombre(empresa.getcontador_nombre());	
					empresaLocal.setcontador_ruc(empresa.getcontador_ruc());	
					empresaLocal.setcontador_licencia(empresa.getcontador_licencia());	
					empresaLocal.setrepresentante_nombre(empresa.getrepresentante_nombre());	
					empresaLocal.setrepresentante_cedula(empresa.getrepresentante_cedula());	
					
					
					empresaLocal.setSucursals(empresa.getSucursals());
					
					existe=true;
					break;
				}
			}
			
			if(!empresa.getIsDeleted()) {
				if(!existe) {
					empresas.add(empresa);
				}
			} else {
				if(empresaEncontrado!=null && permiteQuitar)  {
					empresas.remove(empresaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Empresa empresa,List<Empresa> empresas) throws Exception {
		try	{			
			for(Empresa empresaLocal:empresas) {
				if(empresaLocal.getId().equals(empresa.getId())) {
					empresaLocal.setIsSelected(empresa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpresa(List<Empresa> empresasAux) throws Exception {
		//this.empresasAux=empresasAux;
		
		for(Empresa empresaAux:empresasAux) {
			if(empresaAux.getIsChanged()) {
				empresaAux.setIsChanged(false);
			}		
			
			if(empresaAux.getIsNew()) {
				empresaAux.setIsNew(false);
			}	
			
			if(empresaAux.getIsDeleted()) {
				empresaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpresa(Empresa empresaAux) throws Exception {
		//this.empresaAux=empresaAux;
		
			if(empresaAux.getIsChanged()) {
				empresaAux.setIsChanged(false);
			}		
			
			if(empresaAux.getIsNew()) {
				empresaAux.setIsNew(false);
			}	
			
			if(empresaAux.getIsDeleted()) {
				empresaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Empresa empresaAsignar,Empresa empresa) throws Exception {
		empresaAsignar.setId(empresa.getId());	
		empresaAsignar.setVersionRow(empresa.getVersionRow());	
		empresaAsignar.setid_pais(empresa.getid_pais());
		empresaAsignar.setpais_descripcion(empresa.getpais_descripcion());	
		empresaAsignar.setid_ciudad(empresa.getid_ciudad());
		empresaAsignar.setciudad_descripcion(empresa.getciudad_descripcion());	
		empresaAsignar.setid_tipo_empresa(empresa.getid_tipo_empresa());
		empresaAsignar.settipoempresa_descripcion(empresa.gettipoempresa_descripcion());	
		empresaAsignar.setnombre(empresa.getnombre());	
		empresaAsignar.setdireccion(empresa.getdireccion());	
		empresaAsignar.setruc(empresa.getruc());	
		empresaAsignar.setmail(empresa.getmail());	
		empresaAsignar.settelefono(empresa.gettelefono());	
		empresaAsignar.setfax(empresa.getfax());	
		empresaAsignar.setcodigo_postal(empresa.getcodigo_postal());	
		empresaAsignar.setiva(empresa.getiva());	
		empresaAsignar.setactividad_principal(empresa.getactividad_principal());	
		empresaAsignar.setactividad_secundaria(empresa.getactividad_secundaria());	
		empresaAsignar.setcontador_nombre(empresa.getcontador_nombre());	
		empresaAsignar.setcontador_ruc(empresa.getcontador_ruc());	
		empresaAsignar.setcontador_licencia(empresa.getcontador_licencia());	
		empresaAsignar.setrepresentante_nombre(empresa.getrepresentante_nombre());	
		empresaAsignar.setrepresentante_cedula(empresa.getrepresentante_cedula());	
	}
	
	public static void inicializarEmpresa(Empresa empresa) throws Exception {
		try {
				empresa.setId(0L);	
					
				empresa.setid_pais(-1L);	
				empresa.setid_ciudad(-1L);	
				empresa.setid_tipo_empresa(-1L);	
				empresa.setnombre("");	
				empresa.setdireccion("");	
				empresa.setruc("");	
				empresa.setmail("");	
				empresa.settelefono("");	
				empresa.setfax("");	
				empresa.setcodigo_postal("");	
				empresa.setiva(0.0);	
				empresa.setactividad_principal("");	
				empresa.setactividad_secundaria("");	
				empresa.setcontador_nombre("");	
				empresa.setcontador_ruc("");	
				empresa.setcontador_licencia("");	
				empresa.setrepresentante_nombre("");	
				empresa.setrepresentante_cedula("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpresa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_IDTIPOEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_MAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_FAX);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_CODIGOPOSTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_ACTIVIDADPRINCIPAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_ACTIVIDADSECUNDARIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_CONTADORNOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_CONTADORRUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_CONTADORLICENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_REPRESENTANTENOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaConstantesFunciones.LABEL_REPRESENTANTECEDULA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpresa(String sTipo,Row row,Workbook workbook,Empresa empresa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.gettipoempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getmail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getfax());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getcodigo_postal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getactividad_principal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getactividad_secundaria());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getcontador_nombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getcontador_ruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getcontador_licencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getrepresentante_nombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresa.getrepresentante_cedula());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpresa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpresa() {
		return this.sFinalQueryEmpresa;
	}
	
	public void setsFinalQueryEmpresa(String sFinalQueryEmpresa) {
		this.sFinalQueryEmpresa= sFinalQueryEmpresa;
	}
	
	public Border resaltarSeleccionarEmpresa=null;
	
	public Border setResaltarSeleccionarEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpresa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpresa() {
		return this.resaltarSeleccionarEmpresa;
	}
	
	public void setResaltarSeleccionarEmpresa(Border borderResaltarSeleccionarEmpresa) {
		this.resaltarSeleccionarEmpresa= borderResaltarSeleccionarEmpresa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpresa=null;
	public Boolean mostraridEmpresa=true;
	public Boolean activaridEmpresa=true;

	public Border resaltarid_paisEmpresa=null;
	public Boolean mostrarid_paisEmpresa=true;
	public Boolean activarid_paisEmpresa=true;
	public Boolean cargarid_paisEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisEmpresa=false;//ConEventDepend=true

	public Border resaltarid_ciudadEmpresa=null;
	public Boolean mostrarid_ciudadEmpresa=true;
	public Boolean activarid_ciudadEmpresa=true;
	public Boolean cargarid_ciudadEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadEmpresa=true;//ConEventDepend=true

	public Border resaltarid_tipo_empresaEmpresa=null;
	public Boolean mostrarid_tipo_empresaEmpresa=true;
	public Boolean activarid_tipo_empresaEmpresa=true;
	public Boolean cargarid_tipo_empresaEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_empresaEmpresa=false;//ConEventDepend=true

	public Border resaltarnombreEmpresa=null;
	public Boolean mostrarnombreEmpresa=true;
	public Boolean activarnombreEmpresa=true;

	public Border resaltardireccionEmpresa=null;
	public Boolean mostrardireccionEmpresa=true;
	public Boolean activardireccionEmpresa=true;

	public Border resaltarrucEmpresa=null;
	public Boolean mostrarrucEmpresa=true;
	public Boolean activarrucEmpresa=true;

	public Border resaltarmailEmpresa=null;
	public Boolean mostrarmailEmpresa=true;
	public Boolean activarmailEmpresa=true;

	public Border resaltartelefonoEmpresa=null;
	public Boolean mostrartelefonoEmpresa=true;
	public Boolean activartelefonoEmpresa=true;

	public Border resaltarfaxEmpresa=null;
	public Boolean mostrarfaxEmpresa=true;
	public Boolean activarfaxEmpresa=true;

	public Border resaltarcodigo_postalEmpresa=null;
	public Boolean mostrarcodigo_postalEmpresa=true;
	public Boolean activarcodigo_postalEmpresa=true;

	public Border resaltarivaEmpresa=null;
	public Boolean mostrarivaEmpresa=true;
	public Boolean activarivaEmpresa=true;

	public Border resaltaractividad_principalEmpresa=null;
	public Boolean mostraractividad_principalEmpresa=true;
	public Boolean activaractividad_principalEmpresa=true;

	public Border resaltaractividad_secundariaEmpresa=null;
	public Boolean mostraractividad_secundariaEmpresa=true;
	public Boolean activaractividad_secundariaEmpresa=true;

	public Border resaltarcontador_nombreEmpresa=null;
	public Boolean mostrarcontador_nombreEmpresa=true;
	public Boolean activarcontador_nombreEmpresa=true;

	public Border resaltarcontador_rucEmpresa=null;
	public Boolean mostrarcontador_rucEmpresa=true;
	public Boolean activarcontador_rucEmpresa=true;

	public Border resaltarcontador_licenciaEmpresa=null;
	public Boolean mostrarcontador_licenciaEmpresa=true;
	public Boolean activarcontador_licenciaEmpresa=true;

	public Border resaltarrepresentante_nombreEmpresa=null;
	public Boolean mostrarrepresentante_nombreEmpresa=true;
	public Boolean activarrepresentante_nombreEmpresa=true;

	public Border resaltarrepresentante_cedulaEmpresa=null;
	public Boolean mostrarrepresentante_cedulaEmpresa=true;
	public Boolean activarrepresentante_cedulaEmpresa=true;

	
	

	public Border setResaltaridEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltaridEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpresa() {
		return this.resaltaridEmpresa;
	}

	public void setResaltaridEmpresa(Border borderResaltar) {
		this.resaltaridEmpresa= borderResaltar;
	}

	public Boolean getMostraridEmpresa() {
		return this.mostraridEmpresa;
	}

	public void setMostraridEmpresa(Boolean mostraridEmpresa) {
		this.mostraridEmpresa= mostraridEmpresa;
	}

	public Boolean getActivaridEmpresa() {
		return this.activaridEmpresa;
	}

	public void setActivaridEmpresa(Boolean activaridEmpresa) {
		this.activaridEmpresa= activaridEmpresa;
	}

	public Border setResaltarid_paisEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_paisEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisEmpresa() {
		return this.resaltarid_paisEmpresa;
	}

	public void setResaltarid_paisEmpresa(Border borderResaltar) {
		this.resaltarid_paisEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_paisEmpresa() {
		return this.mostrarid_paisEmpresa;
	}

	public void setMostrarid_paisEmpresa(Boolean mostrarid_paisEmpresa) {
		this.mostrarid_paisEmpresa= mostrarid_paisEmpresa;
	}

	public Boolean getActivarid_paisEmpresa() {
		return this.activarid_paisEmpresa;
	}

	public void setActivarid_paisEmpresa(Boolean activarid_paisEmpresa) {
		this.activarid_paisEmpresa= activarid_paisEmpresa;
	}

	public Boolean getCargarid_paisEmpresa() {
		return this.cargarid_paisEmpresa;
	}

	public void setCargarid_paisEmpresa(Boolean cargarid_paisEmpresa) {
		this.cargarid_paisEmpresa= cargarid_paisEmpresa;
	}

	public Border setResaltarid_ciudadEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_ciudadEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadEmpresa() {
		return this.resaltarid_ciudadEmpresa;
	}

	public void setResaltarid_ciudadEmpresa(Border borderResaltar) {
		this.resaltarid_ciudadEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_ciudadEmpresa() {
		return this.mostrarid_ciudadEmpresa;
	}

	public void setMostrarid_ciudadEmpresa(Boolean mostrarid_ciudadEmpresa) {
		this.mostrarid_ciudadEmpresa= mostrarid_ciudadEmpresa;
	}

	public Boolean getActivarid_ciudadEmpresa() {
		return this.activarid_ciudadEmpresa;
	}

	public void setActivarid_ciudadEmpresa(Boolean activarid_ciudadEmpresa) {
		this.activarid_ciudadEmpresa= activarid_ciudadEmpresa;
	}

	public Boolean getCargarid_ciudadEmpresa() {
		return this.cargarid_ciudadEmpresa;
	}

	public void setCargarid_ciudadEmpresa(Boolean cargarid_ciudadEmpresa) {
		this.cargarid_ciudadEmpresa= cargarid_ciudadEmpresa;
	}

	public Border setResaltarid_tipo_empresaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_tipo_empresaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_empresaEmpresa() {
		return this.resaltarid_tipo_empresaEmpresa;
	}

	public void setResaltarid_tipo_empresaEmpresa(Border borderResaltar) {
		this.resaltarid_tipo_empresaEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_tipo_empresaEmpresa() {
		return this.mostrarid_tipo_empresaEmpresa;
	}

	public void setMostrarid_tipo_empresaEmpresa(Boolean mostrarid_tipo_empresaEmpresa) {
		this.mostrarid_tipo_empresaEmpresa= mostrarid_tipo_empresaEmpresa;
	}

	public Boolean getActivarid_tipo_empresaEmpresa() {
		return this.activarid_tipo_empresaEmpresa;
	}

	public void setActivarid_tipo_empresaEmpresa(Boolean activarid_tipo_empresaEmpresa) {
		this.activarid_tipo_empresaEmpresa= activarid_tipo_empresaEmpresa;
	}

	public Boolean getCargarid_tipo_empresaEmpresa() {
		return this.cargarid_tipo_empresaEmpresa;
	}

	public void setCargarid_tipo_empresaEmpresa(Boolean cargarid_tipo_empresaEmpresa) {
		this.cargarid_tipo_empresaEmpresa= cargarid_tipo_empresaEmpresa;
	}

	public Border setResaltarnombreEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarnombreEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEmpresa() {
		return this.resaltarnombreEmpresa;
	}

	public void setResaltarnombreEmpresa(Border borderResaltar) {
		this.resaltarnombreEmpresa= borderResaltar;
	}

	public Boolean getMostrarnombreEmpresa() {
		return this.mostrarnombreEmpresa;
	}

	public void setMostrarnombreEmpresa(Boolean mostrarnombreEmpresa) {
		this.mostrarnombreEmpresa= mostrarnombreEmpresa;
	}

	public Boolean getActivarnombreEmpresa() {
		return this.activarnombreEmpresa;
	}

	public void setActivarnombreEmpresa(Boolean activarnombreEmpresa) {
		this.activarnombreEmpresa= activarnombreEmpresa;
	}

	public Border setResaltardireccionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltardireccionEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionEmpresa() {
		return this.resaltardireccionEmpresa;
	}

	public void setResaltardireccionEmpresa(Border borderResaltar) {
		this.resaltardireccionEmpresa= borderResaltar;
	}

	public Boolean getMostrardireccionEmpresa() {
		return this.mostrardireccionEmpresa;
	}

	public void setMostrardireccionEmpresa(Boolean mostrardireccionEmpresa) {
		this.mostrardireccionEmpresa= mostrardireccionEmpresa;
	}

	public Boolean getActivardireccionEmpresa() {
		return this.activardireccionEmpresa;
	}

	public void setActivardireccionEmpresa(Boolean activardireccionEmpresa) {
		this.activardireccionEmpresa= activardireccionEmpresa;
	}

	public Border setResaltarrucEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarrucEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucEmpresa() {
		return this.resaltarrucEmpresa;
	}

	public void setResaltarrucEmpresa(Border borderResaltar) {
		this.resaltarrucEmpresa= borderResaltar;
	}

	public Boolean getMostrarrucEmpresa() {
		return this.mostrarrucEmpresa;
	}

	public void setMostrarrucEmpresa(Boolean mostrarrucEmpresa) {
		this.mostrarrucEmpresa= mostrarrucEmpresa;
	}

	public Boolean getActivarrucEmpresa() {
		return this.activarrucEmpresa;
	}

	public void setActivarrucEmpresa(Boolean activarrucEmpresa) {
		this.activarrucEmpresa= activarrucEmpresa;
	}

	public Border setResaltarmailEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarmailEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmailEmpresa() {
		return this.resaltarmailEmpresa;
	}

	public void setResaltarmailEmpresa(Border borderResaltar) {
		this.resaltarmailEmpresa= borderResaltar;
	}

	public Boolean getMostrarmailEmpresa() {
		return this.mostrarmailEmpresa;
	}

	public void setMostrarmailEmpresa(Boolean mostrarmailEmpresa) {
		this.mostrarmailEmpresa= mostrarmailEmpresa;
	}

	public Boolean getActivarmailEmpresa() {
		return this.activarmailEmpresa;
	}

	public void setActivarmailEmpresa(Boolean activarmailEmpresa) {
		this.activarmailEmpresa= activarmailEmpresa;
	}

	public Border setResaltartelefonoEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltartelefonoEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoEmpresa() {
		return this.resaltartelefonoEmpresa;
	}

	public void setResaltartelefonoEmpresa(Border borderResaltar) {
		this.resaltartelefonoEmpresa= borderResaltar;
	}

	public Boolean getMostrartelefonoEmpresa() {
		return this.mostrartelefonoEmpresa;
	}

	public void setMostrartelefonoEmpresa(Boolean mostrartelefonoEmpresa) {
		this.mostrartelefonoEmpresa= mostrartelefonoEmpresa;
	}

	public Boolean getActivartelefonoEmpresa() {
		return this.activartelefonoEmpresa;
	}

	public void setActivartelefonoEmpresa(Boolean activartelefonoEmpresa) {
		this.activartelefonoEmpresa= activartelefonoEmpresa;
	}

	public Border setResaltarfaxEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarfaxEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfaxEmpresa() {
		return this.resaltarfaxEmpresa;
	}

	public void setResaltarfaxEmpresa(Border borderResaltar) {
		this.resaltarfaxEmpresa= borderResaltar;
	}

	public Boolean getMostrarfaxEmpresa() {
		return this.mostrarfaxEmpresa;
	}

	public void setMostrarfaxEmpresa(Boolean mostrarfaxEmpresa) {
		this.mostrarfaxEmpresa= mostrarfaxEmpresa;
	}

	public Boolean getActivarfaxEmpresa() {
		return this.activarfaxEmpresa;
	}

	public void setActivarfaxEmpresa(Boolean activarfaxEmpresa) {
		this.activarfaxEmpresa= activarfaxEmpresa;
	}

	public Border setResaltarcodigo_postalEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarcodigo_postalEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_postalEmpresa() {
		return this.resaltarcodigo_postalEmpresa;
	}

	public void setResaltarcodigo_postalEmpresa(Border borderResaltar) {
		this.resaltarcodigo_postalEmpresa= borderResaltar;
	}

	public Boolean getMostrarcodigo_postalEmpresa() {
		return this.mostrarcodigo_postalEmpresa;
	}

	public void setMostrarcodigo_postalEmpresa(Boolean mostrarcodigo_postalEmpresa) {
		this.mostrarcodigo_postalEmpresa= mostrarcodigo_postalEmpresa;
	}

	public Boolean getActivarcodigo_postalEmpresa() {
		return this.activarcodigo_postalEmpresa;
	}

	public void setActivarcodigo_postalEmpresa(Boolean activarcodigo_postalEmpresa) {
		this.activarcodigo_postalEmpresa= activarcodigo_postalEmpresa;
	}

	public Border setResaltarivaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarivaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaEmpresa() {
		return this.resaltarivaEmpresa;
	}

	public void setResaltarivaEmpresa(Border borderResaltar) {
		this.resaltarivaEmpresa= borderResaltar;
	}

	public Boolean getMostrarivaEmpresa() {
		return this.mostrarivaEmpresa;
	}

	public void setMostrarivaEmpresa(Boolean mostrarivaEmpresa) {
		this.mostrarivaEmpresa= mostrarivaEmpresa;
	}

	public Boolean getActivarivaEmpresa() {
		return this.activarivaEmpresa;
	}

	public void setActivarivaEmpresa(Boolean activarivaEmpresa) {
		this.activarivaEmpresa= activarivaEmpresa;
	}

	public Border setResaltaractividad_principalEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltaractividad_principalEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaractividad_principalEmpresa() {
		return this.resaltaractividad_principalEmpresa;
	}

	public void setResaltaractividad_principalEmpresa(Border borderResaltar) {
		this.resaltaractividad_principalEmpresa= borderResaltar;
	}

	public Boolean getMostraractividad_principalEmpresa() {
		return this.mostraractividad_principalEmpresa;
	}

	public void setMostraractividad_principalEmpresa(Boolean mostraractividad_principalEmpresa) {
		this.mostraractividad_principalEmpresa= mostraractividad_principalEmpresa;
	}

	public Boolean getActivaractividad_principalEmpresa() {
		return this.activaractividad_principalEmpresa;
	}

	public void setActivaractividad_principalEmpresa(Boolean activaractividad_principalEmpresa) {
		this.activaractividad_principalEmpresa= activaractividad_principalEmpresa;
	}

	public Border setResaltaractividad_secundariaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltaractividad_secundariaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaractividad_secundariaEmpresa() {
		return this.resaltaractividad_secundariaEmpresa;
	}

	public void setResaltaractividad_secundariaEmpresa(Border borderResaltar) {
		this.resaltaractividad_secundariaEmpresa= borderResaltar;
	}

	public Boolean getMostraractividad_secundariaEmpresa() {
		return this.mostraractividad_secundariaEmpresa;
	}

	public void setMostraractividad_secundariaEmpresa(Boolean mostraractividad_secundariaEmpresa) {
		this.mostraractividad_secundariaEmpresa= mostraractividad_secundariaEmpresa;
	}

	public Boolean getActivaractividad_secundariaEmpresa() {
		return this.activaractividad_secundariaEmpresa;
	}

	public void setActivaractividad_secundariaEmpresa(Boolean activaractividad_secundariaEmpresa) {
		this.activaractividad_secundariaEmpresa= activaractividad_secundariaEmpresa;
	}

	public Border setResaltarcontador_nombreEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarcontador_nombreEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcontador_nombreEmpresa() {
		return this.resaltarcontador_nombreEmpresa;
	}

	public void setResaltarcontador_nombreEmpresa(Border borderResaltar) {
		this.resaltarcontador_nombreEmpresa= borderResaltar;
	}

	public Boolean getMostrarcontador_nombreEmpresa() {
		return this.mostrarcontador_nombreEmpresa;
	}

	public void setMostrarcontador_nombreEmpresa(Boolean mostrarcontador_nombreEmpresa) {
		this.mostrarcontador_nombreEmpresa= mostrarcontador_nombreEmpresa;
	}

	public Boolean getActivarcontador_nombreEmpresa() {
		return this.activarcontador_nombreEmpresa;
	}

	public void setActivarcontador_nombreEmpresa(Boolean activarcontador_nombreEmpresa) {
		this.activarcontador_nombreEmpresa= activarcontador_nombreEmpresa;
	}

	public Border setResaltarcontador_rucEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarcontador_rucEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcontador_rucEmpresa() {
		return this.resaltarcontador_rucEmpresa;
	}

	public void setResaltarcontador_rucEmpresa(Border borderResaltar) {
		this.resaltarcontador_rucEmpresa= borderResaltar;
	}

	public Boolean getMostrarcontador_rucEmpresa() {
		return this.mostrarcontador_rucEmpresa;
	}

	public void setMostrarcontador_rucEmpresa(Boolean mostrarcontador_rucEmpresa) {
		this.mostrarcontador_rucEmpresa= mostrarcontador_rucEmpresa;
	}

	public Boolean getActivarcontador_rucEmpresa() {
		return this.activarcontador_rucEmpresa;
	}

	public void setActivarcontador_rucEmpresa(Boolean activarcontador_rucEmpresa) {
		this.activarcontador_rucEmpresa= activarcontador_rucEmpresa;
	}

	public Border setResaltarcontador_licenciaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarcontador_licenciaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcontador_licenciaEmpresa() {
		return this.resaltarcontador_licenciaEmpresa;
	}

	public void setResaltarcontador_licenciaEmpresa(Border borderResaltar) {
		this.resaltarcontador_licenciaEmpresa= borderResaltar;
	}

	public Boolean getMostrarcontador_licenciaEmpresa() {
		return this.mostrarcontador_licenciaEmpresa;
	}

	public void setMostrarcontador_licenciaEmpresa(Boolean mostrarcontador_licenciaEmpresa) {
		this.mostrarcontador_licenciaEmpresa= mostrarcontador_licenciaEmpresa;
	}

	public Boolean getActivarcontador_licenciaEmpresa() {
		return this.activarcontador_licenciaEmpresa;
	}

	public void setActivarcontador_licenciaEmpresa(Boolean activarcontador_licenciaEmpresa) {
		this.activarcontador_licenciaEmpresa= activarcontador_licenciaEmpresa;
	}

	public Border setResaltarrepresentante_nombreEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarrepresentante_nombreEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrepresentante_nombreEmpresa() {
		return this.resaltarrepresentante_nombreEmpresa;
	}

	public void setResaltarrepresentante_nombreEmpresa(Border borderResaltar) {
		this.resaltarrepresentante_nombreEmpresa= borderResaltar;
	}

	public Boolean getMostrarrepresentante_nombreEmpresa() {
		return this.mostrarrepresentante_nombreEmpresa;
	}

	public void setMostrarrepresentante_nombreEmpresa(Boolean mostrarrepresentante_nombreEmpresa) {
		this.mostrarrepresentante_nombreEmpresa= mostrarrepresentante_nombreEmpresa;
	}

	public Boolean getActivarrepresentante_nombreEmpresa() {
		return this.activarrepresentante_nombreEmpresa;
	}

	public void setActivarrepresentante_nombreEmpresa(Boolean activarrepresentante_nombreEmpresa) {
		this.activarrepresentante_nombreEmpresa= activarrepresentante_nombreEmpresa;
	}

	public Border setResaltarrepresentante_cedulaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltar);
		
		this.resaltarrepresentante_cedulaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrepresentante_cedulaEmpresa() {
		return this.resaltarrepresentante_cedulaEmpresa;
	}

	public void setResaltarrepresentante_cedulaEmpresa(Border borderResaltar) {
		this.resaltarrepresentante_cedulaEmpresa= borderResaltar;
	}

	public Boolean getMostrarrepresentante_cedulaEmpresa() {
		return this.mostrarrepresentante_cedulaEmpresa;
	}

	public void setMostrarrepresentante_cedulaEmpresa(Boolean mostrarrepresentante_cedulaEmpresa) {
		this.mostrarrepresentante_cedulaEmpresa= mostrarrepresentante_cedulaEmpresa;
	}

	public Boolean getActivarrepresentante_cedulaEmpresa() {
		return this.activarrepresentante_cedulaEmpresa;
	}

	public void setActivarrepresentante_cedulaEmpresa(Boolean activarrepresentante_cedulaEmpresa) {
		this.activarrepresentante_cedulaEmpresa= activarrepresentante_cedulaEmpresa;
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
		
		
		this.setMostraridEmpresa(esInicial);
		this.setMostrarid_paisEmpresa(esInicial);
		this.setMostrarid_ciudadEmpresa(esInicial);
		this.setMostrarid_tipo_empresaEmpresa(esInicial);
		this.setMostrarnombreEmpresa(esInicial);
		this.setMostrardireccionEmpresa(esInicial);
		this.setMostrarrucEmpresa(esInicial);
		this.setMostrarmailEmpresa(esInicial);
		this.setMostrartelefonoEmpresa(esInicial);
		this.setMostrarfaxEmpresa(esInicial);
		this.setMostrarcodigo_postalEmpresa(esInicial);
		this.setMostrarivaEmpresa(esInicial);
		this.setMostraractividad_principalEmpresa(esInicial);
		this.setMostraractividad_secundariaEmpresa(esInicial);
		this.setMostrarcontador_nombreEmpresa(esInicial);
		this.setMostrarcontador_rucEmpresa(esInicial);
		this.setMostrarcontador_licenciaEmpresa(esInicial);
		this.setMostrarrepresentante_nombreEmpresa(esInicial);
		this.setMostrarrepresentante_cedulaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpresaConstantesFunciones.ID)) {
				this.setMostraridEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.IDTIPOEMPRESA)) {
				this.setMostrarid_tipo_empresaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.RUC)) {
				this.setMostrarrucEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.MAIL)) {
				this.setMostrarmailEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.FAX)) {
				this.setMostrarfaxEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.CODIGOPOSTAL)) {
				this.setMostrarcodigo_postalEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.IVA)) {
				this.setMostrarivaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.ACTIVIDADPRINCIPAL)) {
				this.setMostraractividad_principalEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.ACTIVIDADSECUNDARIA)) {
				this.setMostraractividad_secundariaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.CONTADORNOMBRE)) {
				this.setMostrarcontador_nombreEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.CONTADORRUC)) {
				this.setMostrarcontador_rucEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.CONTADORLICENCIA)) {
				this.setMostrarcontador_licenciaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.REPRESENTANTENOMBRE)) {
				this.setMostrarrepresentante_nombreEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.REPRESENTANTECEDULA)) {
				this.setMostrarrepresentante_cedulaEmpresa(esAsigna);
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
		
		
		this.setActivaridEmpresa(esInicial);
		this.setActivarid_paisEmpresa(esInicial);
		this.setActivarid_ciudadEmpresa(esInicial);
		this.setActivarid_tipo_empresaEmpresa(esInicial);
		this.setActivarnombreEmpresa(esInicial);
		this.setActivardireccionEmpresa(esInicial);
		this.setActivarrucEmpresa(esInicial);
		this.setActivarmailEmpresa(esInicial);
		this.setActivartelefonoEmpresa(esInicial);
		this.setActivarfaxEmpresa(esInicial);
		this.setActivarcodigo_postalEmpresa(esInicial);
		this.setActivarivaEmpresa(esInicial);
		this.setActivaractividad_principalEmpresa(esInicial);
		this.setActivaractividad_secundariaEmpresa(esInicial);
		this.setActivarcontador_nombreEmpresa(esInicial);
		this.setActivarcontador_rucEmpresa(esInicial);
		this.setActivarcontador_licenciaEmpresa(esInicial);
		this.setActivarrepresentante_nombreEmpresa(esInicial);
		this.setActivarrepresentante_cedulaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpresaConstantesFunciones.ID)) {
				this.setActivaridEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.IDTIPOEMPRESA)) {
				this.setActivarid_tipo_empresaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.DIRECCION)) {
				this.setActivardireccionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.RUC)) {
				this.setActivarrucEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.MAIL)) {
				this.setActivarmailEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.FAX)) {
				this.setActivarfaxEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.CODIGOPOSTAL)) {
				this.setActivarcodigo_postalEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.IVA)) {
				this.setActivarivaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.ACTIVIDADPRINCIPAL)) {
				this.setActivaractividad_principalEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.ACTIVIDADSECUNDARIA)) {
				this.setActivaractividad_secundariaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.CONTADORNOMBRE)) {
				this.setActivarcontador_nombreEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.CONTADORRUC)) {
				this.setActivarcontador_rucEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.CONTADORLICENCIA)) {
				this.setActivarcontador_licenciaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.REPRESENTANTENOMBRE)) {
				this.setActivarrepresentante_nombreEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.REPRESENTANTECEDULA)) {
				this.setActivarrepresentante_cedulaEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpresa(esInicial);
		this.setResaltarid_paisEmpresa(esInicial);
		this.setResaltarid_ciudadEmpresa(esInicial);
		this.setResaltarid_tipo_empresaEmpresa(esInicial);
		this.setResaltarnombreEmpresa(esInicial);
		this.setResaltardireccionEmpresa(esInicial);
		this.setResaltarrucEmpresa(esInicial);
		this.setResaltarmailEmpresa(esInicial);
		this.setResaltartelefonoEmpresa(esInicial);
		this.setResaltarfaxEmpresa(esInicial);
		this.setResaltarcodigo_postalEmpresa(esInicial);
		this.setResaltarivaEmpresa(esInicial);
		this.setResaltaractividad_principalEmpresa(esInicial);
		this.setResaltaractividad_secundariaEmpresa(esInicial);
		this.setResaltarcontador_nombreEmpresa(esInicial);
		this.setResaltarcontador_rucEmpresa(esInicial);
		this.setResaltarcontador_licenciaEmpresa(esInicial);
		this.setResaltarrepresentante_nombreEmpresa(esInicial);
		this.setResaltarrepresentante_cedulaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpresaConstantesFunciones.ID)) {
				this.setResaltaridEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.IDTIPOEMPRESA)) {
				this.setResaltarid_tipo_empresaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.RUC)) {
				this.setResaltarrucEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.MAIL)) {
				this.setResaltarmailEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.FAX)) {
				this.setResaltarfaxEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.CODIGOPOSTAL)) {
				this.setResaltarcodigo_postalEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.IVA)) {
				this.setResaltarivaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.ACTIVIDADPRINCIPAL)) {
				this.setResaltaractividad_principalEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.ACTIVIDADSECUNDARIA)) {
				this.setResaltaractividad_secundariaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.CONTADORNOMBRE)) {
				this.setResaltarcontador_nombreEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.CONTADORRUC)) {
				this.setResaltarcontador_rucEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.CONTADORLICENCIA)) {
				this.setResaltarcontador_licenciaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.REPRESENTANTENOMBRE)) {
				this.setResaltarrepresentante_nombreEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaConstantesFunciones.REPRESENTANTECEDULA)) {
				this.setResaltarrepresentante_cedulaEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarSucursalEmpresa=null;

	public Border getResaltarSucursalEmpresa() {
		return this.resaltarSucursalEmpresa;
	}

	public void setResaltarSucursalEmpresa(Border borderResaltarSucursal) {
		if(borderResaltarSucursal!=null) {
			this.resaltarSucursalEmpresa= borderResaltarSucursal;
		}
	}

	public Border setResaltarSucursalEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltarSucursal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empresaBeanSwingJInternalFrame.jTtoolBarEmpresa.setBorder(borderResaltarSucursal);
			
		this.resaltarSucursalEmpresa= borderResaltarSucursal;

		 return borderResaltarSucursal;
	}



	public Boolean mostrarSucursalEmpresa=true;

	public Boolean getMostrarSucursalEmpresa() {
		return this.mostrarSucursalEmpresa;
	}

	public void setMostrarSucursalEmpresa(Boolean visibilidadResaltarSucursal) {
		this.mostrarSucursalEmpresa= visibilidadResaltarSucursal;
	}



	public Boolean activarSucursalEmpresa=true;

	public Boolean gethabilitarResaltarSucursalEmpresa() {
		return this.activarSucursalEmpresa;
	}

	public void setActivarSucursalEmpresa(Boolean habilitarResaltarSucursal) {
		this.activarSucursalEmpresa= habilitarResaltarSucursal;
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

		this.setMostrarSucursalEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Sucursal.class)) {
				this.setMostrarSucursalEmpresa(esAsigna);
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

		this.setActivarSucursalEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Sucursal.class)) {
				this.setActivarSucursalEmpresa(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarSucursalEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Sucursal.class)) {
				this.setResaltarSucursalEmpresa(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdPaisPorNombreEmpresa=true;

	public Boolean getMostrarBusquedaPorIdPaisPorNombreEmpresa() {
		return this.mostrarBusquedaPorIdPaisPorNombreEmpresa;
	}

	public void setMostrarBusquedaPorIdPaisPorNombreEmpresa(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdPaisPorNombreEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisEmpresa=true;

	public Boolean getMostrarFK_IdPaisEmpresa() {
		return this.mostrarFK_IdPaisEmpresa;
	}

	public void setMostrarFK_IdPaisEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisEmpresa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoEmpresaEmpresa=true;

	public Boolean getMostrarFK_IdTipoEmpresaEmpresa() {
		return this.mostrarFK_IdTipoEmpresaEmpresa;
	}

	public void setMostrarFK_IdTipoEmpresaEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoEmpresaEmpresa= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdPaisPorNombreEmpresa=true;

	public Boolean getActivarBusquedaPorIdPaisPorNombreEmpresa() {
		return this.activarBusquedaPorIdPaisPorNombreEmpresa;
	}

	public void setActivarBusquedaPorIdPaisPorNombreEmpresa(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdPaisPorNombreEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisEmpresa=true;

	public Boolean getActivarFK_IdPaisEmpresa() {
		return this.activarFK_IdPaisEmpresa;
	}

	public void setActivarFK_IdPaisEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdPaisEmpresa= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoEmpresaEmpresa=true;

	public Boolean getActivarFK_IdTipoEmpresaEmpresa() {
		return this.activarFK_IdTipoEmpresaEmpresa;
	}

	public void setActivarFK_IdTipoEmpresaEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdTipoEmpresaEmpresa= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdPaisPorNombreEmpresa=null;

	public Border getResaltarBusquedaPorIdPaisPorNombreEmpresa() {
		return this.resaltarBusquedaPorIdPaisPorNombreEmpresa;
	}

	public void setResaltarBusquedaPorIdPaisPorNombreEmpresa(Border borderResaltar) {
		this.resaltarBusquedaPorIdPaisPorNombreEmpresa= borderResaltar;
	}

	public void setResaltarBusquedaPorIdPaisPorNombreEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdPaisPorNombreEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdPaisEmpresa=null;

	public Border getResaltarFK_IdPaisEmpresa() {
		return this.resaltarFK_IdPaisEmpresa;
	}

	public void setResaltarFK_IdPaisEmpresa(Border borderResaltar) {
		this.resaltarFK_IdPaisEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdPaisEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisEmpresa= borderResaltar;
	}

	public Border resaltarFK_IdTipoEmpresaEmpresa=null;

	public Border getResaltarFK_IdTipoEmpresaEmpresa() {
		return this.resaltarFK_IdTipoEmpresaEmpresa;
	}

	public void setResaltarFK_IdTipoEmpresaEmpresa(Border borderResaltar) {
		this.resaltarFK_IdTipoEmpresaEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdTipoEmpresaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaBeanSwingJInternalFrame empresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoEmpresaEmpresa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}