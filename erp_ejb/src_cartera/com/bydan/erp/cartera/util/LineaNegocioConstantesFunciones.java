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


import com.bydan.erp.cartera.util.LineaNegocioConstantesFunciones;
import com.bydan.erp.cartera.util.LineaNegocioParameterReturnGeneral;
//import com.bydan.erp.cartera.util.LineaNegocioParameterGeneral;

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
final public class LineaNegocioConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="LineaNegocio";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="LineaNegocio"+LineaNegocioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="LineaNegocioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="LineaNegocioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=LineaNegocioConstantesFunciones.SCHEMA+"_"+LineaNegocioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/LineaNegocioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=LineaNegocioConstantesFunciones.SCHEMA+"_"+LineaNegocioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=LineaNegocioConstantesFunciones.SCHEMA+"_"+LineaNegocioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/LineaNegocioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=LineaNegocioConstantesFunciones.SCHEMA+"_"+LineaNegocioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaNegocioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LineaNegocioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaNegocioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaNegocioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LineaNegocioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaNegocioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=LineaNegocioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+LineaNegocioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=LineaNegocioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+LineaNegocioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Linea_negocios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Linea_negocio";
	public static final String SCLASSWEBTITULO_LOWER="Linea Negocio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="LineaNegocio";
	public static final String OBJECTNAME="lineanegocio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="linea_negocio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select lineanegocio from "+LineaNegocioConstantesFunciones.SPERSISTENCENAME+" lineanegocio";
	public static String QUERYSELECTNATIVE="select "+LineaNegocioConstantesFunciones.SCHEMA+"."+LineaNegocioConstantesFunciones.TABLENAME+".id,"+LineaNegocioConstantesFunciones.SCHEMA+"."+LineaNegocioConstantesFunciones.TABLENAME+".version_row,"+LineaNegocioConstantesFunciones.SCHEMA+"."+LineaNegocioConstantesFunciones.TABLENAME+".id_empresa,"+LineaNegocioConstantesFunciones.SCHEMA+"."+LineaNegocioConstantesFunciones.TABLENAME+".codigo,"+LineaNegocioConstantesFunciones.SCHEMA+"."+LineaNegocioConstantesFunciones.TABLENAME+".nombre from "+LineaNegocioConstantesFunciones.SCHEMA+"."+LineaNegocioConstantesFunciones.TABLENAME;//+" as "+LineaNegocioConstantesFunciones.TABLENAME;
	
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
	
	public static String getLineaNegocioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(LineaNegocioConstantesFunciones.IDEMPRESA)) {sLabelColumna=LineaNegocioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(LineaNegocioConstantesFunciones.CODIGO)) {sLabelColumna=LineaNegocioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(LineaNegocioConstantesFunciones.NOMBRE)) {sLabelColumna=LineaNegocioConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getLineaNegocioDescripcion(LineaNegocio lineanegocio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(lineanegocio !=null/* && lineanegocio.getId()!=0*/) {
			sDescripcion=lineanegocio.getcodigo();//lineanegociolineanegocio.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getLineaNegocioDescripcionDetallado(LineaNegocio lineanegocio) {
		String sDescripcion="";
			
		sDescripcion+=LineaNegocioConstantesFunciones.ID+"=";
		sDescripcion+=lineanegocio.getId().toString()+",";
		sDescripcion+=LineaNegocioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=lineanegocio.getVersionRow().toString()+",";
		sDescripcion+=LineaNegocioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=lineanegocio.getid_empresa().toString()+",";
		sDescripcion+=LineaNegocioConstantesFunciones.CODIGO+"=";
		sDescripcion+=lineanegocio.getcodigo()+",";
		sDescripcion+=LineaNegocioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=lineanegocio.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setLineaNegocioDescripcion(LineaNegocio lineanegocio,String sValor) throws Exception {			
		if(lineanegocio !=null) {
			lineanegocio.setcodigo(sValor);;//lineanegociolineanegocio.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosLineaNegocio(LineaNegocio lineanegocio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		lineanegocio.setcodigo(lineanegocio.getcodigo().trim());
		lineanegocio.setnombre(lineanegocio.getnombre().trim());
	}
	
	public static void quitarEspaciosLineaNegocios(List<LineaNegocio> lineanegocios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(LineaNegocio lineanegocio: lineanegocios) {
			lineanegocio.setcodigo(lineanegocio.getcodigo().trim());
			lineanegocio.setnombre(lineanegocio.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLineaNegocio(LineaNegocio lineanegocio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && lineanegocio.getConCambioAuxiliar()) {
			lineanegocio.setIsDeleted(lineanegocio.getIsDeletedAuxiliar());	
			lineanegocio.setIsNew(lineanegocio.getIsNewAuxiliar());	
			lineanegocio.setIsChanged(lineanegocio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			lineanegocio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			lineanegocio.setIsDeletedAuxiliar(false);	
			lineanegocio.setIsNewAuxiliar(false);	
			lineanegocio.setIsChangedAuxiliar(false);
			
			lineanegocio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLineaNegocios(List<LineaNegocio> lineanegocios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(LineaNegocio lineanegocio : lineanegocios) {
			if(conAsignarBase && lineanegocio.getConCambioAuxiliar()) {
				lineanegocio.setIsDeleted(lineanegocio.getIsDeletedAuxiliar());	
				lineanegocio.setIsNew(lineanegocio.getIsNewAuxiliar());	
				lineanegocio.setIsChanged(lineanegocio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				lineanegocio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				lineanegocio.setIsDeletedAuxiliar(false);	
				lineanegocio.setIsNewAuxiliar(false);	
				lineanegocio.setIsChangedAuxiliar(false);
				
				lineanegocio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresLineaNegocio(LineaNegocio lineanegocio,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresLineaNegocios(List<LineaNegocio> lineanegocios,Boolean conEnteros) throws Exception  {
		
		for(LineaNegocio lineanegocio: lineanegocios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaLineaNegocio(List<LineaNegocio> lineanegocios,LineaNegocio lineanegocioAux) throws Exception  {
		LineaNegocioConstantesFunciones.InicializarValoresLineaNegocio(lineanegocioAux,true);
		
		for(LineaNegocio lineanegocio: lineanegocios) {
			if(lineanegocio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesLineaNegocio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=LineaNegocioConstantesFunciones.getArrayColumnasGlobalesLineaNegocio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesLineaNegocio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(LineaNegocioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(LineaNegocioConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoLineaNegocio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<LineaNegocio> lineanegocios,LineaNegocio lineanegocio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(LineaNegocio lineanegocioAux: lineanegocios) {
			if(lineanegocioAux!=null && lineanegocio!=null) {
				if((lineanegocioAux.getId()==null && lineanegocio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(lineanegocioAux.getId()!=null && lineanegocio.getId()!=null){
					if(lineanegocioAux.getId().equals(lineanegocio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaLineaNegocio(List<LineaNegocio> lineanegocios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(LineaNegocio lineanegocio: lineanegocios) {			
			if(lineanegocio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaLineaNegocio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,LineaNegocioConstantesFunciones.LABEL_ID, LineaNegocioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaNegocioConstantesFunciones.LABEL_VERSIONROW, LineaNegocioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaNegocioConstantesFunciones.LABEL_IDEMPRESA, LineaNegocioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaNegocioConstantesFunciones.LABEL_CODIGO, LineaNegocioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaNegocioConstantesFunciones.LABEL_NOMBRE, LineaNegocioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasLineaNegocio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=LineaNegocioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaNegocioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaNegocioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaNegocioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaNegocioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLineaNegocio() throws Exception  {
		return LineaNegocioConstantesFunciones.getTiposSeleccionarLineaNegocio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLineaNegocio(Boolean conFk) throws Exception  {
		return LineaNegocioConstantesFunciones.getTiposSeleccionarLineaNegocio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLineaNegocio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaNegocioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(LineaNegocioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaNegocioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(LineaNegocioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaNegocioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(LineaNegocioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesLineaNegocio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesLineaNegocio(LineaNegocio lineanegocioAux) throws Exception {
		
			lineanegocioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(lineanegocioAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesLineaNegocio(List<LineaNegocio> lineanegociosTemp) throws Exception {
		for(LineaNegocio lineanegocioAux:lineanegociosTemp) {
			
			lineanegocioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(lineanegocioAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfLineaNegocio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfLineaNegocio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfLineaNegocio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return LineaNegocioConstantesFunciones.getClassesRelationshipsOfLineaNegocio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLineaNegocio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PoliticasCliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PoliticasCliente.class)) {
						classes.add(new Classe(PoliticasCliente.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLineaNegocio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return LineaNegocioConstantesFunciones.getClassesRelationshipsFromStringsOfLineaNegocio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLineaNegocio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PoliticasCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticasCliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PoliticasCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticasCliente.class)); continue;
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
	public static void actualizarLista(LineaNegocio lineanegocio,List<LineaNegocio> lineanegocios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			LineaNegocio lineanegocioEncontrado=null;
			
			for(LineaNegocio lineanegocioLocal:lineanegocios) {
				if(lineanegocioLocal.getId().equals(lineanegocio.getId())) {
					lineanegocioEncontrado=lineanegocioLocal;
					
					lineanegocioLocal.setIsChanged(lineanegocio.getIsChanged());
					lineanegocioLocal.setIsNew(lineanegocio.getIsNew());
					lineanegocioLocal.setIsDeleted(lineanegocio.getIsDeleted());
					
					lineanegocioLocal.setGeneralEntityOriginal(lineanegocio.getGeneralEntityOriginal());
					
					lineanegocioLocal.setId(lineanegocio.getId());	
					lineanegocioLocal.setVersionRow(lineanegocio.getVersionRow());	
					lineanegocioLocal.setid_empresa(lineanegocio.getid_empresa());	
					lineanegocioLocal.setcodigo(lineanegocio.getcodigo());	
					lineanegocioLocal.setnombre(lineanegocio.getnombre());	
					
					
					lineanegocioLocal.setPoliticasClientes(lineanegocio.getPoliticasClientes());
					
					existe=true;
					break;
				}
			}
			
			if(!lineanegocio.getIsDeleted()) {
				if(!existe) {
					lineanegocios.add(lineanegocio);
				}
			} else {
				if(lineanegocioEncontrado!=null && permiteQuitar)  {
					lineanegocios.remove(lineanegocioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(LineaNegocio lineanegocio,List<LineaNegocio> lineanegocios) throws Exception {
		try	{			
			for(LineaNegocio lineanegocioLocal:lineanegocios) {
				if(lineanegocioLocal.getId().equals(lineanegocio.getId())) {
					lineanegocioLocal.setIsSelected(lineanegocio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesLineaNegocio(List<LineaNegocio> lineanegociosAux) throws Exception {
		//this.lineanegociosAux=lineanegociosAux;
		
		for(LineaNegocio lineanegocioAux:lineanegociosAux) {
			if(lineanegocioAux.getIsChanged()) {
				lineanegocioAux.setIsChanged(false);
			}		
			
			if(lineanegocioAux.getIsNew()) {
				lineanegocioAux.setIsNew(false);
			}	
			
			if(lineanegocioAux.getIsDeleted()) {
				lineanegocioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesLineaNegocio(LineaNegocio lineanegocioAux) throws Exception {
		//this.lineanegocioAux=lineanegocioAux;
		
			if(lineanegocioAux.getIsChanged()) {
				lineanegocioAux.setIsChanged(false);
			}		
			
			if(lineanegocioAux.getIsNew()) {
				lineanegocioAux.setIsNew(false);
			}	
			
			if(lineanegocioAux.getIsDeleted()) {
				lineanegocioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(LineaNegocio lineanegocioAsignar,LineaNegocio lineanegocio) throws Exception {
		lineanegocioAsignar.setId(lineanegocio.getId());	
		lineanegocioAsignar.setVersionRow(lineanegocio.getVersionRow());	
		lineanegocioAsignar.setid_empresa(lineanegocio.getid_empresa());
		lineanegocioAsignar.setempresa_descripcion(lineanegocio.getempresa_descripcion());	
		lineanegocioAsignar.setcodigo(lineanegocio.getcodigo());	
		lineanegocioAsignar.setnombre(lineanegocio.getnombre());	
	}
	
	public static void inicializarLineaNegocio(LineaNegocio lineanegocio) throws Exception {
		try {
				lineanegocio.setId(0L);	
					
				lineanegocio.setid_empresa(-1L);	
				lineanegocio.setcodigo("");	
				lineanegocio.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderLineaNegocio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaNegocioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaNegocioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaNegocioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataLineaNegocio(String sTipo,Row row,Workbook workbook,LineaNegocio lineanegocio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(lineanegocio.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(lineanegocio.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(lineanegocio.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryLineaNegocio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryLineaNegocio() {
		return this.sFinalQueryLineaNegocio;
	}
	
	public void setsFinalQueryLineaNegocio(String sFinalQueryLineaNegocio) {
		this.sFinalQueryLineaNegocio= sFinalQueryLineaNegocio;
	}
	
	public Border resaltarSeleccionarLineaNegocio=null;
	
	public Border setResaltarSeleccionarLineaNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*LineaNegocioBeanSwingJInternalFrame lineanegocioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//lineanegocioBeanSwingJInternalFrame.jTtoolBarLineaNegocio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarLineaNegocio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarLineaNegocio() {
		return this.resaltarSeleccionarLineaNegocio;
	}
	
	public void setResaltarSeleccionarLineaNegocio(Border borderResaltarSeleccionarLineaNegocio) {
		this.resaltarSeleccionarLineaNegocio= borderResaltarSeleccionarLineaNegocio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridLineaNegocio=null;
	public Boolean mostraridLineaNegocio=true;
	public Boolean activaridLineaNegocio=true;

	public Border resaltarid_empresaLineaNegocio=null;
	public Boolean mostrarid_empresaLineaNegocio=true;
	public Boolean activarid_empresaLineaNegocio=true;
	public Boolean cargarid_empresaLineaNegocio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaLineaNegocio=false;//ConEventDepend=true

	public Border resaltarcodigoLineaNegocio=null;
	public Boolean mostrarcodigoLineaNegocio=true;
	public Boolean activarcodigoLineaNegocio=true;

	public Border resaltarnombreLineaNegocio=null;
	public Boolean mostrarnombreLineaNegocio=true;
	public Boolean activarnombreLineaNegocio=true;

	
	

	public Border setResaltaridLineaNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*LineaNegocioBeanSwingJInternalFrame lineanegocioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineanegocioBeanSwingJInternalFrame.jTtoolBarLineaNegocio.setBorder(borderResaltar);
		
		this.resaltaridLineaNegocio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridLineaNegocio() {
		return this.resaltaridLineaNegocio;
	}

	public void setResaltaridLineaNegocio(Border borderResaltar) {
		this.resaltaridLineaNegocio= borderResaltar;
	}

	public Boolean getMostraridLineaNegocio() {
		return this.mostraridLineaNegocio;
	}

	public void setMostraridLineaNegocio(Boolean mostraridLineaNegocio) {
		this.mostraridLineaNegocio= mostraridLineaNegocio;
	}

	public Boolean getActivaridLineaNegocio() {
		return this.activaridLineaNegocio;
	}

	public void setActivaridLineaNegocio(Boolean activaridLineaNegocio) {
		this.activaridLineaNegocio= activaridLineaNegocio;
	}

	public Border setResaltarid_empresaLineaNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*LineaNegocioBeanSwingJInternalFrame lineanegocioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineanegocioBeanSwingJInternalFrame.jTtoolBarLineaNegocio.setBorder(borderResaltar);
		
		this.resaltarid_empresaLineaNegocio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaLineaNegocio() {
		return this.resaltarid_empresaLineaNegocio;
	}

	public void setResaltarid_empresaLineaNegocio(Border borderResaltar) {
		this.resaltarid_empresaLineaNegocio= borderResaltar;
	}

	public Boolean getMostrarid_empresaLineaNegocio() {
		return this.mostrarid_empresaLineaNegocio;
	}

	public void setMostrarid_empresaLineaNegocio(Boolean mostrarid_empresaLineaNegocio) {
		this.mostrarid_empresaLineaNegocio= mostrarid_empresaLineaNegocio;
	}

	public Boolean getActivarid_empresaLineaNegocio() {
		return this.activarid_empresaLineaNegocio;
	}

	public void setActivarid_empresaLineaNegocio(Boolean activarid_empresaLineaNegocio) {
		this.activarid_empresaLineaNegocio= activarid_empresaLineaNegocio;
	}

	public Boolean getCargarid_empresaLineaNegocio() {
		return this.cargarid_empresaLineaNegocio;
	}

	public void setCargarid_empresaLineaNegocio(Boolean cargarid_empresaLineaNegocio) {
		this.cargarid_empresaLineaNegocio= cargarid_empresaLineaNegocio;
	}

	public Border setResaltarcodigoLineaNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*LineaNegocioBeanSwingJInternalFrame lineanegocioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineanegocioBeanSwingJInternalFrame.jTtoolBarLineaNegocio.setBorder(borderResaltar);
		
		this.resaltarcodigoLineaNegocio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoLineaNegocio() {
		return this.resaltarcodigoLineaNegocio;
	}

	public void setResaltarcodigoLineaNegocio(Border borderResaltar) {
		this.resaltarcodigoLineaNegocio= borderResaltar;
	}

	public Boolean getMostrarcodigoLineaNegocio() {
		return this.mostrarcodigoLineaNegocio;
	}

	public void setMostrarcodigoLineaNegocio(Boolean mostrarcodigoLineaNegocio) {
		this.mostrarcodigoLineaNegocio= mostrarcodigoLineaNegocio;
	}

	public Boolean getActivarcodigoLineaNegocio() {
		return this.activarcodigoLineaNegocio;
	}

	public void setActivarcodigoLineaNegocio(Boolean activarcodigoLineaNegocio) {
		this.activarcodigoLineaNegocio= activarcodigoLineaNegocio;
	}

	public Border setResaltarnombreLineaNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*LineaNegocioBeanSwingJInternalFrame lineanegocioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineanegocioBeanSwingJInternalFrame.jTtoolBarLineaNegocio.setBorder(borderResaltar);
		
		this.resaltarnombreLineaNegocio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreLineaNegocio() {
		return this.resaltarnombreLineaNegocio;
	}

	public void setResaltarnombreLineaNegocio(Border borderResaltar) {
		this.resaltarnombreLineaNegocio= borderResaltar;
	}

	public Boolean getMostrarnombreLineaNegocio() {
		return this.mostrarnombreLineaNegocio;
	}

	public void setMostrarnombreLineaNegocio(Boolean mostrarnombreLineaNegocio) {
		this.mostrarnombreLineaNegocio= mostrarnombreLineaNegocio;
	}

	public Boolean getActivarnombreLineaNegocio() {
		return this.activarnombreLineaNegocio;
	}

	public void setActivarnombreLineaNegocio(Boolean activarnombreLineaNegocio) {
		this.activarnombreLineaNegocio= activarnombreLineaNegocio;
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
		
		
		this.setMostraridLineaNegocio(esInicial);
		this.setMostrarid_empresaLineaNegocio(esInicial);
		this.setMostrarcodigoLineaNegocio(esInicial);
		this.setMostrarnombreLineaNegocio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LineaNegocioConstantesFunciones.ID)) {
				this.setMostraridLineaNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaNegocioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaLineaNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaNegocioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoLineaNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaNegocioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreLineaNegocio(esAsigna);
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
		
		
		this.setActivaridLineaNegocio(esInicial);
		this.setActivarid_empresaLineaNegocio(esInicial);
		this.setActivarcodigoLineaNegocio(esInicial);
		this.setActivarnombreLineaNegocio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LineaNegocioConstantesFunciones.ID)) {
				this.setActivaridLineaNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaNegocioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaLineaNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaNegocioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoLineaNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaNegocioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreLineaNegocio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,LineaNegocioBeanSwingJInternalFrame lineanegocioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridLineaNegocio(esInicial);
		this.setResaltarid_empresaLineaNegocio(esInicial);
		this.setResaltarcodigoLineaNegocio(esInicial);
		this.setResaltarnombreLineaNegocio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LineaNegocioConstantesFunciones.ID)) {
				this.setResaltaridLineaNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaNegocioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaLineaNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaNegocioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoLineaNegocio(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaNegocioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreLineaNegocio(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPoliticasClienteLineaNegocio=null;

	public Border getResaltarPoliticasClienteLineaNegocio() {
		return this.resaltarPoliticasClienteLineaNegocio;
	}

	public void setResaltarPoliticasClienteLineaNegocio(Border borderResaltarPoliticasCliente) {
		if(borderResaltarPoliticasCliente!=null) {
			this.resaltarPoliticasClienteLineaNegocio= borderResaltarPoliticasCliente;
		}
	}

	public Border setResaltarPoliticasClienteLineaNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*LineaNegocioBeanSwingJInternalFrame lineanegocioBeanSwingJInternalFrame*/) {
		Border borderResaltarPoliticasCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//lineanegocioBeanSwingJInternalFrame.jTtoolBarLineaNegocio.setBorder(borderResaltarPoliticasCliente);
			
		this.resaltarPoliticasClienteLineaNegocio= borderResaltarPoliticasCliente;

		 return borderResaltarPoliticasCliente;
	}



	public Boolean mostrarPoliticasClienteLineaNegocio=true;

	public Boolean getMostrarPoliticasClienteLineaNegocio() {
		return this.mostrarPoliticasClienteLineaNegocio;
	}

	public void setMostrarPoliticasClienteLineaNegocio(Boolean visibilidadResaltarPoliticasCliente) {
		this.mostrarPoliticasClienteLineaNegocio= visibilidadResaltarPoliticasCliente;
	}



	public Boolean activarPoliticasClienteLineaNegocio=true;

	public Boolean gethabilitarResaltarPoliticasClienteLineaNegocio() {
		return this.activarPoliticasClienteLineaNegocio;
	}

	public void setActivarPoliticasClienteLineaNegocio(Boolean habilitarResaltarPoliticasCliente) {
		this.activarPoliticasClienteLineaNegocio= habilitarResaltarPoliticasCliente;
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

		this.setMostrarPoliticasClienteLineaNegocio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setMostrarPoliticasClienteLineaNegocio(esAsigna);
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

		this.setActivarPoliticasClienteLineaNegocio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setActivarPoliticasClienteLineaNegocio(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,LineaNegocioBeanSwingJInternalFrame lineanegocioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPoliticasClienteLineaNegocio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setResaltarPoliticasClienteLineaNegocio(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoLineaNegocio=true;

	public Boolean getMostrarBusquedaPorCodigoLineaNegocio() {
		return this.mostrarBusquedaPorCodigoLineaNegocio;
	}

	public void setMostrarBusquedaPorCodigoLineaNegocio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoLineaNegocio= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreLineaNegocio=true;

	public Boolean getMostrarBusquedaPorNombreLineaNegocio() {
		return this.mostrarBusquedaPorNombreLineaNegocio;
	}

	public void setMostrarBusquedaPorNombreLineaNegocio(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreLineaNegocio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaLineaNegocio=true;

	public Boolean getMostrarFK_IdEmpresaLineaNegocio() {
		return this.mostrarFK_IdEmpresaLineaNegocio;
	}

	public void setMostrarFK_IdEmpresaLineaNegocio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaLineaNegocio= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoLineaNegocio=true;

	public Boolean getActivarBusquedaPorCodigoLineaNegocio() {
		return this.activarBusquedaPorCodigoLineaNegocio;
	}

	public void setActivarBusquedaPorCodigoLineaNegocio(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoLineaNegocio= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreLineaNegocio=true;

	public Boolean getActivarBusquedaPorNombreLineaNegocio() {
		return this.activarBusquedaPorNombreLineaNegocio;
	}

	public void setActivarBusquedaPorNombreLineaNegocio(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreLineaNegocio= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaLineaNegocio=true;

	public Boolean getActivarFK_IdEmpresaLineaNegocio() {
		return this.activarFK_IdEmpresaLineaNegocio;
	}

	public void setActivarFK_IdEmpresaLineaNegocio(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaLineaNegocio= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoLineaNegocio=null;

	public Border getResaltarBusquedaPorCodigoLineaNegocio() {
		return this.resaltarBusquedaPorCodigoLineaNegocio;
	}

	public void setResaltarBusquedaPorCodigoLineaNegocio(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoLineaNegocio= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoLineaNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*LineaNegocioBeanSwingJInternalFrame lineanegocioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoLineaNegocio= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreLineaNegocio=null;

	public Border getResaltarBusquedaPorNombreLineaNegocio() {
		return this.resaltarBusquedaPorNombreLineaNegocio;
	}

	public void setResaltarBusquedaPorNombreLineaNegocio(Border borderResaltar) {
		this.resaltarBusquedaPorNombreLineaNegocio= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreLineaNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*LineaNegocioBeanSwingJInternalFrame lineanegocioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreLineaNegocio= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaLineaNegocio=null;

	public Border getResaltarFK_IdEmpresaLineaNegocio() {
		return this.resaltarFK_IdEmpresaLineaNegocio;
	}

	public void setResaltarFK_IdEmpresaLineaNegocio(Border borderResaltar) {
		this.resaltarFK_IdEmpresaLineaNegocio= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaLineaNegocio(ParametroGeneralUsuario parametroGeneralUsuario/*LineaNegocioBeanSwingJInternalFrame lineanegocioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaLineaNegocio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}