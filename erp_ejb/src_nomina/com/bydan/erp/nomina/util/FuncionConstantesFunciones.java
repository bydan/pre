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


import com.bydan.erp.nomina.util.FuncionConstantesFunciones;
import com.bydan.erp.nomina.util.FuncionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.FuncionParameterGeneral;

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
final public class FuncionConstantesFunciones extends FuncionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Funcion";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Funcion"+FuncionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FuncionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FuncionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FuncionConstantesFunciones.SCHEMA+"_"+FuncionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FuncionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FuncionConstantesFunciones.SCHEMA+"_"+FuncionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FuncionConstantesFunciones.SCHEMA+"_"+FuncionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FuncionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FuncionConstantesFunciones.SCHEMA+"_"+FuncionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FuncionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FuncionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FuncionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FuncionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FuncionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FuncionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FuncionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FuncionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FuncionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FuncionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Funciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Funcion";
	public static final String SCLASSWEBTITULO_LOWER="Funcion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Funcion";
	public static final String OBJECTNAME="funcion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="funcion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select funcion from "+FuncionConstantesFunciones.SPERSISTENCENAME+" funcion";
	public static String QUERYSELECTNATIVE="select "+FuncionConstantesFunciones.SCHEMA+"."+FuncionConstantesFunciones.TABLENAME+".id,"+FuncionConstantesFunciones.SCHEMA+"."+FuncionConstantesFunciones.TABLENAME+".version_row,"+FuncionConstantesFunciones.SCHEMA+"."+FuncionConstantesFunciones.TABLENAME+".id_empresa,"+FuncionConstantesFunciones.SCHEMA+"."+FuncionConstantesFunciones.TABLENAME+".nombre,"+FuncionConstantesFunciones.SCHEMA+"."+FuncionConstantesFunciones.TABLENAME+".descripcion from "+FuncionConstantesFunciones.SCHEMA+"."+FuncionConstantesFunciones.TABLENAME;//+" as "+FuncionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FuncionConstantesFuncionesAdditional funcionConstantesFuncionesAdditional=null;
	
	public FuncionConstantesFuncionesAdditional getFuncionConstantesFuncionesAdditional() {
		return this.funcionConstantesFuncionesAdditional;
	}
	
	public void setFuncionConstantesFuncionesAdditional(FuncionConstantesFuncionesAdditional funcionConstantesFuncionesAdditional) {
		try {
			this.funcionConstantesFuncionesAdditional=funcionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getFuncionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FuncionConstantesFunciones.IDEMPRESA)) {sLabelColumna=FuncionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FuncionConstantesFunciones.NOMBRE)) {sLabelColumna=FuncionConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(FuncionConstantesFunciones.DESCRIPCION)) {sLabelColumna=FuncionConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getFuncionDescripcion(Funcion funcion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(funcion !=null/* && funcion.getId()!=0*/) {
			sDescripcion=funcion.getnombre();//funcionfuncion.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getFuncionDescripcionDetallado(Funcion funcion) {
		String sDescripcion="";
			
		sDescripcion+=FuncionConstantesFunciones.ID+"=";
		sDescripcion+=funcion.getId().toString()+",";
		sDescripcion+=FuncionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=funcion.getVersionRow().toString()+",";
		sDescripcion+=FuncionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=funcion.getid_empresa().toString()+",";
		sDescripcion+=FuncionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=funcion.getnombre()+",";
		sDescripcion+=FuncionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=funcion.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setFuncionDescripcion(Funcion funcion,String sValor) throws Exception {			
		if(funcion !=null) {
			funcion.setnombre(sValor);;//funcionfuncion.getnombre().trim();
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFuncion(Funcion funcion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		funcion.setnombre(funcion.getnombre().trim());
		funcion.setdescripcion(funcion.getdescripcion().trim());
	}
	
	public static void quitarEspaciosFuncions(List<Funcion> funcions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Funcion funcion: funcions) {
			funcion.setnombre(funcion.getnombre().trim());
			funcion.setdescripcion(funcion.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFuncion(Funcion funcion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && funcion.getConCambioAuxiliar()) {
			funcion.setIsDeleted(funcion.getIsDeletedAuxiliar());	
			funcion.setIsNew(funcion.getIsNewAuxiliar());	
			funcion.setIsChanged(funcion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			funcion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			funcion.setIsDeletedAuxiliar(false);	
			funcion.setIsNewAuxiliar(false);	
			funcion.setIsChangedAuxiliar(false);
			
			funcion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFuncions(List<Funcion> funcions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Funcion funcion : funcions) {
			if(conAsignarBase && funcion.getConCambioAuxiliar()) {
				funcion.setIsDeleted(funcion.getIsDeletedAuxiliar());	
				funcion.setIsNew(funcion.getIsNewAuxiliar());	
				funcion.setIsChanged(funcion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				funcion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				funcion.setIsDeletedAuxiliar(false);	
				funcion.setIsNewAuxiliar(false);	
				funcion.setIsChangedAuxiliar(false);
				
				funcion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFuncion(Funcion funcion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFuncions(List<Funcion> funcions,Boolean conEnteros) throws Exception  {
		
		for(Funcion funcion: funcions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFuncion(List<Funcion> funcions,Funcion funcionAux) throws Exception  {
		FuncionConstantesFunciones.InicializarValoresFuncion(funcionAux,true);
		
		for(Funcion funcion: funcions) {
			if(funcion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFuncion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FuncionConstantesFunciones.getArrayColumnasGlobalesFuncion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFuncion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FuncionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FuncionConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFuncion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Funcion> funcions,Funcion funcion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Funcion funcionAux: funcions) {
			if(funcionAux!=null && funcion!=null) {
				if((funcionAux.getId()==null && funcion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(funcionAux.getId()!=null && funcion.getId()!=null){
					if(funcionAux.getId().equals(funcion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFuncion(List<Funcion> funcions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Funcion funcion: funcions) {			
			if(funcion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFuncion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FuncionConstantesFunciones.LABEL_ID, FuncionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FuncionConstantesFunciones.LABEL_VERSIONROW, FuncionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FuncionConstantesFunciones.LABEL_IDEMPRESA, FuncionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FuncionConstantesFunciones.LABEL_NOMBRE, FuncionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FuncionConstantesFunciones.LABEL_DESCRIPCION, FuncionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFuncion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FuncionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FuncionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FuncionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FuncionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FuncionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFuncion() throws Exception  {
		return FuncionConstantesFunciones.getTiposSeleccionarFuncion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFuncion(Boolean conFk) throws Exception  {
		return FuncionConstantesFunciones.getTiposSeleccionarFuncion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFuncion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FuncionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FuncionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FuncionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(FuncionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FuncionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(FuncionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFuncion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFuncion(Funcion funcionAux) throws Exception {
		
			funcionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(funcionAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFuncion(List<Funcion> funcionsTemp) throws Exception {
		for(Funcion funcionAux:funcionsTemp) {
			
			funcionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(funcionAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFuncion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFuncion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFuncion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FuncionConstantesFunciones.getClassesRelationshipsOfFuncion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFuncion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FuncionEstruc.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FuncionEstruc.class)) {
						classes.add(new Classe(FuncionEstruc.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFuncion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FuncionConstantesFunciones.getClassesRelationshipsFromStringsOfFuncion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFuncion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FuncionEstruc.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FuncionEstruc.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FuncionEstruc.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FuncionEstruc.class)); continue;
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
	public static void actualizarLista(Funcion funcion,List<Funcion> funcions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Funcion funcionEncontrado=null;
			
			for(Funcion funcionLocal:funcions) {
				if(funcionLocal.getId().equals(funcion.getId())) {
					funcionEncontrado=funcionLocal;
					
					funcionLocal.setIsChanged(funcion.getIsChanged());
					funcionLocal.setIsNew(funcion.getIsNew());
					funcionLocal.setIsDeleted(funcion.getIsDeleted());
					
					funcionLocal.setGeneralEntityOriginal(funcion.getGeneralEntityOriginal());
					
					funcionLocal.setId(funcion.getId());	
					funcionLocal.setVersionRow(funcion.getVersionRow());	
					funcionLocal.setid_empresa(funcion.getid_empresa());	
					funcionLocal.setnombre(funcion.getnombre());	
					funcionLocal.setdescripcion(funcion.getdescripcion());	
					
					
					funcionLocal.setFuncionEstrucs(funcion.getFuncionEstrucs());
					
					existe=true;
					break;
				}
			}
			
			if(!funcion.getIsDeleted()) {
				if(!existe) {
					funcions.add(funcion);
				}
			} else {
				if(funcionEncontrado!=null && permiteQuitar)  {
					funcions.remove(funcionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Funcion funcion,List<Funcion> funcions) throws Exception {
		try	{			
			for(Funcion funcionLocal:funcions) {
				if(funcionLocal.getId().equals(funcion.getId())) {
					funcionLocal.setIsSelected(funcion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFuncion(List<Funcion> funcionsAux) throws Exception {
		//this.funcionsAux=funcionsAux;
		
		for(Funcion funcionAux:funcionsAux) {
			if(funcionAux.getIsChanged()) {
				funcionAux.setIsChanged(false);
			}		
			
			if(funcionAux.getIsNew()) {
				funcionAux.setIsNew(false);
			}	
			
			if(funcionAux.getIsDeleted()) {
				funcionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFuncion(Funcion funcionAux) throws Exception {
		//this.funcionAux=funcionAux;
		
			if(funcionAux.getIsChanged()) {
				funcionAux.setIsChanged(false);
			}		
			
			if(funcionAux.getIsNew()) {
				funcionAux.setIsNew(false);
			}	
			
			if(funcionAux.getIsDeleted()) {
				funcionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Funcion funcionAsignar,Funcion funcion) throws Exception {
		funcionAsignar.setId(funcion.getId());	
		funcionAsignar.setVersionRow(funcion.getVersionRow());	
		funcionAsignar.setid_empresa(funcion.getid_empresa());
		funcionAsignar.setempresa_descripcion(funcion.getempresa_descripcion());	
		funcionAsignar.setnombre(funcion.getnombre());	
		funcionAsignar.setdescripcion(funcion.getdescripcion());	
	}
	
	public static void inicializarFuncion(Funcion funcion) throws Exception {
		try {
				funcion.setId(0L);	
					
				funcion.setid_empresa(-1L);	
				funcion.setnombre("");	
				funcion.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFuncion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FuncionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FuncionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FuncionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFuncion(String sTipo,Row row,Workbook workbook,Funcion funcion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(funcion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(funcion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(funcion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFuncion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFuncion() {
		return this.sFinalQueryFuncion;
	}
	
	public void setsFinalQueryFuncion(String sFinalQueryFuncion) {
		this.sFinalQueryFuncion= sFinalQueryFuncion;
	}
	
	public Border resaltarSeleccionarFuncion=null;
	
	public Border setResaltarSeleccionarFuncion(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionBeanSwingJInternalFrame funcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//funcionBeanSwingJInternalFrame.jTtoolBarFuncion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFuncion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFuncion() {
		return this.resaltarSeleccionarFuncion;
	}
	
	public void setResaltarSeleccionarFuncion(Border borderResaltarSeleccionarFuncion) {
		this.resaltarSeleccionarFuncion= borderResaltarSeleccionarFuncion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFuncion=null;
	public Boolean mostraridFuncion=true;
	public Boolean activaridFuncion=true;

	public Border resaltarid_empresaFuncion=null;
	public Boolean mostrarid_empresaFuncion=true;
	public Boolean activarid_empresaFuncion=true;
	public Boolean cargarid_empresaFuncion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFuncion=false;//ConEventDepend=true

	public Border resaltarnombreFuncion=null;
	public Boolean mostrarnombreFuncion=true;
	public Boolean activarnombreFuncion=true;

	public Border resaltardescripcionFuncion=null;
	public Boolean mostrardescripcionFuncion=true;
	public Boolean activardescripcionFuncion=true;

	
	

	public Border setResaltaridFuncion(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionBeanSwingJInternalFrame funcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//funcionBeanSwingJInternalFrame.jTtoolBarFuncion.setBorder(borderResaltar);
		
		this.resaltaridFuncion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFuncion() {
		return this.resaltaridFuncion;
	}

	public void setResaltaridFuncion(Border borderResaltar) {
		this.resaltaridFuncion= borderResaltar;
	}

	public Boolean getMostraridFuncion() {
		return this.mostraridFuncion;
	}

	public void setMostraridFuncion(Boolean mostraridFuncion) {
		this.mostraridFuncion= mostraridFuncion;
	}

	public Boolean getActivaridFuncion() {
		return this.activaridFuncion;
	}

	public void setActivaridFuncion(Boolean activaridFuncion) {
		this.activaridFuncion= activaridFuncion;
	}

	public Border setResaltarid_empresaFuncion(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionBeanSwingJInternalFrame funcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//funcionBeanSwingJInternalFrame.jTtoolBarFuncion.setBorder(borderResaltar);
		
		this.resaltarid_empresaFuncion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFuncion() {
		return this.resaltarid_empresaFuncion;
	}

	public void setResaltarid_empresaFuncion(Border borderResaltar) {
		this.resaltarid_empresaFuncion= borderResaltar;
	}

	public Boolean getMostrarid_empresaFuncion() {
		return this.mostrarid_empresaFuncion;
	}

	public void setMostrarid_empresaFuncion(Boolean mostrarid_empresaFuncion) {
		this.mostrarid_empresaFuncion= mostrarid_empresaFuncion;
	}

	public Boolean getActivarid_empresaFuncion() {
		return this.activarid_empresaFuncion;
	}

	public void setActivarid_empresaFuncion(Boolean activarid_empresaFuncion) {
		this.activarid_empresaFuncion= activarid_empresaFuncion;
	}

	public Boolean getCargarid_empresaFuncion() {
		return this.cargarid_empresaFuncion;
	}

	public void setCargarid_empresaFuncion(Boolean cargarid_empresaFuncion) {
		this.cargarid_empresaFuncion= cargarid_empresaFuncion;
	}

	public Border setResaltarnombreFuncion(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionBeanSwingJInternalFrame funcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//funcionBeanSwingJInternalFrame.jTtoolBarFuncion.setBorder(borderResaltar);
		
		this.resaltarnombreFuncion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreFuncion() {
		return this.resaltarnombreFuncion;
	}

	public void setResaltarnombreFuncion(Border borderResaltar) {
		this.resaltarnombreFuncion= borderResaltar;
	}

	public Boolean getMostrarnombreFuncion() {
		return this.mostrarnombreFuncion;
	}

	public void setMostrarnombreFuncion(Boolean mostrarnombreFuncion) {
		this.mostrarnombreFuncion= mostrarnombreFuncion;
	}

	public Boolean getActivarnombreFuncion() {
		return this.activarnombreFuncion;
	}

	public void setActivarnombreFuncion(Boolean activarnombreFuncion) {
		this.activarnombreFuncion= activarnombreFuncion;
	}

	public Border setResaltardescripcionFuncion(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionBeanSwingJInternalFrame funcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//funcionBeanSwingJInternalFrame.jTtoolBarFuncion.setBorder(borderResaltar);
		
		this.resaltardescripcionFuncion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionFuncion() {
		return this.resaltardescripcionFuncion;
	}

	public void setResaltardescripcionFuncion(Border borderResaltar) {
		this.resaltardescripcionFuncion= borderResaltar;
	}

	public Boolean getMostrardescripcionFuncion() {
		return this.mostrardescripcionFuncion;
	}

	public void setMostrardescripcionFuncion(Boolean mostrardescripcionFuncion) {
		this.mostrardescripcionFuncion= mostrardescripcionFuncion;
	}

	public Boolean getActivardescripcionFuncion() {
		return this.activardescripcionFuncion;
	}

	public void setActivardescripcionFuncion(Boolean activardescripcionFuncion) {
		this.activardescripcionFuncion= activardescripcionFuncion;
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
		
		
		this.setMostraridFuncion(esInicial);
		this.setMostrarid_empresaFuncion(esInicial);
		this.setMostrarnombreFuncion(esInicial);
		this.setMostrardescripcionFuncion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FuncionConstantesFunciones.ID)) {
				this.setMostraridFuncion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFuncion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreFuncion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionFuncion(esAsigna);
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
		
		
		this.setActivaridFuncion(esInicial);
		this.setActivarid_empresaFuncion(esInicial);
		this.setActivarnombreFuncion(esInicial);
		this.setActivardescripcionFuncion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FuncionConstantesFunciones.ID)) {
				this.setActivaridFuncion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFuncion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreFuncion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionFuncion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FuncionBeanSwingJInternalFrame funcionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFuncion(esInicial);
		this.setResaltarid_empresaFuncion(esInicial);
		this.setResaltarnombreFuncion(esInicial);
		this.setResaltardescripcionFuncion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FuncionConstantesFunciones.ID)) {
				this.setResaltaridFuncion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFuncion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreFuncion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FuncionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionFuncion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFuncionEstrucFuncion=null;

	public Border getResaltarFuncionEstrucFuncion() {
		return this.resaltarFuncionEstrucFuncion;
	}

	public void setResaltarFuncionEstrucFuncion(Border borderResaltarFuncionEstruc) {
		if(borderResaltarFuncionEstruc!=null) {
			this.resaltarFuncionEstrucFuncion= borderResaltarFuncionEstruc;
		}
	}

	public Border setResaltarFuncionEstrucFuncion(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionBeanSwingJInternalFrame funcionBeanSwingJInternalFrame*/) {
		Border borderResaltarFuncionEstruc=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//funcionBeanSwingJInternalFrame.jTtoolBarFuncion.setBorder(borderResaltarFuncionEstruc);
			
		this.resaltarFuncionEstrucFuncion= borderResaltarFuncionEstruc;

		 return borderResaltarFuncionEstruc;
	}



	public Boolean mostrarFuncionEstrucFuncion=true;

	public Boolean getMostrarFuncionEstrucFuncion() {
		return this.mostrarFuncionEstrucFuncion;
	}

	public void setMostrarFuncionEstrucFuncion(Boolean visibilidadResaltarFuncionEstruc) {
		this.mostrarFuncionEstrucFuncion= visibilidadResaltarFuncionEstruc;
	}



	public Boolean activarFuncionEstrucFuncion=true;

	public Boolean gethabilitarResaltarFuncionEstrucFuncion() {
		return this.activarFuncionEstrucFuncion;
	}

	public void setActivarFuncionEstrucFuncion(Boolean habilitarResaltarFuncionEstruc) {
		this.activarFuncionEstrucFuncion= habilitarResaltarFuncionEstruc;
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

		this.setMostrarFuncionEstrucFuncion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FuncionEstruc.class)) {
				this.setMostrarFuncionEstrucFuncion(esAsigna);
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

		this.setActivarFuncionEstrucFuncion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FuncionEstruc.class)) {
				this.setActivarFuncionEstrucFuncion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FuncionBeanSwingJInternalFrame funcionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFuncionEstrucFuncion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FuncionEstruc.class)) {
				this.setResaltarFuncionEstrucFuncion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaFuncion=true;

	public Boolean getMostrarFK_IdEmpresaFuncion() {
		return this.mostrarFK_IdEmpresaFuncion;
	}

	public void setMostrarFK_IdEmpresaFuncion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFuncion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaFuncion=true;

	public Boolean getActivarFK_IdEmpresaFuncion() {
		return this.activarFK_IdEmpresaFuncion;
	}

	public void setActivarFK_IdEmpresaFuncion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFuncion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaFuncion=null;

	public Border getResaltarFK_IdEmpresaFuncion() {
		return this.resaltarFK_IdEmpresaFuncion;
	}

	public void setResaltarFK_IdEmpresaFuncion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFuncion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFuncion(ParametroGeneralUsuario parametroGeneralUsuario/*FuncionBeanSwingJInternalFrame funcionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFuncion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}