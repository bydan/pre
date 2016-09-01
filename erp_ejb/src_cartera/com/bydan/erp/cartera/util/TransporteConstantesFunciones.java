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


import com.bydan.erp.cartera.util.TransporteConstantesFunciones;
import com.bydan.erp.cartera.util.TransporteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TransporteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TransporteConstantesFunciones extends TransporteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Transporte";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Transporte"+TransporteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TransporteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TransporteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TransporteConstantesFunciones.SCHEMA+"_"+TransporteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TransporteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TransporteConstantesFunciones.SCHEMA+"_"+TransporteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TransporteConstantesFunciones.SCHEMA+"_"+TransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TransporteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TransporteConstantesFunciones.SCHEMA+"_"+TransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransporteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransporteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransporteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransporteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TransporteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TransporteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TransporteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TransporteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Transportes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Transporte";
	public static final String SCLASSWEBTITULO_LOWER="Transporte";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Transporte";
	public static final String OBJECTNAME="transporte";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="transporte";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select transporte from "+TransporteConstantesFunciones.SPERSISTENCENAME+" transporte";
	public static String QUERYSELECTNATIVE="select "+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".id,"+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".version_row,"+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".id_empresa,"+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".id_tipo_via_transporte,"+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".codigo,"+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".nombre from "+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME;//+" as "+TransporteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TransporteConstantesFuncionesAdditional transporteConstantesFuncionesAdditional=null;
	
	public TransporteConstantesFuncionesAdditional getTransporteConstantesFuncionesAdditional() {
		return this.transporteConstantesFuncionesAdditional;
	}
	
	public void setTransporteConstantesFuncionesAdditional(TransporteConstantesFuncionesAdditional transporteConstantesFuncionesAdditional) {
		try {
			this.transporteConstantesFuncionesAdditional=transporteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOVIATRANSPORTE= "id_tipo_via_transporte";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOVIATRANSPORTE= "Tipo Via Transporte";
		public static final String LABEL_IDTIPOVIATRANSPORTE_LOWER= "Tipo Via Transporte";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTransporteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TransporteConstantesFunciones.IDEMPRESA)) {sLabelColumna=TransporteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TransporteConstantesFunciones.IDTIPOVIATRANSPORTE)) {sLabelColumna=TransporteConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE;}
		if(sNombreColumna.equals(TransporteConstantesFunciones.CODIGO)) {sLabelColumna=TransporteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TransporteConstantesFunciones.NOMBRE)) {sLabelColumna=TransporteConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getTransporteDescripcion(Transporte transporte) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(transporte !=null/* && transporte.getId()!=0*/) {
			sDescripcion=transporte.getcodigo();//transportetransporte.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTransporteDescripcionDetallado(Transporte transporte) {
		String sDescripcion="";
			
		sDescripcion+=TransporteConstantesFunciones.ID+"=";
		sDescripcion+=transporte.getId().toString()+",";
		sDescripcion+=TransporteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=transporte.getVersionRow().toString()+",";
		sDescripcion+=TransporteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=transporte.getid_empresa().toString()+",";
		sDescripcion+=TransporteConstantesFunciones.IDTIPOVIATRANSPORTE+"=";
		sDescripcion+=transporte.getid_tipo_via_transporte().toString()+",";
		sDescripcion+=TransporteConstantesFunciones.CODIGO+"=";
		sDescripcion+=transporte.getcodigo()+",";
		sDescripcion+=TransporteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=transporte.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTransporteDescripcion(Transporte transporte,String sValor) throws Exception {			
		if(transporte !=null) {
			transporte.setcodigo(sValor);;//transportetransporte.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoViaTransporteDescripcion(TipoViaTransporte tipoviatransporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoviatransporte!=null/*&&tipoviatransporte.getId()>0*/) {
			sDescripcion=TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(tipoviatransporte);
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
		} else if(sNombreIndice.equals("FK_IdTipoViaTransporte")) {
			sNombreIndice="Tipo=  Por Tipo Via Transporte";
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

	public static String getDetalleIndiceFK_IdTipoViaTransporte(Long id_tipo_via_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_via_transporte!=null) {sDetalleIndice+=" Codigo Unico De Tipo Via Transporte="+id_tipo_via_transporte.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTransporte(Transporte transporte,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		transporte.setcodigo(transporte.getcodigo().trim());
		transporte.setnombre(transporte.getnombre().trim());
	}
	
	public static void quitarEspaciosTransportes(List<Transporte> transportes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Transporte transporte: transportes) {
			transporte.setcodigo(transporte.getcodigo().trim());
			transporte.setnombre(transporte.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransporte(Transporte transporte,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && transporte.getConCambioAuxiliar()) {
			transporte.setIsDeleted(transporte.getIsDeletedAuxiliar());	
			transporte.setIsNew(transporte.getIsNewAuxiliar());	
			transporte.setIsChanged(transporte.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			transporte.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			transporte.setIsDeletedAuxiliar(false);	
			transporte.setIsNewAuxiliar(false);	
			transporte.setIsChangedAuxiliar(false);
			
			transporte.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransportes(List<Transporte> transportes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Transporte transporte : transportes) {
			if(conAsignarBase && transporte.getConCambioAuxiliar()) {
				transporte.setIsDeleted(transporte.getIsDeletedAuxiliar());	
				transporte.setIsNew(transporte.getIsNewAuxiliar());	
				transporte.setIsChanged(transporte.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				transporte.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				transporte.setIsDeletedAuxiliar(false);	
				transporte.setIsNewAuxiliar(false);	
				transporte.setIsChangedAuxiliar(false);
				
				transporte.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTransporte(Transporte transporte,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTransportes(List<Transporte> transportes,Boolean conEnteros) throws Exception  {
		
		for(Transporte transporte: transportes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTransporte(List<Transporte> transportes,Transporte transporteAux) throws Exception  {
		TransporteConstantesFunciones.InicializarValoresTransporte(transporteAux,true);
		
		for(Transporte transporte: transportes) {
			if(transporte.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTransporte(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TransporteConstantesFunciones.getArrayColumnasGlobalesTransporte(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTransporte(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransporteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransporteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTransporte(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Transporte> transportes,Transporte transporte,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Transporte transporteAux: transportes) {
			if(transporteAux!=null && transporte!=null) {
				if((transporteAux.getId()==null && transporte.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(transporteAux.getId()!=null && transporte.getId()!=null){
					if(transporteAux.getId().equals(transporte.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTransporte(List<Transporte> transportes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Transporte transporte: transportes) {			
			if(transporte.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTransporte() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TransporteConstantesFunciones.LABEL_ID, TransporteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransporteConstantesFunciones.LABEL_VERSIONROW, TransporteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransporteConstantesFunciones.LABEL_IDEMPRESA, TransporteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransporteConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE, TransporteConstantesFunciones.IDTIPOVIATRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransporteConstantesFunciones.LABEL_CODIGO, TransporteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransporteConstantesFunciones.LABEL_NOMBRE, TransporteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTransporte() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TransporteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransporteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransporteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransporteConstantesFunciones.IDTIPOVIATRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransporteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransporteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransporte() throws Exception  {
		return TransporteConstantesFunciones.getTiposSeleccionarTransporte(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransporte(Boolean conFk) throws Exception  {
		return TransporteConstantesFunciones.getTiposSeleccionarTransporte(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransporte(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransporteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TransporteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransporteConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);
			reporte.setsDescripcion(TransporteConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransporteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TransporteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransporteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TransporteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTransporte(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTransporte(Transporte transporteAux) throws Exception {
		
			transporteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transporteAux.getEmpresa()));
			transporteAux.settipoviatransporte_descripcion(TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(transporteAux.getTipoViaTransporte()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTransporte(List<Transporte> transportesTemp) throws Exception {
		for(Transporte transporteAux:transportesTemp) {
			
			transporteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transporteAux.getEmpresa()));
			transporteAux.settipoviatransporte_descripcion(TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(transporteAux.getTipoViaTransporte()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoViaTransporte.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoViaTransporte.class)) {
						classes.add(new Classe(TipoViaTransporte.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoViaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoViaTransporte.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoViaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoViaTransporte.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransporteConstantesFunciones.getClassesRelationshipsOfTransporte(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransporteConstantesFunciones.getClassesRelationshipsFromStringsOfTransporte(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Transporte transporte,List<Transporte> transportes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Transporte transporteEncontrado=null;
			
			for(Transporte transporteLocal:transportes) {
				if(transporteLocal.getId().equals(transporte.getId())) {
					transporteEncontrado=transporteLocal;
					
					transporteLocal.setIsChanged(transporte.getIsChanged());
					transporteLocal.setIsNew(transporte.getIsNew());
					transporteLocal.setIsDeleted(transporte.getIsDeleted());
					
					transporteLocal.setGeneralEntityOriginal(transporte.getGeneralEntityOriginal());
					
					transporteLocal.setId(transporte.getId());	
					transporteLocal.setVersionRow(transporte.getVersionRow());	
					transporteLocal.setid_empresa(transporte.getid_empresa());	
					transporteLocal.setid_tipo_via_transporte(transporte.getid_tipo_via_transporte());	
					transporteLocal.setcodigo(transporte.getcodigo());	
					transporteLocal.setnombre(transporte.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!transporte.getIsDeleted()) {
				if(!existe) {
					transportes.add(transporte);
				}
			} else {
				if(transporteEncontrado!=null && permiteQuitar)  {
					transportes.remove(transporteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Transporte transporte,List<Transporte> transportes) throws Exception {
		try	{			
			for(Transporte transporteLocal:transportes) {
				if(transporteLocal.getId().equals(transporte.getId())) {
					transporteLocal.setIsSelected(transporte.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTransporte(List<Transporte> transportesAux) throws Exception {
		//this.transportesAux=transportesAux;
		
		for(Transporte transporteAux:transportesAux) {
			if(transporteAux.getIsChanged()) {
				transporteAux.setIsChanged(false);
			}		
			
			if(transporteAux.getIsNew()) {
				transporteAux.setIsNew(false);
			}	
			
			if(transporteAux.getIsDeleted()) {
				transporteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTransporte(Transporte transporteAux) throws Exception {
		//this.transporteAux=transporteAux;
		
			if(transporteAux.getIsChanged()) {
				transporteAux.setIsChanged(false);
			}		
			
			if(transporteAux.getIsNew()) {
				transporteAux.setIsNew(false);
			}	
			
			if(transporteAux.getIsDeleted()) {
				transporteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Transporte transporteAsignar,Transporte transporte) throws Exception {
		transporteAsignar.setId(transporte.getId());	
		transporteAsignar.setVersionRow(transporte.getVersionRow());	
		transporteAsignar.setid_empresa(transporte.getid_empresa());
		transporteAsignar.setempresa_descripcion(transporte.getempresa_descripcion());	
		transporteAsignar.setid_tipo_via_transporte(transporte.getid_tipo_via_transporte());
		transporteAsignar.settipoviatransporte_descripcion(transporte.gettipoviatransporte_descripcion());	
		transporteAsignar.setcodigo(transporte.getcodigo());	
		transporteAsignar.setnombre(transporte.getnombre());	
	}
	
	public static void inicializarTransporte(Transporte transporte) throws Exception {
		try {
				transporte.setId(0L);	
					
				transporte.setid_empresa(-1L);	
				transporte.setid_tipo_via_transporte(-1L);	
				transporte.setcodigo("");	
				transporte.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTransporte(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TransporteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransporteConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransporteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransporteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTransporte(String sTipo,Row row,Workbook workbook,Transporte transporte,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(transporte.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transporte.gettipoviatransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transporte.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transporte.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTransporte=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTransporte() {
		return this.sFinalQueryTransporte;
	}
	
	public void setsFinalQueryTransporte(String sFinalQueryTransporte) {
		this.sFinalQueryTransporte= sFinalQueryTransporte;
	}
	
	public Border resaltarSeleccionarTransporte=null;
	
	public Border setResaltarSeleccionarTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*TransporteBeanSwingJInternalFrame transporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//transporteBeanSwingJInternalFrame.jTtoolBarTransporte.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTransporte= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTransporte() {
		return this.resaltarSeleccionarTransporte;
	}
	
	public void setResaltarSeleccionarTransporte(Border borderResaltarSeleccionarTransporte) {
		this.resaltarSeleccionarTransporte= borderResaltarSeleccionarTransporte;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTransporte=null;
	public Boolean mostraridTransporte=true;
	public Boolean activaridTransporte=true;

	public Border resaltarid_empresaTransporte=null;
	public Boolean mostrarid_empresaTransporte=true;
	public Boolean activarid_empresaTransporte=true;
	public Boolean cargarid_empresaTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTransporte=false;//ConEventDepend=true

	public Border resaltarid_tipo_via_transporteTransporte=null;
	public Boolean mostrarid_tipo_via_transporteTransporte=true;
	public Boolean activarid_tipo_via_transporteTransporte=true;
	public Boolean cargarid_tipo_via_transporteTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_via_transporteTransporte=false;//ConEventDepend=true

	public Border resaltarcodigoTransporte=null;
	public Boolean mostrarcodigoTransporte=true;
	public Boolean activarcodigoTransporte=true;

	public Border resaltarnombreTransporte=null;
	public Boolean mostrarnombreTransporte=true;
	public Boolean activarnombreTransporte=true;

	
	

	public Border setResaltaridTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*TransporteBeanSwingJInternalFrame transporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transporteBeanSwingJInternalFrame.jTtoolBarTransporte.setBorder(borderResaltar);
		
		this.resaltaridTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTransporte() {
		return this.resaltaridTransporte;
	}

	public void setResaltaridTransporte(Border borderResaltar) {
		this.resaltaridTransporte= borderResaltar;
	}

	public Boolean getMostraridTransporte() {
		return this.mostraridTransporte;
	}

	public void setMostraridTransporte(Boolean mostraridTransporte) {
		this.mostraridTransporte= mostraridTransporte;
	}

	public Boolean getActivaridTransporte() {
		return this.activaridTransporte;
	}

	public void setActivaridTransporte(Boolean activaridTransporte) {
		this.activaridTransporte= activaridTransporte;
	}

	public Border setResaltarid_empresaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*TransporteBeanSwingJInternalFrame transporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transporteBeanSwingJInternalFrame.jTtoolBarTransporte.setBorder(borderResaltar);
		
		this.resaltarid_empresaTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTransporte() {
		return this.resaltarid_empresaTransporte;
	}

	public void setResaltarid_empresaTransporte(Border borderResaltar) {
		this.resaltarid_empresaTransporte= borderResaltar;
	}

	public Boolean getMostrarid_empresaTransporte() {
		return this.mostrarid_empresaTransporte;
	}

	public void setMostrarid_empresaTransporte(Boolean mostrarid_empresaTransporte) {
		this.mostrarid_empresaTransporte= mostrarid_empresaTransporte;
	}

	public Boolean getActivarid_empresaTransporte() {
		return this.activarid_empresaTransporte;
	}

	public void setActivarid_empresaTransporte(Boolean activarid_empresaTransporte) {
		this.activarid_empresaTransporte= activarid_empresaTransporte;
	}

	public Boolean getCargarid_empresaTransporte() {
		return this.cargarid_empresaTransporte;
	}

	public void setCargarid_empresaTransporte(Boolean cargarid_empresaTransporte) {
		this.cargarid_empresaTransporte= cargarid_empresaTransporte;
	}

	public Border setResaltarid_tipo_via_transporteTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*TransporteBeanSwingJInternalFrame transporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transporteBeanSwingJInternalFrame.jTtoolBarTransporte.setBorder(borderResaltar);
		
		this.resaltarid_tipo_via_transporteTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_via_transporteTransporte() {
		return this.resaltarid_tipo_via_transporteTransporte;
	}

	public void setResaltarid_tipo_via_transporteTransporte(Border borderResaltar) {
		this.resaltarid_tipo_via_transporteTransporte= borderResaltar;
	}

	public Boolean getMostrarid_tipo_via_transporteTransporte() {
		return this.mostrarid_tipo_via_transporteTransporte;
	}

	public void setMostrarid_tipo_via_transporteTransporte(Boolean mostrarid_tipo_via_transporteTransporte) {
		this.mostrarid_tipo_via_transporteTransporte= mostrarid_tipo_via_transporteTransporte;
	}

	public Boolean getActivarid_tipo_via_transporteTransporte() {
		return this.activarid_tipo_via_transporteTransporte;
	}

	public void setActivarid_tipo_via_transporteTransporte(Boolean activarid_tipo_via_transporteTransporte) {
		this.activarid_tipo_via_transporteTransporte= activarid_tipo_via_transporteTransporte;
	}

	public Boolean getCargarid_tipo_via_transporteTransporte() {
		return this.cargarid_tipo_via_transporteTransporte;
	}

	public void setCargarid_tipo_via_transporteTransporte(Boolean cargarid_tipo_via_transporteTransporte) {
		this.cargarid_tipo_via_transporteTransporte= cargarid_tipo_via_transporteTransporte;
	}

	public Border setResaltarcodigoTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*TransporteBeanSwingJInternalFrame transporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transporteBeanSwingJInternalFrame.jTtoolBarTransporte.setBorder(borderResaltar);
		
		this.resaltarcodigoTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTransporte() {
		return this.resaltarcodigoTransporte;
	}

	public void setResaltarcodigoTransporte(Border borderResaltar) {
		this.resaltarcodigoTransporte= borderResaltar;
	}

	public Boolean getMostrarcodigoTransporte() {
		return this.mostrarcodigoTransporte;
	}

	public void setMostrarcodigoTransporte(Boolean mostrarcodigoTransporte) {
		this.mostrarcodigoTransporte= mostrarcodigoTransporte;
	}

	public Boolean getActivarcodigoTransporte() {
		return this.activarcodigoTransporte;
	}

	public void setActivarcodigoTransporte(Boolean activarcodigoTransporte) {
		this.activarcodigoTransporte= activarcodigoTransporte;
	}

	public Border setResaltarnombreTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*TransporteBeanSwingJInternalFrame transporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transporteBeanSwingJInternalFrame.jTtoolBarTransporte.setBorder(borderResaltar);
		
		this.resaltarnombreTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTransporte() {
		return this.resaltarnombreTransporte;
	}

	public void setResaltarnombreTransporte(Border borderResaltar) {
		this.resaltarnombreTransporte= borderResaltar;
	}

	public Boolean getMostrarnombreTransporte() {
		return this.mostrarnombreTransporte;
	}

	public void setMostrarnombreTransporte(Boolean mostrarnombreTransporte) {
		this.mostrarnombreTransporte= mostrarnombreTransporte;
	}

	public Boolean getActivarnombreTransporte() {
		return this.activarnombreTransporte;
	}

	public void setActivarnombreTransporte(Boolean activarnombreTransporte) {
		this.activarnombreTransporte= activarnombreTransporte;
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
		
		
		this.setMostraridTransporte(esInicial);
		this.setMostrarid_empresaTransporte(esInicial);
		this.setMostrarid_tipo_via_transporteTransporte(esInicial);
		this.setMostrarcodigoTransporte(esInicial);
		this.setMostrarnombreTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransporteConstantesFunciones.ID)) {
				this.setMostraridTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransporteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransporteConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setMostrarid_tipo_via_transporteTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransporteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransporteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTransporte(esAsigna);
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
		
		
		this.setActivaridTransporte(esInicial);
		this.setActivarid_empresaTransporte(esInicial);
		this.setActivarid_tipo_via_transporteTransporte(esInicial);
		this.setActivarcodigoTransporte(esInicial);
		this.setActivarnombreTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransporteConstantesFunciones.ID)) {
				this.setActivaridTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransporteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransporteConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setActivarid_tipo_via_transporteTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransporteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransporteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTransporte(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TransporteBeanSwingJInternalFrame transporteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTransporte(esInicial);
		this.setResaltarid_empresaTransporte(esInicial);
		this.setResaltarid_tipo_via_transporteTransporte(esInicial);
		this.setResaltarcodigoTransporte(esInicial);
		this.setResaltarnombreTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransporteConstantesFunciones.ID)) {
				this.setResaltaridTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransporteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransporteConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setResaltarid_tipo_via_transporteTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransporteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransporteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTransporte(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TransporteBeanSwingJInternalFrame transporteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTransporte=true;

	public Boolean getMostrarBusquedaPorCodigoTransporte() {
		return this.mostrarBusquedaPorCodigoTransporte;
	}

	public void setMostrarBusquedaPorCodigoTransporte(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTransporte= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTransporte=true;

	public Boolean getMostrarBusquedaPorNombreTransporte() {
		return this.mostrarBusquedaPorNombreTransporte;
	}

	public void setMostrarBusquedaPorNombreTransporte(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTransporte=true;

	public Boolean getMostrarFK_IdEmpresaTransporte() {
		return this.mostrarFK_IdEmpresaTransporte;
	}

	public void setMostrarFK_IdEmpresaTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoViaTransporteTransporte=true;

	public Boolean getMostrarFK_IdTipoViaTransporteTransporte() {
		return this.mostrarFK_IdTipoViaTransporteTransporte;
	}

	public void setMostrarFK_IdTipoViaTransporteTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoViaTransporteTransporte= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTransporte=true;

	public Boolean getActivarBusquedaPorCodigoTransporte() {
		return this.activarBusquedaPorCodigoTransporte;
	}

	public void setActivarBusquedaPorCodigoTransporte(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTransporte= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTransporte=true;

	public Boolean getActivarBusquedaPorNombreTransporte() {
		return this.activarBusquedaPorNombreTransporte;
	}

	public void setActivarBusquedaPorNombreTransporte(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTransporte=true;

	public Boolean getActivarFK_IdEmpresaTransporte() {
		return this.activarFK_IdEmpresaTransporte;
	}

	public void setActivarFK_IdEmpresaTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoViaTransporteTransporte=true;

	public Boolean getActivarFK_IdTipoViaTransporteTransporte() {
		return this.activarFK_IdTipoViaTransporteTransporte;
	}

	public void setActivarFK_IdTipoViaTransporteTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdTipoViaTransporteTransporte= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTransporte=null;

	public Border getResaltarBusquedaPorCodigoTransporte() {
		return this.resaltarBusquedaPorCodigoTransporte;
	}

	public void setResaltarBusquedaPorCodigoTransporte(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTransporte= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*TransporteBeanSwingJInternalFrame transporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTransporte= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTransporte=null;

	public Border getResaltarBusquedaPorNombreTransporte() {
		return this.resaltarBusquedaPorNombreTransporte;
	}

	public void setResaltarBusquedaPorNombreTransporte(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTransporte= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*TransporteBeanSwingJInternalFrame transporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTransporte= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTransporte=null;

	public Border getResaltarFK_IdEmpresaTransporte() {
		return this.resaltarFK_IdEmpresaTransporte;
	}

	public void setResaltarFK_IdEmpresaTransporte(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTransporte= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*TransporteBeanSwingJInternalFrame transporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTransporte= borderResaltar;
	}

	public Border resaltarFK_IdTipoViaTransporteTransporte=null;

	public Border getResaltarFK_IdTipoViaTransporteTransporte() {
		return this.resaltarFK_IdTipoViaTransporteTransporte;
	}

	public void setResaltarFK_IdTipoViaTransporteTransporte(Border borderResaltar) {
		this.resaltarFK_IdTipoViaTransporteTransporte= borderResaltar;
	}

	public void setResaltarFK_IdTipoViaTransporteTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*TransporteBeanSwingJInternalFrame transporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoViaTransporteTransporte= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}