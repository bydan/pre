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
package com.bydan.erp.importaciones.util;

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


import com.bydan.erp.importaciones.util.TipoTerminosImporConstantesFunciones;
import com.bydan.erp.importaciones.util.TipoTerminosImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.TipoTerminosImporParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoTerminosImporConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoTerminosImpor";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoTerminosImpor"+TipoTerminosImporConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoTerminosImporHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoTerminosImporHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoTerminosImporConstantesFunciones.SCHEMA+"_"+TipoTerminosImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoTerminosImporHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoTerminosImporConstantesFunciones.SCHEMA+"_"+TipoTerminosImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoTerminosImporConstantesFunciones.SCHEMA+"_"+TipoTerminosImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoTerminosImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoTerminosImporConstantesFunciones.SCHEMA+"_"+TipoTerminosImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTerminosImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTerminosImporHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTerminosImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTerminosImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTerminosImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTerminosImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoTerminosImporConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoTerminosImporConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoTerminosImporConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoTerminosImporConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Terminoss";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Terminos";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Terminos Impor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoTerminosImpor";
	public static final String OBJECTNAME="tipoterminosimpor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="tipo_terminos_impor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoterminosimpor from "+TipoTerminosImporConstantesFunciones.SPERSISTENCENAME+" tipoterminosimpor";
	public static String QUERYSELECTNATIVE="select "+TipoTerminosImporConstantesFunciones.SCHEMA+"."+TipoTerminosImporConstantesFunciones.TABLENAME+".id,"+TipoTerminosImporConstantesFunciones.SCHEMA+"."+TipoTerminosImporConstantesFunciones.TABLENAME+".version_row,"+TipoTerminosImporConstantesFunciones.SCHEMA+"."+TipoTerminosImporConstantesFunciones.TABLENAME+".codigo,"+TipoTerminosImporConstantesFunciones.SCHEMA+"."+TipoTerminosImporConstantesFunciones.TABLENAME+".nombre from "+TipoTerminosImporConstantesFunciones.SCHEMA+"."+TipoTerminosImporConstantesFunciones.TABLENAME;//+" as "+TipoTerminosImporConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoTerminosImporLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoTerminosImporConstantesFunciones.CODIGO)) {sLabelColumna=TipoTerminosImporConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoTerminosImporConstantesFunciones.NOMBRE)) {sLabelColumna=TipoTerminosImporConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoTerminosImporDescripcion(TipoTerminosImpor tipoterminosimpor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoterminosimpor !=null/* && tipoterminosimpor.getId()!=0*/) {
			sDescripcion=tipoterminosimpor.getcodigo();//tipoterminosimportipoterminosimpor.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoTerminosImporDescripcionDetallado(TipoTerminosImpor tipoterminosimpor) {
		String sDescripcion="";
			
		sDescripcion+=TipoTerminosImporConstantesFunciones.ID+"=";
		sDescripcion+=tipoterminosimpor.getId().toString()+",";
		sDescripcion+=TipoTerminosImporConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoterminosimpor.getVersionRow().toString()+",";
		sDescripcion+=TipoTerminosImporConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoterminosimpor.getcodigo()+",";
		sDescripcion+=TipoTerminosImporConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoterminosimpor.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoTerminosImporDescripcion(TipoTerminosImpor tipoterminosimpor,String sValor) throws Exception {			
		if(tipoterminosimpor !=null) {
			tipoterminosimpor.setcodigo(sValor);;//tipoterminosimportipoterminosimpor.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoTerminosImpor(TipoTerminosImpor tipoterminosimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoterminosimpor.setcodigo(tipoterminosimpor.getcodigo().trim());
		tipoterminosimpor.setnombre(tipoterminosimpor.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoTerminosImpors(List<TipoTerminosImpor> tipoterminosimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoTerminosImpor tipoterminosimpor: tipoterminosimpors) {
			tipoterminosimpor.setcodigo(tipoterminosimpor.getcodigo().trim());
			tipoterminosimpor.setnombre(tipoterminosimpor.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTerminosImpor(TipoTerminosImpor tipoterminosimpor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoterminosimpor.getConCambioAuxiliar()) {
			tipoterminosimpor.setIsDeleted(tipoterminosimpor.getIsDeletedAuxiliar());	
			tipoterminosimpor.setIsNew(tipoterminosimpor.getIsNewAuxiliar());	
			tipoterminosimpor.setIsChanged(tipoterminosimpor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoterminosimpor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoterminosimpor.setIsDeletedAuxiliar(false);	
			tipoterminosimpor.setIsNewAuxiliar(false);	
			tipoterminosimpor.setIsChangedAuxiliar(false);
			
			tipoterminosimpor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTerminosImpors(List<TipoTerminosImpor> tipoterminosimpors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoTerminosImpor tipoterminosimpor : tipoterminosimpors) {
			if(conAsignarBase && tipoterminosimpor.getConCambioAuxiliar()) {
				tipoterminosimpor.setIsDeleted(tipoterminosimpor.getIsDeletedAuxiliar());	
				tipoterminosimpor.setIsNew(tipoterminosimpor.getIsNewAuxiliar());	
				tipoterminosimpor.setIsChanged(tipoterminosimpor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoterminosimpor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoterminosimpor.setIsDeletedAuxiliar(false);	
				tipoterminosimpor.setIsNewAuxiliar(false);	
				tipoterminosimpor.setIsChangedAuxiliar(false);
				
				tipoterminosimpor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoTerminosImpor(TipoTerminosImpor tipoterminosimpor,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoTerminosImpors(List<TipoTerminosImpor> tipoterminosimpors,Boolean conEnteros) throws Exception  {
		
		for(TipoTerminosImpor tipoterminosimpor: tipoterminosimpors) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoTerminosImpor(List<TipoTerminosImpor> tipoterminosimpors,TipoTerminosImpor tipoterminosimporAux) throws Exception  {
		TipoTerminosImporConstantesFunciones.InicializarValoresTipoTerminosImpor(tipoterminosimporAux,true);
		
		for(TipoTerminosImpor tipoterminosimpor: tipoterminosimpors) {
			if(tipoterminosimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTerminosImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoTerminosImporConstantesFunciones.getArrayColumnasGlobalesTipoTerminosImpor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTerminosImpor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoTerminosImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoTerminosImpor> tipoterminosimpors,TipoTerminosImpor tipoterminosimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoTerminosImpor tipoterminosimporAux: tipoterminosimpors) {
			if(tipoterminosimporAux!=null && tipoterminosimpor!=null) {
				if((tipoterminosimporAux.getId()==null && tipoterminosimpor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoterminosimporAux.getId()!=null && tipoterminosimpor.getId()!=null){
					if(tipoterminosimporAux.getId().equals(tipoterminosimpor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoTerminosImpor(List<TipoTerminosImpor> tipoterminosimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoTerminosImpor tipoterminosimpor: tipoterminosimpors) {			
			if(tipoterminosimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoTerminosImpor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoTerminosImporConstantesFunciones.LABEL_ID, TipoTerminosImporConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTerminosImporConstantesFunciones.LABEL_VERSIONROW, TipoTerminosImporConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTerminosImporConstantesFunciones.LABEL_CODIGO, TipoTerminosImporConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTerminosImporConstantesFunciones.LABEL_NOMBRE, TipoTerminosImporConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoTerminosImpor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoTerminosImporConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTerminosImporConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTerminosImporConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTerminosImporConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTerminosImpor() throws Exception  {
		return TipoTerminosImporConstantesFunciones.getTiposSeleccionarTipoTerminosImpor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTerminosImpor(Boolean conFk) throws Exception  {
		return TipoTerminosImporConstantesFunciones.getTiposSeleccionarTipoTerminosImpor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTerminosImpor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTerminosImporConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoTerminosImporConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTerminosImporConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoTerminosImporConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoTerminosImpor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTerminosImpor(TipoTerminosImpor tipoterminosimporAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTerminosImpor(List<TipoTerminosImpor> tipoterminosimporsTemp) throws Exception {
		for(TipoTerminosImpor tipoterminosimporAux:tipoterminosimporsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoTerminosImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoTerminosImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTerminosImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTerminosImporConstantesFunciones.getClassesRelationshipsOfTipoTerminosImpor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTerminosImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTerminosImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTerminosImporConstantesFunciones.getClassesRelationshipsFromStringsOfTipoTerminosImpor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTerminosImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoTerminosImpor tipoterminosimpor,List<TipoTerminosImpor> tipoterminosimpors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoTerminosImpor tipoterminosimporEncontrado=null;
			
			for(TipoTerminosImpor tipoterminosimporLocal:tipoterminosimpors) {
				if(tipoterminosimporLocal.getId().equals(tipoterminosimpor.getId())) {
					tipoterminosimporEncontrado=tipoterminosimporLocal;
					
					tipoterminosimporLocal.setIsChanged(tipoterminosimpor.getIsChanged());
					tipoterminosimporLocal.setIsNew(tipoterminosimpor.getIsNew());
					tipoterminosimporLocal.setIsDeleted(tipoterminosimpor.getIsDeleted());
					
					tipoterminosimporLocal.setGeneralEntityOriginal(tipoterminosimpor.getGeneralEntityOriginal());
					
					tipoterminosimporLocal.setId(tipoterminosimpor.getId());	
					tipoterminosimporLocal.setVersionRow(tipoterminosimpor.getVersionRow());	
					tipoterminosimporLocal.setcodigo(tipoterminosimpor.getcodigo());	
					tipoterminosimporLocal.setnombre(tipoterminosimpor.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoterminosimpor.getIsDeleted()) {
				if(!existe) {
					tipoterminosimpors.add(tipoterminosimpor);
				}
			} else {
				if(tipoterminosimporEncontrado!=null && permiteQuitar)  {
					tipoterminosimpors.remove(tipoterminosimporEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoTerminosImpor tipoterminosimpor,List<TipoTerminosImpor> tipoterminosimpors) throws Exception {
		try	{			
			for(TipoTerminosImpor tipoterminosimporLocal:tipoterminosimpors) {
				if(tipoterminosimporLocal.getId().equals(tipoterminosimpor.getId())) {
					tipoterminosimporLocal.setIsSelected(tipoterminosimpor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoTerminosImpor(List<TipoTerminosImpor> tipoterminosimporsAux) throws Exception {
		//this.tipoterminosimporsAux=tipoterminosimporsAux;
		
		for(TipoTerminosImpor tipoterminosimporAux:tipoterminosimporsAux) {
			if(tipoterminosimporAux.getIsChanged()) {
				tipoterminosimporAux.setIsChanged(false);
			}		
			
			if(tipoterminosimporAux.getIsNew()) {
				tipoterminosimporAux.setIsNew(false);
			}	
			
			if(tipoterminosimporAux.getIsDeleted()) {
				tipoterminosimporAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoTerminosImpor(TipoTerminosImpor tipoterminosimporAux) throws Exception {
		//this.tipoterminosimporAux=tipoterminosimporAux;
		
			if(tipoterminosimporAux.getIsChanged()) {
				tipoterminosimporAux.setIsChanged(false);
			}		
			
			if(tipoterminosimporAux.getIsNew()) {
				tipoterminosimporAux.setIsNew(false);
			}	
			
			if(tipoterminosimporAux.getIsDeleted()) {
				tipoterminosimporAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoTerminosImpor tipoterminosimporAsignar,TipoTerminosImpor tipoterminosimpor) throws Exception {
		tipoterminosimporAsignar.setId(tipoterminosimpor.getId());	
		tipoterminosimporAsignar.setVersionRow(tipoterminosimpor.getVersionRow());	
		tipoterminosimporAsignar.setcodigo(tipoterminosimpor.getcodigo());	
		tipoterminosimporAsignar.setnombre(tipoterminosimpor.getnombre());	
	}
	
	public static void inicializarTipoTerminosImpor(TipoTerminosImpor tipoterminosimpor) throws Exception {
		try {
				tipoterminosimpor.setId(0L);	
					
				tipoterminosimpor.setcodigo("");	
				tipoterminosimpor.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoTerminosImpor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTerminosImporConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTerminosImporConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoTerminosImpor(String sTipo,Row row,Workbook workbook,TipoTerminosImpor tipoterminosimpor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoterminosimpor.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoterminosimpor.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoTerminosImpor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoTerminosImpor() {
		return this.sFinalQueryTipoTerminosImpor;
	}
	
	public void setsFinalQueryTipoTerminosImpor(String sFinalQueryTipoTerminosImpor) {
		this.sFinalQueryTipoTerminosImpor= sFinalQueryTipoTerminosImpor;
	}
	
	public Border resaltarSeleccionarTipoTerminosImpor=null;
	
	public Border setResaltarSeleccionarTipoTerminosImpor(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTerminosImporBeanSwingJInternalFrame tipoterminosimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoterminosimporBeanSwingJInternalFrame.jTtoolBarTipoTerminosImpor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoTerminosImpor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoTerminosImpor() {
		return this.resaltarSeleccionarTipoTerminosImpor;
	}
	
	public void setResaltarSeleccionarTipoTerminosImpor(Border borderResaltarSeleccionarTipoTerminosImpor) {
		this.resaltarSeleccionarTipoTerminosImpor= borderResaltarSeleccionarTipoTerminosImpor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoTerminosImpor=null;
	public Boolean mostraridTipoTerminosImpor=true;
	public Boolean activaridTipoTerminosImpor=true;

	public Border resaltarcodigoTipoTerminosImpor=null;
	public Boolean mostrarcodigoTipoTerminosImpor=true;
	public Boolean activarcodigoTipoTerminosImpor=true;

	public Border resaltarnombreTipoTerminosImpor=null;
	public Boolean mostrarnombreTipoTerminosImpor=true;
	public Boolean activarnombreTipoTerminosImpor=true;

	
	

	public Border setResaltaridTipoTerminosImpor(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTerminosImporBeanSwingJInternalFrame tipoterminosimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoterminosimporBeanSwingJInternalFrame.jTtoolBarTipoTerminosImpor.setBorder(borderResaltar);
		
		this.resaltaridTipoTerminosImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoTerminosImpor() {
		return this.resaltaridTipoTerminosImpor;
	}

	public void setResaltaridTipoTerminosImpor(Border borderResaltar) {
		this.resaltaridTipoTerminosImpor= borderResaltar;
	}

	public Boolean getMostraridTipoTerminosImpor() {
		return this.mostraridTipoTerminosImpor;
	}

	public void setMostraridTipoTerminosImpor(Boolean mostraridTipoTerminosImpor) {
		this.mostraridTipoTerminosImpor= mostraridTipoTerminosImpor;
	}

	public Boolean getActivaridTipoTerminosImpor() {
		return this.activaridTipoTerminosImpor;
	}

	public void setActivaridTipoTerminosImpor(Boolean activaridTipoTerminosImpor) {
		this.activaridTipoTerminosImpor= activaridTipoTerminosImpor;
	}

	public Border setResaltarcodigoTipoTerminosImpor(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTerminosImporBeanSwingJInternalFrame tipoterminosimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoterminosimporBeanSwingJInternalFrame.jTtoolBarTipoTerminosImpor.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoTerminosImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoTerminosImpor() {
		return this.resaltarcodigoTipoTerminosImpor;
	}

	public void setResaltarcodigoTipoTerminosImpor(Border borderResaltar) {
		this.resaltarcodigoTipoTerminosImpor= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoTerminosImpor() {
		return this.mostrarcodigoTipoTerminosImpor;
	}

	public void setMostrarcodigoTipoTerminosImpor(Boolean mostrarcodigoTipoTerminosImpor) {
		this.mostrarcodigoTipoTerminosImpor= mostrarcodigoTipoTerminosImpor;
	}

	public Boolean getActivarcodigoTipoTerminosImpor() {
		return this.activarcodigoTipoTerminosImpor;
	}

	public void setActivarcodigoTipoTerminosImpor(Boolean activarcodigoTipoTerminosImpor) {
		this.activarcodigoTipoTerminosImpor= activarcodigoTipoTerminosImpor;
	}

	public Border setResaltarnombreTipoTerminosImpor(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTerminosImporBeanSwingJInternalFrame tipoterminosimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoterminosimporBeanSwingJInternalFrame.jTtoolBarTipoTerminosImpor.setBorder(borderResaltar);
		
		this.resaltarnombreTipoTerminosImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoTerminosImpor() {
		return this.resaltarnombreTipoTerminosImpor;
	}

	public void setResaltarnombreTipoTerminosImpor(Border borderResaltar) {
		this.resaltarnombreTipoTerminosImpor= borderResaltar;
	}

	public Boolean getMostrarnombreTipoTerminosImpor() {
		return this.mostrarnombreTipoTerminosImpor;
	}

	public void setMostrarnombreTipoTerminosImpor(Boolean mostrarnombreTipoTerminosImpor) {
		this.mostrarnombreTipoTerminosImpor= mostrarnombreTipoTerminosImpor;
	}

	public Boolean getActivarnombreTipoTerminosImpor() {
		return this.activarnombreTipoTerminosImpor;
	}

	public void setActivarnombreTipoTerminosImpor(Boolean activarnombreTipoTerminosImpor) {
		this.activarnombreTipoTerminosImpor= activarnombreTipoTerminosImpor;
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
		
		
		this.setMostraridTipoTerminosImpor(esInicial);
		this.setMostrarcodigoTipoTerminosImpor(esInicial);
		this.setMostrarnombreTipoTerminosImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTerminosImporConstantesFunciones.ID)) {
				this.setMostraridTipoTerminosImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTerminosImporConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoTerminosImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTerminosImporConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoTerminosImpor(esAsigna);
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
		
		
		this.setActivaridTipoTerminosImpor(esInicial);
		this.setActivarcodigoTipoTerminosImpor(esInicial);
		this.setActivarnombreTipoTerminosImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTerminosImporConstantesFunciones.ID)) {
				this.setActivaridTipoTerminosImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTerminosImporConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoTerminosImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTerminosImporConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoTerminosImpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTerminosImporBeanSwingJInternalFrame tipoterminosimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoTerminosImpor(esInicial);
		this.setResaltarcodigoTipoTerminosImpor(esInicial);
		this.setResaltarnombreTipoTerminosImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTerminosImporConstantesFunciones.ID)) {
				this.setResaltaridTipoTerminosImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTerminosImporConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoTerminosImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTerminosImporConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoTerminosImpor(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTerminosImporBeanSwingJInternalFrame tipoterminosimporBeanSwingJInternalFrame*/)throws Exception {	
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
	
	
	//CONTROL_FUNCION2
}