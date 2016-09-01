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


import com.bydan.erp.importaciones.util.ValorPorUnidadConstantesFunciones;
import com.bydan.erp.importaciones.util.ValorPorUnidadParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.ValorPorUnidadParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ValorPorUnidadConstantesFunciones extends ValorPorUnidadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ValorPorUnidad";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ValorPorUnidad"+ValorPorUnidadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ValorPorUnidadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ValorPorUnidadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ValorPorUnidadConstantesFunciones.SCHEMA+"_"+ValorPorUnidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ValorPorUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ValorPorUnidadConstantesFunciones.SCHEMA+"_"+ValorPorUnidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ValorPorUnidadConstantesFunciones.SCHEMA+"_"+ValorPorUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ValorPorUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ValorPorUnidadConstantesFunciones.SCHEMA+"_"+ValorPorUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ValorPorUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ValorPorUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ValorPorUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ValorPorUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ValorPorUnidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ValorPorUnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ValorPorUnidadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ValorPorUnidadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ValorPorUnidadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ValorPorUnidadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Valor Por Unidades";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Valor Por Unidad";
	public static final String SCLASSWEBTITULO_LOWER="Valor Por Unidad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ValorPorUnidad";
	public static final String OBJECTNAME="valorporunidad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="valor_por_unidad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select valorporunidad from "+ValorPorUnidadConstantesFunciones.SPERSISTENCENAME+" valorporunidad";
	public static String QUERYSELECTNATIVE="select "+ValorPorUnidadConstantesFunciones.SCHEMA+"."+ValorPorUnidadConstantesFunciones.TABLENAME+".id,"+ValorPorUnidadConstantesFunciones.SCHEMA+"."+ValorPorUnidadConstantesFunciones.TABLENAME+".version_row,"+ValorPorUnidadConstantesFunciones.SCHEMA+"."+ValorPorUnidadConstantesFunciones.TABLENAME+".id_empresa,"+ValorPorUnidadConstantesFunciones.SCHEMA+"."+ValorPorUnidadConstantesFunciones.TABLENAME+".id_unidad,"+ValorPorUnidadConstantesFunciones.SCHEMA+"."+ValorPorUnidadConstantesFunciones.TABLENAME+".valor from "+ValorPorUnidadConstantesFunciones.SCHEMA+"."+ValorPorUnidadConstantesFunciones.TABLENAME;//+" as "+ValorPorUnidadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ValorPorUnidadConstantesFuncionesAdditional valorporunidadConstantesFuncionesAdditional=null;
	
	public ValorPorUnidadConstantesFuncionesAdditional getValorPorUnidadConstantesFuncionesAdditional() {
		return this.valorporunidadConstantesFuncionesAdditional;
	}
	
	public void setValorPorUnidadConstantesFuncionesAdditional(ValorPorUnidadConstantesFuncionesAdditional valorporunidadConstantesFuncionesAdditional) {
		try {
			this.valorporunidadConstantesFuncionesAdditional=valorporunidadConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDUNIDAD= "id_unidad";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
	
	public static String getValorPorUnidadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ValorPorUnidadConstantesFunciones.IDEMPRESA)) {sLabelColumna=ValorPorUnidadConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ValorPorUnidadConstantesFunciones.IDUNIDAD)) {sLabelColumna=ValorPorUnidadConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(ValorPorUnidadConstantesFunciones.VALOR)) {sLabelColumna=ValorPorUnidadConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getValorPorUnidadDescripcion(ValorPorUnidad valorporunidad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(valorporunidad !=null/* && valorporunidad.getId()!=0*/) {
			if(valorporunidad.getId()!=null) {
				sDescripcion=valorporunidad.getId().toString();
			}//valorporunidadvalorporunidad.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getValorPorUnidadDescripcionDetallado(ValorPorUnidad valorporunidad) {
		String sDescripcion="";
			
		sDescripcion+=ValorPorUnidadConstantesFunciones.ID+"=";
		sDescripcion+=valorporunidad.getId().toString()+",";
		sDescripcion+=ValorPorUnidadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=valorporunidad.getVersionRow().toString()+",";
		sDescripcion+=ValorPorUnidadConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=valorporunidad.getid_empresa().toString()+",";
		sDescripcion+=ValorPorUnidadConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=valorporunidad.getid_unidad().toString()+",";
		sDescripcion+=ValorPorUnidadConstantesFunciones.VALOR+"=";
		sDescripcion+=valorporunidad.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setValorPorUnidadDescripcion(ValorPorUnidad valorporunidad,String sValor) throws Exception {			
		if(valorporunidad !=null) {
			//valorporunidadvalorporunidad.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getUnidadDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(unidad!=null/*&&unidad.getId()>0*/) {
			sDescripcion=UnidadConstantesFunciones.getUnidadDescripcion(unidad);
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
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unidad";
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

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unidad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosValorPorUnidad(ValorPorUnidad valorporunidad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosValorPorUnidads(List<ValorPorUnidad> valorporunidads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ValorPorUnidad valorporunidad: valorporunidads) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresValorPorUnidad(ValorPorUnidad valorporunidad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && valorporunidad.getConCambioAuxiliar()) {
			valorporunidad.setIsDeleted(valorporunidad.getIsDeletedAuxiliar());	
			valorporunidad.setIsNew(valorporunidad.getIsNewAuxiliar());	
			valorporunidad.setIsChanged(valorporunidad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			valorporunidad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			valorporunidad.setIsDeletedAuxiliar(false);	
			valorporunidad.setIsNewAuxiliar(false);	
			valorporunidad.setIsChangedAuxiliar(false);
			
			valorporunidad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresValorPorUnidads(List<ValorPorUnidad> valorporunidads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ValorPorUnidad valorporunidad : valorporunidads) {
			if(conAsignarBase && valorporunidad.getConCambioAuxiliar()) {
				valorporunidad.setIsDeleted(valorporunidad.getIsDeletedAuxiliar());	
				valorporunidad.setIsNew(valorporunidad.getIsNewAuxiliar());	
				valorporunidad.setIsChanged(valorporunidad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				valorporunidad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				valorporunidad.setIsDeletedAuxiliar(false);	
				valorporunidad.setIsNewAuxiliar(false);	
				valorporunidad.setIsChangedAuxiliar(false);
				
				valorporunidad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresValorPorUnidad(ValorPorUnidad valorporunidad,Boolean conEnteros) throws Exception  {
		valorporunidad.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresValorPorUnidads(List<ValorPorUnidad> valorporunidads,Boolean conEnteros) throws Exception  {
		
		for(ValorPorUnidad valorporunidad: valorporunidads) {
			valorporunidad.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaValorPorUnidad(List<ValorPorUnidad> valorporunidads,ValorPorUnidad valorporunidadAux) throws Exception  {
		ValorPorUnidadConstantesFunciones.InicializarValoresValorPorUnidad(valorporunidadAux,true);
		
		for(ValorPorUnidad valorporunidad: valorporunidads) {
			if(valorporunidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorporunidadAux.setvalor(valorporunidadAux.getvalor()+valorporunidad.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesValorPorUnidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ValorPorUnidadConstantesFunciones.getArrayColumnasGlobalesValorPorUnidad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesValorPorUnidad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ValorPorUnidadConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ValorPorUnidadConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoValorPorUnidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ValorPorUnidad> valorporunidads,ValorPorUnidad valorporunidad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ValorPorUnidad valorporunidadAux: valorporunidads) {
			if(valorporunidadAux!=null && valorporunidad!=null) {
				if((valorporunidadAux.getId()==null && valorporunidad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(valorporunidadAux.getId()!=null && valorporunidad.getId()!=null){
					if(valorporunidadAux.getId().equals(valorporunidad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaValorPorUnidad(List<ValorPorUnidad> valorporunidads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(ValorPorUnidad valorporunidad: valorporunidads) {			
			if(valorporunidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=valorporunidad.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ValorPorUnidadConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ValorPorUnidadConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaValorPorUnidad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ValorPorUnidadConstantesFunciones.LABEL_ID, ValorPorUnidadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ValorPorUnidadConstantesFunciones.LABEL_VERSIONROW, ValorPorUnidadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ValorPorUnidadConstantesFunciones.LABEL_IDEMPRESA, ValorPorUnidadConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ValorPorUnidadConstantesFunciones.LABEL_IDUNIDAD, ValorPorUnidadConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ValorPorUnidadConstantesFunciones.LABEL_VALOR, ValorPorUnidadConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasValorPorUnidad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ValorPorUnidadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ValorPorUnidadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ValorPorUnidadConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ValorPorUnidadConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ValorPorUnidadConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarValorPorUnidad() throws Exception  {
		return ValorPorUnidadConstantesFunciones.getTiposSeleccionarValorPorUnidad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarValorPorUnidad(Boolean conFk) throws Exception  {
		return ValorPorUnidadConstantesFunciones.getTiposSeleccionarValorPorUnidad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarValorPorUnidad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ValorPorUnidadConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ValorPorUnidadConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ValorPorUnidadConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(ValorPorUnidadConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ValorPorUnidadConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ValorPorUnidadConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesValorPorUnidad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesValorPorUnidad(ValorPorUnidad valorporunidadAux) throws Exception {
		
			valorporunidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(valorporunidadAux.getEmpresa()));
			valorporunidadAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(valorporunidadAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesValorPorUnidad(List<ValorPorUnidad> valorporunidadsTemp) throws Exception {
		for(ValorPorUnidad valorporunidadAux:valorporunidadsTemp) {
			
			valorporunidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(valorporunidadAux.getEmpresa()));
			valorporunidadAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(valorporunidadAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfValorPorUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfValorPorUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfValorPorUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ValorPorUnidadConstantesFunciones.getClassesRelationshipsOfValorPorUnidad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfValorPorUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfValorPorUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ValorPorUnidadConstantesFunciones.getClassesRelationshipsFromStringsOfValorPorUnidad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfValorPorUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ValorPorUnidad valorporunidad,List<ValorPorUnidad> valorporunidads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ValorPorUnidad valorporunidadEncontrado=null;
			
			for(ValorPorUnidad valorporunidadLocal:valorporunidads) {
				if(valorporunidadLocal.getId().equals(valorporunidad.getId())) {
					valorporunidadEncontrado=valorporunidadLocal;
					
					valorporunidadLocal.setIsChanged(valorporunidad.getIsChanged());
					valorporunidadLocal.setIsNew(valorporunidad.getIsNew());
					valorporunidadLocal.setIsDeleted(valorporunidad.getIsDeleted());
					
					valorporunidadLocal.setGeneralEntityOriginal(valorporunidad.getGeneralEntityOriginal());
					
					valorporunidadLocal.setId(valorporunidad.getId());	
					valorporunidadLocal.setVersionRow(valorporunidad.getVersionRow());	
					valorporunidadLocal.setid_empresa(valorporunidad.getid_empresa());	
					valorporunidadLocal.setid_unidad(valorporunidad.getid_unidad());	
					valorporunidadLocal.setvalor(valorporunidad.getvalor());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!valorporunidad.getIsDeleted()) {
				if(!existe) {
					valorporunidads.add(valorporunidad);
				}
			} else {
				if(valorporunidadEncontrado!=null && permiteQuitar)  {
					valorporunidads.remove(valorporunidadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ValorPorUnidad valorporunidad,List<ValorPorUnidad> valorporunidads) throws Exception {
		try	{			
			for(ValorPorUnidad valorporunidadLocal:valorporunidads) {
				if(valorporunidadLocal.getId().equals(valorporunidad.getId())) {
					valorporunidadLocal.setIsSelected(valorporunidad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesValorPorUnidad(List<ValorPorUnidad> valorporunidadsAux) throws Exception {
		//this.valorporunidadsAux=valorporunidadsAux;
		
		for(ValorPorUnidad valorporunidadAux:valorporunidadsAux) {
			if(valorporunidadAux.getIsChanged()) {
				valorporunidadAux.setIsChanged(false);
			}		
			
			if(valorporunidadAux.getIsNew()) {
				valorporunidadAux.setIsNew(false);
			}	
			
			if(valorporunidadAux.getIsDeleted()) {
				valorporunidadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesValorPorUnidad(ValorPorUnidad valorporunidadAux) throws Exception {
		//this.valorporunidadAux=valorporunidadAux;
		
			if(valorporunidadAux.getIsChanged()) {
				valorporunidadAux.setIsChanged(false);
			}		
			
			if(valorporunidadAux.getIsNew()) {
				valorporunidadAux.setIsNew(false);
			}	
			
			if(valorporunidadAux.getIsDeleted()) {
				valorporunidadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ValorPorUnidad valorporunidadAsignar,ValorPorUnidad valorporunidad) throws Exception {
		valorporunidadAsignar.setId(valorporunidad.getId());	
		valorporunidadAsignar.setVersionRow(valorporunidad.getVersionRow());	
		valorporunidadAsignar.setid_empresa(valorporunidad.getid_empresa());
		valorporunidadAsignar.setempresa_descripcion(valorporunidad.getempresa_descripcion());	
		valorporunidadAsignar.setid_unidad(valorporunidad.getid_unidad());
		valorporunidadAsignar.setunidad_descripcion(valorporunidad.getunidad_descripcion());	
		valorporunidadAsignar.setvalor(valorporunidad.getvalor());	
	}
	
	public static void inicializarValorPorUnidad(ValorPorUnidad valorporunidad) throws Exception {
		try {
				valorporunidad.setId(0L);	
					
				valorporunidad.setid_empresa(-1L);	
				valorporunidad.setid_unidad(-1L);	
				valorporunidad.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderValorPorUnidad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ValorPorUnidadConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ValorPorUnidadConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ValorPorUnidadConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataValorPorUnidad(String sTipo,Row row,Workbook workbook,ValorPorUnidad valorporunidad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(valorporunidad.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(valorporunidad.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(valorporunidad.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryValorPorUnidad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryValorPorUnidad() {
		return this.sFinalQueryValorPorUnidad;
	}
	
	public void setsFinalQueryValorPorUnidad(String sFinalQueryValorPorUnidad) {
		this.sFinalQueryValorPorUnidad= sFinalQueryValorPorUnidad;
	}
	
	public Border resaltarSeleccionarValorPorUnidad=null;
	
	public Border setResaltarSeleccionarValorPorUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ValorPorUnidadBeanSwingJInternalFrame valorporunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//valorporunidadBeanSwingJInternalFrame.jTtoolBarValorPorUnidad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarValorPorUnidad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarValorPorUnidad() {
		return this.resaltarSeleccionarValorPorUnidad;
	}
	
	public void setResaltarSeleccionarValorPorUnidad(Border borderResaltarSeleccionarValorPorUnidad) {
		this.resaltarSeleccionarValorPorUnidad= borderResaltarSeleccionarValorPorUnidad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridValorPorUnidad=null;
	public Boolean mostraridValorPorUnidad=true;
	public Boolean activaridValorPorUnidad=true;

	public Border resaltarid_empresaValorPorUnidad=null;
	public Boolean mostrarid_empresaValorPorUnidad=true;
	public Boolean activarid_empresaValorPorUnidad=true;
	public Boolean cargarid_empresaValorPorUnidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaValorPorUnidad=false;//ConEventDepend=true

	public Border resaltarid_unidadValorPorUnidad=null;
	public Boolean mostrarid_unidadValorPorUnidad=true;
	public Boolean activarid_unidadValorPorUnidad=true;
	public Boolean cargarid_unidadValorPorUnidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadValorPorUnidad=false;//ConEventDepend=true

	public Border resaltarvalorValorPorUnidad=null;
	public Boolean mostrarvalorValorPorUnidad=true;
	public Boolean activarvalorValorPorUnidad=true;

	
	

	public Border setResaltaridValorPorUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ValorPorUnidadBeanSwingJInternalFrame valorporunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//valorporunidadBeanSwingJInternalFrame.jTtoolBarValorPorUnidad.setBorder(borderResaltar);
		
		this.resaltaridValorPorUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridValorPorUnidad() {
		return this.resaltaridValorPorUnidad;
	}

	public void setResaltaridValorPorUnidad(Border borderResaltar) {
		this.resaltaridValorPorUnidad= borderResaltar;
	}

	public Boolean getMostraridValorPorUnidad() {
		return this.mostraridValorPorUnidad;
	}

	public void setMostraridValorPorUnidad(Boolean mostraridValorPorUnidad) {
		this.mostraridValorPorUnidad= mostraridValorPorUnidad;
	}

	public Boolean getActivaridValorPorUnidad() {
		return this.activaridValorPorUnidad;
	}

	public void setActivaridValorPorUnidad(Boolean activaridValorPorUnidad) {
		this.activaridValorPorUnidad= activaridValorPorUnidad;
	}

	public Border setResaltarid_empresaValorPorUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ValorPorUnidadBeanSwingJInternalFrame valorporunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//valorporunidadBeanSwingJInternalFrame.jTtoolBarValorPorUnidad.setBorder(borderResaltar);
		
		this.resaltarid_empresaValorPorUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaValorPorUnidad() {
		return this.resaltarid_empresaValorPorUnidad;
	}

	public void setResaltarid_empresaValorPorUnidad(Border borderResaltar) {
		this.resaltarid_empresaValorPorUnidad= borderResaltar;
	}

	public Boolean getMostrarid_empresaValorPorUnidad() {
		return this.mostrarid_empresaValorPorUnidad;
	}

	public void setMostrarid_empresaValorPorUnidad(Boolean mostrarid_empresaValorPorUnidad) {
		this.mostrarid_empresaValorPorUnidad= mostrarid_empresaValorPorUnidad;
	}

	public Boolean getActivarid_empresaValorPorUnidad() {
		return this.activarid_empresaValorPorUnidad;
	}

	public void setActivarid_empresaValorPorUnidad(Boolean activarid_empresaValorPorUnidad) {
		this.activarid_empresaValorPorUnidad= activarid_empresaValorPorUnidad;
	}

	public Boolean getCargarid_empresaValorPorUnidad() {
		return this.cargarid_empresaValorPorUnidad;
	}

	public void setCargarid_empresaValorPorUnidad(Boolean cargarid_empresaValorPorUnidad) {
		this.cargarid_empresaValorPorUnidad= cargarid_empresaValorPorUnidad;
	}

	public Border setResaltarid_unidadValorPorUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ValorPorUnidadBeanSwingJInternalFrame valorporunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//valorporunidadBeanSwingJInternalFrame.jTtoolBarValorPorUnidad.setBorder(borderResaltar);
		
		this.resaltarid_unidadValorPorUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadValorPorUnidad() {
		return this.resaltarid_unidadValorPorUnidad;
	}

	public void setResaltarid_unidadValorPorUnidad(Border borderResaltar) {
		this.resaltarid_unidadValorPorUnidad= borderResaltar;
	}

	public Boolean getMostrarid_unidadValorPorUnidad() {
		return this.mostrarid_unidadValorPorUnidad;
	}

	public void setMostrarid_unidadValorPorUnidad(Boolean mostrarid_unidadValorPorUnidad) {
		this.mostrarid_unidadValorPorUnidad= mostrarid_unidadValorPorUnidad;
	}

	public Boolean getActivarid_unidadValorPorUnidad() {
		return this.activarid_unidadValorPorUnidad;
	}

	public void setActivarid_unidadValorPorUnidad(Boolean activarid_unidadValorPorUnidad) {
		this.activarid_unidadValorPorUnidad= activarid_unidadValorPorUnidad;
	}

	public Boolean getCargarid_unidadValorPorUnidad() {
		return this.cargarid_unidadValorPorUnidad;
	}

	public void setCargarid_unidadValorPorUnidad(Boolean cargarid_unidadValorPorUnidad) {
		this.cargarid_unidadValorPorUnidad= cargarid_unidadValorPorUnidad;
	}

	public Border setResaltarvalorValorPorUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ValorPorUnidadBeanSwingJInternalFrame valorporunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//valorporunidadBeanSwingJInternalFrame.jTtoolBarValorPorUnidad.setBorder(borderResaltar);
		
		this.resaltarvalorValorPorUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorValorPorUnidad() {
		return this.resaltarvalorValorPorUnidad;
	}

	public void setResaltarvalorValorPorUnidad(Border borderResaltar) {
		this.resaltarvalorValorPorUnidad= borderResaltar;
	}

	public Boolean getMostrarvalorValorPorUnidad() {
		return this.mostrarvalorValorPorUnidad;
	}

	public void setMostrarvalorValorPorUnidad(Boolean mostrarvalorValorPorUnidad) {
		this.mostrarvalorValorPorUnidad= mostrarvalorValorPorUnidad;
	}

	public Boolean getActivarvalorValorPorUnidad() {
		return this.activarvalorValorPorUnidad;
	}

	public void setActivarvalorValorPorUnidad(Boolean activarvalorValorPorUnidad) {
		this.activarvalorValorPorUnidad= activarvalorValorPorUnidad;
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
		
		
		this.setMostraridValorPorUnidad(esInicial);
		this.setMostrarid_empresaValorPorUnidad(esInicial);
		this.setMostrarid_unidadValorPorUnidad(esInicial);
		this.setMostrarvalorValorPorUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ValorPorUnidadConstantesFunciones.ID)) {
				this.setMostraridValorPorUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorPorUnidadConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaValorPorUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorPorUnidadConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadValorPorUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorPorUnidadConstantesFunciones.VALOR)) {
				this.setMostrarvalorValorPorUnidad(esAsigna);
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
		
		
		this.setActivaridValorPorUnidad(esInicial);
		this.setActivarid_empresaValorPorUnidad(esInicial);
		this.setActivarid_unidadValorPorUnidad(esInicial);
		this.setActivarvalorValorPorUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ValorPorUnidadConstantesFunciones.ID)) {
				this.setActivaridValorPorUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorPorUnidadConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaValorPorUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorPorUnidadConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadValorPorUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorPorUnidadConstantesFunciones.VALOR)) {
				this.setActivarvalorValorPorUnidad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ValorPorUnidadBeanSwingJInternalFrame valorporunidadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridValorPorUnidad(esInicial);
		this.setResaltarid_empresaValorPorUnidad(esInicial);
		this.setResaltarid_unidadValorPorUnidad(esInicial);
		this.setResaltarvalorValorPorUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ValorPorUnidadConstantesFunciones.ID)) {
				this.setResaltaridValorPorUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorPorUnidadConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaValorPorUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorPorUnidadConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadValorPorUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ValorPorUnidadConstantesFunciones.VALOR)) {
				this.setResaltarvalorValorPorUnidad(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ValorPorUnidadBeanSwingJInternalFrame valorporunidadBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaValorPorUnidad=true;

	public Boolean getMostrarFK_IdEmpresaValorPorUnidad() {
		return this.mostrarFK_IdEmpresaValorPorUnidad;
	}

	public void setMostrarFK_IdEmpresaValorPorUnidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaValorPorUnidad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadValorPorUnidad=true;

	public Boolean getMostrarFK_IdUnidadValorPorUnidad() {
		return this.mostrarFK_IdUnidadValorPorUnidad;
	}

	public void setMostrarFK_IdUnidadValorPorUnidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadValorPorUnidad= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaValorPorUnidad=true;

	public Boolean getActivarFK_IdEmpresaValorPorUnidad() {
		return this.activarFK_IdEmpresaValorPorUnidad;
	}

	public void setActivarFK_IdEmpresaValorPorUnidad(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaValorPorUnidad= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadValorPorUnidad=true;

	public Boolean getActivarFK_IdUnidadValorPorUnidad() {
		return this.activarFK_IdUnidadValorPorUnidad;
	}

	public void setActivarFK_IdUnidadValorPorUnidad(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadValorPorUnidad= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaValorPorUnidad=null;

	public Border getResaltarFK_IdEmpresaValorPorUnidad() {
		return this.resaltarFK_IdEmpresaValorPorUnidad;
	}

	public void setResaltarFK_IdEmpresaValorPorUnidad(Border borderResaltar) {
		this.resaltarFK_IdEmpresaValorPorUnidad= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaValorPorUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ValorPorUnidadBeanSwingJInternalFrame valorporunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaValorPorUnidad= borderResaltar;
	}

	public Border resaltarFK_IdUnidadValorPorUnidad=null;

	public Border getResaltarFK_IdUnidadValorPorUnidad() {
		return this.resaltarFK_IdUnidadValorPorUnidad;
	}

	public void setResaltarFK_IdUnidadValorPorUnidad(Border borderResaltar) {
		this.resaltarFK_IdUnidadValorPorUnidad= borderResaltar;
	}

	public void setResaltarFK_IdUnidadValorPorUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*ValorPorUnidadBeanSwingJInternalFrame valorporunidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadValorPorUnidad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}