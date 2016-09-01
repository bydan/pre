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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.CentroCostoConstantesFunciones;
import com.bydan.erp.contabilidad.util.CentroCostoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.CentroCostoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CentroCostoConstantesFunciones extends CentroCostoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CentroCosto";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CentroCosto"+CentroCostoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CentroCostoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CentroCostoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CentroCostoConstantesFunciones.SCHEMA+"_"+CentroCostoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CentroCostoConstantesFunciones.SCHEMA+"_"+CentroCostoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CentroCostoConstantesFunciones.SCHEMA+"_"+CentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CentroCostoConstantesFunciones.SCHEMA+"_"+CentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CentroCostoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CentroCostoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CentroCostoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CentroCostoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Centro Costos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Centro Costo";
	public static final String SCLASSWEBTITULO_LOWER="Centro Costo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CentroCosto";
	public static final String OBJECTNAME="centrocosto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="centro_costo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select centrocosto from "+CentroCostoConstantesFunciones.SPERSISTENCENAME+" centrocosto";
	public static String QUERYSELECTNATIVE="select "+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".id,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".version_row,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".id_empresa,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".codigo,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".nombre,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".id_centro_costo,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".porcentaje,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".valor,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".orden,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".es_final,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".descripcion from "+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME;//+" as "+CentroCostoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CentroCostoConstantesFuncionesAdditional centrocostoConstantesFuncionesAdditional=null;
	
	public CentroCostoConstantesFuncionesAdditional getCentroCostoConstantesFuncionesAdditional() {
		return this.centrocostoConstantesFuncionesAdditional;
	}
	
	public void setCentroCostoConstantesFuncionesAdditional(CentroCostoConstantesFuncionesAdditional centrocostoConstantesFuncionesAdditional) {
		try {
			this.centrocostoConstantesFuncionesAdditional=centrocostoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALOR= "valor";
    public static final String ORDEN= "orden";
    public static final String ESFINAL= "es_final";
    public static final String DESCRIPCION= "descripcion";
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
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
    	public static final String LABEL_ESFINAL= "Es Final";
		public static final String LABEL_ESFINAL_LOWER= "Es Final";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCentroCostoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CentroCostoConstantesFunciones.IDEMPRESA)) {sLabelColumna=CentroCostoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CentroCostoConstantesFunciones.CODIGO)) {sLabelColumna=CentroCostoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CentroCostoConstantesFunciones.NOMBRE)) {sLabelColumna=CentroCostoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CentroCostoConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=CentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(CentroCostoConstantesFunciones.PORCENTAJE)) {sLabelColumna=CentroCostoConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(CentroCostoConstantesFunciones.VALOR)) {sLabelColumna=CentroCostoConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(CentroCostoConstantesFunciones.ORDEN)) {sLabelColumna=CentroCostoConstantesFunciones.LABEL_ORDEN;}
		if(sNombreColumna.equals(CentroCostoConstantesFunciones.ESFINAL)) {sLabelColumna=CentroCostoConstantesFunciones.LABEL_ESFINAL;}
		if(sNombreColumna.equals(CentroCostoConstantesFunciones.DESCRIPCION)) {sLabelColumna=CentroCostoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getes_finalDescripcion(CentroCosto centrocosto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!centrocosto.getes_final()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_finalHtmlDescripcion(CentroCosto centrocosto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(centrocosto.getId(),centrocosto.getes_final());

		return sDescripcion;
	}	
			
	
	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(centrocosto !=null/* && centrocosto.getId()!=0*/) {
			sDescripcion=centrocosto.getcodigo()+"-"+centrocosto.getnombre();//centrocostocentrocosto.getcodigo().trim()+"-"+centrocosto.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCentroCostoDescripcionDetallado(CentroCosto centrocosto) {
		String sDescripcion="";
			
		sDescripcion+=CentroCostoConstantesFunciones.ID+"=";
		sDescripcion+=centrocosto.getId().toString()+",";
		sDescripcion+=CentroCostoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=centrocosto.getVersionRow().toString()+",";
		sDescripcion+=CentroCostoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=centrocosto.getid_empresa().toString()+",";
		sDescripcion+=CentroCostoConstantesFunciones.CODIGO+"=";
		sDescripcion+=centrocosto.getcodigo()+",";
		sDescripcion+=CentroCostoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=centrocosto.getnombre()+",";
		sDescripcion+=CentroCostoConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=centrocosto.getid_centro_costo().toString()+",";
		sDescripcion+=CentroCostoConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=centrocosto.getporcentaje().toString()+",";
		sDescripcion+=CentroCostoConstantesFunciones.VALOR+"=";
		sDescripcion+=centrocosto.getvalor().toString()+",";
		sDescripcion+=CentroCostoConstantesFunciones.ORDEN+"=";
		sDescripcion+=centrocosto.getorden().toString()+",";
		sDescripcion+=CentroCostoConstantesFunciones.ESFINAL+"=";
		sDescripcion+=centrocosto.getes_final().toString()+",";
		sDescripcion+=CentroCostoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=centrocosto.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setCentroCostoDescripcion(CentroCosto centrocosto,String sValor) throws Exception {			
		if(centrocosto !=null) {
			centrocosto.setcodigo(sValor);
centrocosto.setnombre(sValor);;//centrocostocentrocosto.getcodigo().trim()+"-"+centrocosto.getnombre().trim();
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
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("PorIdPorEmpresa")) {
			sNombreIndice="Tipo=  Por Id Por Empresa";
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

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPorEmpresa(Long id,Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();}
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCentroCosto(CentroCosto centrocosto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		centrocosto.setcodigo(centrocosto.getcodigo().trim());
		centrocosto.setnombre(centrocosto.getnombre().trim());
		centrocosto.setdescripcion(centrocosto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosCentroCostos(List<CentroCosto> centrocostos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CentroCosto centrocosto: centrocostos) {
			centrocosto.setcodigo(centrocosto.getcodigo().trim());
			centrocosto.setnombre(centrocosto.getnombre().trim());
			centrocosto.setdescripcion(centrocosto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCentroCosto(CentroCosto centrocosto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && centrocosto.getConCambioAuxiliar()) {
			centrocosto.setIsDeleted(centrocosto.getIsDeletedAuxiliar());	
			centrocosto.setIsNew(centrocosto.getIsNewAuxiliar());	
			centrocosto.setIsChanged(centrocosto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			centrocosto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			centrocosto.setIsDeletedAuxiliar(false);	
			centrocosto.setIsNewAuxiliar(false);	
			centrocosto.setIsChangedAuxiliar(false);
			
			centrocosto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCentroCostos(List<CentroCosto> centrocostos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CentroCosto centrocosto : centrocostos) {
			if(conAsignarBase && centrocosto.getConCambioAuxiliar()) {
				centrocosto.setIsDeleted(centrocosto.getIsDeletedAuxiliar());	
				centrocosto.setIsNew(centrocosto.getIsNewAuxiliar());	
				centrocosto.setIsChanged(centrocosto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				centrocosto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				centrocosto.setIsDeletedAuxiliar(false);	
				centrocosto.setIsNewAuxiliar(false);	
				centrocosto.setIsChangedAuxiliar(false);
				
				centrocosto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCentroCosto(CentroCosto centrocosto,Boolean conEnteros) throws Exception  {
		centrocosto.setporcentaje(0.0);
		centrocosto.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			centrocosto.setorden(0);
		}
	}		
	
	public static void InicializarValoresCentroCostos(List<CentroCosto> centrocostos,Boolean conEnteros) throws Exception  {
		
		for(CentroCosto centrocosto: centrocostos) {
			centrocosto.setporcentaje(0.0);
			centrocosto.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				centrocosto.setorden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCentroCosto(List<CentroCosto> centrocostos,CentroCosto centrocostoAux) throws Exception  {
		CentroCostoConstantesFunciones.InicializarValoresCentroCosto(centrocostoAux,true);
		
		for(CentroCosto centrocosto: centrocostos) {
			if(centrocosto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			centrocostoAux.setporcentaje(centrocostoAux.getporcentaje()+centrocosto.getporcentaje());			
			centrocostoAux.setvalor(centrocostoAux.getvalor()+centrocosto.getvalor());			
			centrocostoAux.setorden(centrocostoAux.getorden()+centrocosto.getorden());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCentroCosto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CentroCostoConstantesFunciones.getArrayColumnasGlobalesCentroCosto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCentroCosto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CentroCostoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CentroCostoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCentroCosto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CentroCosto> centrocostos,CentroCosto centrocosto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CentroCosto centrocostoAux: centrocostos) {
			if(centrocostoAux!=null && centrocosto!=null) {
				if((centrocostoAux.getId()==null && centrocosto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(centrocostoAux.getId()!=null && centrocosto.getId()!=null){
					if(centrocostoAux.getId().equals(centrocosto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCentroCosto(List<CentroCosto> centrocostos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
	
		for(CentroCosto centrocosto: centrocostos) {			
			if(centrocosto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=centrocosto.getporcentaje();
			valorTotal+=centrocosto.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(CentroCostoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(CentroCostoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCentroCosto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CentroCostoConstantesFunciones.LABEL_ID, CentroCostoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoConstantesFunciones.LABEL_VERSIONROW, CentroCostoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoConstantesFunciones.LABEL_IDEMPRESA, CentroCostoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoConstantesFunciones.LABEL_CODIGO, CentroCostoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoConstantesFunciones.LABEL_NOMBRE, CentroCostoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO, CentroCostoConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoConstantesFunciones.LABEL_PORCENTAJE, CentroCostoConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoConstantesFunciones.LABEL_VALOR, CentroCostoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoConstantesFunciones.LABEL_ORDEN, CentroCostoConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoConstantesFunciones.LABEL_ESFINAL, CentroCostoConstantesFunciones.ESFINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoConstantesFunciones.LABEL_DESCRIPCION, CentroCostoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCentroCosto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CentroCostoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoConstantesFunciones.ESFINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroCosto() throws Exception  {
		return CentroCostoConstantesFunciones.getTiposSeleccionarCentroCosto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroCosto(Boolean conFk) throws Exception  {
		return CentroCostoConstantesFunciones.getTiposSeleccionarCentroCosto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroCosto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CentroCostoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CentroCostoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CentroCostoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(CentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(CentroCostoConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(CentroCostoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(CentroCostoConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoConstantesFunciones.LABEL_ESFINAL);
			reporte.setsDescripcion(CentroCostoConstantesFunciones.LABEL_ESFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(CentroCostoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCentroCosto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCentroCosto(CentroCosto centrocostoAux) throws Exception {
		
			centrocostoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(centrocostoAux.getEmpresa()));
			centrocostoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocostoAux.getCentroCosto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCentroCosto(List<CentroCosto> centrocostosTemp) throws Exception {
		for(CentroCosto centrocostoAux:centrocostosTemp) {
			
			centrocostoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(centrocostoAux.getEmpresa()));
			centrocostoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocostoAux.getCentroCosto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(CentroCosto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCentroCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CentroCostoConstantesFunciones.getClassesRelationshipsOfCentroCosto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCentroCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CentroCostoConstantesFunciones.getClassesRelationshipsFromStringsOfCentroCosto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCentroCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CentroCosto centrocosto,List<CentroCosto> centrocostos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CentroCosto centrocostoEncontrado=null;
			
			for(CentroCosto centrocostoLocal:centrocostos) {
				if(centrocostoLocal.getId().equals(centrocosto.getId())) {
					centrocostoEncontrado=centrocostoLocal;
					
					centrocostoLocal.setIsChanged(centrocosto.getIsChanged());
					centrocostoLocal.setIsNew(centrocosto.getIsNew());
					centrocostoLocal.setIsDeleted(centrocosto.getIsDeleted());
					
					centrocostoLocal.setGeneralEntityOriginal(centrocosto.getGeneralEntityOriginal());
					
					centrocostoLocal.setId(centrocosto.getId());	
					centrocostoLocal.setVersionRow(centrocosto.getVersionRow());	
					centrocostoLocal.setid_empresa(centrocosto.getid_empresa());	
					centrocostoLocal.setcodigo(centrocosto.getcodigo());	
					centrocostoLocal.setnombre(centrocosto.getnombre());	
					centrocostoLocal.setid_centro_costo(centrocosto.getid_centro_costo());	
					centrocostoLocal.setporcentaje(centrocosto.getporcentaje());	
					centrocostoLocal.setvalor(centrocosto.getvalor());	
					centrocostoLocal.setorden(centrocosto.getorden());	
					centrocostoLocal.setes_final(centrocosto.getes_final());	
					centrocostoLocal.setdescripcion(centrocosto.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!centrocosto.getIsDeleted()) {
				if(!existe) {
					centrocostos.add(centrocosto);
				}
			} else {
				if(centrocostoEncontrado!=null && permiteQuitar)  {
					centrocostos.remove(centrocostoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CentroCosto centrocosto,List<CentroCosto> centrocostos) throws Exception {
		try	{			
			for(CentroCosto centrocostoLocal:centrocostos) {
				if(centrocostoLocal.getId().equals(centrocosto.getId())) {
					centrocostoLocal.setIsSelected(centrocosto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCentroCosto(List<CentroCosto> centrocostosAux) throws Exception {
		//this.centrocostosAux=centrocostosAux;
		
		for(CentroCosto centrocostoAux:centrocostosAux) {
			if(centrocostoAux.getIsChanged()) {
				centrocostoAux.setIsChanged(false);
			}		
			
			if(centrocostoAux.getIsNew()) {
				centrocostoAux.setIsNew(false);
			}	
			
			if(centrocostoAux.getIsDeleted()) {
				centrocostoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCentroCosto(CentroCosto centrocostoAux) throws Exception {
		//this.centrocostoAux=centrocostoAux;
		
			if(centrocostoAux.getIsChanged()) {
				centrocostoAux.setIsChanged(false);
			}		
			
			if(centrocostoAux.getIsNew()) {
				centrocostoAux.setIsNew(false);
			}	
			
			if(centrocostoAux.getIsDeleted()) {
				centrocostoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CentroCosto centrocostoAsignar,CentroCosto centrocosto) throws Exception {
		centrocostoAsignar.setId(centrocosto.getId());	
		centrocostoAsignar.setVersionRow(centrocosto.getVersionRow());	
		centrocostoAsignar.setid_empresa(centrocosto.getid_empresa());
		centrocostoAsignar.setempresa_descripcion(centrocosto.getempresa_descripcion());	
		centrocostoAsignar.setcodigo(centrocosto.getcodigo());	
		centrocostoAsignar.setnombre(centrocosto.getnombre());	
		centrocostoAsignar.setid_centro_costo(centrocosto.getid_centro_costo());
		centrocostoAsignar.setcentrocosto_descripcion(centrocosto.getcentrocosto_descripcion());	
		centrocostoAsignar.setporcentaje(centrocosto.getporcentaje());	
		centrocostoAsignar.setvalor(centrocosto.getvalor());	
		centrocostoAsignar.setorden(centrocosto.getorden());	
		centrocostoAsignar.setes_final(centrocosto.getes_final());	
		centrocostoAsignar.setdescripcion(centrocosto.getdescripcion());	
	}
	
	public static void inicializarCentroCosto(CentroCosto centrocosto) throws Exception {
		try {
				centrocosto.setId(0L);	
					
				centrocosto.setid_empresa(-1L);	
				centrocosto.setcodigo("");	
				centrocosto.setnombre("");	
				centrocosto.setid_centro_costo(null);	
				centrocosto.setporcentaje(0.0);	
				centrocosto.setvalor(0.0);	
				centrocosto.setorden(0);	
				centrocosto.setes_final(false);	
				centrocosto.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCentroCosto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoConstantesFunciones.LABEL_ESFINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCentroCosto(String sTipo,Row row,Workbook workbook,CentroCosto centrocosto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocosto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocosto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocosto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocosto.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocosto.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocosto.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocosto.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(centrocosto.getes_final()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocosto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCentroCosto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCentroCosto() {
		return this.sFinalQueryCentroCosto;
	}
	
	public void setsFinalQueryCentroCosto(String sFinalQueryCentroCosto) {
		this.sFinalQueryCentroCosto= sFinalQueryCentroCosto;
	}
	
	public Border resaltarSeleccionarCentroCosto=null;
	
	public Border setResaltarSeleccionarCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//centrocostoBeanSwingJInternalFrame.jTtoolBarCentroCosto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCentroCosto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCentroCosto() {
		return this.resaltarSeleccionarCentroCosto;
	}
	
	public void setResaltarSeleccionarCentroCosto(Border borderResaltarSeleccionarCentroCosto) {
		this.resaltarSeleccionarCentroCosto= borderResaltarSeleccionarCentroCosto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCentroCosto=null;
	public Boolean mostraridCentroCosto=true;
	public Boolean activaridCentroCosto=true;

	public Border resaltarid_empresaCentroCosto=null;
	public Boolean mostrarid_empresaCentroCosto=true;
	public Boolean activarid_empresaCentroCosto=true;
	public Boolean cargarid_empresaCentroCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCentroCosto=false;//ConEventDepend=true

	public Border resaltarcodigoCentroCosto=null;
	public Boolean mostrarcodigoCentroCosto=true;
	public Boolean activarcodigoCentroCosto=true;

	public Border resaltarnombreCentroCosto=null;
	public Boolean mostrarnombreCentroCosto=true;
	public Boolean activarnombreCentroCosto=true;

	public Border resaltarid_centro_costoCentroCosto=null;
	public Boolean mostrarid_centro_costoCentroCosto=true;
	public Boolean activarid_centro_costoCentroCosto=true;
	public Boolean cargarid_centro_costoCentroCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoCentroCosto=false;//ConEventDepend=true

	public Border resaltarporcentajeCentroCosto=null;
	public Boolean mostrarporcentajeCentroCosto=true;
	public Boolean activarporcentajeCentroCosto=true;

	public Border resaltarvalorCentroCosto=null;
	public Boolean mostrarvalorCentroCosto=true;
	public Boolean activarvalorCentroCosto=true;

	public Border resaltarordenCentroCosto=null;
	public Boolean mostrarordenCentroCosto=true;
	public Boolean activarordenCentroCosto=true;

	public Border resaltares_finalCentroCosto=null;
	public Boolean mostrares_finalCentroCosto=true;
	public Boolean activares_finalCentroCosto=true;

	public Border resaltardescripcionCentroCosto=null;
	public Boolean mostrardescripcionCentroCosto=true;
	public Boolean activardescripcionCentroCosto=true;

	
	

	public Border setResaltaridCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoBeanSwingJInternalFrame.jTtoolBarCentroCosto.setBorder(borderResaltar);
		
		this.resaltaridCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCentroCosto() {
		return this.resaltaridCentroCosto;
	}

	public void setResaltaridCentroCosto(Border borderResaltar) {
		this.resaltaridCentroCosto= borderResaltar;
	}

	public Boolean getMostraridCentroCosto() {
		return this.mostraridCentroCosto;
	}

	public void setMostraridCentroCosto(Boolean mostraridCentroCosto) {
		this.mostraridCentroCosto= mostraridCentroCosto;
	}

	public Boolean getActivaridCentroCosto() {
		return this.activaridCentroCosto;
	}

	public void setActivaridCentroCosto(Boolean activaridCentroCosto) {
		this.activaridCentroCosto= activaridCentroCosto;
	}

	public Border setResaltarid_empresaCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoBeanSwingJInternalFrame.jTtoolBarCentroCosto.setBorder(borderResaltar);
		
		this.resaltarid_empresaCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCentroCosto() {
		return this.resaltarid_empresaCentroCosto;
	}

	public void setResaltarid_empresaCentroCosto(Border borderResaltar) {
		this.resaltarid_empresaCentroCosto= borderResaltar;
	}

	public Boolean getMostrarid_empresaCentroCosto() {
		return this.mostrarid_empresaCentroCosto;
	}

	public void setMostrarid_empresaCentroCosto(Boolean mostrarid_empresaCentroCosto) {
		this.mostrarid_empresaCentroCosto= mostrarid_empresaCentroCosto;
	}

	public Boolean getActivarid_empresaCentroCosto() {
		return this.activarid_empresaCentroCosto;
	}

	public void setActivarid_empresaCentroCosto(Boolean activarid_empresaCentroCosto) {
		this.activarid_empresaCentroCosto= activarid_empresaCentroCosto;
	}

	public Boolean getCargarid_empresaCentroCosto() {
		return this.cargarid_empresaCentroCosto;
	}

	public void setCargarid_empresaCentroCosto(Boolean cargarid_empresaCentroCosto) {
		this.cargarid_empresaCentroCosto= cargarid_empresaCentroCosto;
	}

	public Border setResaltarcodigoCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoBeanSwingJInternalFrame.jTtoolBarCentroCosto.setBorder(borderResaltar);
		
		this.resaltarcodigoCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCentroCosto() {
		return this.resaltarcodigoCentroCosto;
	}

	public void setResaltarcodigoCentroCosto(Border borderResaltar) {
		this.resaltarcodigoCentroCosto= borderResaltar;
	}

	public Boolean getMostrarcodigoCentroCosto() {
		return this.mostrarcodigoCentroCosto;
	}

	public void setMostrarcodigoCentroCosto(Boolean mostrarcodigoCentroCosto) {
		this.mostrarcodigoCentroCosto= mostrarcodigoCentroCosto;
	}

	public Boolean getActivarcodigoCentroCosto() {
		return this.activarcodigoCentroCosto;
	}

	public void setActivarcodigoCentroCosto(Boolean activarcodigoCentroCosto) {
		this.activarcodigoCentroCosto= activarcodigoCentroCosto;
	}

	public Border setResaltarnombreCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoBeanSwingJInternalFrame.jTtoolBarCentroCosto.setBorder(borderResaltar);
		
		this.resaltarnombreCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCentroCosto() {
		return this.resaltarnombreCentroCosto;
	}

	public void setResaltarnombreCentroCosto(Border borderResaltar) {
		this.resaltarnombreCentroCosto= borderResaltar;
	}

	public Boolean getMostrarnombreCentroCosto() {
		return this.mostrarnombreCentroCosto;
	}

	public void setMostrarnombreCentroCosto(Boolean mostrarnombreCentroCosto) {
		this.mostrarnombreCentroCosto= mostrarnombreCentroCosto;
	}

	public Boolean getActivarnombreCentroCosto() {
		return this.activarnombreCentroCosto;
	}

	public void setActivarnombreCentroCosto(Boolean activarnombreCentroCosto) {
		this.activarnombreCentroCosto= activarnombreCentroCosto;
	}

	public Border setResaltarid_centro_costoCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoBeanSwingJInternalFrame.jTtoolBarCentroCosto.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoCentroCosto() {
		return this.resaltarid_centro_costoCentroCosto;
	}

	public void setResaltarid_centro_costoCentroCosto(Border borderResaltar) {
		this.resaltarid_centro_costoCentroCosto= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoCentroCosto() {
		return this.mostrarid_centro_costoCentroCosto;
	}

	public void setMostrarid_centro_costoCentroCosto(Boolean mostrarid_centro_costoCentroCosto) {
		this.mostrarid_centro_costoCentroCosto= mostrarid_centro_costoCentroCosto;
	}

	public Boolean getActivarid_centro_costoCentroCosto() {
		return this.activarid_centro_costoCentroCosto;
	}

	public void setActivarid_centro_costoCentroCosto(Boolean activarid_centro_costoCentroCosto) {
		this.activarid_centro_costoCentroCosto= activarid_centro_costoCentroCosto;
	}

	public Boolean getCargarid_centro_costoCentroCosto() {
		return this.cargarid_centro_costoCentroCosto;
	}

	public void setCargarid_centro_costoCentroCosto(Boolean cargarid_centro_costoCentroCosto) {
		this.cargarid_centro_costoCentroCosto= cargarid_centro_costoCentroCosto;
	}

	public Border setResaltarporcentajeCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoBeanSwingJInternalFrame.jTtoolBarCentroCosto.setBorder(borderResaltar);
		
		this.resaltarporcentajeCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeCentroCosto() {
		return this.resaltarporcentajeCentroCosto;
	}

	public void setResaltarporcentajeCentroCosto(Border borderResaltar) {
		this.resaltarporcentajeCentroCosto= borderResaltar;
	}

	public Boolean getMostrarporcentajeCentroCosto() {
		return this.mostrarporcentajeCentroCosto;
	}

	public void setMostrarporcentajeCentroCosto(Boolean mostrarporcentajeCentroCosto) {
		this.mostrarporcentajeCentroCosto= mostrarporcentajeCentroCosto;
	}

	public Boolean getActivarporcentajeCentroCosto() {
		return this.activarporcentajeCentroCosto;
	}

	public void setActivarporcentajeCentroCosto(Boolean activarporcentajeCentroCosto) {
		this.activarporcentajeCentroCosto= activarporcentajeCentroCosto;
	}

	public Border setResaltarvalorCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoBeanSwingJInternalFrame.jTtoolBarCentroCosto.setBorder(borderResaltar);
		
		this.resaltarvalorCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorCentroCosto() {
		return this.resaltarvalorCentroCosto;
	}

	public void setResaltarvalorCentroCosto(Border borderResaltar) {
		this.resaltarvalorCentroCosto= borderResaltar;
	}

	public Boolean getMostrarvalorCentroCosto() {
		return this.mostrarvalorCentroCosto;
	}

	public void setMostrarvalorCentroCosto(Boolean mostrarvalorCentroCosto) {
		this.mostrarvalorCentroCosto= mostrarvalorCentroCosto;
	}

	public Boolean getActivarvalorCentroCosto() {
		return this.activarvalorCentroCosto;
	}

	public void setActivarvalorCentroCosto(Boolean activarvalorCentroCosto) {
		this.activarvalorCentroCosto= activarvalorCentroCosto;
	}

	public Border setResaltarordenCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoBeanSwingJInternalFrame.jTtoolBarCentroCosto.setBorder(borderResaltar);
		
		this.resaltarordenCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenCentroCosto() {
		return this.resaltarordenCentroCosto;
	}

	public void setResaltarordenCentroCosto(Border borderResaltar) {
		this.resaltarordenCentroCosto= borderResaltar;
	}

	public Boolean getMostrarordenCentroCosto() {
		return this.mostrarordenCentroCosto;
	}

	public void setMostrarordenCentroCosto(Boolean mostrarordenCentroCosto) {
		this.mostrarordenCentroCosto= mostrarordenCentroCosto;
	}

	public Boolean getActivarordenCentroCosto() {
		return this.activarordenCentroCosto;
	}

	public void setActivarordenCentroCosto(Boolean activarordenCentroCosto) {
		this.activarordenCentroCosto= activarordenCentroCosto;
	}

	public Border setResaltares_finalCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoBeanSwingJInternalFrame.jTtoolBarCentroCosto.setBorder(borderResaltar);
		
		this.resaltares_finalCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_finalCentroCosto() {
		return this.resaltares_finalCentroCosto;
	}

	public void setResaltares_finalCentroCosto(Border borderResaltar) {
		this.resaltares_finalCentroCosto= borderResaltar;
	}

	public Boolean getMostrares_finalCentroCosto() {
		return this.mostrares_finalCentroCosto;
	}

	public void setMostrares_finalCentroCosto(Boolean mostrares_finalCentroCosto) {
		this.mostrares_finalCentroCosto= mostrares_finalCentroCosto;
	}

	public Boolean getActivares_finalCentroCosto() {
		return this.activares_finalCentroCosto;
	}

	public void setActivares_finalCentroCosto(Boolean activares_finalCentroCosto) {
		this.activares_finalCentroCosto= activares_finalCentroCosto;
	}

	public Border setResaltardescripcionCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostoBeanSwingJInternalFrame.jTtoolBarCentroCosto.setBorder(borderResaltar);
		
		this.resaltardescripcionCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionCentroCosto() {
		return this.resaltardescripcionCentroCosto;
	}

	public void setResaltardescripcionCentroCosto(Border borderResaltar) {
		this.resaltardescripcionCentroCosto= borderResaltar;
	}

	public Boolean getMostrardescripcionCentroCosto() {
		return this.mostrardescripcionCentroCosto;
	}

	public void setMostrardescripcionCentroCosto(Boolean mostrardescripcionCentroCosto) {
		this.mostrardescripcionCentroCosto= mostrardescripcionCentroCosto;
	}

	public Boolean getActivardescripcionCentroCosto() {
		return this.activardescripcionCentroCosto;
	}

	public void setActivardescripcionCentroCosto(Boolean activardescripcionCentroCosto) {
		this.activardescripcionCentroCosto= activardescripcionCentroCosto;
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
		
		
		this.setMostraridCentroCosto(esInicial);
		this.setMostrarid_empresaCentroCosto(esInicial);
		this.setMostrarcodigoCentroCosto(esInicial);
		this.setMostrarnombreCentroCosto(esInicial);
		this.setMostrarid_centro_costoCentroCosto(esInicial);
		this.setMostrarporcentajeCentroCosto(esInicial);
		this.setMostrarvalorCentroCosto(esInicial);
		this.setMostrarordenCentroCosto(esInicial);
		this.setMostrares_finalCentroCosto(esInicial);
		this.setMostrardescripcionCentroCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroCostoConstantesFunciones.ID)) {
				this.setMostraridCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.VALOR)) {
				this.setMostrarvalorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.ORDEN)) {
				this.setMostrarordenCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.ESFINAL)) {
				this.setMostrares_finalCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionCentroCosto(esAsigna);
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
		
		
		this.setActivaridCentroCosto(esInicial);
		this.setActivarid_empresaCentroCosto(esInicial);
		this.setActivarcodigoCentroCosto(esInicial);
		this.setActivarnombreCentroCosto(esInicial);
		this.setActivarid_centro_costoCentroCosto(esInicial);
		this.setActivarporcentajeCentroCosto(esInicial);
		this.setActivarvalorCentroCosto(esInicial);
		this.setActivarordenCentroCosto(esInicial);
		this.setActivares_finalCentroCosto(esInicial);
		this.setActivardescripcionCentroCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroCostoConstantesFunciones.ID)) {
				this.setActivaridCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.VALOR)) {
				this.setActivarvalorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.ORDEN)) {
				this.setActivarordenCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.ESFINAL)) {
				this.setActivares_finalCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionCentroCosto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCentroCosto(esInicial);
		this.setResaltarid_empresaCentroCosto(esInicial);
		this.setResaltarcodigoCentroCosto(esInicial);
		this.setResaltarnombreCentroCosto(esInicial);
		this.setResaltarid_centro_costoCentroCosto(esInicial);
		this.setResaltarporcentajeCentroCosto(esInicial);
		this.setResaltarvalorCentroCosto(esInicial);
		this.setResaltarordenCentroCosto(esInicial);
		this.setResaltares_finalCentroCosto(esInicial);
		this.setResaltardescripcionCentroCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroCostoConstantesFunciones.ID)) {
				this.setResaltaridCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.VALOR)) {
				this.setResaltarvalorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.ORDEN)) {
				this.setResaltarordenCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.ESFINAL)) {
				this.setResaltares_finalCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionCentroCosto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoCentroCosto=true;

	public Boolean getMostrarBusquedaPorCodigoCentroCosto() {
		return this.mostrarBusquedaPorCodigoCentroCosto;
	}

	public void setMostrarBusquedaPorCodigoCentroCosto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoCentroCosto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreCentroCosto=true;

	public Boolean getMostrarBusquedaPorNombreCentroCosto() {
		return this.mostrarBusquedaPorNombreCentroCosto;
	}

	public void setMostrarBusquedaPorNombreCentroCosto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreCentroCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoCentroCosto=true;

	public Boolean getMostrarFK_IdCentroCostoCentroCosto() {
		return this.mostrarFK_IdCentroCostoCentroCosto;
	}

	public void setMostrarFK_IdCentroCostoCentroCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoCentroCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCentroCosto=true;

	public Boolean getMostrarFK_IdEmpresaCentroCosto() {
		return this.mostrarFK_IdEmpresaCentroCosto;
	}

	public void setMostrarFK_IdEmpresaCentroCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCentroCosto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoCentroCosto=true;

	public Boolean getActivarBusquedaPorCodigoCentroCosto() {
		return this.activarBusquedaPorCodigoCentroCosto;
	}

	public void setActivarBusquedaPorCodigoCentroCosto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoCentroCosto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreCentroCosto=true;

	public Boolean getActivarBusquedaPorNombreCentroCosto() {
		return this.activarBusquedaPorNombreCentroCosto;
	}

	public void setActivarBusquedaPorNombreCentroCosto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreCentroCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoCentroCosto=true;

	public Boolean getActivarFK_IdCentroCostoCentroCosto() {
		return this.activarFK_IdCentroCostoCentroCosto;
	}

	public void setActivarFK_IdCentroCostoCentroCosto(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoCentroCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCentroCosto=true;

	public Boolean getActivarFK_IdEmpresaCentroCosto() {
		return this.activarFK_IdEmpresaCentroCosto;
	}

	public void setActivarFK_IdEmpresaCentroCosto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCentroCosto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoCentroCosto=null;

	public Border getResaltarBusquedaPorCodigoCentroCosto() {
		return this.resaltarBusquedaPorCodigoCentroCosto;
	}

	public void setResaltarBusquedaPorCodigoCentroCosto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoCentroCosto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoCentroCosto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreCentroCosto=null;

	public Border getResaltarBusquedaPorNombreCentroCosto() {
		return this.resaltarBusquedaPorNombreCentroCosto;
	}

	public void setResaltarBusquedaPorNombreCentroCosto(Border borderResaltar) {
		this.resaltarBusquedaPorNombreCentroCosto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreCentroCosto= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoCentroCosto=null;

	public Border getResaltarFK_IdCentroCostoCentroCosto() {
		return this.resaltarFK_IdCentroCostoCentroCosto;
	}

	public void setResaltarFK_IdCentroCostoCentroCosto(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoCentroCosto= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoCentroCosto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCentroCosto=null;

	public Border getResaltarFK_IdEmpresaCentroCosto() {
		return this.resaltarFK_IdEmpresaCentroCosto;
	}

	public void setResaltarFK_IdEmpresaCentroCosto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCentroCosto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoBeanSwingJInternalFrame centrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCentroCosto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}