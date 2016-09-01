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


import com.bydan.erp.nomina.util.TipoPago_NMConstantesFunciones;
import com.bydan.erp.nomina.util.TipoPago_NMParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoPago_NMParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoPago_NMConstantesFunciones extends TipoPago_NMConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoPago_NM";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoPago_NM"+TipoPago_NMConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoPago_NMHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoPago_NMHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoPago_NMConstantesFunciones.SCHEMA+"_"+TipoPago_NMConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoPago_NMHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoPago_NMConstantesFunciones.SCHEMA+"_"+TipoPago_NMConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoPago_NMConstantesFunciones.SCHEMA+"_"+TipoPago_NMConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoPago_NMHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoPago_NMConstantesFunciones.SCHEMA+"_"+TipoPago_NMConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPago_NMConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPago_NMHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPago_NMConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPago_NMConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPago_NMHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPago_NMConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoPago_NMConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoPago_NMConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoPago_NMConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoPago_NMConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Pago_ N Mes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Pago_ N M";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Pago_ N M";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoPago_NM";
	public static final String OBJECTNAME="tipopago_nm";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_pago__n_m";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipopago_nm from "+TipoPago_NMConstantesFunciones.SPERSISTENCENAME+" tipopago_nm";
	public static String QUERYSELECTNATIVE="select "+TipoPago_NMConstantesFunciones.SCHEMA+"."+TipoPago_NMConstantesFunciones.TABLENAME+".id,"+TipoPago_NMConstantesFunciones.SCHEMA+"."+TipoPago_NMConstantesFunciones.TABLENAME+".version_row,"+TipoPago_NMConstantesFunciones.SCHEMA+"."+TipoPago_NMConstantesFunciones.TABLENAME+".id_empresa,"+TipoPago_NMConstantesFunciones.SCHEMA+"."+TipoPago_NMConstantesFunciones.TABLENAME+".codigo,"+TipoPago_NMConstantesFunciones.SCHEMA+"."+TipoPago_NMConstantesFunciones.TABLENAME+".nombre from "+TipoPago_NMConstantesFunciones.SCHEMA+"."+TipoPago_NMConstantesFunciones.TABLENAME;//+" as "+TipoPago_NMConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoPago_NMConstantesFuncionesAdditional tipopago_nmConstantesFuncionesAdditional=null;
	
	public TipoPago_NMConstantesFuncionesAdditional getTipoPago_NMConstantesFuncionesAdditional() {
		return this.tipopago_nmConstantesFuncionesAdditional;
	}
	
	public void setTipoPago_NMConstantesFuncionesAdditional(TipoPago_NMConstantesFuncionesAdditional tipopago_nmConstantesFuncionesAdditional) {
		try {
			this.tipopago_nmConstantesFuncionesAdditional=tipopago_nmConstantesFuncionesAdditional;
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
	
	public static String getTipoPago_NMLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoPago_NMConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoPago_NMConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoPago_NMConstantesFunciones.CODIGO)) {sLabelColumna=TipoPago_NMConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoPago_NMConstantesFunciones.NOMBRE)) {sLabelColumna=TipoPago_NMConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoPago_NMDescripcion(TipoPago_NM tipopago_nm) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipopago_nm !=null/* && tipopago_nm.getId()!=0*/) {
			sDescripcion=tipopago_nm.getcodigo();//tipopago_nmtipopago_nm.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoPago_NMDescripcionDetallado(TipoPago_NM tipopago_nm) {
		String sDescripcion="";
			
		sDescripcion+=TipoPago_NMConstantesFunciones.ID+"=";
		sDescripcion+=tipopago_nm.getId().toString()+",";
		sDescripcion+=TipoPago_NMConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipopago_nm.getVersionRow().toString()+",";
		sDescripcion+=TipoPago_NMConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipopago_nm.getid_empresa().toString()+",";
		sDescripcion+=TipoPago_NMConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipopago_nm.getcodigo()+",";
		sDescripcion+=TipoPago_NMConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipopago_nm.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoPago_NMDescripcion(TipoPago_NM tipopago_nm,String sValor) throws Exception {			
		if(tipopago_nm !=null) {
			tipopago_nm.setcodigo(sValor);;//tipopago_nmtipopago_nm.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoPago_NM(TipoPago_NM tipopago_nm,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipopago_nm.setcodigo(tipopago_nm.getcodigo().trim());
		tipopago_nm.setnombre(tipopago_nm.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoPago_NMs(List<TipoPago_NM> tipopago_nms,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoPago_NM tipopago_nm: tipopago_nms) {
			tipopago_nm.setcodigo(tipopago_nm.getcodigo().trim());
			tipopago_nm.setnombre(tipopago_nm.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPago_NM(TipoPago_NM tipopago_nm,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipopago_nm.getConCambioAuxiliar()) {
			tipopago_nm.setIsDeleted(tipopago_nm.getIsDeletedAuxiliar());	
			tipopago_nm.setIsNew(tipopago_nm.getIsNewAuxiliar());	
			tipopago_nm.setIsChanged(tipopago_nm.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipopago_nm.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipopago_nm.setIsDeletedAuxiliar(false);	
			tipopago_nm.setIsNewAuxiliar(false);	
			tipopago_nm.setIsChangedAuxiliar(false);
			
			tipopago_nm.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPago_NMs(List<TipoPago_NM> tipopago_nms,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoPago_NM tipopago_nm : tipopago_nms) {
			if(conAsignarBase && tipopago_nm.getConCambioAuxiliar()) {
				tipopago_nm.setIsDeleted(tipopago_nm.getIsDeletedAuxiliar());	
				tipopago_nm.setIsNew(tipopago_nm.getIsNewAuxiliar());	
				tipopago_nm.setIsChanged(tipopago_nm.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipopago_nm.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipopago_nm.setIsDeletedAuxiliar(false);	
				tipopago_nm.setIsNewAuxiliar(false);	
				tipopago_nm.setIsChangedAuxiliar(false);
				
				tipopago_nm.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoPago_NM(TipoPago_NM tipopago_nm,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoPago_NMs(List<TipoPago_NM> tipopago_nms,Boolean conEnteros) throws Exception  {
		
		for(TipoPago_NM tipopago_nm: tipopago_nms) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoPago_NM(List<TipoPago_NM> tipopago_nms,TipoPago_NM tipopago_nmAux) throws Exception  {
		TipoPago_NMConstantesFunciones.InicializarValoresTipoPago_NM(tipopago_nmAux,true);
		
		for(TipoPago_NM tipopago_nm: tipopago_nms) {
			if(tipopago_nm.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPago_NM(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoPago_NMConstantesFunciones.getArrayColumnasGlobalesTipoPago_NM(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPago_NM(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoPago_NMConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoPago_NMConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoPago_NM(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoPago_NM> tipopago_nms,TipoPago_NM tipopago_nm,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoPago_NM tipopago_nmAux: tipopago_nms) {
			if(tipopago_nmAux!=null && tipopago_nm!=null) {
				if((tipopago_nmAux.getId()==null && tipopago_nm.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipopago_nmAux.getId()!=null && tipopago_nm.getId()!=null){
					if(tipopago_nmAux.getId().equals(tipopago_nm.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoPago_NM(List<TipoPago_NM> tipopago_nms) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoPago_NM tipopago_nm: tipopago_nms) {			
			if(tipopago_nm.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoPago_NM() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoPago_NMConstantesFunciones.LABEL_ID, TipoPago_NMConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPago_NMConstantesFunciones.LABEL_VERSIONROW, TipoPago_NMConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPago_NMConstantesFunciones.LABEL_IDEMPRESA, TipoPago_NMConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPago_NMConstantesFunciones.LABEL_CODIGO, TipoPago_NMConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPago_NMConstantesFunciones.LABEL_NOMBRE, TipoPago_NMConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoPago_NM() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoPago_NMConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPago_NMConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPago_NMConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPago_NMConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPago_NMConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPago_NM() throws Exception  {
		return TipoPago_NMConstantesFunciones.getTiposSeleccionarTipoPago_NM(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPago_NM(Boolean conFk) throws Exception  {
		return TipoPago_NMConstantesFunciones.getTiposSeleccionarTipoPago_NM(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPago_NM(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPago_NMConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoPago_NMConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPago_NMConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoPago_NMConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPago_NMConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoPago_NMConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoPago_NM(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPago_NM(TipoPago_NM tipopago_nmAux) throws Exception {
		
			tipopago_nmAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipopago_nmAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPago_NM(List<TipoPago_NM> tipopago_nmsTemp) throws Exception {
		for(TipoPago_NM tipopago_nmAux:tipopago_nmsTemp) {
			
			tipopago_nmAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipopago_nmAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPago_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoPago_NM(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPago_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPago_NMConstantesFunciones.getClassesRelationshipsOfTipoPago_NM(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPago_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Cargo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cargo.class)) {
						classes.add(new Classe(Cargo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPago_NM(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPago_NMConstantesFunciones.getClassesRelationshipsFromStringsOfTipoPago_NM(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPago_NM(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
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
	public static void actualizarLista(TipoPago_NM tipopago_nm,List<TipoPago_NM> tipopago_nms,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoPago_NM tipopago_nmEncontrado=null;
			
			for(TipoPago_NM tipopago_nmLocal:tipopago_nms) {
				if(tipopago_nmLocal.getId().equals(tipopago_nm.getId())) {
					tipopago_nmEncontrado=tipopago_nmLocal;
					
					tipopago_nmLocal.setIsChanged(tipopago_nm.getIsChanged());
					tipopago_nmLocal.setIsNew(tipopago_nm.getIsNew());
					tipopago_nmLocal.setIsDeleted(tipopago_nm.getIsDeleted());
					
					tipopago_nmLocal.setGeneralEntityOriginal(tipopago_nm.getGeneralEntityOriginal());
					
					tipopago_nmLocal.setId(tipopago_nm.getId());	
					tipopago_nmLocal.setVersionRow(tipopago_nm.getVersionRow());	
					tipopago_nmLocal.setid_empresa(tipopago_nm.getid_empresa());	
					tipopago_nmLocal.setcodigo(tipopago_nm.getcodigo());	
					tipopago_nmLocal.setnombre(tipopago_nm.getnombre());	
					
					
					tipopago_nmLocal.setEstructuras(tipopago_nm.getEstructuras());
					tipopago_nmLocal.setCargos(tipopago_nm.getCargos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipopago_nm.getIsDeleted()) {
				if(!existe) {
					tipopago_nms.add(tipopago_nm);
				}
			} else {
				if(tipopago_nmEncontrado!=null && permiteQuitar)  {
					tipopago_nms.remove(tipopago_nmEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoPago_NM tipopago_nm,List<TipoPago_NM> tipopago_nms) throws Exception {
		try	{			
			for(TipoPago_NM tipopago_nmLocal:tipopago_nms) {
				if(tipopago_nmLocal.getId().equals(tipopago_nm.getId())) {
					tipopago_nmLocal.setIsSelected(tipopago_nm.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoPago_NM(List<TipoPago_NM> tipopago_nmsAux) throws Exception {
		//this.tipopago_nmsAux=tipopago_nmsAux;
		
		for(TipoPago_NM tipopago_nmAux:tipopago_nmsAux) {
			if(tipopago_nmAux.getIsChanged()) {
				tipopago_nmAux.setIsChanged(false);
			}		
			
			if(tipopago_nmAux.getIsNew()) {
				tipopago_nmAux.setIsNew(false);
			}	
			
			if(tipopago_nmAux.getIsDeleted()) {
				tipopago_nmAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoPago_NM(TipoPago_NM tipopago_nmAux) throws Exception {
		//this.tipopago_nmAux=tipopago_nmAux;
		
			if(tipopago_nmAux.getIsChanged()) {
				tipopago_nmAux.setIsChanged(false);
			}		
			
			if(tipopago_nmAux.getIsNew()) {
				tipopago_nmAux.setIsNew(false);
			}	
			
			if(tipopago_nmAux.getIsDeleted()) {
				tipopago_nmAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoPago_NM tipopago_nmAsignar,TipoPago_NM tipopago_nm) throws Exception {
		tipopago_nmAsignar.setId(tipopago_nm.getId());	
		tipopago_nmAsignar.setVersionRow(tipopago_nm.getVersionRow());	
		tipopago_nmAsignar.setid_empresa(tipopago_nm.getid_empresa());
		tipopago_nmAsignar.setempresa_descripcion(tipopago_nm.getempresa_descripcion());	
		tipopago_nmAsignar.setcodigo(tipopago_nm.getcodigo());	
		tipopago_nmAsignar.setnombre(tipopago_nm.getnombre());	
	}
	
	public static void inicializarTipoPago_NM(TipoPago_NM tipopago_nm) throws Exception {
		try {
				tipopago_nm.setId(0L);	
					
				tipopago_nm.setid_empresa(-1L);	
				tipopago_nm.setcodigo("");	
				tipopago_nm.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoPago_NM(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPago_NMConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPago_NMConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPago_NMConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoPago_NM(String sTipo,Row row,Workbook workbook,TipoPago_NM tipopago_nm,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipopago_nm.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipopago_nm.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipopago_nm.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoPago_NM=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoPago_NM() {
		return this.sFinalQueryTipoPago_NM;
	}
	
	public void setsFinalQueryTipoPago_NM(String sFinalQueryTipoPago_NM) {
		this.sFinalQueryTipoPago_NM= sFinalQueryTipoPago_NM;
	}
	
	public Border resaltarSeleccionarTipoPago_NM=null;
	
	public Border setResaltarSeleccionarTipoPago_NM(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPago_NMBeanSwingJInternalFrame tipopago_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipopago_nmBeanSwingJInternalFrame.jTtoolBarTipoPago_NM.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoPago_NM= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoPago_NM() {
		return this.resaltarSeleccionarTipoPago_NM;
	}
	
	public void setResaltarSeleccionarTipoPago_NM(Border borderResaltarSeleccionarTipoPago_NM) {
		this.resaltarSeleccionarTipoPago_NM= borderResaltarSeleccionarTipoPago_NM;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoPago_NM=null;
	public Boolean mostraridTipoPago_NM=true;
	public Boolean activaridTipoPago_NM=true;

	public Border resaltarid_empresaTipoPago_NM=null;
	public Boolean mostrarid_empresaTipoPago_NM=true;
	public Boolean activarid_empresaTipoPago_NM=true;
	public Boolean cargarid_empresaTipoPago_NM=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoPago_NM=false;//ConEventDepend=true

	public Border resaltarcodigoTipoPago_NM=null;
	public Boolean mostrarcodigoTipoPago_NM=true;
	public Boolean activarcodigoTipoPago_NM=true;

	public Border resaltarnombreTipoPago_NM=null;
	public Boolean mostrarnombreTipoPago_NM=true;
	public Boolean activarnombreTipoPago_NM=true;

	
	

	public Border setResaltaridTipoPago_NM(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPago_NMBeanSwingJInternalFrame tipopago_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopago_nmBeanSwingJInternalFrame.jTtoolBarTipoPago_NM.setBorder(borderResaltar);
		
		this.resaltaridTipoPago_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoPago_NM() {
		return this.resaltaridTipoPago_NM;
	}

	public void setResaltaridTipoPago_NM(Border borderResaltar) {
		this.resaltaridTipoPago_NM= borderResaltar;
	}

	public Boolean getMostraridTipoPago_NM() {
		return this.mostraridTipoPago_NM;
	}

	public void setMostraridTipoPago_NM(Boolean mostraridTipoPago_NM) {
		this.mostraridTipoPago_NM= mostraridTipoPago_NM;
	}

	public Boolean getActivaridTipoPago_NM() {
		return this.activaridTipoPago_NM;
	}

	public void setActivaridTipoPago_NM(Boolean activaridTipoPago_NM) {
		this.activaridTipoPago_NM= activaridTipoPago_NM;
	}

	public Border setResaltarid_empresaTipoPago_NM(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPago_NMBeanSwingJInternalFrame tipopago_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopago_nmBeanSwingJInternalFrame.jTtoolBarTipoPago_NM.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoPago_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoPago_NM() {
		return this.resaltarid_empresaTipoPago_NM;
	}

	public void setResaltarid_empresaTipoPago_NM(Border borderResaltar) {
		this.resaltarid_empresaTipoPago_NM= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoPago_NM() {
		return this.mostrarid_empresaTipoPago_NM;
	}

	public void setMostrarid_empresaTipoPago_NM(Boolean mostrarid_empresaTipoPago_NM) {
		this.mostrarid_empresaTipoPago_NM= mostrarid_empresaTipoPago_NM;
	}

	public Boolean getActivarid_empresaTipoPago_NM() {
		return this.activarid_empresaTipoPago_NM;
	}

	public void setActivarid_empresaTipoPago_NM(Boolean activarid_empresaTipoPago_NM) {
		this.activarid_empresaTipoPago_NM= activarid_empresaTipoPago_NM;
	}

	public Boolean getCargarid_empresaTipoPago_NM() {
		return this.cargarid_empresaTipoPago_NM;
	}

	public void setCargarid_empresaTipoPago_NM(Boolean cargarid_empresaTipoPago_NM) {
		this.cargarid_empresaTipoPago_NM= cargarid_empresaTipoPago_NM;
	}

	public Border setResaltarcodigoTipoPago_NM(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPago_NMBeanSwingJInternalFrame tipopago_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopago_nmBeanSwingJInternalFrame.jTtoolBarTipoPago_NM.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoPago_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoPago_NM() {
		return this.resaltarcodigoTipoPago_NM;
	}

	public void setResaltarcodigoTipoPago_NM(Border borderResaltar) {
		this.resaltarcodigoTipoPago_NM= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoPago_NM() {
		return this.mostrarcodigoTipoPago_NM;
	}

	public void setMostrarcodigoTipoPago_NM(Boolean mostrarcodigoTipoPago_NM) {
		this.mostrarcodigoTipoPago_NM= mostrarcodigoTipoPago_NM;
	}

	public Boolean getActivarcodigoTipoPago_NM() {
		return this.activarcodigoTipoPago_NM;
	}

	public void setActivarcodigoTipoPago_NM(Boolean activarcodigoTipoPago_NM) {
		this.activarcodigoTipoPago_NM= activarcodigoTipoPago_NM;
	}

	public Border setResaltarnombreTipoPago_NM(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPago_NMBeanSwingJInternalFrame tipopago_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipopago_nmBeanSwingJInternalFrame.jTtoolBarTipoPago_NM.setBorder(borderResaltar);
		
		this.resaltarnombreTipoPago_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoPago_NM() {
		return this.resaltarnombreTipoPago_NM;
	}

	public void setResaltarnombreTipoPago_NM(Border borderResaltar) {
		this.resaltarnombreTipoPago_NM= borderResaltar;
	}

	public Boolean getMostrarnombreTipoPago_NM() {
		return this.mostrarnombreTipoPago_NM;
	}

	public void setMostrarnombreTipoPago_NM(Boolean mostrarnombreTipoPago_NM) {
		this.mostrarnombreTipoPago_NM= mostrarnombreTipoPago_NM;
	}

	public Boolean getActivarnombreTipoPago_NM() {
		return this.activarnombreTipoPago_NM;
	}

	public void setActivarnombreTipoPago_NM(Boolean activarnombreTipoPago_NM) {
		this.activarnombreTipoPago_NM= activarnombreTipoPago_NM;
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
		
		
		this.setMostraridTipoPago_NM(esInicial);
		this.setMostrarid_empresaTipoPago_NM(esInicial);
		this.setMostrarcodigoTipoPago_NM(esInicial);
		this.setMostrarnombreTipoPago_NM(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPago_NMConstantesFunciones.ID)) {
				this.setMostraridTipoPago_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPago_NMConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoPago_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPago_NMConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoPago_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPago_NMConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoPago_NM(esAsigna);
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
		
		
		this.setActivaridTipoPago_NM(esInicial);
		this.setActivarid_empresaTipoPago_NM(esInicial);
		this.setActivarcodigoTipoPago_NM(esInicial);
		this.setActivarnombreTipoPago_NM(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPago_NMConstantesFunciones.ID)) {
				this.setActivaridTipoPago_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPago_NMConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoPago_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPago_NMConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoPago_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPago_NMConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoPago_NM(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPago_NMBeanSwingJInternalFrame tipopago_nmBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoPago_NM(esInicial);
		this.setResaltarid_empresaTipoPago_NM(esInicial);
		this.setResaltarcodigoTipoPago_NM(esInicial);
		this.setResaltarnombreTipoPago_NM(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPago_NMConstantesFunciones.ID)) {
				this.setResaltaridTipoPago_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPago_NMConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoPago_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPago_NMConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoPago_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPago_NMConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoPago_NM(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarEstructuraTipoPago_NM=null;

	public Border getResaltarEstructuraTipoPago_NM() {
		return this.resaltarEstructuraTipoPago_NM;
	}

	public void setResaltarEstructuraTipoPago_NM(Border borderResaltarEstructura) {
		if(borderResaltarEstructura!=null) {
			this.resaltarEstructuraTipoPago_NM= borderResaltarEstructura;
		}
	}

	public Border setResaltarEstructuraTipoPago_NM(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPago_NMBeanSwingJInternalFrame tipopago_nmBeanSwingJInternalFrame*/) {
		Border borderResaltarEstructura=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipopago_nmBeanSwingJInternalFrame.jTtoolBarTipoPago_NM.setBorder(borderResaltarEstructura);
			
		this.resaltarEstructuraTipoPago_NM= borderResaltarEstructura;

		 return borderResaltarEstructura;
	}



	public Boolean mostrarEstructuraTipoPago_NM=true;

	public Boolean getMostrarEstructuraTipoPago_NM() {
		return this.mostrarEstructuraTipoPago_NM;
	}

	public void setMostrarEstructuraTipoPago_NM(Boolean visibilidadResaltarEstructura) {
		this.mostrarEstructuraTipoPago_NM= visibilidadResaltarEstructura;
	}



	public Boolean activarEstructuraTipoPago_NM=true;

	public Boolean gethabilitarResaltarEstructuraTipoPago_NM() {
		return this.activarEstructuraTipoPago_NM;
	}

	public void setActivarEstructuraTipoPago_NM(Boolean habilitarResaltarEstructura) {
		this.activarEstructuraTipoPago_NM= habilitarResaltarEstructura;
	}


	public Border resaltarCargoTipoPago_NM=null;

	public Border getResaltarCargoTipoPago_NM() {
		return this.resaltarCargoTipoPago_NM;
	}

	public void setResaltarCargoTipoPago_NM(Border borderResaltarCargo) {
		if(borderResaltarCargo!=null) {
			this.resaltarCargoTipoPago_NM= borderResaltarCargo;
		}
	}

	public Border setResaltarCargoTipoPago_NM(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPago_NMBeanSwingJInternalFrame tipopago_nmBeanSwingJInternalFrame*/) {
		Border borderResaltarCargo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipopago_nmBeanSwingJInternalFrame.jTtoolBarTipoPago_NM.setBorder(borderResaltarCargo);
			
		this.resaltarCargoTipoPago_NM= borderResaltarCargo;

		 return borderResaltarCargo;
	}



	public Boolean mostrarCargoTipoPago_NM=true;

	public Boolean getMostrarCargoTipoPago_NM() {
		return this.mostrarCargoTipoPago_NM;
	}

	public void setMostrarCargoTipoPago_NM(Boolean visibilidadResaltarCargo) {
		this.mostrarCargoTipoPago_NM= visibilidadResaltarCargo;
	}



	public Boolean activarCargoTipoPago_NM=true;

	public Boolean gethabilitarResaltarCargoTipoPago_NM() {
		return this.activarCargoTipoPago_NM;
	}

	public void setActivarCargoTipoPago_NM(Boolean habilitarResaltarCargo) {
		this.activarCargoTipoPago_NM= habilitarResaltarCargo;
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

		this.setMostrarEstructuraTipoPago_NM(esInicial);
		this.setMostrarCargoTipoPago_NM(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Estructura.class)) {
				this.setMostrarEstructuraTipoPago_NM(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cargo.class)) {
				this.setMostrarCargoTipoPago_NM(esAsigna);
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

		this.setActivarEstructuraTipoPago_NM(esInicial);
		this.setActivarCargoTipoPago_NM(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Estructura.class)) {
				this.setActivarEstructuraTipoPago_NM(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cargo.class)) {
				this.setActivarCargoTipoPago_NM(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPago_NMBeanSwingJInternalFrame tipopago_nmBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarEstructuraTipoPago_NM(esInicial);
		this.setResaltarCargoTipoPago_NM(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Estructura.class)) {
				this.setResaltarEstructuraTipoPago_NM(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cargo.class)) {
				this.setResaltarCargoTipoPago_NM(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoPago_NM=true;

	public Boolean getMostrarFK_IdEmpresaTipoPago_NM() {
		return this.mostrarFK_IdEmpresaTipoPago_NM;
	}

	public void setMostrarFK_IdEmpresaTipoPago_NM(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoPago_NM= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoPago_NM=true;

	public Boolean getActivarFK_IdEmpresaTipoPago_NM() {
		return this.activarFK_IdEmpresaTipoPago_NM;
	}

	public void setActivarFK_IdEmpresaTipoPago_NM(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoPago_NM= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoPago_NM=null;

	public Border getResaltarFK_IdEmpresaTipoPago_NM() {
		return this.resaltarFK_IdEmpresaTipoPago_NM;
	}

	public void setResaltarFK_IdEmpresaTipoPago_NM(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoPago_NM= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoPago_NM(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPago_NMBeanSwingJInternalFrame tipopago_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoPago_NM= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}