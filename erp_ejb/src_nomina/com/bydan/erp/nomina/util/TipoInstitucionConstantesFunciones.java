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


import com.bydan.erp.nomina.util.TipoInstitucionConstantesFunciones;
import com.bydan.erp.nomina.util.TipoInstitucionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoInstitucionParameterGeneral;

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
final public class TipoInstitucionConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoInstitucion";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoInstitucion"+TipoInstitucionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoInstitucionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoInstitucionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoInstitucionConstantesFunciones.SCHEMA+"_"+TipoInstitucionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoInstitucionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoInstitucionConstantesFunciones.SCHEMA+"_"+TipoInstitucionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoInstitucionConstantesFunciones.SCHEMA+"_"+TipoInstitucionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoInstitucionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoInstitucionConstantesFunciones.SCHEMA+"_"+TipoInstitucionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInstitucionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoInstitucionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInstitucionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInstitucionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoInstitucionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInstitucionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoInstitucionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoInstitucionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoInstitucionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoInstitucionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Instituciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Institucion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Institucion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoInstitucion";
	public static final String OBJECTNAME="tipoinstitucion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_institucion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoinstitucion from "+TipoInstitucionConstantesFunciones.SPERSISTENCENAME+" tipoinstitucion";
	public static String QUERYSELECTNATIVE="select "+TipoInstitucionConstantesFunciones.SCHEMA+"."+TipoInstitucionConstantesFunciones.TABLENAME+".id,"+TipoInstitucionConstantesFunciones.SCHEMA+"."+TipoInstitucionConstantesFunciones.TABLENAME+".version_row,"+TipoInstitucionConstantesFunciones.SCHEMA+"."+TipoInstitucionConstantesFunciones.TABLENAME+".id_empresa,"+TipoInstitucionConstantesFunciones.SCHEMA+"."+TipoInstitucionConstantesFunciones.TABLENAME+".codigo,"+TipoInstitucionConstantesFunciones.SCHEMA+"."+TipoInstitucionConstantesFunciones.TABLENAME+".nombre from "+TipoInstitucionConstantesFunciones.SCHEMA+"."+TipoInstitucionConstantesFunciones.TABLENAME;//+" as "+TipoInstitucionConstantesFunciones.TABLENAME;
	
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
    	public static final String LABEL_VERSIONROW= "Version Row";
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
	
	public static String getTipoInstitucionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoInstitucionConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoInstitucionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoInstitucionConstantesFunciones.CODIGO)) {sLabelColumna=TipoInstitucionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoInstitucionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoInstitucionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoInstitucionDescripcion(TipoInstitucion tipoinstitucion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoinstitucion !=null/* && tipoinstitucion.getId()!=0*/) {
			sDescripcion=tipoinstitucion.getcodigo();//tipoinstituciontipoinstitucion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoInstitucionDescripcionDetallado(TipoInstitucion tipoinstitucion) {
		String sDescripcion="";
			
		sDescripcion+=TipoInstitucionConstantesFunciones.ID+"=";
		sDescripcion+=tipoinstitucion.getId().toString()+",";
		sDescripcion+=TipoInstitucionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoinstitucion.getVersionRow().toString()+",";
		sDescripcion+=TipoInstitucionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoinstitucion.getid_empresa().toString()+",";
		sDescripcion+=TipoInstitucionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoinstitucion.getcodigo()+",";
		sDescripcion+=TipoInstitucionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoinstitucion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoInstitucionDescripcion(TipoInstitucion tipoinstitucion,String sValor) throws Exception {			
		if(tipoinstitucion !=null) {
			tipoinstitucion.setcodigo(sValor);;//tipoinstituciontipoinstitucion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoInstitucion(TipoInstitucion tipoinstitucion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoinstitucion.setcodigo(tipoinstitucion.getcodigo().trim());
		tipoinstitucion.setnombre(tipoinstitucion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoInstitucions(List<TipoInstitucion> tipoinstitucions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoInstitucion tipoinstitucion: tipoinstitucions) {
			tipoinstitucion.setcodigo(tipoinstitucion.getcodigo().trim());
			tipoinstitucion.setnombre(tipoinstitucion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoInstitucion(TipoInstitucion tipoinstitucion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoinstitucion.getConCambioAuxiliar()) {
			tipoinstitucion.setIsDeleted(tipoinstitucion.getIsDeletedAuxiliar());	
			tipoinstitucion.setIsNew(tipoinstitucion.getIsNewAuxiliar());	
			tipoinstitucion.setIsChanged(tipoinstitucion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoinstitucion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoinstitucion.setIsDeletedAuxiliar(false);	
			tipoinstitucion.setIsNewAuxiliar(false);	
			tipoinstitucion.setIsChangedAuxiliar(false);
			
			tipoinstitucion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoInstitucions(List<TipoInstitucion> tipoinstitucions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoInstitucion tipoinstitucion : tipoinstitucions) {
			if(conAsignarBase && tipoinstitucion.getConCambioAuxiliar()) {
				tipoinstitucion.setIsDeleted(tipoinstitucion.getIsDeletedAuxiliar());	
				tipoinstitucion.setIsNew(tipoinstitucion.getIsNewAuxiliar());	
				tipoinstitucion.setIsChanged(tipoinstitucion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoinstitucion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoinstitucion.setIsDeletedAuxiliar(false);	
				tipoinstitucion.setIsNewAuxiliar(false);	
				tipoinstitucion.setIsChangedAuxiliar(false);
				
				tipoinstitucion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoInstitucion(TipoInstitucion tipoinstitucion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoInstitucions(List<TipoInstitucion> tipoinstitucions,Boolean conEnteros) throws Exception  {
		
		for(TipoInstitucion tipoinstitucion: tipoinstitucions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoInstitucion(List<TipoInstitucion> tipoinstitucions,TipoInstitucion tipoinstitucionAux) throws Exception  {
		TipoInstitucionConstantesFunciones.InicializarValoresTipoInstitucion(tipoinstitucionAux,true);
		
		for(TipoInstitucion tipoinstitucion: tipoinstitucions) {
			if(tipoinstitucion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoInstitucion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoInstitucionConstantesFunciones.getArrayColumnasGlobalesTipoInstitucion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoInstitucion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoInstitucionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoInstitucionConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoInstitucion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoInstitucion> tipoinstitucions,TipoInstitucion tipoinstitucion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoInstitucion tipoinstitucionAux: tipoinstitucions) {
			if(tipoinstitucionAux!=null && tipoinstitucion!=null) {
				if((tipoinstitucionAux.getId()==null && tipoinstitucion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoinstitucionAux.getId()!=null && tipoinstitucion.getId()!=null){
					if(tipoinstitucionAux.getId().equals(tipoinstitucion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoInstitucion(List<TipoInstitucion> tipoinstitucions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoInstitucion tipoinstitucion: tipoinstitucions) {			
			if(tipoinstitucion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoInstitucion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoInstitucionConstantesFunciones.LABEL_ID, TipoInstitucionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInstitucionConstantesFunciones.LABEL_VERSIONROW, TipoInstitucionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInstitucionConstantesFunciones.LABEL_IDEMPRESA, TipoInstitucionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInstitucionConstantesFunciones.LABEL_CODIGO, TipoInstitucionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInstitucionConstantesFunciones.LABEL_NOMBRE, TipoInstitucionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoInstitucion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoInstitucionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInstitucionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInstitucionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInstitucionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInstitucionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInstitucion() throws Exception  {
		return TipoInstitucionConstantesFunciones.getTiposSeleccionarTipoInstitucion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInstitucion(Boolean conFk) throws Exception  {
		return TipoInstitucionConstantesFunciones.getTiposSeleccionarTipoInstitucion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInstitucion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoInstitucionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoInstitucionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoInstitucionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoInstitucionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoInstitucionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoInstitucionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoInstitucion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoInstitucion(TipoInstitucion tipoinstitucionAux) throws Exception {
		
			tipoinstitucionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoinstitucionAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoInstitucion(List<TipoInstitucion> tipoinstitucionsTemp) throws Exception {
		for(TipoInstitucion tipoinstitucionAux:tipoinstitucionsTemp) {
			
			tipoinstitucionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoinstitucionAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoInstitucion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoInstitucion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoInstitucion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoInstitucionConstantesFunciones.getClassesRelationshipsOfTipoInstitucion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoInstitucion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Curso.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Curso.class)) {
						classes.add(new Classe(Curso.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoInstitucion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoInstitucionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoInstitucion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoInstitucion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Curso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Curso.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Curso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Curso.class)); continue;
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
	public static void actualizarLista(TipoInstitucion tipoinstitucion,List<TipoInstitucion> tipoinstitucions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoInstitucion tipoinstitucionEncontrado=null;
			
			for(TipoInstitucion tipoinstitucionLocal:tipoinstitucions) {
				if(tipoinstitucionLocal.getId().equals(tipoinstitucion.getId())) {
					tipoinstitucionEncontrado=tipoinstitucionLocal;
					
					tipoinstitucionLocal.setIsChanged(tipoinstitucion.getIsChanged());
					tipoinstitucionLocal.setIsNew(tipoinstitucion.getIsNew());
					tipoinstitucionLocal.setIsDeleted(tipoinstitucion.getIsDeleted());
					
					tipoinstitucionLocal.setGeneralEntityOriginal(tipoinstitucion.getGeneralEntityOriginal());
					
					tipoinstitucionLocal.setId(tipoinstitucion.getId());	
					tipoinstitucionLocal.setVersionRow(tipoinstitucion.getVersionRow());	
					tipoinstitucionLocal.setid_empresa(tipoinstitucion.getid_empresa());	
					tipoinstitucionLocal.setcodigo(tipoinstitucion.getcodigo());	
					tipoinstitucionLocal.setnombre(tipoinstitucion.getnombre());	
					
					
					tipoinstitucionLocal.setCursos(tipoinstitucion.getCursos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoinstitucion.getIsDeleted()) {
				if(!existe) {
					tipoinstitucions.add(tipoinstitucion);
				}
			} else {
				if(tipoinstitucionEncontrado!=null && permiteQuitar)  {
					tipoinstitucions.remove(tipoinstitucionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoInstitucion tipoinstitucion,List<TipoInstitucion> tipoinstitucions) throws Exception {
		try	{			
			for(TipoInstitucion tipoinstitucionLocal:tipoinstitucions) {
				if(tipoinstitucionLocal.getId().equals(tipoinstitucion.getId())) {
					tipoinstitucionLocal.setIsSelected(tipoinstitucion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoInstitucion(List<TipoInstitucion> tipoinstitucionsAux) throws Exception {
		//this.tipoinstitucionsAux=tipoinstitucionsAux;
		
		for(TipoInstitucion tipoinstitucionAux:tipoinstitucionsAux) {
			if(tipoinstitucionAux.getIsChanged()) {
				tipoinstitucionAux.setIsChanged(false);
			}		
			
			if(tipoinstitucionAux.getIsNew()) {
				tipoinstitucionAux.setIsNew(false);
			}	
			
			if(tipoinstitucionAux.getIsDeleted()) {
				tipoinstitucionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoInstitucion(TipoInstitucion tipoinstitucionAux) throws Exception {
		//this.tipoinstitucionAux=tipoinstitucionAux;
		
			if(tipoinstitucionAux.getIsChanged()) {
				tipoinstitucionAux.setIsChanged(false);
			}		
			
			if(tipoinstitucionAux.getIsNew()) {
				tipoinstitucionAux.setIsNew(false);
			}	
			
			if(tipoinstitucionAux.getIsDeleted()) {
				tipoinstitucionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoInstitucion tipoinstitucionAsignar,TipoInstitucion tipoinstitucion) throws Exception {
		tipoinstitucionAsignar.setId(tipoinstitucion.getId());	
		tipoinstitucionAsignar.setVersionRow(tipoinstitucion.getVersionRow());	
		tipoinstitucionAsignar.setid_empresa(tipoinstitucion.getid_empresa());
		tipoinstitucionAsignar.setempresa_descripcion(tipoinstitucion.getempresa_descripcion());	
		tipoinstitucionAsignar.setcodigo(tipoinstitucion.getcodigo());	
		tipoinstitucionAsignar.setnombre(tipoinstitucion.getnombre());	
	}
	
	public static void inicializarTipoInstitucion(TipoInstitucion tipoinstitucion) throws Exception {
		try {
				tipoinstitucion.setId(0L);	
					
				tipoinstitucion.setid_empresa(-1L);	
				tipoinstitucion.setcodigo("");	
				tipoinstitucion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoInstitucion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoInstitucionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoInstitucionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoInstitucionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoInstitucion(String sTipo,Row row,Workbook workbook,TipoInstitucion tipoinstitucion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoinstitucion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoinstitucion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoinstitucion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoInstitucion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoInstitucion() {
		return this.sFinalQueryTipoInstitucion;
	}
	
	public void setsFinalQueryTipoInstitucion(String sFinalQueryTipoInstitucion) {
		this.sFinalQueryTipoInstitucion= sFinalQueryTipoInstitucion;
	}
	
	public Border resaltarSeleccionarTipoInstitucion=null;
	
	public Border setResaltarSeleccionarTipoInstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInstitucionBeanSwingJInternalFrame tipoinstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoinstitucionBeanSwingJInternalFrame.jTtoolBarTipoInstitucion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoInstitucion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoInstitucion() {
		return this.resaltarSeleccionarTipoInstitucion;
	}
	
	public void setResaltarSeleccionarTipoInstitucion(Border borderResaltarSeleccionarTipoInstitucion) {
		this.resaltarSeleccionarTipoInstitucion= borderResaltarSeleccionarTipoInstitucion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoInstitucion=null;
	public Boolean mostraridTipoInstitucion=true;
	public Boolean activaridTipoInstitucion=true;

	public Border resaltarid_empresaTipoInstitucion=null;
	public Boolean mostrarid_empresaTipoInstitucion=true;
	public Boolean activarid_empresaTipoInstitucion=true;
	public Boolean cargarid_empresaTipoInstitucion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoInstitucion=false;//ConEventDepend=true

	public Border resaltarcodigoTipoInstitucion=null;
	public Boolean mostrarcodigoTipoInstitucion=true;
	public Boolean activarcodigoTipoInstitucion=true;

	public Border resaltarnombreTipoInstitucion=null;
	public Boolean mostrarnombreTipoInstitucion=true;
	public Boolean activarnombreTipoInstitucion=true;

	
	

	public Border setResaltaridTipoInstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInstitucionBeanSwingJInternalFrame tipoinstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinstitucionBeanSwingJInternalFrame.jTtoolBarTipoInstitucion.setBorder(borderResaltar);
		
		this.resaltaridTipoInstitucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoInstitucion() {
		return this.resaltaridTipoInstitucion;
	}

	public void setResaltaridTipoInstitucion(Border borderResaltar) {
		this.resaltaridTipoInstitucion= borderResaltar;
	}

	public Boolean getMostraridTipoInstitucion() {
		return this.mostraridTipoInstitucion;
	}

	public void setMostraridTipoInstitucion(Boolean mostraridTipoInstitucion) {
		this.mostraridTipoInstitucion= mostraridTipoInstitucion;
	}

	public Boolean getActivaridTipoInstitucion() {
		return this.activaridTipoInstitucion;
	}

	public void setActivaridTipoInstitucion(Boolean activaridTipoInstitucion) {
		this.activaridTipoInstitucion= activaridTipoInstitucion;
	}

	public Border setResaltarid_empresaTipoInstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInstitucionBeanSwingJInternalFrame tipoinstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinstitucionBeanSwingJInternalFrame.jTtoolBarTipoInstitucion.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoInstitucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoInstitucion() {
		return this.resaltarid_empresaTipoInstitucion;
	}

	public void setResaltarid_empresaTipoInstitucion(Border borderResaltar) {
		this.resaltarid_empresaTipoInstitucion= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoInstitucion() {
		return this.mostrarid_empresaTipoInstitucion;
	}

	public void setMostrarid_empresaTipoInstitucion(Boolean mostrarid_empresaTipoInstitucion) {
		this.mostrarid_empresaTipoInstitucion= mostrarid_empresaTipoInstitucion;
	}

	public Boolean getActivarid_empresaTipoInstitucion() {
		return this.activarid_empresaTipoInstitucion;
	}

	public void setActivarid_empresaTipoInstitucion(Boolean activarid_empresaTipoInstitucion) {
		this.activarid_empresaTipoInstitucion= activarid_empresaTipoInstitucion;
	}

	public Boolean getCargarid_empresaTipoInstitucion() {
		return this.cargarid_empresaTipoInstitucion;
	}

	public void setCargarid_empresaTipoInstitucion(Boolean cargarid_empresaTipoInstitucion) {
		this.cargarid_empresaTipoInstitucion= cargarid_empresaTipoInstitucion;
	}

	public Border setResaltarcodigoTipoInstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInstitucionBeanSwingJInternalFrame tipoinstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinstitucionBeanSwingJInternalFrame.jTtoolBarTipoInstitucion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoInstitucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoInstitucion() {
		return this.resaltarcodigoTipoInstitucion;
	}

	public void setResaltarcodigoTipoInstitucion(Border borderResaltar) {
		this.resaltarcodigoTipoInstitucion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoInstitucion() {
		return this.mostrarcodigoTipoInstitucion;
	}

	public void setMostrarcodigoTipoInstitucion(Boolean mostrarcodigoTipoInstitucion) {
		this.mostrarcodigoTipoInstitucion= mostrarcodigoTipoInstitucion;
	}

	public Boolean getActivarcodigoTipoInstitucion() {
		return this.activarcodigoTipoInstitucion;
	}

	public void setActivarcodigoTipoInstitucion(Boolean activarcodigoTipoInstitucion) {
		this.activarcodigoTipoInstitucion= activarcodigoTipoInstitucion;
	}

	public Border setResaltarnombreTipoInstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInstitucionBeanSwingJInternalFrame tipoinstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinstitucionBeanSwingJInternalFrame.jTtoolBarTipoInstitucion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoInstitucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoInstitucion() {
		return this.resaltarnombreTipoInstitucion;
	}

	public void setResaltarnombreTipoInstitucion(Border borderResaltar) {
		this.resaltarnombreTipoInstitucion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoInstitucion() {
		return this.mostrarnombreTipoInstitucion;
	}

	public void setMostrarnombreTipoInstitucion(Boolean mostrarnombreTipoInstitucion) {
		this.mostrarnombreTipoInstitucion= mostrarnombreTipoInstitucion;
	}

	public Boolean getActivarnombreTipoInstitucion() {
		return this.activarnombreTipoInstitucion;
	}

	public void setActivarnombreTipoInstitucion(Boolean activarnombreTipoInstitucion) {
		this.activarnombreTipoInstitucion= activarnombreTipoInstitucion;
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
		
		
		this.setMostraridTipoInstitucion(esInicial);
		this.setMostrarid_empresaTipoInstitucion(esInicial);
		this.setMostrarcodigoTipoInstitucion(esInicial);
		this.setMostrarnombreTipoInstitucion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInstitucionConstantesFunciones.ID)) {
				this.setMostraridTipoInstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstitucionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoInstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstitucionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoInstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstitucionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoInstitucion(esAsigna);
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
		
		
		this.setActivaridTipoInstitucion(esInicial);
		this.setActivarid_empresaTipoInstitucion(esInicial);
		this.setActivarcodigoTipoInstitucion(esInicial);
		this.setActivarnombreTipoInstitucion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInstitucionConstantesFunciones.ID)) {
				this.setActivaridTipoInstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstitucionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoInstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstitucionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoInstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstitucionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoInstitucion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoInstitucionBeanSwingJInternalFrame tipoinstitucionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoInstitucion(esInicial);
		this.setResaltarid_empresaTipoInstitucion(esInicial);
		this.setResaltarcodigoTipoInstitucion(esInicial);
		this.setResaltarnombreTipoInstitucion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInstitucionConstantesFunciones.ID)) {
				this.setResaltaridTipoInstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstitucionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoInstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstitucionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoInstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInstitucionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoInstitucion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCursoTipoInstitucion=null;

	public Border getResaltarCursoTipoInstitucion() {
		return this.resaltarCursoTipoInstitucion;
	}

	public void setResaltarCursoTipoInstitucion(Border borderResaltarCurso) {
		if(borderResaltarCurso!=null) {
			this.resaltarCursoTipoInstitucion= borderResaltarCurso;
		}
	}

	public Border setResaltarCursoTipoInstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInstitucionBeanSwingJInternalFrame tipoinstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltarCurso=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoinstitucionBeanSwingJInternalFrame.jTtoolBarTipoInstitucion.setBorder(borderResaltarCurso);
			
		this.resaltarCursoTipoInstitucion= borderResaltarCurso;

		 return borderResaltarCurso;
	}



	public Boolean mostrarCursoTipoInstitucion=true;

	public Boolean getMostrarCursoTipoInstitucion() {
		return this.mostrarCursoTipoInstitucion;
	}

	public void setMostrarCursoTipoInstitucion(Boolean visibilidadResaltarCurso) {
		this.mostrarCursoTipoInstitucion= visibilidadResaltarCurso;
	}



	public Boolean activarCursoTipoInstitucion=true;

	public Boolean gethabilitarResaltarCursoTipoInstitucion() {
		return this.activarCursoTipoInstitucion;
	}

	public void setActivarCursoTipoInstitucion(Boolean habilitarResaltarCurso) {
		this.activarCursoTipoInstitucion= habilitarResaltarCurso;
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

		this.setMostrarCursoTipoInstitucion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Curso.class)) {
				this.setMostrarCursoTipoInstitucion(esAsigna);
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

		this.setActivarCursoTipoInstitucion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Curso.class)) {
				this.setActivarCursoTipoInstitucion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoInstitucionBeanSwingJInternalFrame tipoinstitucionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCursoTipoInstitucion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Curso.class)) {
				this.setResaltarCursoTipoInstitucion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoInstitucion=true;

	public Boolean getMostrarFK_IdEmpresaTipoInstitucion() {
		return this.mostrarFK_IdEmpresaTipoInstitucion;
	}

	public void setMostrarFK_IdEmpresaTipoInstitucion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoInstitucion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoInstitucion=true;

	public Boolean getActivarFK_IdEmpresaTipoInstitucion() {
		return this.activarFK_IdEmpresaTipoInstitucion;
	}

	public void setActivarFK_IdEmpresaTipoInstitucion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoInstitucion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoInstitucion=null;

	public Border getResaltarFK_IdEmpresaTipoInstitucion() {
		return this.resaltarFK_IdEmpresaTipoInstitucion;
	}

	public void setResaltarFK_IdEmpresaTipoInstitucion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoInstitucion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoInstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInstitucionBeanSwingJInternalFrame tipoinstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoInstitucion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}