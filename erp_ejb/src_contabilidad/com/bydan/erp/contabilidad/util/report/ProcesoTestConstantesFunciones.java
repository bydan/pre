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
package com.bydan.erp.contabilidad.util.report;

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


import com.bydan.erp.contabilidad.util.report.ProcesoTestConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.ProcesoTestParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ProcesoTestParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoTestConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoTest";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoTest"+ProcesoTestConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoTestHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoTestHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoTestConstantesFunciones.SCHEMA+"_"+ProcesoTestConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoTestHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoTestConstantesFunciones.SCHEMA+"_"+ProcesoTestConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoTestConstantesFunciones.SCHEMA+"_"+ProcesoTestConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoTestHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoTestConstantesFunciones.SCHEMA+"_"+ProcesoTestConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoTestConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoTestHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoTestConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoTestConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoTestHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoTestConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoTestConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoTestConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoTestConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoTestConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Testes";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Test";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Test";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoTest";
	public static final String OBJECTNAME="procesotest";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="proceso_test";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesotest from "+ProcesoTestConstantesFunciones.SPERSISTENCENAME+" procesotest";
	public static String QUERYSELECTNATIVE="select "+ProcesoTestConstantesFunciones.SCHEMA+"."+ProcesoTestConstantesFunciones.TABLENAME+".id,"+ProcesoTestConstantesFunciones.SCHEMA+"."+ProcesoTestConstantesFunciones.TABLENAME+".version_row,"+ProcesoTestConstantesFunciones.SCHEMA+"."+ProcesoTestConstantesFunciones.TABLENAME+".id_empresa,"+ProcesoTestConstantesFunciones.SCHEMA+"."+ProcesoTestConstantesFunciones.TABLENAME+".id_modulo,"+ProcesoTestConstantesFunciones.SCHEMA+"."+ProcesoTestConstantesFunciones.TABLENAME+".nombre from "+ProcesoTestConstantesFunciones.SCHEMA+"."+ProcesoTestConstantesFunciones.TABLENAME;//+" as "+ProcesoTestConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDMODULO= "id_modulo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProcesoTestLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoTestConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProcesoTestConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProcesoTestConstantesFunciones.IDMODULO)) {sLabelColumna=ProcesoTestConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(ProcesoTestConstantesFunciones.NOMBRE)) {sLabelColumna=ProcesoTestConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getProcesoTestDescripcion(ProcesoTest procesotest) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesotest !=null/* && procesotest.getId()!=0*/) {
			if(procesotest.getId()!=null) {
				sDescripcion=procesotest.getId().toString();
			}//procesotestprocesotest.getId().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoTestDescripcionDetallado(ProcesoTest procesotest) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoTestConstantesFunciones.ID+"=";
		sDescripcion+=procesotest.getId().toString()+",";
		sDescripcion+=ProcesoTestConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesotest.getVersionRow().toString()+",";
		sDescripcion+=ProcesoTestConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=procesotest.getid_empresa().toString()+",";
		sDescripcion+=ProcesoTestConstantesFunciones.IDMODULO+"=";
		sDescripcion+=procesotest.getid_modulo().toString()+",";
		sDescripcion+=ProcesoTestConstantesFunciones.NOMBRE+"=";
		sDescripcion+=procesotest.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoTestDescripcion(ProcesoTest procesotest,String sValor) throws Exception {			
		if(procesotest !=null) {
			;//procesotestprocesotest.getId().toString().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdEmpresaPorIdModulo")) {
			sNombreIndice="Tipo=  Por Empresa Por Modulo Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdEmpresaPorIdModulo(Long id_empresa,Long id_modulo,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoTest(ProcesoTest procesotest,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoTests(List<ProcesoTest> procesotests,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoTest procesotest: procesotests) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoTest(ProcesoTest procesotest,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesotest.getConCambioAuxiliar()) {
			procesotest.setIsDeleted(procesotest.getIsDeletedAuxiliar());	
			procesotest.setIsNew(procesotest.getIsNewAuxiliar());	
			procesotest.setIsChanged(procesotest.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesotest.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesotest.setIsDeletedAuxiliar(false);	
			procesotest.setIsNewAuxiliar(false);	
			procesotest.setIsChangedAuxiliar(false);
			
			procesotest.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoTests(List<ProcesoTest> procesotests,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoTest procesotest : procesotests) {
			if(conAsignarBase && procesotest.getConCambioAuxiliar()) {
				procesotest.setIsDeleted(procesotest.getIsDeletedAuxiliar());	
				procesotest.setIsNew(procesotest.getIsNewAuxiliar());	
				procesotest.setIsChanged(procesotest.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesotest.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesotest.setIsDeletedAuxiliar(false);	
				procesotest.setIsNewAuxiliar(false);	
				procesotest.setIsChangedAuxiliar(false);
				
				procesotest.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoTest(ProcesoTest procesotest,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoTests(List<ProcesoTest> procesotests,Boolean conEnteros) throws Exception  {
		
		for(ProcesoTest procesotest: procesotests) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoTest(List<ProcesoTest> procesotests,ProcesoTest procesotestAux) throws Exception  {
		ProcesoTestConstantesFunciones.InicializarValoresProcesoTest(procesotestAux,true);
		
		for(ProcesoTest procesotest: procesotests) {
			if(procesotest.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoTest(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoTestConstantesFunciones.getArrayColumnasGlobalesProcesoTest(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoTest(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoTestConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoTestConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoTestConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoTestConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoTest(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoTest> procesotests,ProcesoTest procesotest,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoTest procesotestAux: procesotests) {
			if(procesotestAux!=null && procesotest!=null) {
				if((procesotestAux.getId()==null && procesotest.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesotestAux.getId()!=null && procesotest.getId()!=null){
					if(procesotestAux.getId().equals(procesotest.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoTest(List<ProcesoTest> procesotests) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoTest procesotest: procesotests) {			
			if(procesotest.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoTest() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoTest() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoTest() throws Exception  {
		return ProcesoTestConstantesFunciones.getTiposSeleccionarProcesoTest(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoTest(Boolean conFk) throws Exception  {
		return ProcesoTestConstantesFunciones.getTiposSeleccionarProcesoTest(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoTest(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoTestConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProcesoTestConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoTestConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(ProcesoTestConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoTestConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProcesoTestConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoTest(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoTest(ProcesoTest procesotestAux) throws Exception {
		
			procesotestAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesotestAux.getEmpresa()));
			procesotestAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(procesotestAux.getModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoTest(List<ProcesoTest> procesotestsTemp) throws Exception {
		for(ProcesoTest procesotestAux:procesotestsTemp) {
			
			procesotestAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesotestAux.getEmpresa()));
			procesotestAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(procesotestAux.getModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoTest(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Modulo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoTest(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoTest(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoTestConstantesFunciones.getClassesRelationshipsOfProcesoTest(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoTest(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoTest(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoTestConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoTest(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoTest(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoTest procesotest,List<ProcesoTest> procesotests,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoTest procesotest,List<ProcesoTest> procesotests) throws Exception {
		try	{			
			for(ProcesoTest procesotestLocal:procesotests) {
				if(procesotestLocal.getId().equals(procesotest.getId())) {
					procesotestLocal.setIsSelected(procesotest.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoTest(List<ProcesoTest> procesotestsAux) throws Exception {
		//this.procesotestsAux=procesotestsAux;
		
		for(ProcesoTest procesotestAux:procesotestsAux) {
			if(procesotestAux.getIsChanged()) {
				procesotestAux.setIsChanged(false);
			}		
			
			if(procesotestAux.getIsNew()) {
				procesotestAux.setIsNew(false);
			}	
			
			if(procesotestAux.getIsDeleted()) {
				procesotestAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoTest(ProcesoTest procesotestAux) throws Exception {
		//this.procesotestAux=procesotestAux;
		
			if(procesotestAux.getIsChanged()) {
				procesotestAux.setIsChanged(false);
			}		
			
			if(procesotestAux.getIsNew()) {
				procesotestAux.setIsNew(false);
			}	
			
			if(procesotestAux.getIsDeleted()) {
				procesotestAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoTest procesotestAsignar,ProcesoTest procesotest) throws Exception {
		procesotestAsignar.setId(procesotest.getId());	
		procesotestAsignar.setVersionRow(procesotest.getVersionRow());	
	}
	
	public static void inicializarProcesoTest(ProcesoTest procesotest) throws Exception {
		try {
				procesotest.setId(0L);	
					
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoTest(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoTestConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoTestConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoTestConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoTest(String sTipo,Row row,Workbook workbook,ProcesoTest procesotest,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesotest.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesotest.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesotest.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoTest="";
	
	public String getsFinalQueryProcesoTest() {
		return this.sFinalQueryProcesoTest;
	}
	
	public void setsFinalQueryProcesoTest(String sFinalQueryProcesoTest) {
		this.sFinalQueryProcesoTest= sFinalQueryProcesoTest;
	}
	
	public Border resaltarSeleccionarProcesoTest=null;
	
	public Border setResaltarSeleccionarProcesoTest(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoTestBeanSwingJInternalFrame procesotestBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesotestBeanSwingJInternalFrame.jTtoolBarProcesoTest.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoTest= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoTest() {
		return this.resaltarSeleccionarProcesoTest;
	}
	
	public void setResaltarSeleccionarProcesoTest(Border borderResaltarSeleccionarProcesoTest) {
		this.resaltarSeleccionarProcesoTest= borderResaltarSeleccionarProcesoTest;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoTest=null;
	public Boolean mostraridProcesoTest=true;
	public Boolean activaridProcesoTest=true;

	public Border resaltarid_empresaProcesoTest=null;
	public Boolean mostrarid_empresaProcesoTest=true;
	public Boolean activarid_empresaProcesoTest=true;
	public Boolean cargarid_empresaProcesoTest=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProcesoTest=false;//ConEventDepend=true

	public Border resaltarid_moduloProcesoTest=null;
	public Boolean mostrarid_moduloProcesoTest=true;
	public Boolean activarid_moduloProcesoTest=true;
	public Boolean cargarid_moduloProcesoTest=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloProcesoTest=false;//ConEventDepend=true

	public Border resaltarnombreProcesoTest=null;
	public Boolean mostrarnombreProcesoTest=true;
	public Boolean activarnombreProcesoTest=true;

	
	

	public Border setResaltaridProcesoTest(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoTestBeanSwingJInternalFrame procesotestBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesotestBeanSwingJInternalFrame.jTtoolBarProcesoTest.setBorder(borderResaltar);
		
		this.resaltaridProcesoTest= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoTest() {
		return this.resaltaridProcesoTest;
	}

	public void setResaltaridProcesoTest(Border borderResaltar) {
		this.resaltaridProcesoTest= borderResaltar;
	}

	public Boolean getMostraridProcesoTest() {
		return this.mostraridProcesoTest;
	}

	public void setMostraridProcesoTest(Boolean mostraridProcesoTest) {
		this.mostraridProcesoTest= mostraridProcesoTest;
	}

	public Boolean getActivaridProcesoTest() {
		return this.activaridProcesoTest;
	}

	public void setActivaridProcesoTest(Boolean activaridProcesoTest) {
		this.activaridProcesoTest= activaridProcesoTest;
	}

	public Border setResaltarid_empresaProcesoTest(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoTestBeanSwingJInternalFrame procesotestBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesotestBeanSwingJInternalFrame.jTtoolBarProcesoTest.setBorder(borderResaltar);
		
		this.resaltarid_empresaProcesoTest= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProcesoTest() {
		return this.resaltarid_empresaProcesoTest;
	}

	public void setResaltarid_empresaProcesoTest(Border borderResaltar) {
		this.resaltarid_empresaProcesoTest= borderResaltar;
	}

	public Boolean getMostrarid_empresaProcesoTest() {
		return this.mostrarid_empresaProcesoTest;
	}

	public void setMostrarid_empresaProcesoTest(Boolean mostrarid_empresaProcesoTest) {
		this.mostrarid_empresaProcesoTest= mostrarid_empresaProcesoTest;
	}

	public Boolean getActivarid_empresaProcesoTest() {
		return this.activarid_empresaProcesoTest;
	}

	public void setActivarid_empresaProcesoTest(Boolean activarid_empresaProcesoTest) {
		this.activarid_empresaProcesoTest= activarid_empresaProcesoTest;
	}

	public Boolean getCargarid_empresaProcesoTest() {
		return this.cargarid_empresaProcesoTest;
	}

	public void setCargarid_empresaProcesoTest(Boolean cargarid_empresaProcesoTest) {
		this.cargarid_empresaProcesoTest= cargarid_empresaProcesoTest;
	}

	public Border setResaltarid_moduloProcesoTest(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoTestBeanSwingJInternalFrame procesotestBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesotestBeanSwingJInternalFrame.jTtoolBarProcesoTest.setBorder(borderResaltar);
		
		this.resaltarid_moduloProcesoTest= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloProcesoTest() {
		return this.resaltarid_moduloProcesoTest;
	}

	public void setResaltarid_moduloProcesoTest(Border borderResaltar) {
		this.resaltarid_moduloProcesoTest= borderResaltar;
	}

	public Boolean getMostrarid_moduloProcesoTest() {
		return this.mostrarid_moduloProcesoTest;
	}

	public void setMostrarid_moduloProcesoTest(Boolean mostrarid_moduloProcesoTest) {
		this.mostrarid_moduloProcesoTest= mostrarid_moduloProcesoTest;
	}

	public Boolean getActivarid_moduloProcesoTest() {
		return this.activarid_moduloProcesoTest;
	}

	public void setActivarid_moduloProcesoTest(Boolean activarid_moduloProcesoTest) {
		this.activarid_moduloProcesoTest= activarid_moduloProcesoTest;
	}

	public Boolean getCargarid_moduloProcesoTest() {
		return this.cargarid_moduloProcesoTest;
	}

	public void setCargarid_moduloProcesoTest(Boolean cargarid_moduloProcesoTest) {
		this.cargarid_moduloProcesoTest= cargarid_moduloProcesoTest;
	}

	public Border setResaltarnombreProcesoTest(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoTestBeanSwingJInternalFrame procesotestBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesotestBeanSwingJInternalFrame.jTtoolBarProcesoTest.setBorder(borderResaltar);
		
		this.resaltarnombreProcesoTest= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProcesoTest() {
		return this.resaltarnombreProcesoTest;
	}

	public void setResaltarnombreProcesoTest(Border borderResaltar) {
		this.resaltarnombreProcesoTest= borderResaltar;
	}

	public Boolean getMostrarnombreProcesoTest() {
		return this.mostrarnombreProcesoTest;
	}

	public void setMostrarnombreProcesoTest(Boolean mostrarnombreProcesoTest) {
		this.mostrarnombreProcesoTest= mostrarnombreProcesoTest;
	}

	public Boolean getActivarnombreProcesoTest() {
		return this.activarnombreProcesoTest;
	}

	public void setActivarnombreProcesoTest(Boolean activarnombreProcesoTest) {
		this.activarnombreProcesoTest= activarnombreProcesoTest;
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
		
		
		this.setMostraridProcesoTest(esInicial);
		this.setMostrarid_empresaProcesoTest(esInicial);
		this.setMostrarid_moduloProcesoTest(esInicial);
		this.setMostrarnombreProcesoTest(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoTestConstantesFunciones.ID)) {
				this.setMostraridProcesoTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTestConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProcesoTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTestConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloProcesoTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTestConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProcesoTest(esAsigna);
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
		
		
		this.setActivaridProcesoTest(esInicial);
		this.setActivarid_empresaProcesoTest(esInicial);
		this.setActivarid_moduloProcesoTest(esInicial);
		this.setActivarnombreProcesoTest(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoTestConstantesFunciones.ID)) {
				this.setActivaridProcesoTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTestConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProcesoTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTestConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloProcesoTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTestConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProcesoTest(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoTestBeanSwingJInternalFrame procesotestBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoTest(esInicial);
		this.setResaltarid_empresaProcesoTest(esInicial);
		this.setResaltarid_moduloProcesoTest(esInicial);
		this.setResaltarnombreProcesoTest(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoTestConstantesFunciones.ID)) {
				this.setResaltaridProcesoTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTestConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProcesoTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTestConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloProcesoTest(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoTestConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProcesoTest(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoTestBeanSwingJInternalFrame procesotestBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdEmpresaPorIdModuloProcesoTest=true;

	public Boolean getMostrarBusquedaPorIdEmpresaPorIdModuloProcesoTest() {
		return this.mostrarBusquedaPorIdEmpresaPorIdModuloProcesoTest;
	}

	public void setMostrarBusquedaPorIdEmpresaPorIdModuloProcesoTest(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdEmpresaPorIdModuloProcesoTest= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdEmpresaPorIdModuloProcesoTest=true;

	public Boolean getActivarBusquedaPorIdEmpresaPorIdModuloProcesoTest() {
		return this.activarBusquedaPorIdEmpresaPorIdModuloProcesoTest;
	}

	public void setActivarBusquedaPorIdEmpresaPorIdModuloProcesoTest(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdEmpresaPorIdModuloProcesoTest= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdEmpresaPorIdModuloProcesoTest=null;

	public Border getResaltarBusquedaPorIdEmpresaPorIdModuloProcesoTest() {
		return this.resaltarBusquedaPorIdEmpresaPorIdModuloProcesoTest;
	}

	public void setResaltarBusquedaPorIdEmpresaPorIdModuloProcesoTest(Border borderResaltar) {
		this.resaltarBusquedaPorIdEmpresaPorIdModuloProcesoTest= borderResaltar;
	}

	public void setResaltarBusquedaPorIdEmpresaPorIdModuloProcesoTest(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoTestBeanSwingJInternalFrame procesotestBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdEmpresaPorIdModuloProcesoTest= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}