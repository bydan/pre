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


import com.bydan.erp.cartera.util.TipoComproConstantesFunciones;
import com.bydan.erp.cartera.util.TipoComproParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoComproParameterGeneral;

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
final public class TipoComproConstantesFunciones extends TipoComproConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCompro";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCompro"+TipoComproConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoComproHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoComproHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoComproConstantesFunciones.SCHEMA+"_"+TipoComproConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoComproHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoComproConstantesFunciones.SCHEMA+"_"+TipoComproConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoComproConstantesFunciones.SCHEMA+"_"+TipoComproConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoComproHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoComproConstantesFunciones.SCHEMA+"_"+TipoComproConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoComproConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoComproHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoComproConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoComproConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoComproHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoComproConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoComproConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoComproConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoComproConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoComproConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Compros";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Compro";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Compro";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCompro";
	public static final String OBJECTNAME="tipocompro";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_compro";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocompro from "+TipoComproConstantesFunciones.SPERSISTENCENAME+" tipocompro";
	public static String QUERYSELECTNATIVE="select "+TipoComproConstantesFunciones.SCHEMA+"."+TipoComproConstantesFunciones.TABLENAME+".id,"+TipoComproConstantesFunciones.SCHEMA+"."+TipoComproConstantesFunciones.TABLENAME+".version_row,"+TipoComproConstantesFunciones.SCHEMA+"."+TipoComproConstantesFunciones.TABLENAME+".id_empresa,"+TipoComproConstantesFunciones.SCHEMA+"."+TipoComproConstantesFunciones.TABLENAME+".codigo,"+TipoComproConstantesFunciones.SCHEMA+"."+TipoComproConstantesFunciones.TABLENAME+".nombre from "+TipoComproConstantesFunciones.SCHEMA+"."+TipoComproConstantesFunciones.TABLENAME;//+" as "+TipoComproConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoComproConstantesFuncionesAdditional tipocomproConstantesFuncionesAdditional=null;
	
	public TipoComproConstantesFuncionesAdditional getTipoComproConstantesFuncionesAdditional() {
		return this.tipocomproConstantesFuncionesAdditional;
	}
	
	public void setTipoComproConstantesFuncionesAdditional(TipoComproConstantesFuncionesAdditional tipocomproConstantesFuncionesAdditional) {
		try {
			this.tipocomproConstantesFuncionesAdditional=tipocomproConstantesFuncionesAdditional;
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
	
	public static String getTipoComproLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoComproConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoComproConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoComproConstantesFunciones.CODIGO)) {sLabelColumna=TipoComproConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoComproConstantesFunciones.NOMBRE)) {sLabelColumna=TipoComproConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoComproDescripcion(TipoCompro tipocompro) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocompro !=null/* && tipocompro.getId()!=0*/) {
			sDescripcion=tipocompro.getcodigo();//tipocomprotipocompro.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoComproDescripcionDetallado(TipoCompro tipocompro) {
		String sDescripcion="";
			
		sDescripcion+=TipoComproConstantesFunciones.ID+"=";
		sDescripcion+=tipocompro.getId().toString()+",";
		sDescripcion+=TipoComproConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocompro.getVersionRow().toString()+",";
		sDescripcion+=TipoComproConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipocompro.getid_empresa().toString()+",";
		sDescripcion+=TipoComproConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocompro.getcodigo()+",";
		sDescripcion+=TipoComproConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocompro.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoComproDescripcion(TipoCompro tipocompro,String sValor) throws Exception {			
		if(tipocompro !=null) {
			tipocompro.setcodigo(sValor);;//tipocomprotipocompro.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCompro(TipoCompro tipocompro,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocompro.setcodigo(tipocompro.getcodigo().trim());
		tipocompro.setnombre(tipocompro.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCompros(List<TipoCompro> tipocompros,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCompro tipocompro: tipocompros) {
			tipocompro.setcodigo(tipocompro.getcodigo().trim());
			tipocompro.setnombre(tipocompro.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCompro(TipoCompro tipocompro,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocompro.getConCambioAuxiliar()) {
			tipocompro.setIsDeleted(tipocompro.getIsDeletedAuxiliar());	
			tipocompro.setIsNew(tipocompro.getIsNewAuxiliar());	
			tipocompro.setIsChanged(tipocompro.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocompro.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocompro.setIsDeletedAuxiliar(false);	
			tipocompro.setIsNewAuxiliar(false);	
			tipocompro.setIsChangedAuxiliar(false);
			
			tipocompro.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCompros(List<TipoCompro> tipocompros,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCompro tipocompro : tipocompros) {
			if(conAsignarBase && tipocompro.getConCambioAuxiliar()) {
				tipocompro.setIsDeleted(tipocompro.getIsDeletedAuxiliar());	
				tipocompro.setIsNew(tipocompro.getIsNewAuxiliar());	
				tipocompro.setIsChanged(tipocompro.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocompro.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocompro.setIsDeletedAuxiliar(false);	
				tipocompro.setIsNewAuxiliar(false);	
				tipocompro.setIsChangedAuxiliar(false);
				
				tipocompro.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCompro(TipoCompro tipocompro,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCompros(List<TipoCompro> tipocompros,Boolean conEnteros) throws Exception  {
		
		for(TipoCompro tipocompro: tipocompros) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCompro(List<TipoCompro> tipocompros,TipoCompro tipocomproAux) throws Exception  {
		TipoComproConstantesFunciones.InicializarValoresTipoCompro(tipocomproAux,true);
		
		for(TipoCompro tipocompro: tipocompros) {
			if(tipocompro.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCompro(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoComproConstantesFunciones.getArrayColumnasGlobalesTipoCompro(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCompro(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoComproConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoComproConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCompro(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCompro> tipocompros,TipoCompro tipocompro,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCompro tipocomproAux: tipocompros) {
			if(tipocomproAux!=null && tipocompro!=null) {
				if((tipocomproAux.getId()==null && tipocompro.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocomproAux.getId()!=null && tipocompro.getId()!=null){
					if(tipocomproAux.getId().equals(tipocompro.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCompro(List<TipoCompro> tipocompros) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCompro tipocompro: tipocompros) {			
			if(tipocompro.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCompro() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoComproConstantesFunciones.LABEL_ID, TipoComproConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoComproConstantesFunciones.LABEL_VERSIONROW, TipoComproConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoComproConstantesFunciones.LABEL_IDEMPRESA, TipoComproConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoComproConstantesFunciones.LABEL_CODIGO, TipoComproConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoComproConstantesFunciones.LABEL_NOMBRE, TipoComproConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCompro() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoComproConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoComproConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoComproConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoComproConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoComproConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCompro() throws Exception  {
		return TipoComproConstantesFunciones.getTiposSeleccionarTipoCompro(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCompro(Boolean conFk) throws Exception  {
		return TipoComproConstantesFunciones.getTiposSeleccionarTipoCompro(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCompro(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoComproConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoComproConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoComproConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoComproConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoComproConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoComproConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCompro(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCompro(TipoCompro tipocomproAux) throws Exception {
		
			tipocomproAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocomproAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCompro(List<TipoCompro> tipocomprosTemp) throws Exception {
		for(TipoCompro tipocomproAux:tipocomprosTemp) {
			
			tipocomproAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocomproAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCompro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCompro(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCompro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoComproConstantesFunciones.getClassesRelationshipsOfTipoCompro(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCompro(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCompro(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoComproConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCompro(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCompro(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoCompro tipocompro,List<TipoCompro> tipocompros,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCompro tipocomproEncontrado=null;
			
			for(TipoCompro tipocomproLocal:tipocompros) {
				if(tipocomproLocal.getId().equals(tipocompro.getId())) {
					tipocomproEncontrado=tipocomproLocal;
					
					tipocomproLocal.setIsChanged(tipocompro.getIsChanged());
					tipocomproLocal.setIsNew(tipocompro.getIsNew());
					tipocomproLocal.setIsDeleted(tipocompro.getIsDeleted());
					
					tipocomproLocal.setGeneralEntityOriginal(tipocompro.getGeneralEntityOriginal());
					
					tipocomproLocal.setId(tipocompro.getId());	
					tipocomproLocal.setVersionRow(tipocompro.getVersionRow());	
					tipocomproLocal.setid_empresa(tipocompro.getid_empresa());	
					tipocomproLocal.setcodigo(tipocompro.getcodigo());	
					tipocomproLocal.setnombre(tipocompro.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipocompro.getIsDeleted()) {
				if(!existe) {
					tipocompros.add(tipocompro);
				}
			} else {
				if(tipocomproEncontrado!=null && permiteQuitar)  {
					tipocompros.remove(tipocomproEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCompro tipocompro,List<TipoCompro> tipocompros) throws Exception {
		try	{			
			for(TipoCompro tipocomproLocal:tipocompros) {
				if(tipocomproLocal.getId().equals(tipocompro.getId())) {
					tipocomproLocal.setIsSelected(tipocompro.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCompro(List<TipoCompro> tipocomprosAux) throws Exception {
		//this.tipocomprosAux=tipocomprosAux;
		
		for(TipoCompro tipocomproAux:tipocomprosAux) {
			if(tipocomproAux.getIsChanged()) {
				tipocomproAux.setIsChanged(false);
			}		
			
			if(tipocomproAux.getIsNew()) {
				tipocomproAux.setIsNew(false);
			}	
			
			if(tipocomproAux.getIsDeleted()) {
				tipocomproAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCompro(TipoCompro tipocomproAux) throws Exception {
		//this.tipocomproAux=tipocomproAux;
		
			if(tipocomproAux.getIsChanged()) {
				tipocomproAux.setIsChanged(false);
			}		
			
			if(tipocomproAux.getIsNew()) {
				tipocomproAux.setIsNew(false);
			}	
			
			if(tipocomproAux.getIsDeleted()) {
				tipocomproAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCompro tipocomproAsignar,TipoCompro tipocompro) throws Exception {
		tipocomproAsignar.setId(tipocompro.getId());	
		tipocomproAsignar.setVersionRow(tipocompro.getVersionRow());	
		tipocomproAsignar.setid_empresa(tipocompro.getid_empresa());
		tipocomproAsignar.setempresa_descripcion(tipocompro.getempresa_descripcion());	
		tipocomproAsignar.setcodigo(tipocompro.getcodigo());	
		tipocomproAsignar.setnombre(tipocompro.getnombre());	
	}
	
	public static void inicializarTipoCompro(TipoCompro tipocompro) throws Exception {
		try {
				tipocompro.setId(0L);	
					
				tipocompro.setid_empresa(-1L);	
				tipocompro.setcodigo("");	
				tipocompro.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCompro(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoComproConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoComproConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoComproConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCompro(String sTipo,Row row,Workbook workbook,TipoCompro tipocompro,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocompro.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocompro.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocompro.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCompro=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCompro() {
		return this.sFinalQueryTipoCompro;
	}
	
	public void setsFinalQueryTipoCompro(String sFinalQueryTipoCompro) {
		this.sFinalQueryTipoCompro= sFinalQueryTipoCompro;
	}
	
	public Border resaltarSeleccionarTipoCompro=null;
	
	public Border setResaltarSeleccionarTipoCompro(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComproBeanSwingJInternalFrame tipocomproBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocomproBeanSwingJInternalFrame.jTtoolBarTipoCompro.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCompro= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCompro() {
		return this.resaltarSeleccionarTipoCompro;
	}
	
	public void setResaltarSeleccionarTipoCompro(Border borderResaltarSeleccionarTipoCompro) {
		this.resaltarSeleccionarTipoCompro= borderResaltarSeleccionarTipoCompro;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCompro=null;
	public Boolean mostraridTipoCompro=true;
	public Boolean activaridTipoCompro=true;

	public Border resaltarid_empresaTipoCompro=null;
	public Boolean mostrarid_empresaTipoCompro=true;
	public Boolean activarid_empresaTipoCompro=true;
	public Boolean cargarid_empresaTipoCompro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoCompro=false;//ConEventDepend=true

	public Border resaltarcodigoTipoCompro=null;
	public Boolean mostrarcodigoTipoCompro=true;
	public Boolean activarcodigoTipoCompro=true;

	public Border resaltarnombreTipoCompro=null;
	public Boolean mostrarnombreTipoCompro=true;
	public Boolean activarnombreTipoCompro=true;

	
	

	public Border setResaltaridTipoCompro(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComproBeanSwingJInternalFrame tipocomproBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocomproBeanSwingJInternalFrame.jTtoolBarTipoCompro.setBorder(borderResaltar);
		
		this.resaltaridTipoCompro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCompro() {
		return this.resaltaridTipoCompro;
	}

	public void setResaltaridTipoCompro(Border borderResaltar) {
		this.resaltaridTipoCompro= borderResaltar;
	}

	public Boolean getMostraridTipoCompro() {
		return this.mostraridTipoCompro;
	}

	public void setMostraridTipoCompro(Boolean mostraridTipoCompro) {
		this.mostraridTipoCompro= mostraridTipoCompro;
	}

	public Boolean getActivaridTipoCompro() {
		return this.activaridTipoCompro;
	}

	public void setActivaridTipoCompro(Boolean activaridTipoCompro) {
		this.activaridTipoCompro= activaridTipoCompro;
	}

	public Border setResaltarid_empresaTipoCompro(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComproBeanSwingJInternalFrame tipocomproBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocomproBeanSwingJInternalFrame.jTtoolBarTipoCompro.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoCompro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoCompro() {
		return this.resaltarid_empresaTipoCompro;
	}

	public void setResaltarid_empresaTipoCompro(Border borderResaltar) {
		this.resaltarid_empresaTipoCompro= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoCompro() {
		return this.mostrarid_empresaTipoCompro;
	}

	public void setMostrarid_empresaTipoCompro(Boolean mostrarid_empresaTipoCompro) {
		this.mostrarid_empresaTipoCompro= mostrarid_empresaTipoCompro;
	}

	public Boolean getActivarid_empresaTipoCompro() {
		return this.activarid_empresaTipoCompro;
	}

	public void setActivarid_empresaTipoCompro(Boolean activarid_empresaTipoCompro) {
		this.activarid_empresaTipoCompro= activarid_empresaTipoCompro;
	}

	public Boolean getCargarid_empresaTipoCompro() {
		return this.cargarid_empresaTipoCompro;
	}

	public void setCargarid_empresaTipoCompro(Boolean cargarid_empresaTipoCompro) {
		this.cargarid_empresaTipoCompro= cargarid_empresaTipoCompro;
	}

	public Border setResaltarcodigoTipoCompro(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComproBeanSwingJInternalFrame tipocomproBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocomproBeanSwingJInternalFrame.jTtoolBarTipoCompro.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCompro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCompro() {
		return this.resaltarcodigoTipoCompro;
	}

	public void setResaltarcodigoTipoCompro(Border borderResaltar) {
		this.resaltarcodigoTipoCompro= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCompro() {
		return this.mostrarcodigoTipoCompro;
	}

	public void setMostrarcodigoTipoCompro(Boolean mostrarcodigoTipoCompro) {
		this.mostrarcodigoTipoCompro= mostrarcodigoTipoCompro;
	}

	public Boolean getActivarcodigoTipoCompro() {
		return this.activarcodigoTipoCompro;
	}

	public void setActivarcodigoTipoCompro(Boolean activarcodigoTipoCompro) {
		this.activarcodigoTipoCompro= activarcodigoTipoCompro;
	}

	public Border setResaltarnombreTipoCompro(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComproBeanSwingJInternalFrame tipocomproBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocomproBeanSwingJInternalFrame.jTtoolBarTipoCompro.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCompro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCompro() {
		return this.resaltarnombreTipoCompro;
	}

	public void setResaltarnombreTipoCompro(Border borderResaltar) {
		this.resaltarnombreTipoCompro= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCompro() {
		return this.mostrarnombreTipoCompro;
	}

	public void setMostrarnombreTipoCompro(Boolean mostrarnombreTipoCompro) {
		this.mostrarnombreTipoCompro= mostrarnombreTipoCompro;
	}

	public Boolean getActivarnombreTipoCompro() {
		return this.activarnombreTipoCompro;
	}

	public void setActivarnombreTipoCompro(Boolean activarnombreTipoCompro) {
		this.activarnombreTipoCompro= activarnombreTipoCompro;
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
		
		
		this.setMostraridTipoCompro(esInicial);
		this.setMostrarid_empresaTipoCompro(esInicial);
		this.setMostrarcodigoTipoCompro(esInicial);
		this.setMostrarnombreTipoCompro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoComproConstantesFunciones.ID)) {
				this.setMostraridTipoCompro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComproConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoCompro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComproConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCompro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComproConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCompro(esAsigna);
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
		
		
		this.setActivaridTipoCompro(esInicial);
		this.setActivarid_empresaTipoCompro(esInicial);
		this.setActivarcodigoTipoCompro(esInicial);
		this.setActivarnombreTipoCompro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoComproConstantesFunciones.ID)) {
				this.setActivaridTipoCompro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComproConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoCompro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComproConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCompro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComproConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCompro(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoComproBeanSwingJInternalFrame tipocomproBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCompro(esInicial);
		this.setResaltarid_empresaTipoCompro(esInicial);
		this.setResaltarcodigoTipoCompro(esInicial);
		this.setResaltarnombreTipoCompro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoComproConstantesFunciones.ID)) {
				this.setResaltaridTipoCompro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComproConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoCompro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComproConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCompro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComproConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCompro(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoComproBeanSwingJInternalFrame tipocomproBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTipoCompro=true;

	public Boolean getMostrarBusquedaPorCodigoTipoCompro() {
		return this.mostrarBusquedaPorCodigoTipoCompro;
	}

	public void setMostrarBusquedaPorCodigoTipoCompro(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoCompro= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoCompro=true;

	public Boolean getMostrarBusquedaPorNombreTipoCompro() {
		return this.mostrarBusquedaPorNombreTipoCompro;
	}

	public void setMostrarBusquedaPorNombreTipoCompro(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoCompro= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoCompro=true;

	public Boolean getMostrarFK_IdEmpresaTipoCompro() {
		return this.mostrarFK_IdEmpresaTipoCompro;
	}

	public void setMostrarFK_IdEmpresaTipoCompro(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoCompro= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoCompro=true;

	public Boolean getActivarBusquedaPorCodigoTipoCompro() {
		return this.activarBusquedaPorCodigoTipoCompro;
	}

	public void setActivarBusquedaPorCodigoTipoCompro(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoCompro= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoCompro=true;

	public Boolean getActivarBusquedaPorNombreTipoCompro() {
		return this.activarBusquedaPorNombreTipoCompro;
	}

	public void setActivarBusquedaPorNombreTipoCompro(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoCompro= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoCompro=true;

	public Boolean getActivarFK_IdEmpresaTipoCompro() {
		return this.activarFK_IdEmpresaTipoCompro;
	}

	public void setActivarFK_IdEmpresaTipoCompro(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoCompro= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoCompro=null;

	public Border getResaltarBusquedaPorCodigoTipoCompro() {
		return this.resaltarBusquedaPorCodigoTipoCompro;
	}

	public void setResaltarBusquedaPorCodigoTipoCompro(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoCompro= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoCompro(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComproBeanSwingJInternalFrame tipocomproBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoCompro= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoCompro=null;

	public Border getResaltarBusquedaPorNombreTipoCompro() {
		return this.resaltarBusquedaPorNombreTipoCompro;
	}

	public void setResaltarBusquedaPorNombreTipoCompro(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoCompro= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoCompro(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComproBeanSwingJInternalFrame tipocomproBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoCompro= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoCompro=null;

	public Border getResaltarFK_IdEmpresaTipoCompro() {
		return this.resaltarFK_IdEmpresaTipoCompro;
	}

	public void setResaltarFK_IdEmpresaTipoCompro(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoCompro= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoCompro(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComproBeanSwingJInternalFrame tipocomproBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoCompro= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}