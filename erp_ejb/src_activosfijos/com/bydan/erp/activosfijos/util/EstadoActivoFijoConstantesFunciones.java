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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.EstadoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.EstadoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.EstadoActivoFijoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoActivoFijoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoActivoFijo"+EstadoActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoActivoFijoConstantesFunciones.SCHEMA+"_"+EstadoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoActivoFijoConstantesFunciones.SCHEMA+"_"+EstadoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoActivoFijoConstantesFunciones.SCHEMA+"_"+EstadoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoActivoFijoConstantesFunciones.SCHEMA+"_"+EstadoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Activo Fijos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Activo Fijo";
	public static final String SCLASSWEBTITULO_LOWER="Estado Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoActivoFijo";
	public static final String OBJECTNAME="estadoactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="estado_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadoactivofijo from "+EstadoActivoFijoConstantesFunciones.SPERSISTENCENAME+" estadoactivofijo";
	public static String QUERYSELECTNATIVE="select "+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+".id,"+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+".codigo,"+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+".nombre from "+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME;//+" as "+EstadoActivoFijoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEstadoActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoActivoFijoConstantesFunciones.IDEMPRESA)) {sLabelColumna=EstadoActivoFijoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EstadoActivoFijoConstantesFunciones.CODIGO)) {sLabelColumna=EstadoActivoFijoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoActivoFijoConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoActivoFijoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getEstadoActivoFijoDescripcion(EstadoActivoFijo estadoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadoactivofijo !=null/* && estadoactivofijo.getId()!=0*/) {
			sDescripcion=estadoactivofijo.getcodigo();//estadoactivofijoestadoactivofijo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoActivoFijoDescripcionDetallado(EstadoActivoFijo estadoactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=EstadoActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=estadoactivofijo.getId().toString()+",";
		sDescripcion+=EstadoActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadoactivofijo.getVersionRow().toString()+",";
		sDescripcion+=EstadoActivoFijoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=estadoactivofijo.getid_empresa().toString()+",";
		sDescripcion+=EstadoActivoFijoConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadoactivofijo.getcodigo()+",";
		sDescripcion+=EstadoActivoFijoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadoactivofijo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoActivoFijoDescripcion(EstadoActivoFijo estadoactivofijo,String sValor) throws Exception {			
		if(estadoactivofijo !=null) {
			estadoactivofijo.setcodigo(sValor);;//estadoactivofijoestadoactivofijo.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoActivoFijo(EstadoActivoFijo estadoactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadoactivofijo.setcodigo(estadoactivofijo.getcodigo().trim());
		estadoactivofijo.setnombre(estadoactivofijo.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoActivoFijos(List<EstadoActivoFijo> estadoactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoActivoFijo estadoactivofijo: estadoactivofijos) {
			estadoactivofijo.setcodigo(estadoactivofijo.getcodigo().trim());
			estadoactivofijo.setnombre(estadoactivofijo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoActivoFijo(EstadoActivoFijo estadoactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadoactivofijo.getConCambioAuxiliar()) {
			estadoactivofijo.setIsDeleted(estadoactivofijo.getIsDeletedAuxiliar());	
			estadoactivofijo.setIsNew(estadoactivofijo.getIsNewAuxiliar());	
			estadoactivofijo.setIsChanged(estadoactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadoactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadoactivofijo.setIsDeletedAuxiliar(false);	
			estadoactivofijo.setIsNewAuxiliar(false);	
			estadoactivofijo.setIsChangedAuxiliar(false);
			
			estadoactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoActivoFijos(List<EstadoActivoFijo> estadoactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoActivoFijo estadoactivofijo : estadoactivofijos) {
			if(conAsignarBase && estadoactivofijo.getConCambioAuxiliar()) {
				estadoactivofijo.setIsDeleted(estadoactivofijo.getIsDeletedAuxiliar());	
				estadoactivofijo.setIsNew(estadoactivofijo.getIsNewAuxiliar());	
				estadoactivofijo.setIsChanged(estadoactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadoactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadoactivofijo.setIsDeletedAuxiliar(false);	
				estadoactivofijo.setIsNewAuxiliar(false);	
				estadoactivofijo.setIsChangedAuxiliar(false);
				
				estadoactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoActivoFijo(EstadoActivoFijo estadoactivofijo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoActivoFijos(List<EstadoActivoFijo> estadoactivofijos,Boolean conEnteros) throws Exception  {
		
		for(EstadoActivoFijo estadoactivofijo: estadoactivofijos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoActivoFijo(List<EstadoActivoFijo> estadoactivofijos,EstadoActivoFijo estadoactivofijoAux) throws Exception  {
		EstadoActivoFijoConstantesFunciones.InicializarValoresEstadoActivoFijo(estadoactivofijoAux,true);
		
		for(EstadoActivoFijo estadoactivofijo: estadoactivofijos) {
			if(estadoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoActivoFijoConstantesFunciones.getArrayColumnasGlobalesEstadoActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EstadoActivoFijoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EstadoActivoFijoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoActivoFijo> estadoactivofijos,EstadoActivoFijo estadoactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoActivoFijo estadoactivofijoAux: estadoactivofijos) {
			if(estadoactivofijoAux!=null && estadoactivofijo!=null) {
				if((estadoactivofijoAux.getId()==null && estadoactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoactivofijoAux.getId()!=null && estadoactivofijo.getId()!=null){
					if(estadoactivofijoAux.getId().equals(estadoactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoActivoFijo(List<EstadoActivoFijo> estadoactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoActivoFijo estadoactivofijo: estadoactivofijos) {			
			if(estadoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoActivoFijoConstantesFunciones.LABEL_ID, EstadoActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoActivoFijoConstantesFunciones.LABEL_VERSIONROW, EstadoActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoActivoFijoConstantesFunciones.LABEL_IDEMPRESA, EstadoActivoFijoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoActivoFijoConstantesFunciones.LABEL_CODIGO, EstadoActivoFijoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoActivoFijoConstantesFunciones.LABEL_NOMBRE, EstadoActivoFijoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoActivoFijoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoActivoFijoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoActivoFijoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoActivoFijo() throws Exception  {
		return EstadoActivoFijoConstantesFunciones.getTiposSeleccionarEstadoActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoActivoFijo(Boolean conFk) throws Exception  {
		return EstadoActivoFijoConstantesFunciones.getTiposSeleccionarEstadoActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EstadoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoActivoFijoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoActivoFijoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoActivoFijoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoActivoFijoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoActivoFijo(EstadoActivoFijo estadoactivofijoAux) throws Exception {
		
			estadoactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(estadoactivofijoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoActivoFijo(List<EstadoActivoFijo> estadoactivofijosTemp) throws Exception {
		for(EstadoActivoFijo estadoactivofijoAux:estadoactivofijosTemp) {
			
			estadoactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(estadoactivofijoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoActivoFijoConstantesFunciones.getClassesRelationshipsOfEstadoActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleActivoFijo.class));
				classes.add(new Classe(ParteActivoFijo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParteActivoFijo.class)) {
						classes.add(new Classe(ParteActivoFijo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(ParteActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParteActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(ParteActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParteActivoFijo.class)); continue;
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
	public static void actualizarLista(EstadoActivoFijo estadoactivofijo,List<EstadoActivoFijo> estadoactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoActivoFijo estadoactivofijoEncontrado=null;
			
			for(EstadoActivoFijo estadoactivofijoLocal:estadoactivofijos) {
				if(estadoactivofijoLocal.getId().equals(estadoactivofijo.getId())) {
					estadoactivofijoEncontrado=estadoactivofijoLocal;
					
					estadoactivofijoLocal.setIsChanged(estadoactivofijo.getIsChanged());
					estadoactivofijoLocal.setIsNew(estadoactivofijo.getIsNew());
					estadoactivofijoLocal.setIsDeleted(estadoactivofijo.getIsDeleted());
					
					estadoactivofijoLocal.setGeneralEntityOriginal(estadoactivofijo.getGeneralEntityOriginal());
					
					estadoactivofijoLocal.setId(estadoactivofijo.getId());	
					estadoactivofijoLocal.setVersionRow(estadoactivofijo.getVersionRow());	
					estadoactivofijoLocal.setid_empresa(estadoactivofijo.getid_empresa());	
					estadoactivofijoLocal.setcodigo(estadoactivofijo.getcodigo());	
					estadoactivofijoLocal.setnombre(estadoactivofijo.getnombre());	
					
					
					estadoactivofijoLocal.setDetalleActivoFijos(estadoactivofijo.getDetalleActivoFijos());
					estadoactivofijoLocal.setParteActivoFijos(estadoactivofijo.getParteActivoFijos());
					
					existe=true;
					break;
				}
			}
			
			if(!estadoactivofijo.getIsDeleted()) {
				if(!existe) {
					estadoactivofijos.add(estadoactivofijo);
				}
			} else {
				if(estadoactivofijoEncontrado!=null && permiteQuitar)  {
					estadoactivofijos.remove(estadoactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoActivoFijo estadoactivofijo,List<EstadoActivoFijo> estadoactivofijos) throws Exception {
		try	{			
			for(EstadoActivoFijo estadoactivofijoLocal:estadoactivofijos) {
				if(estadoactivofijoLocal.getId().equals(estadoactivofijo.getId())) {
					estadoactivofijoLocal.setIsSelected(estadoactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoActivoFijo(List<EstadoActivoFijo> estadoactivofijosAux) throws Exception {
		//this.estadoactivofijosAux=estadoactivofijosAux;
		
		for(EstadoActivoFijo estadoactivofijoAux:estadoactivofijosAux) {
			if(estadoactivofijoAux.getIsChanged()) {
				estadoactivofijoAux.setIsChanged(false);
			}		
			
			if(estadoactivofijoAux.getIsNew()) {
				estadoactivofijoAux.setIsNew(false);
			}	
			
			if(estadoactivofijoAux.getIsDeleted()) {
				estadoactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoActivoFijo(EstadoActivoFijo estadoactivofijoAux) throws Exception {
		//this.estadoactivofijoAux=estadoactivofijoAux;
		
			if(estadoactivofijoAux.getIsChanged()) {
				estadoactivofijoAux.setIsChanged(false);
			}		
			
			if(estadoactivofijoAux.getIsNew()) {
				estadoactivofijoAux.setIsNew(false);
			}	
			
			if(estadoactivofijoAux.getIsDeleted()) {
				estadoactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoActivoFijo estadoactivofijoAsignar,EstadoActivoFijo estadoactivofijo) throws Exception {
		estadoactivofijoAsignar.setId(estadoactivofijo.getId());	
		estadoactivofijoAsignar.setVersionRow(estadoactivofijo.getVersionRow());	
		estadoactivofijoAsignar.setid_empresa(estadoactivofijo.getid_empresa());
		estadoactivofijoAsignar.setempresa_descripcion(estadoactivofijo.getempresa_descripcion());	
		estadoactivofijoAsignar.setcodigo(estadoactivofijo.getcodigo());	
		estadoactivofijoAsignar.setnombre(estadoactivofijo.getnombre());	
	}
	
	public static void inicializarEstadoActivoFijo(EstadoActivoFijo estadoactivofijo) throws Exception {
		try {
				estadoactivofijo.setId(0L);	
					
				estadoactivofijo.setid_empresa(-1L);	
				estadoactivofijo.setcodigo("");	
				estadoactivofijo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoActivoFijoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoActivoFijoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoActivoFijo(String sTipo,Row row,Workbook workbook,EstadoActivoFijo estadoactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoactivofijo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoactivofijo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoactivofijo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoActivoFijo() {
		return this.sFinalQueryEstadoActivoFijo;
	}
	
	public void setsFinalQueryEstadoActivoFijo(String sFinalQueryEstadoActivoFijo) {
		this.sFinalQueryEstadoActivoFijo= sFinalQueryEstadoActivoFijo;
	}
	
	public Border resaltarSeleccionarEstadoActivoFijo=null;
	
	public Border setResaltarSeleccionarEstadoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoActivoFijoBeanSwingJInternalFrame estadoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoactivofijoBeanSwingJInternalFrame.jTtoolBarEstadoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoActivoFijo() {
		return this.resaltarSeleccionarEstadoActivoFijo;
	}
	
	public void setResaltarSeleccionarEstadoActivoFijo(Border borderResaltarSeleccionarEstadoActivoFijo) {
		this.resaltarSeleccionarEstadoActivoFijo= borderResaltarSeleccionarEstadoActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoActivoFijo=null;
	public Boolean mostraridEstadoActivoFijo=true;
	public Boolean activaridEstadoActivoFijo=true;

	public Border resaltarid_empresaEstadoActivoFijo=null;
	public Boolean mostrarid_empresaEstadoActivoFijo=true;
	public Boolean activarid_empresaEstadoActivoFijo=true;
	public Boolean cargarid_empresaEstadoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEstadoActivoFijo=false;//ConEventDepend=true

	public Border resaltarcodigoEstadoActivoFijo=null;
	public Boolean mostrarcodigoEstadoActivoFijo=true;
	public Boolean activarcodigoEstadoActivoFijo=true;

	public Border resaltarnombreEstadoActivoFijo=null;
	public Boolean mostrarnombreEstadoActivoFijo=true;
	public Boolean activarnombreEstadoActivoFijo=true;

	
	

	public Border setResaltaridEstadoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoActivoFijoBeanSwingJInternalFrame estadoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoactivofijoBeanSwingJInternalFrame.jTtoolBarEstadoActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridEstadoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoActivoFijo() {
		return this.resaltaridEstadoActivoFijo;
	}

	public void setResaltaridEstadoActivoFijo(Border borderResaltar) {
		this.resaltaridEstadoActivoFijo= borderResaltar;
	}

	public Boolean getMostraridEstadoActivoFijo() {
		return this.mostraridEstadoActivoFijo;
	}

	public void setMostraridEstadoActivoFijo(Boolean mostraridEstadoActivoFijo) {
		this.mostraridEstadoActivoFijo= mostraridEstadoActivoFijo;
	}

	public Boolean getActivaridEstadoActivoFijo() {
		return this.activaridEstadoActivoFijo;
	}

	public void setActivaridEstadoActivoFijo(Boolean activaridEstadoActivoFijo) {
		this.activaridEstadoActivoFijo= activaridEstadoActivoFijo;
	}

	public Border setResaltarid_empresaEstadoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoActivoFijoBeanSwingJInternalFrame estadoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoactivofijoBeanSwingJInternalFrame.jTtoolBarEstadoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empresaEstadoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEstadoActivoFijo() {
		return this.resaltarid_empresaEstadoActivoFijo;
	}

	public void setResaltarid_empresaEstadoActivoFijo(Border borderResaltar) {
		this.resaltarid_empresaEstadoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empresaEstadoActivoFijo() {
		return this.mostrarid_empresaEstadoActivoFijo;
	}

	public void setMostrarid_empresaEstadoActivoFijo(Boolean mostrarid_empresaEstadoActivoFijo) {
		this.mostrarid_empresaEstadoActivoFijo= mostrarid_empresaEstadoActivoFijo;
	}

	public Boolean getActivarid_empresaEstadoActivoFijo() {
		return this.activarid_empresaEstadoActivoFijo;
	}

	public void setActivarid_empresaEstadoActivoFijo(Boolean activarid_empresaEstadoActivoFijo) {
		this.activarid_empresaEstadoActivoFijo= activarid_empresaEstadoActivoFijo;
	}

	public Boolean getCargarid_empresaEstadoActivoFijo() {
		return this.cargarid_empresaEstadoActivoFijo;
	}

	public void setCargarid_empresaEstadoActivoFijo(Boolean cargarid_empresaEstadoActivoFijo) {
		this.cargarid_empresaEstadoActivoFijo= cargarid_empresaEstadoActivoFijo;
	}

	public Border setResaltarcodigoEstadoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoActivoFijoBeanSwingJInternalFrame estadoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoactivofijoBeanSwingJInternalFrame.jTtoolBarEstadoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoActivoFijo() {
		return this.resaltarcodigoEstadoActivoFijo;
	}

	public void setResaltarcodigoEstadoActivoFijo(Border borderResaltar) {
		this.resaltarcodigoEstadoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoActivoFijo() {
		return this.mostrarcodigoEstadoActivoFijo;
	}

	public void setMostrarcodigoEstadoActivoFijo(Boolean mostrarcodigoEstadoActivoFijo) {
		this.mostrarcodigoEstadoActivoFijo= mostrarcodigoEstadoActivoFijo;
	}

	public Boolean getActivarcodigoEstadoActivoFijo() {
		return this.activarcodigoEstadoActivoFijo;
	}

	public void setActivarcodigoEstadoActivoFijo(Boolean activarcodigoEstadoActivoFijo) {
		this.activarcodigoEstadoActivoFijo= activarcodigoEstadoActivoFijo;
	}

	public Border setResaltarnombreEstadoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoActivoFijoBeanSwingJInternalFrame estadoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoactivofijoBeanSwingJInternalFrame.jTtoolBarEstadoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoActivoFijo() {
		return this.resaltarnombreEstadoActivoFijo;
	}

	public void setResaltarnombreEstadoActivoFijo(Border borderResaltar) {
		this.resaltarnombreEstadoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoActivoFijo() {
		return this.mostrarnombreEstadoActivoFijo;
	}

	public void setMostrarnombreEstadoActivoFijo(Boolean mostrarnombreEstadoActivoFijo) {
		this.mostrarnombreEstadoActivoFijo= mostrarnombreEstadoActivoFijo;
	}

	public Boolean getActivarnombreEstadoActivoFijo() {
		return this.activarnombreEstadoActivoFijo;
	}

	public void setActivarnombreEstadoActivoFijo(Boolean activarnombreEstadoActivoFijo) {
		this.activarnombreEstadoActivoFijo= activarnombreEstadoActivoFijo;
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
		
		
		this.setMostraridEstadoActivoFijo(esInicial);
		this.setMostrarid_empresaEstadoActivoFijo(esInicial);
		this.setMostrarcodigoEstadoActivoFijo(esInicial);
		this.setMostrarnombreEstadoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoActivoFijoConstantesFunciones.ID)) {
				this.setMostraridEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoActivoFijoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoActivoFijo(esAsigna);
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
		
		
		this.setActivaridEstadoActivoFijo(esInicial);
		this.setActivarid_empresaEstadoActivoFijo(esInicial);
		this.setActivarcodigoEstadoActivoFijo(esInicial);
		this.setActivarnombreEstadoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoActivoFijoConstantesFunciones.ID)) {
				this.setActivaridEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoActivoFijoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoActivoFijoBeanSwingJInternalFrame estadoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoActivoFijo(esInicial);
		this.setResaltarid_empresaEstadoActivoFijo(esInicial);
		this.setResaltarcodigoEstadoActivoFijo(esInicial);
		this.setResaltarnombreEstadoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoActivoFijoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleActivoFijoEstadoActivoFijo=null;

	public Border getResaltarDetalleActivoFijoEstadoActivoFijo() {
		return this.resaltarDetalleActivoFijoEstadoActivoFijo;
	}

	public void setResaltarDetalleActivoFijoEstadoActivoFijo(Border borderResaltarDetalleActivoFijo) {
		if(borderResaltarDetalleActivoFijo!=null) {
			this.resaltarDetalleActivoFijoEstadoActivoFijo= borderResaltarDetalleActivoFijo;
		}
	}

	public Border setResaltarDetalleActivoFijoEstadoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoActivoFijoBeanSwingJInternalFrame estadoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoactivofijoBeanSwingJInternalFrame.jTtoolBarEstadoActivoFijo.setBorder(borderResaltarDetalleActivoFijo);
			
		this.resaltarDetalleActivoFijoEstadoActivoFijo= borderResaltarDetalleActivoFijo;

		 return borderResaltarDetalleActivoFijo;
	}



	public Boolean mostrarDetalleActivoFijoEstadoActivoFijo=true;

	public Boolean getMostrarDetalleActivoFijoEstadoActivoFijo() {
		return this.mostrarDetalleActivoFijoEstadoActivoFijo;
	}

	public void setMostrarDetalleActivoFijoEstadoActivoFijo(Boolean visibilidadResaltarDetalleActivoFijo) {
		this.mostrarDetalleActivoFijoEstadoActivoFijo= visibilidadResaltarDetalleActivoFijo;
	}



	public Boolean activarDetalleActivoFijoEstadoActivoFijo=true;

	public Boolean gethabilitarResaltarDetalleActivoFijoEstadoActivoFijo() {
		return this.activarDetalleActivoFijoEstadoActivoFijo;
	}

	public void setActivarDetalleActivoFijoEstadoActivoFijo(Boolean habilitarResaltarDetalleActivoFijo) {
		this.activarDetalleActivoFijoEstadoActivoFijo= habilitarResaltarDetalleActivoFijo;
	}


	public Border resaltarParteActivoFijoEstadoActivoFijo=null;

	public Border getResaltarParteActivoFijoEstadoActivoFijo() {
		return this.resaltarParteActivoFijoEstadoActivoFijo;
	}

	public void setResaltarParteActivoFijoEstadoActivoFijo(Border borderResaltarParteActivoFijo) {
		if(borderResaltarParteActivoFijo!=null) {
			this.resaltarParteActivoFijoEstadoActivoFijo= borderResaltarParteActivoFijo;
		}
	}

	public Border setResaltarParteActivoFijoEstadoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoActivoFijoBeanSwingJInternalFrame estadoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarParteActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoactivofijoBeanSwingJInternalFrame.jTtoolBarEstadoActivoFijo.setBorder(borderResaltarParteActivoFijo);
			
		this.resaltarParteActivoFijoEstadoActivoFijo= borderResaltarParteActivoFijo;

		 return borderResaltarParteActivoFijo;
	}



	public Boolean mostrarParteActivoFijoEstadoActivoFijo=true;

	public Boolean getMostrarParteActivoFijoEstadoActivoFijo() {
		return this.mostrarParteActivoFijoEstadoActivoFijo;
	}

	public void setMostrarParteActivoFijoEstadoActivoFijo(Boolean visibilidadResaltarParteActivoFijo) {
		this.mostrarParteActivoFijoEstadoActivoFijo= visibilidadResaltarParteActivoFijo;
	}



	public Boolean activarParteActivoFijoEstadoActivoFijo=true;

	public Boolean gethabilitarResaltarParteActivoFijoEstadoActivoFijo() {
		return this.activarParteActivoFijoEstadoActivoFijo;
	}

	public void setActivarParteActivoFijoEstadoActivoFijo(Boolean habilitarResaltarParteActivoFijo) {
		this.activarParteActivoFijoEstadoActivoFijo= habilitarResaltarParteActivoFijo;
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

		this.setMostrarDetalleActivoFijoEstadoActivoFijo(esInicial);
		this.setMostrarParteActivoFijoEstadoActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setMostrarDetalleActivoFijoEstadoActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParteActivoFijo.class)) {
				this.setMostrarParteActivoFijoEstadoActivoFijo(esAsigna);
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

		this.setActivarDetalleActivoFijoEstadoActivoFijo(esInicial);
		this.setActivarParteActivoFijoEstadoActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setActivarDetalleActivoFijoEstadoActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParteActivoFijo.class)) {
				this.setActivarParteActivoFijoEstadoActivoFijo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoActivoFijoBeanSwingJInternalFrame estadoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleActivoFijoEstadoActivoFijo(esInicial);
		this.setResaltarParteActivoFijoEstadoActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setResaltarDetalleActivoFijoEstadoActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParteActivoFijo.class)) {
				this.setResaltarParteActivoFijoEstadoActivoFijo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaEstadoActivoFijo=true;

	public Boolean getMostrarFK_IdEmpresaEstadoActivoFijo() {
		return this.mostrarFK_IdEmpresaEstadoActivoFijo;
	}

	public void setMostrarFK_IdEmpresaEstadoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEstadoActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaEstadoActivoFijo=true;

	public Boolean getActivarFK_IdEmpresaEstadoActivoFijo() {
		return this.activarFK_IdEmpresaEstadoActivoFijo;
	}

	public void setActivarFK_IdEmpresaEstadoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEstadoActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaEstadoActivoFijo=null;

	public Border getResaltarFK_IdEmpresaEstadoActivoFijo() {
		return this.resaltarFK_IdEmpresaEstadoActivoFijo;
	}

	public void setResaltarFK_IdEmpresaEstadoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEstadoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEstadoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoActivoFijoBeanSwingJInternalFrame estadoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEstadoActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}