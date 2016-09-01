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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.EstadoFactuImpreConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoFactuImpreParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoFactuImpreParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoFactuImpreConstantesFunciones extends EstadoFactuImpreConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoFactuImpre";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoFactuImpre"+EstadoFactuImpreConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoFactuImpreHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoFactuImpreHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoFactuImpreConstantesFunciones.SCHEMA+"_"+EstadoFactuImpreConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoFactuImpreHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoFactuImpreConstantesFunciones.SCHEMA+"_"+EstadoFactuImpreConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoFactuImpreConstantesFunciones.SCHEMA+"_"+EstadoFactuImpreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoFactuImpreHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoFactuImpreConstantesFunciones.SCHEMA+"_"+EstadoFactuImpreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFactuImpreConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoFactuImpreHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFactuImpreConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFactuImpreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoFactuImpreHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFactuImpreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoFactuImpreConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoFactuImpreConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoFactuImpreConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoFactuImpreConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Factu Impres";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Factu Impre";
	public static final String SCLASSWEBTITULO_LOWER="Estado Factu Impre";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoFactuImpre";
	public static final String OBJECTNAME="estadofactuimpre";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="estado_factu_impre";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadofactuimpre from "+EstadoFactuImpreConstantesFunciones.SPERSISTENCENAME+" estadofactuimpre";
	public static String QUERYSELECTNATIVE="select "+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+".id,"+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+".version_row,"+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+".codigo,"+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+".nombre from "+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME;//+" as "+EstadoFactuImpreConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoFactuImpreConstantesFuncionesAdditional estadofactuimpreConstantesFuncionesAdditional=null;
	
	public EstadoFactuImpreConstantesFuncionesAdditional getEstadoFactuImpreConstantesFuncionesAdditional() {
		return this.estadofactuimpreConstantesFuncionesAdditional;
	}
	
	public void setEstadoFactuImpreConstantesFuncionesAdditional(EstadoFactuImpreConstantesFuncionesAdditional estadofactuimpreConstantesFuncionesAdditional) {
		try {
			this.estadofactuimpreConstantesFuncionesAdditional=estadofactuimpreConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
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
	
	public static String getEstadoFactuImpreLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoFactuImpreConstantesFunciones.CODIGO)) {sLabelColumna=EstadoFactuImpreConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoFactuImpreConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoFactuImpreConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoFactuImpreDescripcion(EstadoFactuImpre estadofactuimpre) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadofactuimpre !=null/* && estadofactuimpre.getId()!=0*/) {
			sDescripcion=estadofactuimpre.getcodigo();//estadofactuimpreestadofactuimpre.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoFactuImpreDescripcionDetallado(EstadoFactuImpre estadofactuimpre) {
		String sDescripcion="";
			
		sDescripcion+=EstadoFactuImpreConstantesFunciones.ID+"=";
		sDescripcion+=estadofactuimpre.getId().toString()+",";
		sDescripcion+=EstadoFactuImpreConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadofactuimpre.getVersionRow().toString()+",";
		sDescripcion+=EstadoFactuImpreConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadofactuimpre.getcodigo()+",";
		sDescripcion+=EstadoFactuImpreConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadofactuimpre.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoFactuImpreDescripcion(EstadoFactuImpre estadofactuimpre,String sValor) throws Exception {			
		if(estadofactuimpre !=null) {
			estadofactuimpre.setcodigo(sValor);;//estadofactuimpreestadofactuimpre.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("PorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndicePorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadoFactuImpre(EstadoFactuImpre estadofactuimpre,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadofactuimpre.setcodigo(estadofactuimpre.getcodigo().trim());
		estadofactuimpre.setnombre(estadofactuimpre.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoFactuImpres(List<EstadoFactuImpre> estadofactuimpres,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoFactuImpre estadofactuimpre: estadofactuimpres) {
			estadofactuimpre.setcodigo(estadofactuimpre.getcodigo().trim());
			estadofactuimpre.setnombre(estadofactuimpre.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoFactuImpre(EstadoFactuImpre estadofactuimpre,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadofactuimpre.getConCambioAuxiliar()) {
			estadofactuimpre.setIsDeleted(estadofactuimpre.getIsDeletedAuxiliar());	
			estadofactuimpre.setIsNew(estadofactuimpre.getIsNewAuxiliar());	
			estadofactuimpre.setIsChanged(estadofactuimpre.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadofactuimpre.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadofactuimpre.setIsDeletedAuxiliar(false);	
			estadofactuimpre.setIsNewAuxiliar(false);	
			estadofactuimpre.setIsChangedAuxiliar(false);
			
			estadofactuimpre.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoFactuImpres(List<EstadoFactuImpre> estadofactuimpres,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoFactuImpre estadofactuimpre : estadofactuimpres) {
			if(conAsignarBase && estadofactuimpre.getConCambioAuxiliar()) {
				estadofactuimpre.setIsDeleted(estadofactuimpre.getIsDeletedAuxiliar());	
				estadofactuimpre.setIsNew(estadofactuimpre.getIsNewAuxiliar());	
				estadofactuimpre.setIsChanged(estadofactuimpre.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadofactuimpre.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadofactuimpre.setIsDeletedAuxiliar(false);	
				estadofactuimpre.setIsNewAuxiliar(false);	
				estadofactuimpre.setIsChangedAuxiliar(false);
				
				estadofactuimpre.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoFactuImpre(EstadoFactuImpre estadofactuimpre,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoFactuImpres(List<EstadoFactuImpre> estadofactuimpres,Boolean conEnteros) throws Exception  {
		
		for(EstadoFactuImpre estadofactuimpre: estadofactuimpres) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoFactuImpre(List<EstadoFactuImpre> estadofactuimpres,EstadoFactuImpre estadofactuimpreAux) throws Exception  {
		EstadoFactuImpreConstantesFunciones.InicializarValoresEstadoFactuImpre(estadofactuimpreAux,true);
		
		for(EstadoFactuImpre estadofactuimpre: estadofactuimpres) {
			if(estadofactuimpre.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoFactuImpre(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoFactuImpreConstantesFunciones.getArrayColumnasGlobalesEstadoFactuImpre(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoFactuImpre(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoFactuImpre(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoFactuImpre> estadofactuimpres,EstadoFactuImpre estadofactuimpre,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoFactuImpre estadofactuimpreAux: estadofactuimpres) {
			if(estadofactuimpreAux!=null && estadofactuimpre!=null) {
				if((estadofactuimpreAux.getId()==null && estadofactuimpre.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadofactuimpreAux.getId()!=null && estadofactuimpre.getId()!=null){
					if(estadofactuimpreAux.getId().equals(estadofactuimpre.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoFactuImpre(List<EstadoFactuImpre> estadofactuimpres) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoFactuImpre estadofactuimpre: estadofactuimpres) {			
			if(estadofactuimpre.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoFactuImpre() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoFactuImpreConstantesFunciones.LABEL_ID, EstadoFactuImpreConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoFactuImpreConstantesFunciones.LABEL_VERSIONROW, EstadoFactuImpreConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoFactuImpreConstantesFunciones.LABEL_CODIGO, EstadoFactuImpreConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoFactuImpreConstantesFunciones.LABEL_NOMBRE, EstadoFactuImpreConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoFactuImpre() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoFactuImpreConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoFactuImpreConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoFactuImpreConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoFactuImpreConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoFactuImpre() throws Exception  {
		return EstadoFactuImpreConstantesFunciones.getTiposSeleccionarEstadoFactuImpre(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoFactuImpre(Boolean conFk) throws Exception  {
		return EstadoFactuImpreConstantesFunciones.getTiposSeleccionarEstadoFactuImpre(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoFactuImpre(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoFactuImpreConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoFactuImpreConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoFactuImpreConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoFactuImpreConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoFactuImpre(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoFactuImpre(EstadoFactuImpre estadofactuimpreAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoFactuImpre(List<EstadoFactuImpre> estadofactuimpresTemp) throws Exception {
		for(EstadoFactuImpre estadofactuimpreAux:estadofactuimpresTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoFactuImpre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoFactuImpre(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoFactuImpre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoFactuImpreConstantesFunciones.getClassesRelationshipsOfEstadoFactuImpre(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoFactuImpre(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FacturaImpresion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaImpresion.class)) {
						classes.add(new Classe(FacturaImpresion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoFactuImpre(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoFactuImpreConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoFactuImpre(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoFactuImpre(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaImpresion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaImpresion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaImpresion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaImpresion.class)); continue;
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
	public static void actualizarLista(EstadoFactuImpre estadofactuimpre,List<EstadoFactuImpre> estadofactuimpres,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoFactuImpre estadofactuimpreEncontrado=null;
			
			for(EstadoFactuImpre estadofactuimpreLocal:estadofactuimpres) {
				if(estadofactuimpreLocal.getId().equals(estadofactuimpre.getId())) {
					estadofactuimpreEncontrado=estadofactuimpreLocal;
					
					estadofactuimpreLocal.setIsChanged(estadofactuimpre.getIsChanged());
					estadofactuimpreLocal.setIsNew(estadofactuimpre.getIsNew());
					estadofactuimpreLocal.setIsDeleted(estadofactuimpre.getIsDeleted());
					
					estadofactuimpreLocal.setGeneralEntityOriginal(estadofactuimpre.getGeneralEntityOriginal());
					
					estadofactuimpreLocal.setId(estadofactuimpre.getId());	
					estadofactuimpreLocal.setVersionRow(estadofactuimpre.getVersionRow());	
					estadofactuimpreLocal.setcodigo(estadofactuimpre.getcodigo());	
					estadofactuimpreLocal.setnombre(estadofactuimpre.getnombre());	
					
					
					estadofactuimpreLocal.setFacturaImpresions(estadofactuimpre.getFacturaImpresions());
					
					existe=true;
					break;
				}
			}
			
			if(!estadofactuimpre.getIsDeleted()) {
				if(!existe) {
					estadofactuimpres.add(estadofactuimpre);
				}
			} else {
				if(estadofactuimpreEncontrado!=null && permiteQuitar)  {
					estadofactuimpres.remove(estadofactuimpreEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoFactuImpre estadofactuimpre,List<EstadoFactuImpre> estadofactuimpres) throws Exception {
		try	{			
			for(EstadoFactuImpre estadofactuimpreLocal:estadofactuimpres) {
				if(estadofactuimpreLocal.getId().equals(estadofactuimpre.getId())) {
					estadofactuimpreLocal.setIsSelected(estadofactuimpre.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoFactuImpre(List<EstadoFactuImpre> estadofactuimpresAux) throws Exception {
		//this.estadofactuimpresAux=estadofactuimpresAux;
		
		for(EstadoFactuImpre estadofactuimpreAux:estadofactuimpresAux) {
			if(estadofactuimpreAux.getIsChanged()) {
				estadofactuimpreAux.setIsChanged(false);
			}		
			
			if(estadofactuimpreAux.getIsNew()) {
				estadofactuimpreAux.setIsNew(false);
			}	
			
			if(estadofactuimpreAux.getIsDeleted()) {
				estadofactuimpreAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoFactuImpre(EstadoFactuImpre estadofactuimpreAux) throws Exception {
		//this.estadofactuimpreAux=estadofactuimpreAux;
		
			if(estadofactuimpreAux.getIsChanged()) {
				estadofactuimpreAux.setIsChanged(false);
			}		
			
			if(estadofactuimpreAux.getIsNew()) {
				estadofactuimpreAux.setIsNew(false);
			}	
			
			if(estadofactuimpreAux.getIsDeleted()) {
				estadofactuimpreAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoFactuImpre estadofactuimpreAsignar,EstadoFactuImpre estadofactuimpre) throws Exception {
		estadofactuimpreAsignar.setId(estadofactuimpre.getId());	
		estadofactuimpreAsignar.setVersionRow(estadofactuimpre.getVersionRow());	
		estadofactuimpreAsignar.setcodigo(estadofactuimpre.getcodigo());	
		estadofactuimpreAsignar.setnombre(estadofactuimpre.getnombre());	
	}
	
	public static void inicializarEstadoFactuImpre(EstadoFactuImpre estadofactuimpre) throws Exception {
		try {
				estadofactuimpre.setId(0L);	
					
				estadofactuimpre.setcodigo("");	
				estadofactuimpre.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoFactuImpre(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoFactuImpreConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoFactuImpreConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoFactuImpre(String sTipo,Row row,Workbook workbook,EstadoFactuImpre estadofactuimpre,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadofactuimpre.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadofactuimpre.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoFactuImpre=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoFactuImpre() {
		return this.sFinalQueryEstadoFactuImpre;
	}
	
	public void setsFinalQueryEstadoFactuImpre(String sFinalQueryEstadoFactuImpre) {
		this.sFinalQueryEstadoFactuImpre= sFinalQueryEstadoFactuImpre;
	}
	
	public Border resaltarSeleccionarEstadoFactuImpre=null;
	
	public Border setResaltarSeleccionarEstadoFactuImpre(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFactuImpreBeanSwingJInternalFrame estadofactuimpreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadofactuimpreBeanSwingJInternalFrame.jTtoolBarEstadoFactuImpre.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoFactuImpre= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoFactuImpre() {
		return this.resaltarSeleccionarEstadoFactuImpre;
	}
	
	public void setResaltarSeleccionarEstadoFactuImpre(Border borderResaltarSeleccionarEstadoFactuImpre) {
		this.resaltarSeleccionarEstadoFactuImpre= borderResaltarSeleccionarEstadoFactuImpre;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoFactuImpre=null;
	public Boolean mostraridEstadoFactuImpre=true;
	public Boolean activaridEstadoFactuImpre=true;

	public Border resaltarcodigoEstadoFactuImpre=null;
	public Boolean mostrarcodigoEstadoFactuImpre=true;
	public Boolean activarcodigoEstadoFactuImpre=true;

	public Border resaltarnombreEstadoFactuImpre=null;
	public Boolean mostrarnombreEstadoFactuImpre=true;
	public Boolean activarnombreEstadoFactuImpre=true;

	
	

	public Border setResaltaridEstadoFactuImpre(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFactuImpreBeanSwingJInternalFrame estadofactuimpreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadofactuimpreBeanSwingJInternalFrame.jTtoolBarEstadoFactuImpre.setBorder(borderResaltar);
		
		this.resaltaridEstadoFactuImpre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoFactuImpre() {
		return this.resaltaridEstadoFactuImpre;
	}

	public void setResaltaridEstadoFactuImpre(Border borderResaltar) {
		this.resaltaridEstadoFactuImpre= borderResaltar;
	}

	public Boolean getMostraridEstadoFactuImpre() {
		return this.mostraridEstadoFactuImpre;
	}

	public void setMostraridEstadoFactuImpre(Boolean mostraridEstadoFactuImpre) {
		this.mostraridEstadoFactuImpre= mostraridEstadoFactuImpre;
	}

	public Boolean getActivaridEstadoFactuImpre() {
		return this.activaridEstadoFactuImpre;
	}

	public void setActivaridEstadoFactuImpre(Boolean activaridEstadoFactuImpre) {
		this.activaridEstadoFactuImpre= activaridEstadoFactuImpre;
	}

	public Border setResaltarcodigoEstadoFactuImpre(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFactuImpreBeanSwingJInternalFrame estadofactuimpreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadofactuimpreBeanSwingJInternalFrame.jTtoolBarEstadoFactuImpre.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoFactuImpre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoFactuImpre() {
		return this.resaltarcodigoEstadoFactuImpre;
	}

	public void setResaltarcodigoEstadoFactuImpre(Border borderResaltar) {
		this.resaltarcodigoEstadoFactuImpre= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoFactuImpre() {
		return this.mostrarcodigoEstadoFactuImpre;
	}

	public void setMostrarcodigoEstadoFactuImpre(Boolean mostrarcodigoEstadoFactuImpre) {
		this.mostrarcodigoEstadoFactuImpre= mostrarcodigoEstadoFactuImpre;
	}

	public Boolean getActivarcodigoEstadoFactuImpre() {
		return this.activarcodigoEstadoFactuImpre;
	}

	public void setActivarcodigoEstadoFactuImpre(Boolean activarcodigoEstadoFactuImpre) {
		this.activarcodigoEstadoFactuImpre= activarcodigoEstadoFactuImpre;
	}

	public Border setResaltarnombreEstadoFactuImpre(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFactuImpreBeanSwingJInternalFrame estadofactuimpreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadofactuimpreBeanSwingJInternalFrame.jTtoolBarEstadoFactuImpre.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoFactuImpre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoFactuImpre() {
		return this.resaltarnombreEstadoFactuImpre;
	}

	public void setResaltarnombreEstadoFactuImpre(Border borderResaltar) {
		this.resaltarnombreEstadoFactuImpre= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoFactuImpre() {
		return this.mostrarnombreEstadoFactuImpre;
	}

	public void setMostrarnombreEstadoFactuImpre(Boolean mostrarnombreEstadoFactuImpre) {
		this.mostrarnombreEstadoFactuImpre= mostrarnombreEstadoFactuImpre;
	}

	public Boolean getActivarnombreEstadoFactuImpre() {
		return this.activarnombreEstadoFactuImpre;
	}

	public void setActivarnombreEstadoFactuImpre(Boolean activarnombreEstadoFactuImpre) {
		this.activarnombreEstadoFactuImpre= activarnombreEstadoFactuImpre;
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
		
		
		this.setMostraridEstadoFactuImpre(esInicial);
		this.setMostrarcodigoEstadoFactuImpre(esInicial);
		this.setMostrarnombreEstadoFactuImpre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoFactuImpreConstantesFunciones.ID)) {
				this.setMostraridEstadoFactuImpre(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFactuImpreConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoFactuImpre(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFactuImpreConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoFactuImpre(esAsigna);
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
		
		
		this.setActivaridEstadoFactuImpre(esInicial);
		this.setActivarcodigoEstadoFactuImpre(esInicial);
		this.setActivarnombreEstadoFactuImpre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoFactuImpreConstantesFunciones.ID)) {
				this.setActivaridEstadoFactuImpre(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFactuImpreConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoFactuImpre(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFactuImpreConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoFactuImpre(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoFactuImpreBeanSwingJInternalFrame estadofactuimpreBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoFactuImpre(esInicial);
		this.setResaltarcodigoEstadoFactuImpre(esInicial);
		this.setResaltarnombreEstadoFactuImpre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoFactuImpreConstantesFunciones.ID)) {
				this.setResaltaridEstadoFactuImpre(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFactuImpreConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoFactuImpre(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFactuImpreConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoFactuImpre(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFacturaImpresionEstadoFactuImpre=null;

	public Border getResaltarFacturaImpresionEstadoFactuImpre() {
		return this.resaltarFacturaImpresionEstadoFactuImpre;
	}

	public void setResaltarFacturaImpresionEstadoFactuImpre(Border borderResaltarFacturaImpresion) {
		if(borderResaltarFacturaImpresion!=null) {
			this.resaltarFacturaImpresionEstadoFactuImpre= borderResaltarFacturaImpresion;
		}
	}

	public Border setResaltarFacturaImpresionEstadoFactuImpre(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFactuImpreBeanSwingJInternalFrame estadofactuimpreBeanSwingJInternalFrame*/) {
		Border borderResaltarFacturaImpresion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadofactuimpreBeanSwingJInternalFrame.jTtoolBarEstadoFactuImpre.setBorder(borderResaltarFacturaImpresion);
			
		this.resaltarFacturaImpresionEstadoFactuImpre= borderResaltarFacturaImpresion;

		 return borderResaltarFacturaImpresion;
	}



	public Boolean mostrarFacturaImpresionEstadoFactuImpre=true;

	public Boolean getMostrarFacturaImpresionEstadoFactuImpre() {
		return this.mostrarFacturaImpresionEstadoFactuImpre;
	}

	public void setMostrarFacturaImpresionEstadoFactuImpre(Boolean visibilidadResaltarFacturaImpresion) {
		this.mostrarFacturaImpresionEstadoFactuImpre= visibilidadResaltarFacturaImpresion;
	}



	public Boolean activarFacturaImpresionEstadoFactuImpre=true;

	public Boolean gethabilitarResaltarFacturaImpresionEstadoFactuImpre() {
		return this.activarFacturaImpresionEstadoFactuImpre;
	}

	public void setActivarFacturaImpresionEstadoFactuImpre(Boolean habilitarResaltarFacturaImpresion) {
		this.activarFacturaImpresionEstadoFactuImpre= habilitarResaltarFacturaImpresion;
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

		this.setMostrarFacturaImpresionEstadoFactuImpre(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FacturaImpresion.class)) {
				this.setMostrarFacturaImpresionEstadoFactuImpre(esAsigna);
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

		this.setActivarFacturaImpresionEstadoFactuImpre(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FacturaImpresion.class)) {
				this.setActivarFacturaImpresionEstadoFactuImpre(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoFactuImpreBeanSwingJInternalFrame estadofactuimpreBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFacturaImpresionEstadoFactuImpre(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FacturaImpresion.class)) {
				this.setResaltarFacturaImpresionEstadoFactuImpre(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}