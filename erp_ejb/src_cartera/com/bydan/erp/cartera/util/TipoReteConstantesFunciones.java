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


import com.bydan.erp.cartera.util.TipoReteConstantesFunciones;
import com.bydan.erp.cartera.util.TipoReteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoReteParameterGeneral;

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
final public class TipoReteConstantesFunciones extends TipoReteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoRete";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoRete"+TipoReteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoReteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoReteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoReteConstantesFunciones.SCHEMA+"_"+TipoReteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoReteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoReteConstantesFunciones.SCHEMA+"_"+TipoReteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoReteConstantesFunciones.SCHEMA+"_"+TipoReteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoReteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoReteConstantesFunciones.SCHEMA+"_"+TipoReteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoReteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoReteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoReteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoReteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoReteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoReteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoReteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoReteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoReteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoReteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Rete(temporal)s";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Rete(temporal)";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Rete";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoRete";
	public static final String OBJECTNAME="tiporete";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_rete";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiporete from "+TipoReteConstantesFunciones.SPERSISTENCENAME+" tiporete";
	public static String QUERYSELECTNATIVE="select "+TipoReteConstantesFunciones.SCHEMA+"."+TipoReteConstantesFunciones.TABLENAME+".id,"+TipoReteConstantesFunciones.SCHEMA+"."+TipoReteConstantesFunciones.TABLENAME+".version_row,"+TipoReteConstantesFunciones.SCHEMA+"."+TipoReteConstantesFunciones.TABLENAME+".id_empresa,"+TipoReteConstantesFunciones.SCHEMA+"."+TipoReteConstantesFunciones.TABLENAME+".codigo,"+TipoReteConstantesFunciones.SCHEMA+"."+TipoReteConstantesFunciones.TABLENAME+".nombre from "+TipoReteConstantesFunciones.SCHEMA+"."+TipoReteConstantesFunciones.TABLENAME;//+" as "+TipoReteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoReteConstantesFuncionesAdditional tiporeteConstantesFuncionesAdditional=null;
	
	public TipoReteConstantesFuncionesAdditional getTipoReteConstantesFuncionesAdditional() {
		return this.tiporeteConstantesFuncionesAdditional;
	}
	
	public void setTipoReteConstantesFuncionesAdditional(TipoReteConstantesFuncionesAdditional tiporeteConstantesFuncionesAdditional) {
		try {
			this.tiporeteConstantesFuncionesAdditional=tiporeteConstantesFuncionesAdditional;
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
	
	public static String getTipoReteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoReteConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoReteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoReteConstantesFunciones.CODIGO)) {sLabelColumna=TipoReteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoReteConstantesFunciones.NOMBRE)) {sLabelColumna=TipoReteConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoReteDescripcion(TipoRete tiporete) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiporete !=null/* && tiporete.getId()!=0*/) {
			sDescripcion=tiporete.getcodigo();//tiporetetiporete.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoReteDescripcionDetallado(TipoRete tiporete) {
		String sDescripcion="";
			
		sDescripcion+=TipoReteConstantesFunciones.ID+"=";
		sDescripcion+=tiporete.getId().toString()+",";
		sDescripcion+=TipoReteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiporete.getVersionRow().toString()+",";
		sDescripcion+=TipoReteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tiporete.getid_empresa().toString()+",";
		sDescripcion+=TipoReteConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiporete.getcodigo()+",";
		sDescripcion+=TipoReteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiporete.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoReteDescripcion(TipoRete tiporete,String sValor) throws Exception {			
		if(tiporete !=null) {
			tiporete.setcodigo(sValor);;//tiporetetiporete.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoRete(TipoRete tiporete,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiporete.setcodigo(tiporete.getcodigo().trim());
		tiporete.setnombre(tiporete.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoRetes(List<TipoRete> tiporetes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoRete tiporete: tiporetes) {
			tiporete.setcodigo(tiporete.getcodigo().trim());
			tiporete.setnombre(tiporete.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRete(TipoRete tiporete,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiporete.getConCambioAuxiliar()) {
			tiporete.setIsDeleted(tiporete.getIsDeletedAuxiliar());	
			tiporete.setIsNew(tiporete.getIsNewAuxiliar());	
			tiporete.setIsChanged(tiporete.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiporete.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiporete.setIsDeletedAuxiliar(false);	
			tiporete.setIsNewAuxiliar(false);	
			tiporete.setIsChangedAuxiliar(false);
			
			tiporete.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRetes(List<TipoRete> tiporetes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoRete tiporete : tiporetes) {
			if(conAsignarBase && tiporete.getConCambioAuxiliar()) {
				tiporete.setIsDeleted(tiporete.getIsDeletedAuxiliar());	
				tiporete.setIsNew(tiporete.getIsNewAuxiliar());	
				tiporete.setIsChanged(tiporete.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiporete.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiporete.setIsDeletedAuxiliar(false);	
				tiporete.setIsNewAuxiliar(false);	
				tiporete.setIsChangedAuxiliar(false);
				
				tiporete.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoRete(TipoRete tiporete,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoRetes(List<TipoRete> tiporetes,Boolean conEnteros) throws Exception  {
		
		for(TipoRete tiporete: tiporetes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoRete(List<TipoRete> tiporetes,TipoRete tiporeteAux) throws Exception  {
		TipoReteConstantesFunciones.InicializarValoresTipoRete(tiporeteAux,true);
		
		for(TipoRete tiporete: tiporetes) {
			if(tiporete.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRete(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoReteConstantesFunciones.getArrayColumnasGlobalesTipoRete(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRete(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoReteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoReteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoRete(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoRete> tiporetes,TipoRete tiporete,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoRete tiporeteAux: tiporetes) {
			if(tiporeteAux!=null && tiporete!=null) {
				if((tiporeteAux.getId()==null && tiporete.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiporeteAux.getId()!=null && tiporete.getId()!=null){
					if(tiporeteAux.getId().equals(tiporete.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoRete(List<TipoRete> tiporetes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoRete tiporete: tiporetes) {			
			if(tiporete.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoRete() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoReteConstantesFunciones.LABEL_ID, TipoReteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoReteConstantesFunciones.LABEL_VERSIONROW, TipoReteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoReteConstantesFunciones.LABEL_IDEMPRESA, TipoReteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoReteConstantesFunciones.LABEL_CODIGO, TipoReteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoReteConstantesFunciones.LABEL_NOMBRE, TipoReteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoRete() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoReteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoReteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoReteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoReteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoReteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRete() throws Exception  {
		return TipoReteConstantesFunciones.getTiposSeleccionarTipoRete(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRete(Boolean conFk) throws Exception  {
		return TipoReteConstantesFunciones.getTiposSeleccionarTipoRete(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRete(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoReteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoReteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoReteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoReteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoReteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoReteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoRete(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRete(TipoRete tiporeteAux) throws Exception {
		
			tiporeteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiporeteAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRete(List<TipoRete> tiporetesTemp) throws Exception {
		for(TipoRete tiporeteAux:tiporetesTemp) {
			
			tiporeteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiporeteAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRete(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoRete(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRete(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoReteConstantesFunciones.getClassesRelationshipsOfTipoRete(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRete(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRete(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoReteConstantesFunciones.getClassesRelationshipsFromStringsOfTipoRete(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRete(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoRete tiporete,List<TipoRete> tiporetes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoRete tiporeteEncontrado=null;
			
			for(TipoRete tiporeteLocal:tiporetes) {
				if(tiporeteLocal.getId().equals(tiporete.getId())) {
					tiporeteEncontrado=tiporeteLocal;
					
					tiporeteLocal.setIsChanged(tiporete.getIsChanged());
					tiporeteLocal.setIsNew(tiporete.getIsNew());
					tiporeteLocal.setIsDeleted(tiporete.getIsDeleted());
					
					tiporeteLocal.setGeneralEntityOriginal(tiporete.getGeneralEntityOriginal());
					
					tiporeteLocal.setId(tiporete.getId());	
					tiporeteLocal.setVersionRow(tiporete.getVersionRow());	
					tiporeteLocal.setid_empresa(tiporete.getid_empresa());	
					tiporeteLocal.setcodigo(tiporete.getcodigo());	
					tiporeteLocal.setnombre(tiporete.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tiporete.getIsDeleted()) {
				if(!existe) {
					tiporetes.add(tiporete);
				}
			} else {
				if(tiporeteEncontrado!=null && permiteQuitar)  {
					tiporetes.remove(tiporeteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoRete tiporete,List<TipoRete> tiporetes) throws Exception {
		try	{			
			for(TipoRete tiporeteLocal:tiporetes) {
				if(tiporeteLocal.getId().equals(tiporete.getId())) {
					tiporeteLocal.setIsSelected(tiporete.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoRete(List<TipoRete> tiporetesAux) throws Exception {
		//this.tiporetesAux=tiporetesAux;
		
		for(TipoRete tiporeteAux:tiporetesAux) {
			if(tiporeteAux.getIsChanged()) {
				tiporeteAux.setIsChanged(false);
			}		
			
			if(tiporeteAux.getIsNew()) {
				tiporeteAux.setIsNew(false);
			}	
			
			if(tiporeteAux.getIsDeleted()) {
				tiporeteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoRete(TipoRete tiporeteAux) throws Exception {
		//this.tiporeteAux=tiporeteAux;
		
			if(tiporeteAux.getIsChanged()) {
				tiporeteAux.setIsChanged(false);
			}		
			
			if(tiporeteAux.getIsNew()) {
				tiporeteAux.setIsNew(false);
			}	
			
			if(tiporeteAux.getIsDeleted()) {
				tiporeteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoRete tiporeteAsignar,TipoRete tiporete) throws Exception {
		tiporeteAsignar.setId(tiporete.getId());	
		tiporeteAsignar.setVersionRow(tiporete.getVersionRow());	
		tiporeteAsignar.setid_empresa(tiporete.getid_empresa());
		tiporeteAsignar.setempresa_descripcion(tiporete.getempresa_descripcion());	
		tiporeteAsignar.setcodigo(tiporete.getcodigo());	
		tiporeteAsignar.setnombre(tiporete.getnombre());	
	}
	
	public static void inicializarTipoRete(TipoRete tiporete) throws Exception {
		try {
				tiporete.setId(0L);	
					
				tiporete.setid_empresa(-1L);	
				tiporete.setcodigo("");	
				tiporete.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoRete(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoReteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoReteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoReteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoRete(String sTipo,Row row,Workbook workbook,TipoRete tiporete,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporete.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporete.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporete.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoRete=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoRete() {
		return this.sFinalQueryTipoRete;
	}
	
	public void setsFinalQueryTipoRete(String sFinalQueryTipoRete) {
		this.sFinalQueryTipoRete= sFinalQueryTipoRete;
	}
	
	public Border resaltarSeleccionarTipoRete=null;
	
	public Border setResaltarSeleccionarTipoRete(ParametroGeneralUsuario parametroGeneralUsuario/*TipoReteBeanSwingJInternalFrame tiporeteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiporeteBeanSwingJInternalFrame.jTtoolBarTipoRete.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoRete= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoRete() {
		return this.resaltarSeleccionarTipoRete;
	}
	
	public void setResaltarSeleccionarTipoRete(Border borderResaltarSeleccionarTipoRete) {
		this.resaltarSeleccionarTipoRete= borderResaltarSeleccionarTipoRete;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoRete=null;
	public Boolean mostraridTipoRete=true;
	public Boolean activaridTipoRete=true;

	public Border resaltarid_empresaTipoRete=null;
	public Boolean mostrarid_empresaTipoRete=true;
	public Boolean activarid_empresaTipoRete=true;
	public Boolean cargarid_empresaTipoRete=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoRete=false;//ConEventDepend=true

	public Border resaltarcodigoTipoRete=null;
	public Boolean mostrarcodigoTipoRete=true;
	public Boolean activarcodigoTipoRete=true;

	public Border resaltarnombreTipoRete=null;
	public Boolean mostrarnombreTipoRete=true;
	public Boolean activarnombreTipoRete=true;

	
	

	public Border setResaltaridTipoRete(ParametroGeneralUsuario parametroGeneralUsuario/*TipoReteBeanSwingJInternalFrame tiporeteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporeteBeanSwingJInternalFrame.jTtoolBarTipoRete.setBorder(borderResaltar);
		
		this.resaltaridTipoRete= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoRete() {
		return this.resaltaridTipoRete;
	}

	public void setResaltaridTipoRete(Border borderResaltar) {
		this.resaltaridTipoRete= borderResaltar;
	}

	public Boolean getMostraridTipoRete() {
		return this.mostraridTipoRete;
	}

	public void setMostraridTipoRete(Boolean mostraridTipoRete) {
		this.mostraridTipoRete= mostraridTipoRete;
	}

	public Boolean getActivaridTipoRete() {
		return this.activaridTipoRete;
	}

	public void setActivaridTipoRete(Boolean activaridTipoRete) {
		this.activaridTipoRete= activaridTipoRete;
	}

	public Border setResaltarid_empresaTipoRete(ParametroGeneralUsuario parametroGeneralUsuario/*TipoReteBeanSwingJInternalFrame tiporeteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporeteBeanSwingJInternalFrame.jTtoolBarTipoRete.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoRete= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoRete() {
		return this.resaltarid_empresaTipoRete;
	}

	public void setResaltarid_empresaTipoRete(Border borderResaltar) {
		this.resaltarid_empresaTipoRete= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoRete() {
		return this.mostrarid_empresaTipoRete;
	}

	public void setMostrarid_empresaTipoRete(Boolean mostrarid_empresaTipoRete) {
		this.mostrarid_empresaTipoRete= mostrarid_empresaTipoRete;
	}

	public Boolean getActivarid_empresaTipoRete() {
		return this.activarid_empresaTipoRete;
	}

	public void setActivarid_empresaTipoRete(Boolean activarid_empresaTipoRete) {
		this.activarid_empresaTipoRete= activarid_empresaTipoRete;
	}

	public Boolean getCargarid_empresaTipoRete() {
		return this.cargarid_empresaTipoRete;
	}

	public void setCargarid_empresaTipoRete(Boolean cargarid_empresaTipoRete) {
		this.cargarid_empresaTipoRete= cargarid_empresaTipoRete;
	}

	public Border setResaltarcodigoTipoRete(ParametroGeneralUsuario parametroGeneralUsuario/*TipoReteBeanSwingJInternalFrame tiporeteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporeteBeanSwingJInternalFrame.jTtoolBarTipoRete.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoRete= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoRete() {
		return this.resaltarcodigoTipoRete;
	}

	public void setResaltarcodigoTipoRete(Border borderResaltar) {
		this.resaltarcodigoTipoRete= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoRete() {
		return this.mostrarcodigoTipoRete;
	}

	public void setMostrarcodigoTipoRete(Boolean mostrarcodigoTipoRete) {
		this.mostrarcodigoTipoRete= mostrarcodigoTipoRete;
	}

	public Boolean getActivarcodigoTipoRete() {
		return this.activarcodigoTipoRete;
	}

	public void setActivarcodigoTipoRete(Boolean activarcodigoTipoRete) {
		this.activarcodigoTipoRete= activarcodigoTipoRete;
	}

	public Border setResaltarnombreTipoRete(ParametroGeneralUsuario parametroGeneralUsuario/*TipoReteBeanSwingJInternalFrame tiporeteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporeteBeanSwingJInternalFrame.jTtoolBarTipoRete.setBorder(borderResaltar);
		
		this.resaltarnombreTipoRete= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoRete() {
		return this.resaltarnombreTipoRete;
	}

	public void setResaltarnombreTipoRete(Border borderResaltar) {
		this.resaltarnombreTipoRete= borderResaltar;
	}

	public Boolean getMostrarnombreTipoRete() {
		return this.mostrarnombreTipoRete;
	}

	public void setMostrarnombreTipoRete(Boolean mostrarnombreTipoRete) {
		this.mostrarnombreTipoRete= mostrarnombreTipoRete;
	}

	public Boolean getActivarnombreTipoRete() {
		return this.activarnombreTipoRete;
	}

	public void setActivarnombreTipoRete(Boolean activarnombreTipoRete) {
		this.activarnombreTipoRete= activarnombreTipoRete;
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
		
		
		this.setMostraridTipoRete(esInicial);
		this.setMostrarid_empresaTipoRete(esInicial);
		this.setMostrarcodigoTipoRete(esInicial);
		this.setMostrarnombreTipoRete(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoReteConstantesFunciones.ID)) {
				this.setMostraridTipoRete(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoReteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoRete(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoReteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoRete(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoReteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoRete(esAsigna);
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
		
		
		this.setActivaridTipoRete(esInicial);
		this.setActivarid_empresaTipoRete(esInicial);
		this.setActivarcodigoTipoRete(esInicial);
		this.setActivarnombreTipoRete(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoReteConstantesFunciones.ID)) {
				this.setActivaridTipoRete(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoReteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoRete(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoReteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoRete(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoReteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoRete(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoReteBeanSwingJInternalFrame tiporeteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoRete(esInicial);
		this.setResaltarid_empresaTipoRete(esInicial);
		this.setResaltarcodigoTipoRete(esInicial);
		this.setResaltarnombreTipoRete(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoReteConstantesFunciones.ID)) {
				this.setResaltaridTipoRete(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoReteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoRete(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoReteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoRete(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoReteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoRete(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoReteBeanSwingJInternalFrame tiporeteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTipoRete=true;

	public Boolean getMostrarBusquedaPorCodigoTipoRete() {
		return this.mostrarBusquedaPorCodigoTipoRete;
	}

	public void setMostrarBusquedaPorCodigoTipoRete(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoRete= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoRete=true;

	public Boolean getMostrarBusquedaPorNombreTipoRete() {
		return this.mostrarBusquedaPorNombreTipoRete;
	}

	public void setMostrarBusquedaPorNombreTipoRete(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoRete= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoRete=true;

	public Boolean getMostrarFK_IdEmpresaTipoRete() {
		return this.mostrarFK_IdEmpresaTipoRete;
	}

	public void setMostrarFK_IdEmpresaTipoRete(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoRete= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoRete=true;

	public Boolean getActivarBusquedaPorCodigoTipoRete() {
		return this.activarBusquedaPorCodigoTipoRete;
	}

	public void setActivarBusquedaPorCodigoTipoRete(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoRete= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoRete=true;

	public Boolean getActivarBusquedaPorNombreTipoRete() {
		return this.activarBusquedaPorNombreTipoRete;
	}

	public void setActivarBusquedaPorNombreTipoRete(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoRete= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoRete=true;

	public Boolean getActivarFK_IdEmpresaTipoRete() {
		return this.activarFK_IdEmpresaTipoRete;
	}

	public void setActivarFK_IdEmpresaTipoRete(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoRete= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoRete=null;

	public Border getResaltarBusquedaPorCodigoTipoRete() {
		return this.resaltarBusquedaPorCodigoTipoRete;
	}

	public void setResaltarBusquedaPorCodigoTipoRete(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoRete= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoRete(ParametroGeneralUsuario parametroGeneralUsuario/*TipoReteBeanSwingJInternalFrame tiporeteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoRete= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoRete=null;

	public Border getResaltarBusquedaPorNombreTipoRete() {
		return this.resaltarBusquedaPorNombreTipoRete;
	}

	public void setResaltarBusquedaPorNombreTipoRete(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoRete= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoRete(ParametroGeneralUsuario parametroGeneralUsuario/*TipoReteBeanSwingJInternalFrame tiporeteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoRete= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoRete=null;

	public Border getResaltarFK_IdEmpresaTipoRete() {
		return this.resaltarFK_IdEmpresaTipoRete;
	}

	public void setResaltarFK_IdEmpresaTipoRete(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoRete= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoRete(ParametroGeneralUsuario parametroGeneralUsuario/*TipoReteBeanSwingJInternalFrame tiporeteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoRete= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}