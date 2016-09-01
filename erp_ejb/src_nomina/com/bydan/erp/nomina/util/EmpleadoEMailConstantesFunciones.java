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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.EmpleadoEMailConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoEMailParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoEMailParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EmpleadoEMailConstantesFunciones extends EmpleadoEMailConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EmpleadoEMail";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EmpleadoEMail"+EmpleadoEMailConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpleadoEMailHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpleadoEMailHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpleadoEMailConstantesFunciones.SCHEMA+"_"+EmpleadoEMailConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoEMailHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpleadoEMailConstantesFunciones.SCHEMA+"_"+EmpleadoEMailConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpleadoEMailConstantesFunciones.SCHEMA+"_"+EmpleadoEMailConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoEMailHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpleadoEMailConstantesFunciones.SCHEMA+"_"+EmpleadoEMailConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoEMailConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoEMailHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoEMailConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoEMailConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoEMailHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoEMailConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpleadoEMailConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpleadoEMailConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpleadoEMailConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpleadoEMailConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empleado Emails";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Empleado Email";
	public static final String SCLASSWEBTITULO_LOWER="Empleado E Mail";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EmpleadoEMail";
	public static final String OBJECTNAME="empleadoemail";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="empleado_e_mail";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empleadoemail from "+EmpleadoEMailConstantesFunciones.SPERSISTENCENAME+" empleadoemail";
	public static String QUERYSELECTNATIVE="select "+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".id,"+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".version_row,"+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".e_mail,"+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".descripcion,"+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".esta_activo from "+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME;//+" as "+EmpleadoEMailConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpleadoEMailConstantesFuncionesAdditional empleadoemailConstantesFuncionesAdditional=null;
	
	public EmpleadoEMailConstantesFuncionesAdditional getEmpleadoEMailConstantesFuncionesAdditional() {
		return this.empleadoemailConstantesFuncionesAdditional;
	}
	
	public void setEmpleadoEMailConstantesFuncionesAdditional(EmpleadoEMailConstantesFuncionesAdditional empleadoemailConstantesFuncionesAdditional) {
		try {
			this.empleadoemailConstantesFuncionesAdditional=empleadoemailConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String EMAIL= "e_mail";
    public static final String DESCRIPCION= "descripcion";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_EMAIL= "E Mail";
		public static final String LABEL_EMAIL_LOWER= "E Mail";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
	public static final String SREGEXE_MAIL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXE_MAIL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getEmpleadoEMailLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpleadoEMailConstantesFunciones.IDEMPRESA)) {sLabelColumna=EmpleadoEMailConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EmpleadoEMailConstantesFunciones.IDEMPLEADO)) {sLabelColumna=EmpleadoEMailConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(EmpleadoEMailConstantesFunciones.EMAIL)) {sLabelColumna=EmpleadoEMailConstantesFunciones.LABEL_EMAIL;}
		if(sNombreColumna.equals(EmpleadoEMailConstantesFunciones.DESCRIPCION)) {sLabelColumna=EmpleadoEMailConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(EmpleadoEMailConstantesFunciones.ESTAACTIVO)) {sLabelColumna=EmpleadoEMailConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(EmpleadoEMail empleadoemail) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!empleadoemail.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(EmpleadoEMail empleadoemail) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(empleadoemail.getId(),empleadoemail.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getEmpleadoEMailDescripcion(EmpleadoEMail empleadoemail) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empleadoemail !=null/* && empleadoemail.getId()!=0*/) {
			sDescripcion=empleadoemail.gete_mail();//empleadoemailempleadoemail.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpleadoEMailDescripcionDetallado(EmpleadoEMail empleadoemail) {
		String sDescripcion="";
			
		sDescripcion+=EmpleadoEMailConstantesFunciones.ID+"=";
		sDescripcion+=empleadoemail.getId().toString()+",";
		sDescripcion+=EmpleadoEMailConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empleadoemail.getVersionRow().toString()+",";
		sDescripcion+=EmpleadoEMailConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=empleadoemail.getid_empresa().toString()+",";
		sDescripcion+=EmpleadoEMailConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=empleadoemail.getid_empleado().toString()+",";
		sDescripcion+=EmpleadoEMailConstantesFunciones.EMAIL+"=";
		sDescripcion+=empleadoemail.gete_mail()+",";
		sDescripcion+=EmpleadoEMailConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=empleadoemail.getdescripcion()+",";
		sDescripcion+=EmpleadoEMailConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=empleadoemail.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpleadoEMailDescripcion(EmpleadoEMail empleadoemail,String sValor) throws Exception {			
		if(empleadoemail !=null) {
			empleadoemail.sete_mail(sValor);//empleadoemailempleadoemail.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosEmpleadoEMail(EmpleadoEMail empleadoemail,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		empleadoemail.sete_mail(empleadoemail.gete_mail().trim());
		empleadoemail.setdescripcion(empleadoemail.getdescripcion().trim());
	}
	
	public static void quitarEspaciosEmpleadoEMails(List<EmpleadoEMail> empleadoemails,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EmpleadoEMail empleadoemail: empleadoemails) {
			empleadoemail.sete_mail(empleadoemail.gete_mail().trim());
			empleadoemail.setdescripcion(empleadoemail.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoEMail(EmpleadoEMail empleadoemail,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empleadoemail.getConCambioAuxiliar()) {
			empleadoemail.setIsDeleted(empleadoemail.getIsDeletedAuxiliar());	
			empleadoemail.setIsNew(empleadoemail.getIsNewAuxiliar());	
			empleadoemail.setIsChanged(empleadoemail.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empleadoemail.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empleadoemail.setIsDeletedAuxiliar(false);	
			empleadoemail.setIsNewAuxiliar(false);	
			empleadoemail.setIsChangedAuxiliar(false);
			
			empleadoemail.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoEMails(List<EmpleadoEMail> empleadoemails,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EmpleadoEMail empleadoemail : empleadoemails) {
			if(conAsignarBase && empleadoemail.getConCambioAuxiliar()) {
				empleadoemail.setIsDeleted(empleadoemail.getIsDeletedAuxiliar());	
				empleadoemail.setIsNew(empleadoemail.getIsNewAuxiliar());	
				empleadoemail.setIsChanged(empleadoemail.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empleadoemail.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empleadoemail.setIsDeletedAuxiliar(false);	
				empleadoemail.setIsNewAuxiliar(false);	
				empleadoemail.setIsChangedAuxiliar(false);
				
				empleadoemail.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpleadoEMail(EmpleadoEMail empleadoemail,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEmpleadoEMails(List<EmpleadoEMail> empleadoemails,Boolean conEnteros) throws Exception  {
		
		for(EmpleadoEMail empleadoemail: empleadoemails) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpleadoEMail(List<EmpleadoEMail> empleadoemails,EmpleadoEMail empleadoemailAux) throws Exception  {
		EmpleadoEMailConstantesFunciones.InicializarValoresEmpleadoEMail(empleadoemailAux,true);
		
		for(EmpleadoEMail empleadoemail: empleadoemails) {
			if(empleadoemail.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoEMail(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpleadoEMailConstantesFunciones.getArrayColumnasGlobalesEmpleadoEMail(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoEMail(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoEMailConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoEMailConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpleadoEMail(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EmpleadoEMail> empleadoemails,EmpleadoEMail empleadoemail,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EmpleadoEMail empleadoemailAux: empleadoemails) {
			if(empleadoemailAux!=null && empleadoemail!=null) {
				if((empleadoemailAux.getId()==null && empleadoemail.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empleadoemailAux.getId()!=null && empleadoemail.getId()!=null){
					if(empleadoemailAux.getId().equals(empleadoemail.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpleadoEMail(List<EmpleadoEMail> empleadoemails) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EmpleadoEMail empleadoemail: empleadoemails) {			
			if(empleadoemail.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpleadoEMail() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpleadoEMailConstantesFunciones.LABEL_ID, EmpleadoEMailConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEMailConstantesFunciones.LABEL_VERSIONROW, EmpleadoEMailConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEMailConstantesFunciones.LABEL_IDEMPRESA, EmpleadoEMailConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEMailConstantesFunciones.LABEL_IDEMPLEADO, EmpleadoEMailConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEMailConstantesFunciones.LABEL_EMAIL, EmpleadoEMailConstantesFunciones.EMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEMailConstantesFunciones.LABEL_DESCRIPCION, EmpleadoEMailConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEMailConstantesFunciones.LABEL_ESTAACTIVO, EmpleadoEMailConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpleadoEMail() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEMailConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEMailConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEMailConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEMailConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEMailConstantesFunciones.EMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEMailConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEMailConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoEMail() throws Exception  {
		return EmpleadoEMailConstantesFunciones.getTiposSeleccionarEmpleadoEMail(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoEMail(Boolean conFk) throws Exception  {
		return EmpleadoEMailConstantesFunciones.getTiposSeleccionarEmpleadoEMail(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoEMail(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEMailConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EmpleadoEMailConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEMailConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(EmpleadoEMailConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEMailConstantesFunciones.LABEL_EMAIL);
			reporte.setsDescripcion(EmpleadoEMailConstantesFunciones.LABEL_EMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEMailConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(EmpleadoEMailConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEMailConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(EmpleadoEMailConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpleadoEMail(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoEMail(EmpleadoEMail empleadoemailAux) throws Exception {
		
			empleadoemailAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoemailAux.getEmpresa()));
			empleadoemailAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoemailAux.getEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoEMail(List<EmpleadoEMail> empleadoemailsTemp) throws Exception {
		for(EmpleadoEMail empleadoemailAux:empleadoemailsTemp) {
			
			empleadoemailAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoemailAux.getEmpresa()));
			empleadoemailAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoemailAux.getEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoEMail(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpleadoEMail(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoEMail(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoEMailConstantesFunciones.getClassesRelationshipsOfEmpleadoEMail(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoEMail(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoEMail(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoEMailConstantesFunciones.getClassesRelationshipsFromStringsOfEmpleadoEMail(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoEMail(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EmpleadoEMail empleadoemail,List<EmpleadoEMail> empleadoemails,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EmpleadoEMail empleadoemailEncontrado=null;
			
			for(EmpleadoEMail empleadoemailLocal:empleadoemails) {
				if(empleadoemailLocal.getId().equals(empleadoemail.getId())) {
					empleadoemailEncontrado=empleadoemailLocal;
					
					empleadoemailLocal.setIsChanged(empleadoemail.getIsChanged());
					empleadoemailLocal.setIsNew(empleadoemail.getIsNew());
					empleadoemailLocal.setIsDeleted(empleadoemail.getIsDeleted());
					
					empleadoemailLocal.setGeneralEntityOriginal(empleadoemail.getGeneralEntityOriginal());
					
					empleadoemailLocal.setId(empleadoemail.getId());	
					empleadoemailLocal.setVersionRow(empleadoemail.getVersionRow());	
					empleadoemailLocal.setid_empresa(empleadoemail.getid_empresa());	
					empleadoemailLocal.setid_empleado(empleadoemail.getid_empleado());	
					empleadoemailLocal.sete_mail(empleadoemail.gete_mail());	
					empleadoemailLocal.setdescripcion(empleadoemail.getdescripcion());	
					empleadoemailLocal.setesta_activo(empleadoemail.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!empleadoemail.getIsDeleted()) {
				if(!existe) {
					empleadoemails.add(empleadoemail);
				}
			} else {
				if(empleadoemailEncontrado!=null && permiteQuitar)  {
					empleadoemails.remove(empleadoemailEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EmpleadoEMail empleadoemail,List<EmpleadoEMail> empleadoemails) throws Exception {
		try	{			
			for(EmpleadoEMail empleadoemailLocal:empleadoemails) {
				if(empleadoemailLocal.getId().equals(empleadoemail.getId())) {
					empleadoemailLocal.setIsSelected(empleadoemail.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpleadoEMail(List<EmpleadoEMail> empleadoemailsAux) throws Exception {
		//this.empleadoemailsAux=empleadoemailsAux;
		
		for(EmpleadoEMail empleadoemailAux:empleadoemailsAux) {
			if(empleadoemailAux.getIsChanged()) {
				empleadoemailAux.setIsChanged(false);
			}		
			
			if(empleadoemailAux.getIsNew()) {
				empleadoemailAux.setIsNew(false);
			}	
			
			if(empleadoemailAux.getIsDeleted()) {
				empleadoemailAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpleadoEMail(EmpleadoEMail empleadoemailAux) throws Exception {
		//this.empleadoemailAux=empleadoemailAux;
		
			if(empleadoemailAux.getIsChanged()) {
				empleadoemailAux.setIsChanged(false);
			}		
			
			if(empleadoemailAux.getIsNew()) {
				empleadoemailAux.setIsNew(false);
			}	
			
			if(empleadoemailAux.getIsDeleted()) {
				empleadoemailAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EmpleadoEMail empleadoemailAsignar,EmpleadoEMail empleadoemail) throws Exception {
		empleadoemailAsignar.setId(empleadoemail.getId());	
		empleadoemailAsignar.setVersionRow(empleadoemail.getVersionRow());	
		empleadoemailAsignar.setid_empresa(empleadoemail.getid_empresa());
		empleadoemailAsignar.setempresa_descripcion(empleadoemail.getempresa_descripcion());	
		empleadoemailAsignar.setid_empleado(empleadoemail.getid_empleado());
		empleadoemailAsignar.setempleado_descripcion(empleadoemail.getempleado_descripcion());	
		empleadoemailAsignar.sete_mail(empleadoemail.gete_mail());	
		empleadoemailAsignar.setdescripcion(empleadoemail.getdescripcion());	
		empleadoemailAsignar.setesta_activo(empleadoemail.getesta_activo());	
	}
	
	public static void inicializarEmpleadoEMail(EmpleadoEMail empleadoemail) throws Exception {
		try {
				empleadoemail.setId(0L);	
					
				empleadoemail.setid_empresa(-1L);	
				empleadoemail.setid_empleado(-1L);	
				empleadoemail.sete_mail("");	
				empleadoemail.setdescripcion("");	
				empleadoemail.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpleadoEMail(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEMailConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEMailConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEMailConstantesFunciones.LABEL_EMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEMailConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEMailConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpleadoEMail(String sTipo,Row row,Workbook workbook,EmpleadoEMail empleadoemail,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoemail.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoemail.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoemail.gete_mail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoemail.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(empleadoemail.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpleadoEMail=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpleadoEMail() {
		return this.sFinalQueryEmpleadoEMail;
	}
	
	public void setsFinalQueryEmpleadoEMail(String sFinalQueryEmpleadoEMail) {
		this.sFinalQueryEmpleadoEMail= sFinalQueryEmpleadoEMail;
	}
	
	public Border resaltarSeleccionarEmpleadoEMail=null;
	
	public Border setResaltarSeleccionarEmpleadoEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEMailBeanSwingJInternalFrame empleadoemailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empleadoemailBeanSwingJInternalFrame.jTtoolBarEmpleadoEMail.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpleadoEMail= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpleadoEMail() {
		return this.resaltarSeleccionarEmpleadoEMail;
	}
	
	public void setResaltarSeleccionarEmpleadoEMail(Border borderResaltarSeleccionarEmpleadoEMail) {
		this.resaltarSeleccionarEmpleadoEMail= borderResaltarSeleccionarEmpleadoEMail;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpleadoEMail=null;
	public Boolean mostraridEmpleadoEMail=true;
	public Boolean activaridEmpleadoEMail=true;

	public Border resaltarid_empresaEmpleadoEMail=null;
	public Boolean mostrarid_empresaEmpleadoEMail=true;
	public Boolean activarid_empresaEmpleadoEMail=true;
	public Boolean cargarid_empresaEmpleadoEMail=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEmpleadoEMail=false;//ConEventDepend=true

	public Border resaltarid_empleadoEmpleadoEMail=null;
	public Boolean mostrarid_empleadoEmpleadoEMail=true;
	public Boolean activarid_empleadoEmpleadoEMail=true;
	public Boolean cargarid_empleadoEmpleadoEMail=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoEmpleadoEMail=false;//ConEventDepend=true

	public Border resaltare_mailEmpleadoEMail=null;
	public Boolean mostrare_mailEmpleadoEMail=true;
	public Boolean activare_mailEmpleadoEMail=true;

	public Border resaltardescripcionEmpleadoEMail=null;
	public Boolean mostrardescripcionEmpleadoEMail=true;
	public Boolean activardescripcionEmpleadoEMail=true;

	public Border resaltaresta_activoEmpleadoEMail=null;
	public Boolean mostraresta_activoEmpleadoEMail=true;
	public Boolean activaresta_activoEmpleadoEMail=true;

	
	

	public Border setResaltaridEmpleadoEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEMailBeanSwingJInternalFrame empleadoemailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoemailBeanSwingJInternalFrame.jTtoolBarEmpleadoEMail.setBorder(borderResaltar);
		
		this.resaltaridEmpleadoEMail= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpleadoEMail() {
		return this.resaltaridEmpleadoEMail;
	}

	public void setResaltaridEmpleadoEMail(Border borderResaltar) {
		this.resaltaridEmpleadoEMail= borderResaltar;
	}

	public Boolean getMostraridEmpleadoEMail() {
		return this.mostraridEmpleadoEMail;
	}

	public void setMostraridEmpleadoEMail(Boolean mostraridEmpleadoEMail) {
		this.mostraridEmpleadoEMail= mostraridEmpleadoEMail;
	}

	public Boolean getActivaridEmpleadoEMail() {
		return this.activaridEmpleadoEMail;
	}

	public void setActivaridEmpleadoEMail(Boolean activaridEmpleadoEMail) {
		this.activaridEmpleadoEMail= activaridEmpleadoEMail;
	}

	public Border setResaltarid_empresaEmpleadoEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEMailBeanSwingJInternalFrame empleadoemailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoemailBeanSwingJInternalFrame.jTtoolBarEmpleadoEMail.setBorder(borderResaltar);
		
		this.resaltarid_empresaEmpleadoEMail= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEmpleadoEMail() {
		return this.resaltarid_empresaEmpleadoEMail;
	}

	public void setResaltarid_empresaEmpleadoEMail(Border borderResaltar) {
		this.resaltarid_empresaEmpleadoEMail= borderResaltar;
	}

	public Boolean getMostrarid_empresaEmpleadoEMail() {
		return this.mostrarid_empresaEmpleadoEMail;
	}

	public void setMostrarid_empresaEmpleadoEMail(Boolean mostrarid_empresaEmpleadoEMail) {
		this.mostrarid_empresaEmpleadoEMail= mostrarid_empresaEmpleadoEMail;
	}

	public Boolean getActivarid_empresaEmpleadoEMail() {
		return this.activarid_empresaEmpleadoEMail;
	}

	public void setActivarid_empresaEmpleadoEMail(Boolean activarid_empresaEmpleadoEMail) {
		this.activarid_empresaEmpleadoEMail= activarid_empresaEmpleadoEMail;
	}

	public Boolean getCargarid_empresaEmpleadoEMail() {
		return this.cargarid_empresaEmpleadoEMail;
	}

	public void setCargarid_empresaEmpleadoEMail(Boolean cargarid_empresaEmpleadoEMail) {
		this.cargarid_empresaEmpleadoEMail= cargarid_empresaEmpleadoEMail;
	}

	public Border setResaltarid_empleadoEmpleadoEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEMailBeanSwingJInternalFrame empleadoemailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoemailBeanSwingJInternalFrame.jTtoolBarEmpleadoEMail.setBorder(borderResaltar);
		
		this.resaltarid_empleadoEmpleadoEMail= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoEmpleadoEMail() {
		return this.resaltarid_empleadoEmpleadoEMail;
	}

	public void setResaltarid_empleadoEmpleadoEMail(Border borderResaltar) {
		this.resaltarid_empleadoEmpleadoEMail= borderResaltar;
	}

	public Boolean getMostrarid_empleadoEmpleadoEMail() {
		return this.mostrarid_empleadoEmpleadoEMail;
	}

	public void setMostrarid_empleadoEmpleadoEMail(Boolean mostrarid_empleadoEmpleadoEMail) {
		this.mostrarid_empleadoEmpleadoEMail= mostrarid_empleadoEmpleadoEMail;
	}

	public Boolean getActivarid_empleadoEmpleadoEMail() {
		return this.activarid_empleadoEmpleadoEMail;
	}

	public void setActivarid_empleadoEmpleadoEMail(Boolean activarid_empleadoEmpleadoEMail) {
		this.activarid_empleadoEmpleadoEMail= activarid_empleadoEmpleadoEMail;
	}

	public Boolean getCargarid_empleadoEmpleadoEMail() {
		return this.cargarid_empleadoEmpleadoEMail;
	}

	public void setCargarid_empleadoEmpleadoEMail(Boolean cargarid_empleadoEmpleadoEMail) {
		this.cargarid_empleadoEmpleadoEMail= cargarid_empleadoEmpleadoEMail;
	}

	public Border setResaltare_mailEmpleadoEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEMailBeanSwingJInternalFrame empleadoemailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoemailBeanSwingJInternalFrame.jTtoolBarEmpleadoEMail.setBorder(borderResaltar);
		
		this.resaltare_mailEmpleadoEMail= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltare_mailEmpleadoEMail() {
		return this.resaltare_mailEmpleadoEMail;
	}

	public void setResaltare_mailEmpleadoEMail(Border borderResaltar) {
		this.resaltare_mailEmpleadoEMail= borderResaltar;
	}

	public Boolean getMostrare_mailEmpleadoEMail() {
		return this.mostrare_mailEmpleadoEMail;
	}

	public void setMostrare_mailEmpleadoEMail(Boolean mostrare_mailEmpleadoEMail) {
		this.mostrare_mailEmpleadoEMail= mostrare_mailEmpleadoEMail;
	}

	public Boolean getActivare_mailEmpleadoEMail() {
		return this.activare_mailEmpleadoEMail;
	}

	public void setActivare_mailEmpleadoEMail(Boolean activare_mailEmpleadoEMail) {
		this.activare_mailEmpleadoEMail= activare_mailEmpleadoEMail;
	}

	public Border setResaltardescripcionEmpleadoEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEMailBeanSwingJInternalFrame empleadoemailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoemailBeanSwingJInternalFrame.jTtoolBarEmpleadoEMail.setBorder(borderResaltar);
		
		this.resaltardescripcionEmpleadoEMail= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionEmpleadoEMail() {
		return this.resaltardescripcionEmpleadoEMail;
	}

	public void setResaltardescripcionEmpleadoEMail(Border borderResaltar) {
		this.resaltardescripcionEmpleadoEMail= borderResaltar;
	}

	public Boolean getMostrardescripcionEmpleadoEMail() {
		return this.mostrardescripcionEmpleadoEMail;
	}

	public void setMostrardescripcionEmpleadoEMail(Boolean mostrardescripcionEmpleadoEMail) {
		this.mostrardescripcionEmpleadoEMail= mostrardescripcionEmpleadoEMail;
	}

	public Boolean getActivardescripcionEmpleadoEMail() {
		return this.activardescripcionEmpleadoEMail;
	}

	public void setActivardescripcionEmpleadoEMail(Boolean activardescripcionEmpleadoEMail) {
		this.activardescripcionEmpleadoEMail= activardescripcionEmpleadoEMail;
	}

	public Border setResaltaresta_activoEmpleadoEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEMailBeanSwingJInternalFrame empleadoemailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoemailBeanSwingJInternalFrame.jTtoolBarEmpleadoEMail.setBorder(borderResaltar);
		
		this.resaltaresta_activoEmpleadoEMail= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoEmpleadoEMail() {
		return this.resaltaresta_activoEmpleadoEMail;
	}

	public void setResaltaresta_activoEmpleadoEMail(Border borderResaltar) {
		this.resaltaresta_activoEmpleadoEMail= borderResaltar;
	}

	public Boolean getMostraresta_activoEmpleadoEMail() {
		return this.mostraresta_activoEmpleadoEMail;
	}

	public void setMostraresta_activoEmpleadoEMail(Boolean mostraresta_activoEmpleadoEMail) {
		this.mostraresta_activoEmpleadoEMail= mostraresta_activoEmpleadoEMail;
	}

	public Boolean getActivaresta_activoEmpleadoEMail() {
		return this.activaresta_activoEmpleadoEMail;
	}

	public void setActivaresta_activoEmpleadoEMail(Boolean activaresta_activoEmpleadoEMail) {
		this.activaresta_activoEmpleadoEMail= activaresta_activoEmpleadoEMail;
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
		
		
		this.setMostraridEmpleadoEMail(esInicial);
		this.setMostrarid_empresaEmpleadoEMail(esInicial);
		this.setMostrarid_empleadoEmpleadoEMail(esInicial);
		this.setMostrare_mailEmpleadoEMail(esInicial);
		this.setMostrardescripcionEmpleadoEMail(esInicial);
		this.setMostraresta_activoEmpleadoEMail(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.ID)) {
				this.setMostraridEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.EMAIL)) {
				this.setMostrare_mailEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoEmpleadoEMail(esAsigna);
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
		
		
		this.setActivaridEmpleadoEMail(esInicial);
		this.setActivarid_empresaEmpleadoEMail(esInicial);
		this.setActivarid_empleadoEmpleadoEMail(esInicial);
		this.setActivare_mailEmpleadoEMail(esInicial);
		this.setActivardescripcionEmpleadoEMail(esInicial);
		this.setActivaresta_activoEmpleadoEMail(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.ID)) {
				this.setActivaridEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.EMAIL)) {
				this.setActivare_mailEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoEmpleadoEMail(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoEMailBeanSwingJInternalFrame empleadoemailBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpleadoEMail(esInicial);
		this.setResaltarid_empresaEmpleadoEMail(esInicial);
		this.setResaltarid_empleadoEmpleadoEMail(esInicial);
		this.setResaltare_mailEmpleadoEMail(esInicial);
		this.setResaltardescripcionEmpleadoEMail(esInicial);
		this.setResaltaresta_activoEmpleadoEMail(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.ID)) {
				this.setResaltaridEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.EMAIL)) {
				this.setResaltare_mailEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionEmpleadoEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEMailConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoEmpleadoEMail(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoEMailBeanSwingJInternalFrame empleadoemailBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoEmpleadoEMail=true;

	public Boolean getMostrarFK_IdEmpleadoEmpleadoEMail() {
		return this.mostrarFK_IdEmpleadoEmpleadoEMail;
	}

	public void setMostrarFK_IdEmpleadoEmpleadoEMail(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEmpleadoEMail= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEmpleadoEMail=true;

	public Boolean getMostrarFK_IdEmpresaEmpleadoEMail() {
		return this.mostrarFK_IdEmpresaEmpleadoEMail;
	}

	public void setMostrarFK_IdEmpresaEmpleadoEMail(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEmpleadoEMail= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoEmpleadoEMail=true;

	public Boolean getActivarFK_IdEmpleadoEmpleadoEMail() {
		return this.activarFK_IdEmpleadoEmpleadoEMail;
	}

	public void setActivarFK_IdEmpleadoEmpleadoEMail(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEmpleadoEMail= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEmpleadoEMail=true;

	public Boolean getActivarFK_IdEmpresaEmpleadoEMail() {
		return this.activarFK_IdEmpresaEmpleadoEMail;
	}

	public void setActivarFK_IdEmpresaEmpleadoEMail(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEmpleadoEMail= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoEmpleadoEMail=null;

	public Border getResaltarFK_IdEmpleadoEmpleadoEMail() {
		return this.resaltarFK_IdEmpleadoEmpleadoEMail;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoEMail(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEmpleadoEMail= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEMailBeanSwingJInternalFrame empleadoemailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEmpleadoEMail= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEmpleadoEMail=null;

	public Border getResaltarFK_IdEmpresaEmpleadoEMail() {
		return this.resaltarFK_IdEmpresaEmpleadoEMail;
	}

	public void setResaltarFK_IdEmpresaEmpleadoEMail(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEmpleadoEMail= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEmpleadoEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEMailBeanSwingJInternalFrame empleadoemailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEmpleadoEMail= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}