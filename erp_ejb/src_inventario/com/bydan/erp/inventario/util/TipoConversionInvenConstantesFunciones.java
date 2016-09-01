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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.TipoConversionInvenConstantesFunciones;
import com.bydan.erp.inventario.util.TipoConversionInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoConversionInvenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoConversionInvenConstantesFunciones extends TipoConversionInvenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoConversionInven";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoConversionInven"+TipoConversionInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoConversionInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoConversionInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoConversionInvenConstantesFunciones.SCHEMA+"_"+TipoConversionInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoConversionInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoConversionInvenConstantesFunciones.SCHEMA+"_"+TipoConversionInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoConversionInvenConstantesFunciones.SCHEMA+"_"+TipoConversionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoConversionInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoConversionInvenConstantesFunciones.SCHEMA+"_"+TipoConversionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConversionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoConversionInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConversionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConversionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoConversionInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConversionInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoConversionInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoConversionInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoConversionInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoConversionInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Conversion Invenes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Conversion Inven";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Conversion Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoConversionInven";
	public static final String OBJECTNAME="tipoconversioninven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_conversion_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoconversioninven from "+TipoConversionInvenConstantesFunciones.SPERSISTENCENAME+" tipoconversioninven";
	public static String QUERYSELECTNATIVE="select "+TipoConversionInvenConstantesFunciones.SCHEMA+"."+TipoConversionInvenConstantesFunciones.TABLENAME+".id,"+TipoConversionInvenConstantesFunciones.SCHEMA+"."+TipoConversionInvenConstantesFunciones.TABLENAME+".version_row,"+TipoConversionInvenConstantesFunciones.SCHEMA+"."+TipoConversionInvenConstantesFunciones.TABLENAME+".id_empresa,"+TipoConversionInvenConstantesFunciones.SCHEMA+"."+TipoConversionInvenConstantesFunciones.TABLENAME+".codigo,"+TipoConversionInvenConstantesFunciones.SCHEMA+"."+TipoConversionInvenConstantesFunciones.TABLENAME+".nombre from "+TipoConversionInvenConstantesFunciones.SCHEMA+"."+TipoConversionInvenConstantesFunciones.TABLENAME;//+" as "+TipoConversionInvenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoConversionInvenConstantesFuncionesAdditional tipoconversioninvenConstantesFuncionesAdditional=null;
	
	public TipoConversionInvenConstantesFuncionesAdditional getTipoConversionInvenConstantesFuncionesAdditional() {
		return this.tipoconversioninvenConstantesFuncionesAdditional;
	}
	
	public void setTipoConversionInvenConstantesFuncionesAdditional(TipoConversionInvenConstantesFuncionesAdditional tipoconversioninvenConstantesFuncionesAdditional) {
		try {
			this.tipoconversioninvenConstantesFuncionesAdditional=tipoconversioninvenConstantesFuncionesAdditional;
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
	
	public static String getTipoConversionInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoConversionInvenConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoConversionInvenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoConversionInvenConstantesFunciones.CODIGO)) {sLabelColumna=TipoConversionInvenConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoConversionInvenConstantesFunciones.NOMBRE)) {sLabelColumna=TipoConversionInvenConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoConversionInvenDescripcion(TipoConversionInven tipoconversioninven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoconversioninven !=null/* && tipoconversioninven.getId()!=0*/) {
			sDescripcion=tipoconversioninven.getcodigo();//tipoconversioninventipoconversioninven.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoConversionInvenDescripcionDetallado(TipoConversionInven tipoconversioninven) {
		String sDescripcion="";
			
		sDescripcion+=TipoConversionInvenConstantesFunciones.ID+"=";
		sDescripcion+=tipoconversioninven.getId().toString()+",";
		sDescripcion+=TipoConversionInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoconversioninven.getVersionRow().toString()+",";
		sDescripcion+=TipoConversionInvenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoconversioninven.getid_empresa().toString()+",";
		sDescripcion+=TipoConversionInvenConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoconversioninven.getcodigo()+",";
		sDescripcion+=TipoConversionInvenConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoconversioninven.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoConversionInvenDescripcion(TipoConversionInven tipoconversioninven,String sValor) throws Exception {			
		if(tipoconversioninven !=null) {
			tipoconversioninven.setcodigo(sValor);;//tipoconversioninventipoconversioninven.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoConversionInven(TipoConversionInven tipoconversioninven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoconversioninven.setcodigo(tipoconversioninven.getcodigo().trim());
		tipoconversioninven.setnombre(tipoconversioninven.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoConversionInvens(List<TipoConversionInven> tipoconversioninvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoConversionInven tipoconversioninven: tipoconversioninvens) {
			tipoconversioninven.setcodigo(tipoconversioninven.getcodigo().trim());
			tipoconversioninven.setnombre(tipoconversioninven.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoConversionInven(TipoConversionInven tipoconversioninven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoconversioninven.getConCambioAuxiliar()) {
			tipoconversioninven.setIsDeleted(tipoconversioninven.getIsDeletedAuxiliar());	
			tipoconversioninven.setIsNew(tipoconversioninven.getIsNewAuxiliar());	
			tipoconversioninven.setIsChanged(tipoconversioninven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoconversioninven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoconversioninven.setIsDeletedAuxiliar(false);	
			tipoconversioninven.setIsNewAuxiliar(false);	
			tipoconversioninven.setIsChangedAuxiliar(false);
			
			tipoconversioninven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoConversionInvens(List<TipoConversionInven> tipoconversioninvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoConversionInven tipoconversioninven : tipoconversioninvens) {
			if(conAsignarBase && tipoconversioninven.getConCambioAuxiliar()) {
				tipoconversioninven.setIsDeleted(tipoconversioninven.getIsDeletedAuxiliar());	
				tipoconversioninven.setIsNew(tipoconversioninven.getIsNewAuxiliar());	
				tipoconversioninven.setIsChanged(tipoconversioninven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoconversioninven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoconversioninven.setIsDeletedAuxiliar(false);	
				tipoconversioninven.setIsNewAuxiliar(false);	
				tipoconversioninven.setIsChangedAuxiliar(false);
				
				tipoconversioninven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoConversionInven(TipoConversionInven tipoconversioninven,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoConversionInvens(List<TipoConversionInven> tipoconversioninvens,Boolean conEnteros) throws Exception  {
		
		for(TipoConversionInven tipoconversioninven: tipoconversioninvens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoConversionInven(List<TipoConversionInven> tipoconversioninvens,TipoConversionInven tipoconversioninvenAux) throws Exception  {
		TipoConversionInvenConstantesFunciones.InicializarValoresTipoConversionInven(tipoconversioninvenAux,true);
		
		for(TipoConversionInven tipoconversioninven: tipoconversioninvens) {
			if(tipoconversioninven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoConversionInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoConversionInvenConstantesFunciones.getArrayColumnasGlobalesTipoConversionInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoConversionInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoConversionInvenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoConversionInvenConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoConversionInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoConversionInven> tipoconversioninvens,TipoConversionInven tipoconversioninven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoConversionInven tipoconversioninvenAux: tipoconversioninvens) {
			if(tipoconversioninvenAux!=null && tipoconversioninven!=null) {
				if((tipoconversioninvenAux.getId()==null && tipoconversioninven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoconversioninvenAux.getId()!=null && tipoconversioninven.getId()!=null){
					if(tipoconversioninvenAux.getId().equals(tipoconversioninven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoConversionInven(List<TipoConversionInven> tipoconversioninvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoConversionInven tipoconversioninven: tipoconversioninvens) {			
			if(tipoconversioninven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoConversionInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoConversionInvenConstantesFunciones.LABEL_ID, TipoConversionInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoConversionInvenConstantesFunciones.LABEL_VERSIONROW, TipoConversionInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoConversionInvenConstantesFunciones.LABEL_IDEMPRESA, TipoConversionInvenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoConversionInvenConstantesFunciones.LABEL_CODIGO, TipoConversionInvenConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoConversionInvenConstantesFunciones.LABEL_NOMBRE, TipoConversionInvenConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoConversionInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoConversionInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoConversionInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoConversionInvenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoConversionInvenConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoConversionInvenConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoConversionInven() throws Exception  {
		return TipoConversionInvenConstantesFunciones.getTiposSeleccionarTipoConversionInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoConversionInven(Boolean conFk) throws Exception  {
		return TipoConversionInvenConstantesFunciones.getTiposSeleccionarTipoConversionInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoConversionInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoConversionInvenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoConversionInvenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoConversionInvenConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoConversionInvenConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoConversionInvenConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoConversionInvenConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoConversionInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoConversionInven(TipoConversionInven tipoconversioninvenAux) throws Exception {
		
			tipoconversioninvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoconversioninvenAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoConversionInven(List<TipoConversionInven> tipoconversioninvensTemp) throws Exception {
		for(TipoConversionInven tipoconversioninvenAux:tipoconversioninvensTemp) {
			
			tipoconversioninvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoconversioninvenAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoConversionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoConversionInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoConversionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoConversionInvenConstantesFunciones.getClassesRelationshipsOfTipoConversionInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoConversionInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ConversionInven.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ConversionInven.class)) {
						classes.add(new Classe(ConversionInven.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoConversionInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoConversionInvenConstantesFunciones.getClassesRelationshipsFromStringsOfTipoConversionInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoConversionInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ConversionInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ConversionInven.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ConversionInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ConversionInven.class)); continue;
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
	public static void actualizarLista(TipoConversionInven tipoconversioninven,List<TipoConversionInven> tipoconversioninvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoConversionInven tipoconversioninvenEncontrado=null;
			
			for(TipoConversionInven tipoconversioninvenLocal:tipoconversioninvens) {
				if(tipoconversioninvenLocal.getId().equals(tipoconversioninven.getId())) {
					tipoconversioninvenEncontrado=tipoconversioninvenLocal;
					
					tipoconversioninvenLocal.setIsChanged(tipoconversioninven.getIsChanged());
					tipoconversioninvenLocal.setIsNew(tipoconversioninven.getIsNew());
					tipoconversioninvenLocal.setIsDeleted(tipoconversioninven.getIsDeleted());
					
					tipoconversioninvenLocal.setGeneralEntityOriginal(tipoconversioninven.getGeneralEntityOriginal());
					
					tipoconversioninvenLocal.setId(tipoconversioninven.getId());	
					tipoconversioninvenLocal.setVersionRow(tipoconversioninven.getVersionRow());	
					tipoconversioninvenLocal.setid_empresa(tipoconversioninven.getid_empresa());	
					tipoconversioninvenLocal.setcodigo(tipoconversioninven.getcodigo());	
					tipoconversioninvenLocal.setnombre(tipoconversioninven.getnombre());	
					
					
					tipoconversioninvenLocal.setConversionInvens(tipoconversioninven.getConversionInvens());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoconversioninven.getIsDeleted()) {
				if(!existe) {
					tipoconversioninvens.add(tipoconversioninven);
				}
			} else {
				if(tipoconversioninvenEncontrado!=null && permiteQuitar)  {
					tipoconversioninvens.remove(tipoconversioninvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoConversionInven tipoconversioninven,List<TipoConversionInven> tipoconversioninvens) throws Exception {
		try	{			
			for(TipoConversionInven tipoconversioninvenLocal:tipoconversioninvens) {
				if(tipoconversioninvenLocal.getId().equals(tipoconversioninven.getId())) {
					tipoconversioninvenLocal.setIsSelected(tipoconversioninven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoConversionInven(List<TipoConversionInven> tipoconversioninvensAux) throws Exception {
		//this.tipoconversioninvensAux=tipoconversioninvensAux;
		
		for(TipoConversionInven tipoconversioninvenAux:tipoconversioninvensAux) {
			if(tipoconversioninvenAux.getIsChanged()) {
				tipoconversioninvenAux.setIsChanged(false);
			}		
			
			if(tipoconversioninvenAux.getIsNew()) {
				tipoconversioninvenAux.setIsNew(false);
			}	
			
			if(tipoconversioninvenAux.getIsDeleted()) {
				tipoconversioninvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoConversionInven(TipoConversionInven tipoconversioninvenAux) throws Exception {
		//this.tipoconversioninvenAux=tipoconversioninvenAux;
		
			if(tipoconversioninvenAux.getIsChanged()) {
				tipoconversioninvenAux.setIsChanged(false);
			}		
			
			if(tipoconversioninvenAux.getIsNew()) {
				tipoconversioninvenAux.setIsNew(false);
			}	
			
			if(tipoconversioninvenAux.getIsDeleted()) {
				tipoconversioninvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoConversionInven tipoconversioninvenAsignar,TipoConversionInven tipoconversioninven) throws Exception {
		tipoconversioninvenAsignar.setId(tipoconversioninven.getId());	
		tipoconversioninvenAsignar.setVersionRow(tipoconversioninven.getVersionRow());	
		tipoconversioninvenAsignar.setid_empresa(tipoconversioninven.getid_empresa());
		tipoconversioninvenAsignar.setempresa_descripcion(tipoconversioninven.getempresa_descripcion());	
		tipoconversioninvenAsignar.setcodigo(tipoconversioninven.getcodigo());	
		tipoconversioninvenAsignar.setnombre(tipoconversioninven.getnombre());	
	}
	
	public static void inicializarTipoConversionInven(TipoConversionInven tipoconversioninven) throws Exception {
		try {
				tipoconversioninven.setId(0L);	
					
				tipoconversioninven.setid_empresa(-1L);	
				tipoconversioninven.setcodigo("");	
				tipoconversioninven.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoConversionInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoConversionInvenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoConversionInvenConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoConversionInvenConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoConversionInven(String sTipo,Row row,Workbook workbook,TipoConversionInven tipoconversioninven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoconversioninven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoconversioninven.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoconversioninven.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoConversionInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoConversionInven() {
		return this.sFinalQueryTipoConversionInven;
	}
	
	public void setsFinalQueryTipoConversionInven(String sFinalQueryTipoConversionInven) {
		this.sFinalQueryTipoConversionInven= sFinalQueryTipoConversionInven;
	}
	
	public Border resaltarSeleccionarTipoConversionInven=null;
	
	public Border setResaltarSeleccionarTipoConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConversionInvenBeanSwingJInternalFrame tipoconversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoconversioninvenBeanSwingJInternalFrame.jTtoolBarTipoConversionInven.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoConversionInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoConversionInven() {
		return this.resaltarSeleccionarTipoConversionInven;
	}
	
	public void setResaltarSeleccionarTipoConversionInven(Border borderResaltarSeleccionarTipoConversionInven) {
		this.resaltarSeleccionarTipoConversionInven= borderResaltarSeleccionarTipoConversionInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoConversionInven=null;
	public Boolean mostraridTipoConversionInven=true;
	public Boolean activaridTipoConversionInven=true;

	public Border resaltarid_empresaTipoConversionInven=null;
	public Boolean mostrarid_empresaTipoConversionInven=true;
	public Boolean activarid_empresaTipoConversionInven=true;
	public Boolean cargarid_empresaTipoConversionInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoConversionInven=false;//ConEventDepend=true

	public Border resaltarcodigoTipoConversionInven=null;
	public Boolean mostrarcodigoTipoConversionInven=true;
	public Boolean activarcodigoTipoConversionInven=true;

	public Border resaltarnombreTipoConversionInven=null;
	public Boolean mostrarnombreTipoConversionInven=true;
	public Boolean activarnombreTipoConversionInven=true;

	
	

	public Border setResaltaridTipoConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConversionInvenBeanSwingJInternalFrame tipoconversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoconversioninvenBeanSwingJInternalFrame.jTtoolBarTipoConversionInven.setBorder(borderResaltar);
		
		this.resaltaridTipoConversionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoConversionInven() {
		return this.resaltaridTipoConversionInven;
	}

	public void setResaltaridTipoConversionInven(Border borderResaltar) {
		this.resaltaridTipoConversionInven= borderResaltar;
	}

	public Boolean getMostraridTipoConversionInven() {
		return this.mostraridTipoConversionInven;
	}

	public void setMostraridTipoConversionInven(Boolean mostraridTipoConversionInven) {
		this.mostraridTipoConversionInven= mostraridTipoConversionInven;
	}

	public Boolean getActivaridTipoConversionInven() {
		return this.activaridTipoConversionInven;
	}

	public void setActivaridTipoConversionInven(Boolean activaridTipoConversionInven) {
		this.activaridTipoConversionInven= activaridTipoConversionInven;
	}

	public Border setResaltarid_empresaTipoConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConversionInvenBeanSwingJInternalFrame tipoconversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoconversioninvenBeanSwingJInternalFrame.jTtoolBarTipoConversionInven.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoConversionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoConversionInven() {
		return this.resaltarid_empresaTipoConversionInven;
	}

	public void setResaltarid_empresaTipoConversionInven(Border borderResaltar) {
		this.resaltarid_empresaTipoConversionInven= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoConversionInven() {
		return this.mostrarid_empresaTipoConversionInven;
	}

	public void setMostrarid_empresaTipoConversionInven(Boolean mostrarid_empresaTipoConversionInven) {
		this.mostrarid_empresaTipoConversionInven= mostrarid_empresaTipoConversionInven;
	}

	public Boolean getActivarid_empresaTipoConversionInven() {
		return this.activarid_empresaTipoConversionInven;
	}

	public void setActivarid_empresaTipoConversionInven(Boolean activarid_empresaTipoConversionInven) {
		this.activarid_empresaTipoConversionInven= activarid_empresaTipoConversionInven;
	}

	public Boolean getCargarid_empresaTipoConversionInven() {
		return this.cargarid_empresaTipoConversionInven;
	}

	public void setCargarid_empresaTipoConversionInven(Boolean cargarid_empresaTipoConversionInven) {
		this.cargarid_empresaTipoConversionInven= cargarid_empresaTipoConversionInven;
	}

	public Border setResaltarcodigoTipoConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConversionInvenBeanSwingJInternalFrame tipoconversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoconversioninvenBeanSwingJInternalFrame.jTtoolBarTipoConversionInven.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoConversionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoConversionInven() {
		return this.resaltarcodigoTipoConversionInven;
	}

	public void setResaltarcodigoTipoConversionInven(Border borderResaltar) {
		this.resaltarcodigoTipoConversionInven= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoConversionInven() {
		return this.mostrarcodigoTipoConversionInven;
	}

	public void setMostrarcodigoTipoConversionInven(Boolean mostrarcodigoTipoConversionInven) {
		this.mostrarcodigoTipoConversionInven= mostrarcodigoTipoConversionInven;
	}

	public Boolean getActivarcodigoTipoConversionInven() {
		return this.activarcodigoTipoConversionInven;
	}

	public void setActivarcodigoTipoConversionInven(Boolean activarcodigoTipoConversionInven) {
		this.activarcodigoTipoConversionInven= activarcodigoTipoConversionInven;
	}

	public Border setResaltarnombreTipoConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConversionInvenBeanSwingJInternalFrame tipoconversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoconversioninvenBeanSwingJInternalFrame.jTtoolBarTipoConversionInven.setBorder(borderResaltar);
		
		this.resaltarnombreTipoConversionInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoConversionInven() {
		return this.resaltarnombreTipoConversionInven;
	}

	public void setResaltarnombreTipoConversionInven(Border borderResaltar) {
		this.resaltarnombreTipoConversionInven= borderResaltar;
	}

	public Boolean getMostrarnombreTipoConversionInven() {
		return this.mostrarnombreTipoConversionInven;
	}

	public void setMostrarnombreTipoConversionInven(Boolean mostrarnombreTipoConversionInven) {
		this.mostrarnombreTipoConversionInven= mostrarnombreTipoConversionInven;
	}

	public Boolean getActivarnombreTipoConversionInven() {
		return this.activarnombreTipoConversionInven;
	}

	public void setActivarnombreTipoConversionInven(Boolean activarnombreTipoConversionInven) {
		this.activarnombreTipoConversionInven= activarnombreTipoConversionInven;
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
		
		
		this.setMostraridTipoConversionInven(esInicial);
		this.setMostrarid_empresaTipoConversionInven(esInicial);
		this.setMostrarcodigoTipoConversionInven(esInicial);
		this.setMostrarnombreTipoConversionInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoConversionInvenConstantesFunciones.ID)) {
				this.setMostraridTipoConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConversionInvenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConversionInvenConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConversionInvenConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoConversionInven(esAsigna);
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
		
		
		this.setActivaridTipoConversionInven(esInicial);
		this.setActivarid_empresaTipoConversionInven(esInicial);
		this.setActivarcodigoTipoConversionInven(esInicial);
		this.setActivarnombreTipoConversionInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoConversionInvenConstantesFunciones.ID)) {
				this.setActivaridTipoConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConversionInvenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConversionInvenConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConversionInvenConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoConversionInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoConversionInvenBeanSwingJInternalFrame tipoconversioninvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoConversionInven(esInicial);
		this.setResaltarid_empresaTipoConversionInven(esInicial);
		this.setResaltarcodigoTipoConversionInven(esInicial);
		this.setResaltarnombreTipoConversionInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoConversionInvenConstantesFunciones.ID)) {
				this.setResaltaridTipoConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConversionInvenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConversionInvenConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoConversionInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConversionInvenConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoConversionInven(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarConversionInvenTipoConversionInven=null;

	public Border getResaltarConversionInvenTipoConversionInven() {
		return this.resaltarConversionInvenTipoConversionInven;
	}

	public void setResaltarConversionInvenTipoConversionInven(Border borderResaltarConversionInven) {
		if(borderResaltarConversionInven!=null) {
			this.resaltarConversionInvenTipoConversionInven= borderResaltarConversionInven;
		}
	}

	public Border setResaltarConversionInvenTipoConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConversionInvenBeanSwingJInternalFrame tipoconversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltarConversionInven=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoconversioninvenBeanSwingJInternalFrame.jTtoolBarTipoConversionInven.setBorder(borderResaltarConversionInven);
			
		this.resaltarConversionInvenTipoConversionInven= borderResaltarConversionInven;

		 return borderResaltarConversionInven;
	}



	public Boolean mostrarConversionInvenTipoConversionInven=true;

	public Boolean getMostrarConversionInvenTipoConversionInven() {
		return this.mostrarConversionInvenTipoConversionInven;
	}

	public void setMostrarConversionInvenTipoConversionInven(Boolean visibilidadResaltarConversionInven) {
		this.mostrarConversionInvenTipoConversionInven= visibilidadResaltarConversionInven;
	}



	public Boolean activarConversionInvenTipoConversionInven=true;

	public Boolean gethabilitarResaltarConversionInvenTipoConversionInven() {
		return this.activarConversionInvenTipoConversionInven;
	}

	public void setActivarConversionInvenTipoConversionInven(Boolean habilitarResaltarConversionInven) {
		this.activarConversionInvenTipoConversionInven= habilitarResaltarConversionInven;
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

		this.setMostrarConversionInvenTipoConversionInven(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ConversionInven.class)) {
				this.setMostrarConversionInvenTipoConversionInven(esAsigna);
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

		this.setActivarConversionInvenTipoConversionInven(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ConversionInven.class)) {
				this.setActivarConversionInvenTipoConversionInven(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoConversionInvenBeanSwingJInternalFrame tipoconversioninvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarConversionInvenTipoConversionInven(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ConversionInven.class)) {
				this.setResaltarConversionInvenTipoConversionInven(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoConversionInven=true;

	public Boolean getMostrarBusquedaPorCodigoTipoConversionInven() {
		return this.mostrarBusquedaPorCodigoTipoConversionInven;
	}

	public void setMostrarBusquedaPorCodigoTipoConversionInven(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoConversionInven= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoConversionInven=true;

	public Boolean getMostrarBusquedaPorNombreTipoConversionInven() {
		return this.mostrarBusquedaPorNombreTipoConversionInven;
	}

	public void setMostrarBusquedaPorNombreTipoConversionInven(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoConversionInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoConversionInven=true;

	public Boolean getMostrarFK_IdEmpresaTipoConversionInven() {
		return this.mostrarFK_IdEmpresaTipoConversionInven;
	}

	public void setMostrarFK_IdEmpresaTipoConversionInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoConversionInven= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoConversionInven=true;

	public Boolean getActivarBusquedaPorCodigoTipoConversionInven() {
		return this.activarBusquedaPorCodigoTipoConversionInven;
	}

	public void setActivarBusquedaPorCodigoTipoConversionInven(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoConversionInven= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoConversionInven=true;

	public Boolean getActivarBusquedaPorNombreTipoConversionInven() {
		return this.activarBusquedaPorNombreTipoConversionInven;
	}

	public void setActivarBusquedaPorNombreTipoConversionInven(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoConversionInven= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoConversionInven=true;

	public Boolean getActivarFK_IdEmpresaTipoConversionInven() {
		return this.activarFK_IdEmpresaTipoConversionInven;
	}

	public void setActivarFK_IdEmpresaTipoConversionInven(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoConversionInven= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoConversionInven=null;

	public Border getResaltarBusquedaPorCodigoTipoConversionInven() {
		return this.resaltarBusquedaPorCodigoTipoConversionInven;
	}

	public void setResaltarBusquedaPorCodigoTipoConversionInven(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoConversionInven= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConversionInvenBeanSwingJInternalFrame tipoconversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoConversionInven= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoConversionInven=null;

	public Border getResaltarBusquedaPorNombreTipoConversionInven() {
		return this.resaltarBusquedaPorNombreTipoConversionInven;
	}

	public void setResaltarBusquedaPorNombreTipoConversionInven(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoConversionInven= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConversionInvenBeanSwingJInternalFrame tipoconversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoConversionInven= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoConversionInven=null;

	public Border getResaltarFK_IdEmpresaTipoConversionInven() {
		return this.resaltarFK_IdEmpresaTipoConversionInven;
	}

	public void setResaltarFK_IdEmpresaTipoConversionInven(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoConversionInven= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoConversionInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConversionInvenBeanSwingJInternalFrame tipoconversioninvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoConversionInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}