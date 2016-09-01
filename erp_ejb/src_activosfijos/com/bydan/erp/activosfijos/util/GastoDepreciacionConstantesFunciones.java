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


import com.bydan.erp.activosfijos.util.GastoDepreciacionConstantesFunciones;
import com.bydan.erp.activosfijos.util.GastoDepreciacionParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.GastoDepreciacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class GastoDepreciacionConstantesFunciones extends GastoDepreciacionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="GastoDepreciacion";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="GastoDepreciacion"+GastoDepreciacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="GastoDepreciacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="GastoDepreciacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=GastoDepreciacionConstantesFunciones.SCHEMA+"_"+GastoDepreciacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/GastoDepreciacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=GastoDepreciacionConstantesFunciones.SCHEMA+"_"+GastoDepreciacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=GastoDepreciacionConstantesFunciones.SCHEMA+"_"+GastoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/GastoDepreciacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=GastoDepreciacionConstantesFunciones.SCHEMA+"_"+GastoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GastoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GastoDepreciacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GastoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GastoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GastoDepreciacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GastoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=GastoDepreciacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+GastoDepreciacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=GastoDepreciacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+GastoDepreciacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Gasto Depreciaciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Gasto Depreciacion";
	public static final String SCLASSWEBTITULO_LOWER="Gasto Depreciacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="GastoDepreciacion";
	public static final String OBJECTNAME="gastodepreciacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="gasto_depreciacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select gastodepreciacion from "+GastoDepreciacionConstantesFunciones.SPERSISTENCENAME+" gastodepreciacion";
	public static String QUERYSELECTNATIVE="select "+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+".id,"+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+".version_row,"+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+".id_empresa,"+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+".id_detalle_grupo_activo_fijo,"+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+".anio,"+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+".valor from "+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME;//+" as "+GastoDepreciacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected GastoDepreciacionConstantesFuncionesAdditional gastodepreciacionConstantesFuncionesAdditional=null;
	
	public GastoDepreciacionConstantesFuncionesAdditional getGastoDepreciacionConstantesFuncionesAdditional() {
		return this.gastodepreciacionConstantesFuncionesAdditional;
	}
	
	public void setGastoDepreciacionConstantesFuncionesAdditional(GastoDepreciacionConstantesFuncionesAdditional gastodepreciacionConstantesFuncionesAdditional) {
		try {
			this.gastodepreciacionConstantesFuncionesAdditional=gastodepreciacionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDDETALLEGRUPOACTIVOFIJO= "id_detalle_grupo_activo_fijo";
    public static final String ANIO= "anio";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDDETALLEGRUPOACTIVOFIJO= "Detalle Grupo Activo Fijo";
		public static final String LABEL_IDDETALLEGRUPOACTIVOFIJO_LOWER= "Detalle Grupo Activo Fijo";
    	public static final String LABEL_ANIO= "Anio";
		public static final String LABEL_ANIO_LOWER= "Anio";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
		
	
	public static String getGastoDepreciacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(GastoDepreciacionConstantesFunciones.IDEMPRESA)) {sLabelColumna=GastoDepreciacionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(GastoDepreciacionConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {sLabelColumna=GastoDepreciacionConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO;}
		if(sNombreColumna.equals(GastoDepreciacionConstantesFunciones.ANIO)) {sLabelColumna=GastoDepreciacionConstantesFunciones.LABEL_ANIO;}
		if(sNombreColumna.equals(GastoDepreciacionConstantesFunciones.VALOR)) {sLabelColumna=GastoDepreciacionConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getGastoDepreciacionDescripcion(GastoDepreciacion gastodepreciacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(gastodepreciacion !=null/* && gastodepreciacion.getId()!=0*/) {
			if(gastodepreciacion.getId()!=null) {
				sDescripcion=gastodepreciacion.getId().toString();
			}//gastodepreciaciongastodepreciacion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getGastoDepreciacionDescripcionDetallado(GastoDepreciacion gastodepreciacion) {
		String sDescripcion="";
			
		sDescripcion+=GastoDepreciacionConstantesFunciones.ID+"=";
		sDescripcion+=gastodepreciacion.getId().toString()+",";
		sDescripcion+=GastoDepreciacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=gastodepreciacion.getVersionRow().toString()+",";
		sDescripcion+=GastoDepreciacionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=gastodepreciacion.getid_empresa().toString()+",";
		sDescripcion+=GastoDepreciacionConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO+"=";
		sDescripcion+=gastodepreciacion.getid_detalle_grupo_activo_fijo().toString()+",";
		sDescripcion+=GastoDepreciacionConstantesFunciones.ANIO+"=";
		sDescripcion+=gastodepreciacion.getanio().toString()+",";
		sDescripcion+=GastoDepreciacionConstantesFunciones.VALOR+"=";
		sDescripcion+=gastodepreciacion.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setGastoDepreciacionDescripcion(GastoDepreciacion gastodepreciacion,String sValor) throws Exception {			
		if(gastodepreciacion !=null) {
			//gastodepreciaciongastodepreciacion.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getDetalleGrupoActivoFijoDescripcion(DetalleGrupoActivoFijo detallegrupoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detallegrupoactivofijo!=null/*&&detallegrupoactivofijo.getId()>0*/) {
			sDescripcion=DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(detallegrupoactivofijo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdDetalleGrupoActivoFijo")) {
			sNombreIndice="Tipo=  Por Detalle Grupo Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdDetalleGrupoActivoFijo(Long id_detalle_grupo_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_grupo_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Detalle Grupo Activo Fijo="+id_detalle_grupo_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosGastoDepreciacion(GastoDepreciacion gastodepreciacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosGastoDepreciacions(List<GastoDepreciacion> gastodepreciacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GastoDepreciacion gastodepreciacion: gastodepreciacions) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGastoDepreciacion(GastoDepreciacion gastodepreciacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && gastodepreciacion.getConCambioAuxiliar()) {
			gastodepreciacion.setIsDeleted(gastodepreciacion.getIsDeletedAuxiliar());	
			gastodepreciacion.setIsNew(gastodepreciacion.getIsNewAuxiliar());	
			gastodepreciacion.setIsChanged(gastodepreciacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			gastodepreciacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			gastodepreciacion.setIsDeletedAuxiliar(false);	
			gastodepreciacion.setIsNewAuxiliar(false);	
			gastodepreciacion.setIsChangedAuxiliar(false);
			
			gastodepreciacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGastoDepreciacions(List<GastoDepreciacion> gastodepreciacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(GastoDepreciacion gastodepreciacion : gastodepreciacions) {
			if(conAsignarBase && gastodepreciacion.getConCambioAuxiliar()) {
				gastodepreciacion.setIsDeleted(gastodepreciacion.getIsDeletedAuxiliar());	
				gastodepreciacion.setIsNew(gastodepreciacion.getIsNewAuxiliar());	
				gastodepreciacion.setIsChanged(gastodepreciacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				gastodepreciacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				gastodepreciacion.setIsDeletedAuxiliar(false);	
				gastodepreciacion.setIsNewAuxiliar(false);	
				gastodepreciacion.setIsChangedAuxiliar(false);
				
				gastodepreciacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresGastoDepreciacion(GastoDepreciacion gastodepreciacion,Boolean conEnteros) throws Exception  {
		gastodepreciacion.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			gastodepreciacion.setanio(0);
		}
	}		
	
	public static void InicializarValoresGastoDepreciacions(List<GastoDepreciacion> gastodepreciacions,Boolean conEnteros) throws Exception  {
		
		for(GastoDepreciacion gastodepreciacion: gastodepreciacions) {
			gastodepreciacion.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				gastodepreciacion.setanio(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaGastoDepreciacion(List<GastoDepreciacion> gastodepreciacions,GastoDepreciacion gastodepreciacionAux) throws Exception  {
		GastoDepreciacionConstantesFunciones.InicializarValoresGastoDepreciacion(gastodepreciacionAux,true);
		
		for(GastoDepreciacion gastodepreciacion: gastodepreciacions) {
			if(gastodepreciacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			gastodepreciacionAux.setanio(gastodepreciacionAux.getanio()+gastodepreciacion.getanio());			
			gastodepreciacionAux.setvalor(gastodepreciacionAux.getvalor()+gastodepreciacion.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGastoDepreciacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=GastoDepreciacionConstantesFunciones.getArrayColumnasGlobalesGastoDepreciacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesGastoDepreciacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GastoDepreciacionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GastoDepreciacionConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoGastoDepreciacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GastoDepreciacion> gastodepreciacions,GastoDepreciacion gastodepreciacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GastoDepreciacion gastodepreciacionAux: gastodepreciacions) {
			if(gastodepreciacionAux!=null && gastodepreciacion!=null) {
				if((gastodepreciacionAux.getId()==null && gastodepreciacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(gastodepreciacionAux.getId()!=null && gastodepreciacion.getId()!=null){
					if(gastodepreciacionAux.getId().equals(gastodepreciacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGastoDepreciacion(List<GastoDepreciacion> gastodepreciacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(GastoDepreciacion gastodepreciacion: gastodepreciacions) {			
			if(gastodepreciacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=gastodepreciacion.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoDepreciacionConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(GastoDepreciacionConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaGastoDepreciacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,GastoDepreciacionConstantesFunciones.LABEL_ID, GastoDepreciacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoDepreciacionConstantesFunciones.LABEL_VERSIONROW, GastoDepreciacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoDepreciacionConstantesFunciones.LABEL_IDEMPRESA, GastoDepreciacionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoDepreciacionConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO, GastoDepreciacionConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoDepreciacionConstantesFunciones.LABEL_ANIO, GastoDepreciacionConstantesFunciones.ANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoDepreciacionConstantesFunciones.LABEL_VALOR, GastoDepreciacionConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasGastoDepreciacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=GastoDepreciacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoDepreciacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoDepreciacionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoDepreciacionConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoDepreciacionConstantesFunciones.ANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoDepreciacionConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGastoDepreciacion() throws Exception  {
		return GastoDepreciacionConstantesFunciones.getTiposSeleccionarGastoDepreciacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGastoDepreciacion(Boolean conFk) throws Exception  {
		return GastoDepreciacionConstantesFunciones.getTiposSeleccionarGastoDepreciacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGastoDepreciacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoDepreciacionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(GastoDepreciacionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoDepreciacionConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);
			reporte.setsDescripcion(GastoDepreciacionConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoDepreciacionConstantesFunciones.LABEL_ANIO);
			reporte.setsDescripcion(GastoDepreciacionConstantesFunciones.LABEL_ANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoDepreciacionConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(GastoDepreciacionConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesGastoDepreciacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesGastoDepreciacion(GastoDepreciacion gastodepreciacionAux) throws Exception {
		
			gastodepreciacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(gastodepreciacionAux.getEmpresa()));
			gastodepreciacionAux.setdetallegrupoactivofijo_descripcion(DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(gastodepreciacionAux.getDetalleGrupoActivoFijo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesGastoDepreciacion(List<GastoDepreciacion> gastodepreciacionsTemp) throws Exception {
		for(GastoDepreciacion gastodepreciacionAux:gastodepreciacionsTemp) {
			
			gastodepreciacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(gastodepreciacionAux.getEmpresa()));
			gastodepreciacionAux.setdetallegrupoactivofijo_descripcion(DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(gastodepreciacionAux.getDetalleGrupoActivoFijo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfGastoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(DetalleGrupoActivoFijo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfGastoDepreciacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(DetalleGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(DetalleGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfGastoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return GastoDepreciacionConstantesFunciones.getClassesRelationshipsOfGastoDepreciacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGastoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CuentaContaGastoDepre.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContaGastoDepre.class)) {
						classes.add(new Classe(CuentaContaGastoDepre.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGastoDepreciacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return GastoDepreciacionConstantesFunciones.getClassesRelationshipsFromStringsOfGastoDepreciacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGastoDepreciacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaContaGastoDepre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContaGastoDepre.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CuentaContaGastoDepre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContaGastoDepre.class)); continue;
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
	public static void actualizarLista(GastoDepreciacion gastodepreciacion,List<GastoDepreciacion> gastodepreciacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			GastoDepreciacion gastodepreciacionEncontrado=null;
			
			for(GastoDepreciacion gastodepreciacionLocal:gastodepreciacions) {
				if(gastodepreciacionLocal.getId().equals(gastodepreciacion.getId())) {
					gastodepreciacionEncontrado=gastodepreciacionLocal;
					
					gastodepreciacionLocal.setIsChanged(gastodepreciacion.getIsChanged());
					gastodepreciacionLocal.setIsNew(gastodepreciacion.getIsNew());
					gastodepreciacionLocal.setIsDeleted(gastodepreciacion.getIsDeleted());
					
					gastodepreciacionLocal.setGeneralEntityOriginal(gastodepreciacion.getGeneralEntityOriginal());
					
					gastodepreciacionLocal.setId(gastodepreciacion.getId());	
					gastodepreciacionLocal.setVersionRow(gastodepreciacion.getVersionRow());	
					gastodepreciacionLocal.setid_empresa(gastodepreciacion.getid_empresa());	
					gastodepreciacionLocal.setid_detalle_grupo_activo_fijo(gastodepreciacion.getid_detalle_grupo_activo_fijo());	
					gastodepreciacionLocal.setanio(gastodepreciacion.getanio());	
					gastodepreciacionLocal.setvalor(gastodepreciacion.getvalor());	
					
					
					gastodepreciacionLocal.setCuentaContaGastoDepres(gastodepreciacion.getCuentaContaGastoDepres());
					
					existe=true;
					break;
				}
			}
			
			if(!gastodepreciacion.getIsDeleted()) {
				if(!existe) {
					gastodepreciacions.add(gastodepreciacion);
				}
			} else {
				if(gastodepreciacionEncontrado!=null && permiteQuitar)  {
					gastodepreciacions.remove(gastodepreciacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(GastoDepreciacion gastodepreciacion,List<GastoDepreciacion> gastodepreciacions) throws Exception {
		try	{			
			for(GastoDepreciacion gastodepreciacionLocal:gastodepreciacions) {
				if(gastodepreciacionLocal.getId().equals(gastodepreciacion.getId())) {
					gastodepreciacionLocal.setIsSelected(gastodepreciacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesGastoDepreciacion(List<GastoDepreciacion> gastodepreciacionsAux) throws Exception {
		//this.gastodepreciacionsAux=gastodepreciacionsAux;
		
		for(GastoDepreciacion gastodepreciacionAux:gastodepreciacionsAux) {
			if(gastodepreciacionAux.getIsChanged()) {
				gastodepreciacionAux.setIsChanged(false);
			}		
			
			if(gastodepreciacionAux.getIsNew()) {
				gastodepreciacionAux.setIsNew(false);
			}	
			
			if(gastodepreciacionAux.getIsDeleted()) {
				gastodepreciacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesGastoDepreciacion(GastoDepreciacion gastodepreciacionAux) throws Exception {
		//this.gastodepreciacionAux=gastodepreciacionAux;
		
			if(gastodepreciacionAux.getIsChanged()) {
				gastodepreciacionAux.setIsChanged(false);
			}		
			
			if(gastodepreciacionAux.getIsNew()) {
				gastodepreciacionAux.setIsNew(false);
			}	
			
			if(gastodepreciacionAux.getIsDeleted()) {
				gastodepreciacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(GastoDepreciacion gastodepreciacionAsignar,GastoDepreciacion gastodepreciacion) throws Exception {
		gastodepreciacionAsignar.setId(gastodepreciacion.getId());	
		gastodepreciacionAsignar.setVersionRow(gastodepreciacion.getVersionRow());	
		gastodepreciacionAsignar.setid_empresa(gastodepreciacion.getid_empresa());
		gastodepreciacionAsignar.setempresa_descripcion(gastodepreciacion.getempresa_descripcion());	
		gastodepreciacionAsignar.setid_detalle_grupo_activo_fijo(gastodepreciacion.getid_detalle_grupo_activo_fijo());
		gastodepreciacionAsignar.setdetallegrupoactivofijo_descripcion(gastodepreciacion.getdetallegrupoactivofijo_descripcion());	
		gastodepreciacionAsignar.setanio(gastodepreciacion.getanio());	
		gastodepreciacionAsignar.setvalor(gastodepreciacion.getvalor());	
	}
	
	public static void inicializarGastoDepreciacion(GastoDepreciacion gastodepreciacion) throws Exception {
		try {
				gastodepreciacion.setId(0L);	
					
				gastodepreciacion.setid_empresa(-1L);	
				gastodepreciacion.setid_detalle_grupo_activo_fijo(-1L);	
				gastodepreciacion.setanio(0);	
				gastodepreciacion.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderGastoDepreciacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoDepreciacionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoDepreciacionConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoDepreciacionConstantesFunciones.LABEL_ANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoDepreciacionConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataGastoDepreciacion(String sTipo,Row row,Workbook workbook,GastoDepreciacion gastodepreciacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(gastodepreciacion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastodepreciacion.getdetallegrupoactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastodepreciacion.getanio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastodepreciacion.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryGastoDepreciacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryGastoDepreciacion() {
		return this.sFinalQueryGastoDepreciacion;
	}
	
	public void setsFinalQueryGastoDepreciacion(String sFinalQueryGastoDepreciacion) {
		this.sFinalQueryGastoDepreciacion= sFinalQueryGastoDepreciacion;
	}
	
	public Border resaltarSeleccionarGastoDepreciacion=null;
	
	public Border setResaltarSeleccionarGastoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionBeanSwingJInternalFrame gastodepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//gastodepreciacionBeanSwingJInternalFrame.jTtoolBarGastoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarGastoDepreciacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarGastoDepreciacion() {
		return this.resaltarSeleccionarGastoDepreciacion;
	}
	
	public void setResaltarSeleccionarGastoDepreciacion(Border borderResaltarSeleccionarGastoDepreciacion) {
		this.resaltarSeleccionarGastoDepreciacion= borderResaltarSeleccionarGastoDepreciacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridGastoDepreciacion=null;
	public Boolean mostraridGastoDepreciacion=true;
	public Boolean activaridGastoDepreciacion=true;

	public Border resaltarid_empresaGastoDepreciacion=null;
	public Boolean mostrarid_empresaGastoDepreciacion=true;
	public Boolean activarid_empresaGastoDepreciacion=true;
	public Boolean cargarid_empresaGastoDepreciacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaGastoDepreciacion=false;//ConEventDepend=true

	public Border resaltarid_detalle_grupo_activo_fijoGastoDepreciacion=null;
	public Boolean mostrarid_detalle_grupo_activo_fijoGastoDepreciacion=true;
	public Boolean activarid_detalle_grupo_activo_fijoGastoDepreciacion=true;
	public Boolean cargarid_detalle_grupo_activo_fijoGastoDepreciacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_grupo_activo_fijoGastoDepreciacion=false;//ConEventDepend=true

	public Border resaltaranioGastoDepreciacion=null;
	public Boolean mostraranioGastoDepreciacion=true;
	public Boolean activaranioGastoDepreciacion=true;

	public Border resaltarvalorGastoDepreciacion=null;
	public Boolean mostrarvalorGastoDepreciacion=true;
	public Boolean activarvalorGastoDepreciacion=true;

	
	

	public Border setResaltaridGastoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionBeanSwingJInternalFrame gastodepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastodepreciacionBeanSwingJInternalFrame.jTtoolBarGastoDepreciacion.setBorder(borderResaltar);
		
		this.resaltaridGastoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridGastoDepreciacion() {
		return this.resaltaridGastoDepreciacion;
	}

	public void setResaltaridGastoDepreciacion(Border borderResaltar) {
		this.resaltaridGastoDepreciacion= borderResaltar;
	}

	public Boolean getMostraridGastoDepreciacion() {
		return this.mostraridGastoDepreciacion;
	}

	public void setMostraridGastoDepreciacion(Boolean mostraridGastoDepreciacion) {
		this.mostraridGastoDepreciacion= mostraridGastoDepreciacion;
	}

	public Boolean getActivaridGastoDepreciacion() {
		return this.activaridGastoDepreciacion;
	}

	public void setActivaridGastoDepreciacion(Boolean activaridGastoDepreciacion) {
		this.activaridGastoDepreciacion= activaridGastoDepreciacion;
	}

	public Border setResaltarid_empresaGastoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionBeanSwingJInternalFrame gastodepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastodepreciacionBeanSwingJInternalFrame.jTtoolBarGastoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarid_empresaGastoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaGastoDepreciacion() {
		return this.resaltarid_empresaGastoDepreciacion;
	}

	public void setResaltarid_empresaGastoDepreciacion(Border borderResaltar) {
		this.resaltarid_empresaGastoDepreciacion= borderResaltar;
	}

	public Boolean getMostrarid_empresaGastoDepreciacion() {
		return this.mostrarid_empresaGastoDepreciacion;
	}

	public void setMostrarid_empresaGastoDepreciacion(Boolean mostrarid_empresaGastoDepreciacion) {
		this.mostrarid_empresaGastoDepreciacion= mostrarid_empresaGastoDepreciacion;
	}

	public Boolean getActivarid_empresaGastoDepreciacion() {
		return this.activarid_empresaGastoDepreciacion;
	}

	public void setActivarid_empresaGastoDepreciacion(Boolean activarid_empresaGastoDepreciacion) {
		this.activarid_empresaGastoDepreciacion= activarid_empresaGastoDepreciacion;
	}

	public Boolean getCargarid_empresaGastoDepreciacion() {
		return this.cargarid_empresaGastoDepreciacion;
	}

	public void setCargarid_empresaGastoDepreciacion(Boolean cargarid_empresaGastoDepreciacion) {
		this.cargarid_empresaGastoDepreciacion= cargarid_empresaGastoDepreciacion;
	}

	public Border setResaltarid_detalle_grupo_activo_fijoGastoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionBeanSwingJInternalFrame gastodepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastodepreciacionBeanSwingJInternalFrame.jTtoolBarGastoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarid_detalle_grupo_activo_fijoGastoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_grupo_activo_fijoGastoDepreciacion() {
		return this.resaltarid_detalle_grupo_activo_fijoGastoDepreciacion;
	}

	public void setResaltarid_detalle_grupo_activo_fijoGastoDepreciacion(Border borderResaltar) {
		this.resaltarid_detalle_grupo_activo_fijoGastoDepreciacion= borderResaltar;
	}

	public Boolean getMostrarid_detalle_grupo_activo_fijoGastoDepreciacion() {
		return this.mostrarid_detalle_grupo_activo_fijoGastoDepreciacion;
	}

	public void setMostrarid_detalle_grupo_activo_fijoGastoDepreciacion(Boolean mostrarid_detalle_grupo_activo_fijoGastoDepreciacion) {
		this.mostrarid_detalle_grupo_activo_fijoGastoDepreciacion= mostrarid_detalle_grupo_activo_fijoGastoDepreciacion;
	}

	public Boolean getActivarid_detalle_grupo_activo_fijoGastoDepreciacion() {
		return this.activarid_detalle_grupo_activo_fijoGastoDepreciacion;
	}

	public void setActivarid_detalle_grupo_activo_fijoGastoDepreciacion(Boolean activarid_detalle_grupo_activo_fijoGastoDepreciacion) {
		this.activarid_detalle_grupo_activo_fijoGastoDepreciacion= activarid_detalle_grupo_activo_fijoGastoDepreciacion;
	}

	public Boolean getCargarid_detalle_grupo_activo_fijoGastoDepreciacion() {
		return this.cargarid_detalle_grupo_activo_fijoGastoDepreciacion;
	}

	public void setCargarid_detalle_grupo_activo_fijoGastoDepreciacion(Boolean cargarid_detalle_grupo_activo_fijoGastoDepreciacion) {
		this.cargarid_detalle_grupo_activo_fijoGastoDepreciacion= cargarid_detalle_grupo_activo_fijoGastoDepreciacion;
	}

	public Border setResaltaranioGastoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionBeanSwingJInternalFrame gastodepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastodepreciacionBeanSwingJInternalFrame.jTtoolBarGastoDepreciacion.setBorder(borderResaltar);
		
		this.resaltaranioGastoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranioGastoDepreciacion() {
		return this.resaltaranioGastoDepreciacion;
	}

	public void setResaltaranioGastoDepreciacion(Border borderResaltar) {
		this.resaltaranioGastoDepreciacion= borderResaltar;
	}

	public Boolean getMostraranioGastoDepreciacion() {
		return this.mostraranioGastoDepreciacion;
	}

	public void setMostraranioGastoDepreciacion(Boolean mostraranioGastoDepreciacion) {
		this.mostraranioGastoDepreciacion= mostraranioGastoDepreciacion;
	}

	public Boolean getActivaranioGastoDepreciacion() {
		return this.activaranioGastoDepreciacion;
	}

	public void setActivaranioGastoDepreciacion(Boolean activaranioGastoDepreciacion) {
		this.activaranioGastoDepreciacion= activaranioGastoDepreciacion;
	}

	public Border setResaltarvalorGastoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionBeanSwingJInternalFrame gastodepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastodepreciacionBeanSwingJInternalFrame.jTtoolBarGastoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarvalorGastoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorGastoDepreciacion() {
		return this.resaltarvalorGastoDepreciacion;
	}

	public void setResaltarvalorGastoDepreciacion(Border borderResaltar) {
		this.resaltarvalorGastoDepreciacion= borderResaltar;
	}

	public Boolean getMostrarvalorGastoDepreciacion() {
		return this.mostrarvalorGastoDepreciacion;
	}

	public void setMostrarvalorGastoDepreciacion(Boolean mostrarvalorGastoDepreciacion) {
		this.mostrarvalorGastoDepreciacion= mostrarvalorGastoDepreciacion;
	}

	public Boolean getActivarvalorGastoDepreciacion() {
		return this.activarvalorGastoDepreciacion;
	}

	public void setActivarvalorGastoDepreciacion(Boolean activarvalorGastoDepreciacion) {
		this.activarvalorGastoDepreciacion= activarvalorGastoDepreciacion;
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
		
		
		this.setMostraridGastoDepreciacion(esInicial);
		this.setMostrarid_empresaGastoDepreciacion(esInicial);
		this.setMostrarid_detalle_grupo_activo_fijoGastoDepreciacion(esInicial);
		this.setMostraranioGastoDepreciacion(esInicial);
		this.setMostrarvalorGastoDepreciacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.ID)) {
				this.setMostraridGastoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaGastoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setMostrarid_detalle_grupo_activo_fijoGastoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.ANIO)) {
				this.setMostraranioGastoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.VALOR)) {
				this.setMostrarvalorGastoDepreciacion(esAsigna);
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
		
		
		this.setActivaridGastoDepreciacion(esInicial);
		this.setActivarid_empresaGastoDepreciacion(esInicial);
		this.setActivarid_detalle_grupo_activo_fijoGastoDepreciacion(esInicial);
		this.setActivaranioGastoDepreciacion(esInicial);
		this.setActivarvalorGastoDepreciacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.ID)) {
				this.setActivaridGastoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaGastoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setActivarid_detalle_grupo_activo_fijoGastoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.ANIO)) {
				this.setActivaranioGastoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.VALOR)) {
				this.setActivarvalorGastoDepreciacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,GastoDepreciacionBeanSwingJInternalFrame gastodepreciacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridGastoDepreciacion(esInicial);
		this.setResaltarid_empresaGastoDepreciacion(esInicial);
		this.setResaltarid_detalle_grupo_activo_fijoGastoDepreciacion(esInicial);
		this.setResaltaranioGastoDepreciacion(esInicial);
		this.setResaltarvalorGastoDepreciacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.ID)) {
				this.setResaltaridGastoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaGastoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setResaltarid_detalle_grupo_activo_fijoGastoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.ANIO)) {
				this.setResaltaranioGastoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionConstantesFunciones.VALOR)) {
				this.setResaltarvalorGastoDepreciacion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCuentaContaGastoDepreGastoDepreciacion=null;

	public Border getResaltarCuentaContaGastoDepreGastoDepreciacion() {
		return this.resaltarCuentaContaGastoDepreGastoDepreciacion;
	}

	public void setResaltarCuentaContaGastoDepreGastoDepreciacion(Border borderResaltarCuentaContaGastoDepre) {
		if(borderResaltarCuentaContaGastoDepre!=null) {
			this.resaltarCuentaContaGastoDepreGastoDepreciacion= borderResaltarCuentaContaGastoDepre;
		}
	}

	public Border setResaltarCuentaContaGastoDepreGastoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionBeanSwingJInternalFrame gastodepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltarCuentaContaGastoDepre=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//gastodepreciacionBeanSwingJInternalFrame.jTtoolBarGastoDepreciacion.setBorder(borderResaltarCuentaContaGastoDepre);
			
		this.resaltarCuentaContaGastoDepreGastoDepreciacion= borderResaltarCuentaContaGastoDepre;

		 return borderResaltarCuentaContaGastoDepre;
	}



	public Boolean mostrarCuentaContaGastoDepreGastoDepreciacion=true;

	public Boolean getMostrarCuentaContaGastoDepreGastoDepreciacion() {
		return this.mostrarCuentaContaGastoDepreGastoDepreciacion;
	}

	public void setMostrarCuentaContaGastoDepreGastoDepreciacion(Boolean visibilidadResaltarCuentaContaGastoDepre) {
		this.mostrarCuentaContaGastoDepreGastoDepreciacion= visibilidadResaltarCuentaContaGastoDepre;
	}



	public Boolean activarCuentaContaGastoDepreGastoDepreciacion=true;

	public Boolean gethabilitarResaltarCuentaContaGastoDepreGastoDepreciacion() {
		return this.activarCuentaContaGastoDepreGastoDepreciacion;
	}

	public void setActivarCuentaContaGastoDepreGastoDepreciacion(Boolean habilitarResaltarCuentaContaGastoDepre) {
		this.activarCuentaContaGastoDepreGastoDepreciacion= habilitarResaltarCuentaContaGastoDepre;
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

		this.setMostrarCuentaContaGastoDepreGastoDepreciacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContaGastoDepre.class)) {
				this.setMostrarCuentaContaGastoDepreGastoDepreciacion(esAsigna);
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

		this.setActivarCuentaContaGastoDepreGastoDepreciacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContaGastoDepre.class)) {
				this.setActivarCuentaContaGastoDepreGastoDepreciacion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,GastoDepreciacionBeanSwingJInternalFrame gastodepreciacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCuentaContaGastoDepreGastoDepreciacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CuentaContaGastoDepre.class)) {
				this.setResaltarCuentaContaGastoDepreGastoDepreciacion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdDetalleGrupoActivoFijoGastoDepreciacion=true;

	public Boolean getMostrarFK_IdDetalleGrupoActivoFijoGastoDepreciacion() {
		return this.mostrarFK_IdDetalleGrupoActivoFijoGastoDepreciacion;
	}

	public void setMostrarFK_IdDetalleGrupoActivoFijoGastoDepreciacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleGrupoActivoFijoGastoDepreciacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaGastoDepreciacion=true;

	public Boolean getMostrarFK_IdEmpresaGastoDepreciacion() {
		return this.mostrarFK_IdEmpresaGastoDepreciacion;
	}

	public void setMostrarFK_IdEmpresaGastoDepreciacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaGastoDepreciacion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdDetalleGrupoActivoFijoGastoDepreciacion=true;

	public Boolean getActivarFK_IdDetalleGrupoActivoFijoGastoDepreciacion() {
		return this.activarFK_IdDetalleGrupoActivoFijoGastoDepreciacion;
	}

	public void setActivarFK_IdDetalleGrupoActivoFijoGastoDepreciacion(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleGrupoActivoFijoGastoDepreciacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaGastoDepreciacion=true;

	public Boolean getActivarFK_IdEmpresaGastoDepreciacion() {
		return this.activarFK_IdEmpresaGastoDepreciacion;
	}

	public void setActivarFK_IdEmpresaGastoDepreciacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaGastoDepreciacion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdDetalleGrupoActivoFijoGastoDepreciacion=null;

	public Border getResaltarFK_IdDetalleGrupoActivoFijoGastoDepreciacion() {
		return this.resaltarFK_IdDetalleGrupoActivoFijoGastoDepreciacion;
	}

	public void setResaltarFK_IdDetalleGrupoActivoFijoGastoDepreciacion(Border borderResaltar) {
		this.resaltarFK_IdDetalleGrupoActivoFijoGastoDepreciacion= borderResaltar;
	}

	public void setResaltarFK_IdDetalleGrupoActivoFijoGastoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionBeanSwingJInternalFrame gastodepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleGrupoActivoFijoGastoDepreciacion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaGastoDepreciacion=null;

	public Border getResaltarFK_IdEmpresaGastoDepreciacion() {
		return this.resaltarFK_IdEmpresaGastoDepreciacion;
	}

	public void setResaltarFK_IdEmpresaGastoDepreciacion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaGastoDepreciacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaGastoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionBeanSwingJInternalFrame gastodepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaGastoDepreciacion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}