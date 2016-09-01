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


import com.bydan.erp.cartera.util.EMailConstantesFunciones;
import com.bydan.erp.cartera.util.EMailParameterReturnGeneral;
//import com.bydan.erp.cartera.util.EMailParameterGeneral;

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
final public class EMailConstantesFunciones extends EMailConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EMail";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EMail"+EMailConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EMailHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EMailHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EMailConstantesFunciones.SCHEMA+"_"+EMailConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EMailHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EMailConstantesFunciones.SCHEMA+"_"+EMailConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EMailConstantesFunciones.SCHEMA+"_"+EMailConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EMailHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EMailConstantesFunciones.SCHEMA+"_"+EMailConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EMailConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EMailHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EMailConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EMailConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EMailHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EMailConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EMailConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EMailConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EMailConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EMailConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="E Mailes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="E Mail";
	public static final String SCLASSWEBTITULO_LOWER="E Mail";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EMail";
	public static final String OBJECTNAME="email";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="e_mail";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select email from "+EMailConstantesFunciones.SPERSISTENCENAME+" email";
	public static String QUERYSELECTNATIVE="select "+EMailConstantesFunciones.SCHEMA+"."+EMailConstantesFunciones.TABLENAME+".id,"+EMailConstantesFunciones.SCHEMA+"."+EMailConstantesFunciones.TABLENAME+".version_row,"+EMailConstantesFunciones.SCHEMA+"."+EMailConstantesFunciones.TABLENAME+".id_empresa,"+EMailConstantesFunciones.SCHEMA+"."+EMailConstantesFunciones.TABLENAME+".id_cliente,"+EMailConstantesFunciones.SCHEMA+"."+EMailConstantesFunciones.TABLENAME+".e_mail,"+EMailConstantesFunciones.SCHEMA+"."+EMailConstantesFunciones.TABLENAME+".descripcion from "+EMailConstantesFunciones.SCHEMA+"."+EMailConstantesFunciones.TABLENAME;//+" as "+EMailConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EMailConstantesFuncionesAdditional emailConstantesFuncionesAdditional=null;
	
	public EMailConstantesFuncionesAdditional getEMailConstantesFuncionesAdditional() {
		return this.emailConstantesFuncionesAdditional;
	}
	
	public void setEMailConstantesFuncionesAdditional(EMailConstantesFuncionesAdditional emailConstantesFuncionesAdditional) {
		try {
			this.emailConstantesFuncionesAdditional=emailConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String EMAIL= "e_mail";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_EMAIL= "E Mail";
		public static final String LABEL_EMAIL_LOWER= "E Mail";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXE_MAIL=ConstantesValidacion.SREGEXCADENA_MAIL;
	public static final String SMENSAJEREGEXE_MAIL=ConstantesValidacion.SVALIDACIONCADENA_MAIL;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEMailLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EMailConstantesFunciones.IDEMPRESA)) {sLabelColumna=EMailConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EMailConstantesFunciones.IDCLIENTE)) {sLabelColumna=EMailConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(EMailConstantesFunciones.EMAIL)) {sLabelColumna=EMailConstantesFunciones.LABEL_EMAIL;}
		if(sNombreColumna.equals(EMailConstantesFunciones.DESCRIPCION)) {sLabelColumna=EMailConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getEMailDescripcion(EMail email) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(email !=null/* && email.getId()!=0*/) {
			sDescripcion=email.gete_mail();//emailemail.gete_mail().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEMailDescripcionDetallado(EMail email) {
		String sDescripcion="";
			
		sDescripcion+=EMailConstantesFunciones.ID+"=";
		sDescripcion+=email.getId().toString()+",";
		sDescripcion+=EMailConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=email.getVersionRow().toString()+",";
		sDescripcion+=EMailConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=email.getid_empresa().toString()+",";
		sDescripcion+=EMailConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=email.getid_cliente().toString()+",";
		sDescripcion+=EMailConstantesFunciones.EMAIL+"=";
		sDescripcion+=email.gete_mail()+",";
		sDescripcion+=EMailConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=email.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setEMailDescripcion(EMail email,String sValor) throws Exception {			
		if(email !=null) {
			email.sete_mail(sValor);;//emailemail.gete_mail().trim();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEMail(EMail email,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		email.sete_mail(email.gete_mail().trim());
		email.setdescripcion(email.getdescripcion().trim());
	}
	
	public static void quitarEspaciosEMails(List<EMail> emails,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EMail email: emails) {
			email.sete_mail(email.gete_mail().trim());
			email.setdescripcion(email.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEMail(EMail email,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && email.getConCambioAuxiliar()) {
			email.setIsDeleted(email.getIsDeletedAuxiliar());	
			email.setIsNew(email.getIsNewAuxiliar());	
			email.setIsChanged(email.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			email.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			email.setIsDeletedAuxiliar(false);	
			email.setIsNewAuxiliar(false);	
			email.setIsChangedAuxiliar(false);
			
			email.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEMails(List<EMail> emails,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EMail email : emails) {
			if(conAsignarBase && email.getConCambioAuxiliar()) {
				email.setIsDeleted(email.getIsDeletedAuxiliar());	
				email.setIsNew(email.getIsNewAuxiliar());	
				email.setIsChanged(email.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				email.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				email.setIsDeletedAuxiliar(false);	
				email.setIsNewAuxiliar(false);	
				email.setIsChangedAuxiliar(false);
				
				email.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEMail(EMail email,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEMails(List<EMail> emails,Boolean conEnteros) throws Exception  {
		
		for(EMail email: emails) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEMail(List<EMail> emails,EMail emailAux) throws Exception  {
		EMailConstantesFunciones.InicializarValoresEMail(emailAux,true);
		
		for(EMail email: emails) {
			if(email.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEMail(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EMailConstantesFunciones.getArrayColumnasGlobalesEMail(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEMail(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EMailConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EMailConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEMail(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EMail> emails,EMail email,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EMail emailAux: emails) {
			if(emailAux!=null && email!=null) {
				if((emailAux.getId()==null && email.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(emailAux.getId()!=null && email.getId()!=null){
					if(emailAux.getId().equals(email.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEMail(List<EMail> emails) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EMail email: emails) {			
			if(email.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEMail() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EMailConstantesFunciones.LABEL_ID, EMailConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EMailConstantesFunciones.LABEL_VERSIONROW, EMailConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EMailConstantesFunciones.LABEL_IDEMPRESA, EMailConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EMailConstantesFunciones.LABEL_IDCLIENTE, EMailConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EMailConstantesFunciones.LABEL_EMAIL, EMailConstantesFunciones.EMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EMailConstantesFunciones.LABEL_DESCRIPCION, EMailConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEMail() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EMailConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EMailConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EMailConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EMailConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EMailConstantesFunciones.EMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EMailConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEMail() throws Exception  {
		return EMailConstantesFunciones.getTiposSeleccionarEMail(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEMail(Boolean conFk) throws Exception  {
		return EMailConstantesFunciones.getTiposSeleccionarEMail(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEMail(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EMailConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EMailConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EMailConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(EMailConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EMailConstantesFunciones.LABEL_EMAIL);
			reporte.setsDescripcion(EMailConstantesFunciones.LABEL_EMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EMailConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(EMailConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEMail(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEMail(EMail emailAux) throws Exception {
		
			emailAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(emailAux.getEmpresa()));
			emailAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(emailAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEMail(List<EMail> emailsTemp) throws Exception {
		for(EMail emailAux:emailsTemp) {
			
			emailAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(emailAux.getEmpresa()));
			emailAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(emailAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEMail(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEMail(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEMail(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EMailConstantesFunciones.getClassesRelationshipsOfEMail(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEMail(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEMail(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EMailConstantesFunciones.getClassesRelationshipsFromStringsOfEMail(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEMail(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EMail email,List<EMail> emails,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EMail emailEncontrado=null;
			
			for(EMail emailLocal:emails) {
				if(emailLocal.getId().equals(email.getId())) {
					emailEncontrado=emailLocal;
					
					emailLocal.setIsChanged(email.getIsChanged());
					emailLocal.setIsNew(email.getIsNew());
					emailLocal.setIsDeleted(email.getIsDeleted());
					
					emailLocal.setGeneralEntityOriginal(email.getGeneralEntityOriginal());
					
					emailLocal.setId(email.getId());	
					emailLocal.setVersionRow(email.getVersionRow());	
					emailLocal.setid_empresa(email.getid_empresa());	
					emailLocal.setid_cliente(email.getid_cliente());	
					emailLocal.sete_mail(email.gete_mail());	
					emailLocal.setdescripcion(email.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!email.getIsDeleted()) {
				if(!existe) {
					emails.add(email);
				}
			} else {
				if(emailEncontrado!=null && permiteQuitar)  {
					emails.remove(emailEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EMail email,List<EMail> emails) throws Exception {
		try	{			
			for(EMail emailLocal:emails) {
				if(emailLocal.getId().equals(email.getId())) {
					emailLocal.setIsSelected(email.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEMail(List<EMail> emailsAux) throws Exception {
		//this.emailsAux=emailsAux;
		
		for(EMail emailAux:emailsAux) {
			if(emailAux.getIsChanged()) {
				emailAux.setIsChanged(false);
			}		
			
			if(emailAux.getIsNew()) {
				emailAux.setIsNew(false);
			}	
			
			if(emailAux.getIsDeleted()) {
				emailAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEMail(EMail emailAux) throws Exception {
		//this.emailAux=emailAux;
		
			if(emailAux.getIsChanged()) {
				emailAux.setIsChanged(false);
			}		
			
			if(emailAux.getIsNew()) {
				emailAux.setIsNew(false);
			}	
			
			if(emailAux.getIsDeleted()) {
				emailAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EMail emailAsignar,EMail email) throws Exception {
		emailAsignar.setId(email.getId());	
		emailAsignar.setVersionRow(email.getVersionRow());	
		emailAsignar.setid_empresa(email.getid_empresa());
		emailAsignar.setempresa_descripcion(email.getempresa_descripcion());	
		emailAsignar.setid_cliente(email.getid_cliente());
		emailAsignar.setcliente_descripcion(email.getcliente_descripcion());	
		emailAsignar.sete_mail(email.gete_mail());	
		emailAsignar.setdescripcion(email.getdescripcion());	
	}
	
	public static void inicializarEMail(EMail email) throws Exception {
		try {
				email.setId(0L);	
					
				email.setid_empresa(-1L);	
				email.setid_cliente(-1L);	
				email.sete_mail("");	
				email.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEMail(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EMailConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EMailConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EMailConstantesFunciones.LABEL_EMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EMailConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEMail(String sTipo,Row row,Workbook workbook,EMail email,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(email.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(email.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(email.gete_mail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(email.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEMail=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEMail() {
		return this.sFinalQueryEMail;
	}
	
	public void setsFinalQueryEMail(String sFinalQueryEMail) {
		this.sFinalQueryEMail= sFinalQueryEMail;
	}
	
	public Border resaltarSeleccionarEMail=null;
	
	public Border setResaltarSeleccionarEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EMailBeanSwingJInternalFrame emailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//emailBeanSwingJInternalFrame.jTtoolBarEMail.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEMail= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEMail() {
		return this.resaltarSeleccionarEMail;
	}
	
	public void setResaltarSeleccionarEMail(Border borderResaltarSeleccionarEMail) {
		this.resaltarSeleccionarEMail= borderResaltarSeleccionarEMail;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEMail=null;
	public Boolean mostraridEMail=true;
	public Boolean activaridEMail=true;

	public Border resaltarid_empresaEMail=null;
	public Boolean mostrarid_empresaEMail=true;
	public Boolean activarid_empresaEMail=true;
	public Boolean cargarid_empresaEMail=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEMail=false;//ConEventDepend=true

	public Border resaltarid_clienteEMail=null;
	public Boolean mostrarid_clienteEMail=true;
	public Boolean activarid_clienteEMail=true;
	public Boolean cargarid_clienteEMail=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteEMail=false;//ConEventDepend=true

	public Border resaltare_mailEMail=null;
	public Boolean mostrare_mailEMail=true;
	public Boolean activare_mailEMail=true;

	public Border resaltardescripcionEMail=null;
	public Boolean mostrardescripcionEMail=true;
	public Boolean activardescripcionEMail=true;

	
	

	public Border setResaltaridEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EMailBeanSwingJInternalFrame emailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//emailBeanSwingJInternalFrame.jTtoolBarEMail.setBorder(borderResaltar);
		
		this.resaltaridEMail= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEMail() {
		return this.resaltaridEMail;
	}

	public void setResaltaridEMail(Border borderResaltar) {
		this.resaltaridEMail= borderResaltar;
	}

	public Boolean getMostraridEMail() {
		return this.mostraridEMail;
	}

	public void setMostraridEMail(Boolean mostraridEMail) {
		this.mostraridEMail= mostraridEMail;
	}

	public Boolean getActivaridEMail() {
		return this.activaridEMail;
	}

	public void setActivaridEMail(Boolean activaridEMail) {
		this.activaridEMail= activaridEMail;
	}

	public Border setResaltarid_empresaEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EMailBeanSwingJInternalFrame emailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//emailBeanSwingJInternalFrame.jTtoolBarEMail.setBorder(borderResaltar);
		
		this.resaltarid_empresaEMail= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEMail() {
		return this.resaltarid_empresaEMail;
	}

	public void setResaltarid_empresaEMail(Border borderResaltar) {
		this.resaltarid_empresaEMail= borderResaltar;
	}

	public Boolean getMostrarid_empresaEMail() {
		return this.mostrarid_empresaEMail;
	}

	public void setMostrarid_empresaEMail(Boolean mostrarid_empresaEMail) {
		this.mostrarid_empresaEMail= mostrarid_empresaEMail;
	}

	public Boolean getActivarid_empresaEMail() {
		return this.activarid_empresaEMail;
	}

	public void setActivarid_empresaEMail(Boolean activarid_empresaEMail) {
		this.activarid_empresaEMail= activarid_empresaEMail;
	}

	public Boolean getCargarid_empresaEMail() {
		return this.cargarid_empresaEMail;
	}

	public void setCargarid_empresaEMail(Boolean cargarid_empresaEMail) {
		this.cargarid_empresaEMail= cargarid_empresaEMail;
	}

	public Border setResaltarid_clienteEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EMailBeanSwingJInternalFrame emailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//emailBeanSwingJInternalFrame.jTtoolBarEMail.setBorder(borderResaltar);
		
		this.resaltarid_clienteEMail= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteEMail() {
		return this.resaltarid_clienteEMail;
	}

	public void setResaltarid_clienteEMail(Border borderResaltar) {
		this.resaltarid_clienteEMail= borderResaltar;
	}

	public Boolean getMostrarid_clienteEMail() {
		return this.mostrarid_clienteEMail;
	}

	public void setMostrarid_clienteEMail(Boolean mostrarid_clienteEMail) {
		this.mostrarid_clienteEMail= mostrarid_clienteEMail;
	}

	public Boolean getActivarid_clienteEMail() {
		return this.activarid_clienteEMail;
	}

	public void setActivarid_clienteEMail(Boolean activarid_clienteEMail) {
		this.activarid_clienteEMail= activarid_clienteEMail;
	}

	public Boolean getCargarid_clienteEMail() {
		return this.cargarid_clienteEMail;
	}

	public void setCargarid_clienteEMail(Boolean cargarid_clienteEMail) {
		this.cargarid_clienteEMail= cargarid_clienteEMail;
	}

	public Border setResaltare_mailEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EMailBeanSwingJInternalFrame emailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//emailBeanSwingJInternalFrame.jTtoolBarEMail.setBorder(borderResaltar);
		
		this.resaltare_mailEMail= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltare_mailEMail() {
		return this.resaltare_mailEMail;
	}

	public void setResaltare_mailEMail(Border borderResaltar) {
		this.resaltare_mailEMail= borderResaltar;
	}

	public Boolean getMostrare_mailEMail() {
		return this.mostrare_mailEMail;
	}

	public void setMostrare_mailEMail(Boolean mostrare_mailEMail) {
		this.mostrare_mailEMail= mostrare_mailEMail;
	}

	public Boolean getActivare_mailEMail() {
		return this.activare_mailEMail;
	}

	public void setActivare_mailEMail(Boolean activare_mailEMail) {
		this.activare_mailEMail= activare_mailEMail;
	}

	public Border setResaltardescripcionEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EMailBeanSwingJInternalFrame emailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//emailBeanSwingJInternalFrame.jTtoolBarEMail.setBorder(borderResaltar);
		
		this.resaltardescripcionEMail= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionEMail() {
		return this.resaltardescripcionEMail;
	}

	public void setResaltardescripcionEMail(Border borderResaltar) {
		this.resaltardescripcionEMail= borderResaltar;
	}

	public Boolean getMostrardescripcionEMail() {
		return this.mostrardescripcionEMail;
	}

	public void setMostrardescripcionEMail(Boolean mostrardescripcionEMail) {
		this.mostrardescripcionEMail= mostrardescripcionEMail;
	}

	public Boolean getActivardescripcionEMail() {
		return this.activardescripcionEMail;
	}

	public void setActivardescripcionEMail(Boolean activardescripcionEMail) {
		this.activardescripcionEMail= activardescripcionEMail;
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
		
		
		this.setMostraridEMail(esInicial);
		this.setMostrarid_empresaEMail(esInicial);
		this.setMostrarid_clienteEMail(esInicial);
		this.setMostrare_mailEMail(esInicial);
		this.setMostrardescripcionEMail(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EMailConstantesFunciones.ID)) {
				this.setMostraridEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EMailConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EMailConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EMailConstantesFunciones.EMAIL)) {
				this.setMostrare_mailEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EMailConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionEMail(esAsigna);
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
		
		
		this.setActivaridEMail(esInicial);
		this.setActivarid_empresaEMail(esInicial);
		this.setActivarid_clienteEMail(esInicial);
		this.setActivare_mailEMail(esInicial);
		this.setActivardescripcionEMail(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EMailConstantesFunciones.ID)) {
				this.setActivaridEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EMailConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EMailConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EMailConstantesFunciones.EMAIL)) {
				this.setActivare_mailEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EMailConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionEMail(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EMailBeanSwingJInternalFrame emailBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEMail(esInicial);
		this.setResaltarid_empresaEMail(esInicial);
		this.setResaltarid_clienteEMail(esInicial);
		this.setResaltare_mailEMail(esInicial);
		this.setResaltardescripcionEMail(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EMailConstantesFunciones.ID)) {
				this.setResaltaridEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EMailConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EMailConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EMailConstantesFunciones.EMAIL)) {
				this.setResaltare_mailEMail(esAsigna);
				continue;
			}

			if(campo.clase.equals(EMailConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionEMail(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EMailBeanSwingJInternalFrame emailBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteEMail=true;

	public Boolean getMostrarFK_IdClienteEMail() {
		return this.mostrarFK_IdClienteEMail;
	}

	public void setMostrarFK_IdClienteEMail(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteEMail= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEMail=true;

	public Boolean getMostrarFK_IdEmpresaEMail() {
		return this.mostrarFK_IdEmpresaEMail;
	}

	public void setMostrarFK_IdEmpresaEMail(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEMail= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteEMail=true;

	public Boolean getActivarFK_IdClienteEMail() {
		return this.activarFK_IdClienteEMail;
	}

	public void setActivarFK_IdClienteEMail(Boolean habilitarResaltar) {
		this.activarFK_IdClienteEMail= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEMail=true;

	public Boolean getActivarFK_IdEmpresaEMail() {
		return this.activarFK_IdEmpresaEMail;
	}

	public void setActivarFK_IdEmpresaEMail(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEMail= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteEMail=null;

	public Border getResaltarFK_IdClienteEMail() {
		return this.resaltarFK_IdClienteEMail;
	}

	public void setResaltarFK_IdClienteEMail(Border borderResaltar) {
		this.resaltarFK_IdClienteEMail= borderResaltar;
	}

	public void setResaltarFK_IdClienteEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EMailBeanSwingJInternalFrame emailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteEMail= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEMail=null;

	public Border getResaltarFK_IdEmpresaEMail() {
		return this.resaltarFK_IdEmpresaEMail;
	}

	public void setResaltarFK_IdEmpresaEMail(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEMail= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEMail(ParametroGeneralUsuario parametroGeneralUsuario/*EMailBeanSwingJInternalFrame emailBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEMail= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}