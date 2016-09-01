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


import com.bydan.erp.cartera.util.TipoVinculacionConstantesFunciones;
import com.bydan.erp.cartera.util.TipoVinculacionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoVinculacionParameterGeneral;

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
final public class TipoVinculacionConstantesFunciones extends TipoVinculacionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoVinculacion";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoVinculacion"+TipoVinculacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoVinculacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoVinculacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoVinculacionConstantesFunciones.SCHEMA+"_"+TipoVinculacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoVinculacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoVinculacionConstantesFunciones.SCHEMA+"_"+TipoVinculacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoVinculacionConstantesFunciones.SCHEMA+"_"+TipoVinculacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoVinculacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoVinculacionConstantesFunciones.SCHEMA+"_"+TipoVinculacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVinculacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoVinculacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVinculacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVinculacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoVinculacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVinculacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoVinculacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoVinculacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoVinculacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoVinculacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Vinculaciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Vinculacion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Vinculacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoVinculacion";
	public static final String OBJECTNAME="tipovinculacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_vinculacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipovinculacion from "+TipoVinculacionConstantesFunciones.SPERSISTENCENAME+" tipovinculacion";
	public static String QUERYSELECTNATIVE="select "+TipoVinculacionConstantesFunciones.SCHEMA+"."+TipoVinculacionConstantesFunciones.TABLENAME+".id,"+TipoVinculacionConstantesFunciones.SCHEMA+"."+TipoVinculacionConstantesFunciones.TABLENAME+".version_row,"+TipoVinculacionConstantesFunciones.SCHEMA+"."+TipoVinculacionConstantesFunciones.TABLENAME+".id_empresa,"+TipoVinculacionConstantesFunciones.SCHEMA+"."+TipoVinculacionConstantesFunciones.TABLENAME+".codigo,"+TipoVinculacionConstantesFunciones.SCHEMA+"."+TipoVinculacionConstantesFunciones.TABLENAME+".nombre from "+TipoVinculacionConstantesFunciones.SCHEMA+"."+TipoVinculacionConstantesFunciones.TABLENAME;//+" as "+TipoVinculacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoVinculacionConstantesFuncionesAdditional tipovinculacionConstantesFuncionesAdditional=null;
	
	public TipoVinculacionConstantesFuncionesAdditional getTipoVinculacionConstantesFuncionesAdditional() {
		return this.tipovinculacionConstantesFuncionesAdditional;
	}
	
	public void setTipoVinculacionConstantesFuncionesAdditional(TipoVinculacionConstantesFuncionesAdditional tipovinculacionConstantesFuncionesAdditional) {
		try {
			this.tipovinculacionConstantesFuncionesAdditional=tipovinculacionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
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
	
	public static String getTipoVinculacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoVinculacionConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoVinculacionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoVinculacionConstantesFunciones.CODIGO)) {sLabelColumna=TipoVinculacionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoVinculacionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoVinculacionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoVinculacionDescripcion(TipoVinculacion tipovinculacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipovinculacion !=null/* && tipovinculacion.getId()!=0*/) {
			sDescripcion=tipovinculacion.getcodigo();//tipovinculaciontipovinculacion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoVinculacionDescripcionDetallado(TipoVinculacion tipovinculacion) {
		String sDescripcion="";
			
		sDescripcion+=TipoVinculacionConstantesFunciones.ID+"=";
		sDescripcion+=tipovinculacion.getId().toString()+",";
		sDescripcion+=TipoVinculacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipovinculacion.getVersionRow().toString()+",";
		sDescripcion+=TipoVinculacionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipovinculacion.getid_empresa().toString()+",";
		sDescripcion+=TipoVinculacionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipovinculacion.getcodigo()+",";
		sDescripcion+=TipoVinculacionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipovinculacion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoVinculacionDescripcion(TipoVinculacion tipovinculacion,String sValor) throws Exception {			
		if(tipovinculacion !=null) {
			tipovinculacion.setcodigo(sValor);;//tipovinculaciontipovinculacion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoVinculacion(TipoVinculacion tipovinculacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipovinculacion.setcodigo(tipovinculacion.getcodigo().trim());
		tipovinculacion.setnombre(tipovinculacion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoVinculacions(List<TipoVinculacion> tipovinculacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoVinculacion tipovinculacion: tipovinculacions) {
			tipovinculacion.setcodigo(tipovinculacion.getcodigo().trim());
			tipovinculacion.setnombre(tipovinculacion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoVinculacion(TipoVinculacion tipovinculacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipovinculacion.getConCambioAuxiliar()) {
			tipovinculacion.setIsDeleted(tipovinculacion.getIsDeletedAuxiliar());	
			tipovinculacion.setIsNew(tipovinculacion.getIsNewAuxiliar());	
			tipovinculacion.setIsChanged(tipovinculacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipovinculacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipovinculacion.setIsDeletedAuxiliar(false);	
			tipovinculacion.setIsNewAuxiliar(false);	
			tipovinculacion.setIsChangedAuxiliar(false);
			
			tipovinculacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoVinculacions(List<TipoVinculacion> tipovinculacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoVinculacion tipovinculacion : tipovinculacions) {
			if(conAsignarBase && tipovinculacion.getConCambioAuxiliar()) {
				tipovinculacion.setIsDeleted(tipovinculacion.getIsDeletedAuxiliar());	
				tipovinculacion.setIsNew(tipovinculacion.getIsNewAuxiliar());	
				tipovinculacion.setIsChanged(tipovinculacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipovinculacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipovinculacion.setIsDeletedAuxiliar(false);	
				tipovinculacion.setIsNewAuxiliar(false);	
				tipovinculacion.setIsChangedAuxiliar(false);
				
				tipovinculacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoVinculacion(TipoVinculacion tipovinculacion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoVinculacions(List<TipoVinculacion> tipovinculacions,Boolean conEnteros) throws Exception  {
		
		for(TipoVinculacion tipovinculacion: tipovinculacions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoVinculacion(List<TipoVinculacion> tipovinculacions,TipoVinculacion tipovinculacionAux) throws Exception  {
		TipoVinculacionConstantesFunciones.InicializarValoresTipoVinculacion(tipovinculacionAux,true);
		
		for(TipoVinculacion tipovinculacion: tipovinculacions) {
			if(tipovinculacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoVinculacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoVinculacionConstantesFunciones.getArrayColumnasGlobalesTipoVinculacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoVinculacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoVinculacionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoVinculacionConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoVinculacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoVinculacion> tipovinculacions,TipoVinculacion tipovinculacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoVinculacion tipovinculacionAux: tipovinculacions) {
			if(tipovinculacionAux!=null && tipovinculacion!=null) {
				if((tipovinculacionAux.getId()==null && tipovinculacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipovinculacionAux.getId()!=null && tipovinculacion.getId()!=null){
					if(tipovinculacionAux.getId().equals(tipovinculacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoVinculacion(List<TipoVinculacion> tipovinculacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoVinculacion tipovinculacion: tipovinculacions) {			
			if(tipovinculacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoVinculacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoVinculacionConstantesFunciones.LABEL_ID, TipoVinculacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoVinculacionConstantesFunciones.LABEL_VERSIONROW, TipoVinculacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoVinculacionConstantesFunciones.LABEL_IDEMPRESA, TipoVinculacionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoVinculacionConstantesFunciones.LABEL_CODIGO, TipoVinculacionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoVinculacionConstantesFunciones.LABEL_NOMBRE, TipoVinculacionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoVinculacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoVinculacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoVinculacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoVinculacionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoVinculacionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoVinculacionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVinculacion() throws Exception  {
		return TipoVinculacionConstantesFunciones.getTiposSeleccionarTipoVinculacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVinculacion(Boolean conFk) throws Exception  {
		return TipoVinculacionConstantesFunciones.getTiposSeleccionarTipoVinculacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVinculacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoVinculacionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoVinculacionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoVinculacionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoVinculacionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoVinculacionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoVinculacionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoVinculacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoVinculacion(TipoVinculacion tipovinculacionAux) throws Exception {
		
			tipovinculacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipovinculacionAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoVinculacion(List<TipoVinculacion> tipovinculacionsTemp) throws Exception {
		for(TipoVinculacion tipovinculacionAux:tipovinculacionsTemp) {
			
			tipovinculacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipovinculacionAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoVinculacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoVinculacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoVinculacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoVinculacionConstantesFunciones.getClassesRelationshipsOfTipoVinculacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoVinculacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(InformacionEconomica.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(InformacionEconomica.class)) {
						classes.add(new Classe(InformacionEconomica.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoVinculacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoVinculacionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoVinculacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoVinculacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(InformacionEconomica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(InformacionEconomica.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(InformacionEconomica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(InformacionEconomica.class)); continue;
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
	public static void actualizarLista(TipoVinculacion tipovinculacion,List<TipoVinculacion> tipovinculacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoVinculacion tipovinculacionEncontrado=null;
			
			for(TipoVinculacion tipovinculacionLocal:tipovinculacions) {
				if(tipovinculacionLocal.getId().equals(tipovinculacion.getId())) {
					tipovinculacionEncontrado=tipovinculacionLocal;
					
					tipovinculacionLocal.setIsChanged(tipovinculacion.getIsChanged());
					tipovinculacionLocal.setIsNew(tipovinculacion.getIsNew());
					tipovinculacionLocal.setIsDeleted(tipovinculacion.getIsDeleted());
					
					tipovinculacionLocal.setGeneralEntityOriginal(tipovinculacion.getGeneralEntityOriginal());
					
					tipovinculacionLocal.setId(tipovinculacion.getId());	
					tipovinculacionLocal.setVersionRow(tipovinculacion.getVersionRow());	
					tipovinculacionLocal.setid_empresa(tipovinculacion.getid_empresa());	
					tipovinculacionLocal.setcodigo(tipovinculacion.getcodigo());	
					tipovinculacionLocal.setnombre(tipovinculacion.getnombre());	
					
					
					tipovinculacionLocal.setInformacionEconomicas(tipovinculacion.getInformacionEconomicas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipovinculacion.getIsDeleted()) {
				if(!existe) {
					tipovinculacions.add(tipovinculacion);
				}
			} else {
				if(tipovinculacionEncontrado!=null && permiteQuitar)  {
					tipovinculacions.remove(tipovinculacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoVinculacion tipovinculacion,List<TipoVinculacion> tipovinculacions) throws Exception {
		try	{			
			for(TipoVinculacion tipovinculacionLocal:tipovinculacions) {
				if(tipovinculacionLocal.getId().equals(tipovinculacion.getId())) {
					tipovinculacionLocal.setIsSelected(tipovinculacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoVinculacion(List<TipoVinculacion> tipovinculacionsAux) throws Exception {
		//this.tipovinculacionsAux=tipovinculacionsAux;
		
		for(TipoVinculacion tipovinculacionAux:tipovinculacionsAux) {
			if(tipovinculacionAux.getIsChanged()) {
				tipovinculacionAux.setIsChanged(false);
			}		
			
			if(tipovinculacionAux.getIsNew()) {
				tipovinculacionAux.setIsNew(false);
			}	
			
			if(tipovinculacionAux.getIsDeleted()) {
				tipovinculacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoVinculacion(TipoVinculacion tipovinculacionAux) throws Exception {
		//this.tipovinculacionAux=tipovinculacionAux;
		
			if(tipovinculacionAux.getIsChanged()) {
				tipovinculacionAux.setIsChanged(false);
			}		
			
			if(tipovinculacionAux.getIsNew()) {
				tipovinculacionAux.setIsNew(false);
			}	
			
			if(tipovinculacionAux.getIsDeleted()) {
				tipovinculacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoVinculacion tipovinculacionAsignar,TipoVinculacion tipovinculacion) throws Exception {
		tipovinculacionAsignar.setId(tipovinculacion.getId());	
		tipovinculacionAsignar.setVersionRow(tipovinculacion.getVersionRow());	
		tipovinculacionAsignar.setid_empresa(tipovinculacion.getid_empresa());
		tipovinculacionAsignar.setempresa_descripcion(tipovinculacion.getempresa_descripcion());	
		tipovinculacionAsignar.setcodigo(tipovinculacion.getcodigo());	
		tipovinculacionAsignar.setnombre(tipovinculacion.getnombre());	
	}
	
	public static void inicializarTipoVinculacion(TipoVinculacion tipovinculacion) throws Exception {
		try {
				tipovinculacion.setId(0L);	
					
				tipovinculacion.setid_empresa(-1L);	
				tipovinculacion.setcodigo("");	
				tipovinculacion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoVinculacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoVinculacionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoVinculacionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoVinculacionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoVinculacion(String sTipo,Row row,Workbook workbook,TipoVinculacion tipovinculacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipovinculacion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipovinculacion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipovinculacion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoVinculacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoVinculacion() {
		return this.sFinalQueryTipoVinculacion;
	}
	
	public void setsFinalQueryTipoVinculacion(String sFinalQueryTipoVinculacion) {
		this.sFinalQueryTipoVinculacion= sFinalQueryTipoVinculacion;
	}
	
	public Border resaltarSeleccionarTipoVinculacion=null;
	
	public Border setResaltarSeleccionarTipoVinculacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVinculacionBeanSwingJInternalFrame tipovinculacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipovinculacionBeanSwingJInternalFrame.jTtoolBarTipoVinculacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoVinculacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoVinculacion() {
		return this.resaltarSeleccionarTipoVinculacion;
	}
	
	public void setResaltarSeleccionarTipoVinculacion(Border borderResaltarSeleccionarTipoVinculacion) {
		this.resaltarSeleccionarTipoVinculacion= borderResaltarSeleccionarTipoVinculacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoVinculacion=null;
	public Boolean mostraridTipoVinculacion=true;
	public Boolean activaridTipoVinculacion=true;

	public Border resaltarid_empresaTipoVinculacion=null;
	public Boolean mostrarid_empresaTipoVinculacion=true;
	public Boolean activarid_empresaTipoVinculacion=true;
	public Boolean cargarid_empresaTipoVinculacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoVinculacion=false;//ConEventDepend=true

	public Border resaltarcodigoTipoVinculacion=null;
	public Boolean mostrarcodigoTipoVinculacion=true;
	public Boolean activarcodigoTipoVinculacion=true;

	public Border resaltarnombreTipoVinculacion=null;
	public Boolean mostrarnombreTipoVinculacion=true;
	public Boolean activarnombreTipoVinculacion=true;

	
	

	public Border setResaltaridTipoVinculacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVinculacionBeanSwingJInternalFrame tipovinculacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovinculacionBeanSwingJInternalFrame.jTtoolBarTipoVinculacion.setBorder(borderResaltar);
		
		this.resaltaridTipoVinculacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoVinculacion() {
		return this.resaltaridTipoVinculacion;
	}

	public void setResaltaridTipoVinculacion(Border borderResaltar) {
		this.resaltaridTipoVinculacion= borderResaltar;
	}

	public Boolean getMostraridTipoVinculacion() {
		return this.mostraridTipoVinculacion;
	}

	public void setMostraridTipoVinculacion(Boolean mostraridTipoVinculacion) {
		this.mostraridTipoVinculacion= mostraridTipoVinculacion;
	}

	public Boolean getActivaridTipoVinculacion() {
		return this.activaridTipoVinculacion;
	}

	public void setActivaridTipoVinculacion(Boolean activaridTipoVinculacion) {
		this.activaridTipoVinculacion= activaridTipoVinculacion;
	}

	public Border setResaltarid_empresaTipoVinculacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVinculacionBeanSwingJInternalFrame tipovinculacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovinculacionBeanSwingJInternalFrame.jTtoolBarTipoVinculacion.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoVinculacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoVinculacion() {
		return this.resaltarid_empresaTipoVinculacion;
	}

	public void setResaltarid_empresaTipoVinculacion(Border borderResaltar) {
		this.resaltarid_empresaTipoVinculacion= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoVinculacion() {
		return this.mostrarid_empresaTipoVinculacion;
	}

	public void setMostrarid_empresaTipoVinculacion(Boolean mostrarid_empresaTipoVinculacion) {
		this.mostrarid_empresaTipoVinculacion= mostrarid_empresaTipoVinculacion;
	}

	public Boolean getActivarid_empresaTipoVinculacion() {
		return this.activarid_empresaTipoVinculacion;
	}

	public void setActivarid_empresaTipoVinculacion(Boolean activarid_empresaTipoVinculacion) {
		this.activarid_empresaTipoVinculacion= activarid_empresaTipoVinculacion;
	}

	public Boolean getCargarid_empresaTipoVinculacion() {
		return this.cargarid_empresaTipoVinculacion;
	}

	public void setCargarid_empresaTipoVinculacion(Boolean cargarid_empresaTipoVinculacion) {
		this.cargarid_empresaTipoVinculacion= cargarid_empresaTipoVinculacion;
	}

	public Border setResaltarcodigoTipoVinculacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVinculacionBeanSwingJInternalFrame tipovinculacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovinculacionBeanSwingJInternalFrame.jTtoolBarTipoVinculacion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoVinculacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoVinculacion() {
		return this.resaltarcodigoTipoVinculacion;
	}

	public void setResaltarcodigoTipoVinculacion(Border borderResaltar) {
		this.resaltarcodigoTipoVinculacion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoVinculacion() {
		return this.mostrarcodigoTipoVinculacion;
	}

	public void setMostrarcodigoTipoVinculacion(Boolean mostrarcodigoTipoVinculacion) {
		this.mostrarcodigoTipoVinculacion= mostrarcodigoTipoVinculacion;
	}

	public Boolean getActivarcodigoTipoVinculacion() {
		return this.activarcodigoTipoVinculacion;
	}

	public void setActivarcodigoTipoVinculacion(Boolean activarcodigoTipoVinculacion) {
		this.activarcodigoTipoVinculacion= activarcodigoTipoVinculacion;
	}

	public Border setResaltarnombreTipoVinculacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVinculacionBeanSwingJInternalFrame tipovinculacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovinculacionBeanSwingJInternalFrame.jTtoolBarTipoVinculacion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoVinculacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoVinculacion() {
		return this.resaltarnombreTipoVinculacion;
	}

	public void setResaltarnombreTipoVinculacion(Border borderResaltar) {
		this.resaltarnombreTipoVinculacion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoVinculacion() {
		return this.mostrarnombreTipoVinculacion;
	}

	public void setMostrarnombreTipoVinculacion(Boolean mostrarnombreTipoVinculacion) {
		this.mostrarnombreTipoVinculacion= mostrarnombreTipoVinculacion;
	}

	public Boolean getActivarnombreTipoVinculacion() {
		return this.activarnombreTipoVinculacion;
	}

	public void setActivarnombreTipoVinculacion(Boolean activarnombreTipoVinculacion) {
		this.activarnombreTipoVinculacion= activarnombreTipoVinculacion;
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
		
		
		this.setMostraridTipoVinculacion(esInicial);
		this.setMostrarid_empresaTipoVinculacion(esInicial);
		this.setMostrarcodigoTipoVinculacion(esInicial);
		this.setMostrarnombreTipoVinculacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoVinculacionConstantesFunciones.ID)) {
				this.setMostraridTipoVinculacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVinculacionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoVinculacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVinculacionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoVinculacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVinculacionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoVinculacion(esAsigna);
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
		
		
		this.setActivaridTipoVinculacion(esInicial);
		this.setActivarid_empresaTipoVinculacion(esInicial);
		this.setActivarcodigoTipoVinculacion(esInicial);
		this.setActivarnombreTipoVinculacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoVinculacionConstantesFunciones.ID)) {
				this.setActivaridTipoVinculacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVinculacionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoVinculacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVinculacionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoVinculacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVinculacionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoVinculacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoVinculacionBeanSwingJInternalFrame tipovinculacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoVinculacion(esInicial);
		this.setResaltarid_empresaTipoVinculacion(esInicial);
		this.setResaltarcodigoTipoVinculacion(esInicial);
		this.setResaltarnombreTipoVinculacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoVinculacionConstantesFunciones.ID)) {
				this.setResaltaridTipoVinculacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVinculacionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoVinculacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVinculacionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoVinculacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVinculacionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoVinculacion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarInformacionEconomicaTipoVinculacion=null;

	public Border getResaltarInformacionEconomicaTipoVinculacion() {
		return this.resaltarInformacionEconomicaTipoVinculacion;
	}

	public void setResaltarInformacionEconomicaTipoVinculacion(Border borderResaltarInformacionEconomica) {
		if(borderResaltarInformacionEconomica!=null) {
			this.resaltarInformacionEconomicaTipoVinculacion= borderResaltarInformacionEconomica;
		}
	}

	public Border setResaltarInformacionEconomicaTipoVinculacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVinculacionBeanSwingJInternalFrame tipovinculacionBeanSwingJInternalFrame*/) {
		Border borderResaltarInformacionEconomica=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipovinculacionBeanSwingJInternalFrame.jTtoolBarTipoVinculacion.setBorder(borderResaltarInformacionEconomica);
			
		this.resaltarInformacionEconomicaTipoVinculacion= borderResaltarInformacionEconomica;

		 return borderResaltarInformacionEconomica;
	}



	public Boolean mostrarInformacionEconomicaTipoVinculacion=true;

	public Boolean getMostrarInformacionEconomicaTipoVinculacion() {
		return this.mostrarInformacionEconomicaTipoVinculacion;
	}

	public void setMostrarInformacionEconomicaTipoVinculacion(Boolean visibilidadResaltarInformacionEconomica) {
		this.mostrarInformacionEconomicaTipoVinculacion= visibilidadResaltarInformacionEconomica;
	}



	public Boolean activarInformacionEconomicaTipoVinculacion=true;

	public Boolean gethabilitarResaltarInformacionEconomicaTipoVinculacion() {
		return this.activarInformacionEconomicaTipoVinculacion;
	}

	public void setActivarInformacionEconomicaTipoVinculacion(Boolean habilitarResaltarInformacionEconomica) {
		this.activarInformacionEconomicaTipoVinculacion= habilitarResaltarInformacionEconomica;
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

		this.setMostrarInformacionEconomicaTipoVinculacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionEconomica.class)) {
				this.setMostrarInformacionEconomicaTipoVinculacion(esAsigna);
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

		this.setActivarInformacionEconomicaTipoVinculacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionEconomica.class)) {
				this.setActivarInformacionEconomicaTipoVinculacion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoVinculacionBeanSwingJInternalFrame tipovinculacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarInformacionEconomicaTipoVinculacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionEconomica.class)) {
				this.setResaltarInformacionEconomicaTipoVinculacion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoVinculacion=true;

	public Boolean getMostrarFK_IdEmpresaTipoVinculacion() {
		return this.mostrarFK_IdEmpresaTipoVinculacion;
	}

	public void setMostrarFK_IdEmpresaTipoVinculacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoVinculacion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoVinculacion=true;

	public Boolean getActivarFK_IdEmpresaTipoVinculacion() {
		return this.activarFK_IdEmpresaTipoVinculacion;
	}

	public void setActivarFK_IdEmpresaTipoVinculacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoVinculacion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoVinculacion=null;

	public Border getResaltarFK_IdEmpresaTipoVinculacion() {
		return this.resaltarFK_IdEmpresaTipoVinculacion;
	}

	public void setResaltarFK_IdEmpresaTipoVinculacion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoVinculacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoVinculacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVinculacionBeanSwingJInternalFrame tipovinculacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoVinculacion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}