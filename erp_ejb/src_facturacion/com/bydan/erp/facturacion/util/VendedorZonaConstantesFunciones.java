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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.VendedorZonaConstantesFunciones;
import com.bydan.erp.facturacion.util.VendedorZonaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.VendedorZonaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class VendedorZonaConstantesFunciones extends VendedorZonaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="VendedorZona";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VendedorZona"+VendedorZonaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VendedorZonaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VendedorZonaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VendedorZonaConstantesFunciones.SCHEMA+"_"+VendedorZonaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VendedorZonaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VendedorZonaConstantesFunciones.SCHEMA+"_"+VendedorZonaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VendedorZonaConstantesFunciones.SCHEMA+"_"+VendedorZonaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VendedorZonaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VendedorZonaConstantesFunciones.SCHEMA+"_"+VendedorZonaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VendedorZonaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VendedorZonaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VendedorZonaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VendedorZonaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VendedorZonaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VendedorZonaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VendedorZonaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VendedorZonaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VendedorZonaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VendedorZonaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Vendedor Zonas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Vendedor Zona";
	public static final String SCLASSWEBTITULO_LOWER="Vendedor Zona";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VendedorZona";
	public static final String OBJECTNAME="vendedorzona";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="vendedor_zona";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select vendedorzona from "+VendedorZonaConstantesFunciones.SPERSISTENCENAME+" vendedorzona";
	public static String QUERYSELECTNATIVE="select "+VendedorZonaConstantesFunciones.SCHEMA+"."+VendedorZonaConstantesFunciones.TABLENAME+".id,"+VendedorZonaConstantesFunciones.SCHEMA+"."+VendedorZonaConstantesFunciones.TABLENAME+".version_row,"+VendedorZonaConstantesFunciones.SCHEMA+"."+VendedorZonaConstantesFunciones.TABLENAME+".id_empresa,"+VendedorZonaConstantesFunciones.SCHEMA+"."+VendedorZonaConstantesFunciones.TABLENAME+".id_sucursal,"+VendedorZonaConstantesFunciones.SCHEMA+"."+VendedorZonaConstantesFunciones.TABLENAME+".id_vendedor,"+VendedorZonaConstantesFunciones.SCHEMA+"."+VendedorZonaConstantesFunciones.TABLENAME+".id_zona,"+VendedorZonaConstantesFunciones.SCHEMA+"."+VendedorZonaConstantesFunciones.TABLENAME+".observacion from "+VendedorZonaConstantesFunciones.SCHEMA+"."+VendedorZonaConstantesFunciones.TABLENAME;//+" as "+VendedorZonaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected VendedorZonaConstantesFuncionesAdditional vendedorzonaConstantesFuncionesAdditional=null;
	
	public VendedorZonaConstantesFuncionesAdditional getVendedorZonaConstantesFuncionesAdditional() {
		return this.vendedorzonaConstantesFuncionesAdditional;
	}
	
	public void setVendedorZonaConstantesFuncionesAdditional(VendedorZonaConstantesFuncionesAdditional vendedorzonaConstantesFuncionesAdditional) {
		try {
			this.vendedorzonaConstantesFuncionesAdditional=vendedorzonaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDZONA= "id_zona";
    public static final String OBSERVACION= "observacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDZONA= "Zona";
		public static final String LABEL_IDZONA_LOWER= "Zona";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
	
		
		
		
		
		
		
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getVendedorZonaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VendedorZonaConstantesFunciones.IDEMPRESA)) {sLabelColumna=VendedorZonaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VendedorZonaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=VendedorZonaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(VendedorZonaConstantesFunciones.IDVENDEDOR)) {sLabelColumna=VendedorZonaConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(VendedorZonaConstantesFunciones.IDZONA)) {sLabelColumna=VendedorZonaConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(VendedorZonaConstantesFunciones.OBSERVACION)) {sLabelColumna=VendedorZonaConstantesFunciones.LABEL_OBSERVACION;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getVendedorZonaDescripcion(VendedorZona vendedorzona) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(vendedorzona !=null/* && vendedorzona.getId()!=0*/) {
			if(vendedorzona.getId()!=null) {
				sDescripcion=vendedorzona.getId().toString();
			}//vendedorzonavendedorzona.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVendedorZonaDescripcionDetallado(VendedorZona vendedorzona) {
		String sDescripcion="";
			
		sDescripcion+=VendedorZonaConstantesFunciones.ID+"=";
		sDescripcion+=vendedorzona.getId().toString()+",";
		sDescripcion+=VendedorZonaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=vendedorzona.getVersionRow().toString()+",";
		sDescripcion+=VendedorZonaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=vendedorzona.getid_empresa().toString()+",";
		sDescripcion+=VendedorZonaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=vendedorzona.getid_sucursal().toString()+",";
		sDescripcion+=VendedorZonaConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=vendedorzona.getid_vendedor().toString()+",";
		sDescripcion+=VendedorZonaConstantesFunciones.IDZONA+"=";
		sDescripcion+=vendedorzona.getid_zona().toString()+",";
		sDescripcion+=VendedorZonaConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=vendedorzona.getobservacion()+",";
			
		return sDescripcion;
	}
	
	public static void setVendedorZonaDescripcion(VendedorZona vendedorzona,String sValor) throws Exception {			
		if(vendedorzona !=null) {
			//vendedorzonavendedorzona.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}

	public static String getZonaDescripcion(Zona zona) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(zona!=null/*&&zona.getId()>0*/) {
			sDescripcion=ZonaConstantesFunciones.getZonaDescripcion(zona);
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
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		} else if(sNombreIndice.equals("FK_IdZona")) {
			sNombreIndice="Tipo=  Por Zona";
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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdZona(Long id_zona) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVendedorZona(VendedorZona vendedorzona,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		vendedorzona.setobservacion(vendedorzona.getobservacion().trim());
	}
	
	public static void quitarEspaciosVendedorZonas(List<VendedorZona> vendedorzonas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VendedorZona vendedorzona: vendedorzonas) {
			vendedorzona.setobservacion(vendedorzona.getobservacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVendedorZona(VendedorZona vendedorzona,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && vendedorzona.getConCambioAuxiliar()) {
			vendedorzona.setIsDeleted(vendedorzona.getIsDeletedAuxiliar());	
			vendedorzona.setIsNew(vendedorzona.getIsNewAuxiliar());	
			vendedorzona.setIsChanged(vendedorzona.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			vendedorzona.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			vendedorzona.setIsDeletedAuxiliar(false);	
			vendedorzona.setIsNewAuxiliar(false);	
			vendedorzona.setIsChangedAuxiliar(false);
			
			vendedorzona.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVendedorZonas(List<VendedorZona> vendedorzonas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VendedorZona vendedorzona : vendedorzonas) {
			if(conAsignarBase && vendedorzona.getConCambioAuxiliar()) {
				vendedorzona.setIsDeleted(vendedorzona.getIsDeletedAuxiliar());	
				vendedorzona.setIsNew(vendedorzona.getIsNewAuxiliar());	
				vendedorzona.setIsChanged(vendedorzona.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				vendedorzona.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				vendedorzona.setIsDeletedAuxiliar(false);	
				vendedorzona.setIsNewAuxiliar(false);	
				vendedorzona.setIsChangedAuxiliar(false);
				
				vendedorzona.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVendedorZona(VendedorZona vendedorzona,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVendedorZonas(List<VendedorZona> vendedorzonas,Boolean conEnteros) throws Exception  {
		
		for(VendedorZona vendedorzona: vendedorzonas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVendedorZona(List<VendedorZona> vendedorzonas,VendedorZona vendedorzonaAux) throws Exception  {
		VendedorZonaConstantesFunciones.InicializarValoresVendedorZona(vendedorzonaAux,true);
		
		for(VendedorZona vendedorzona: vendedorzonas) {
			if(vendedorzona.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVendedorZona(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VendedorZonaConstantesFunciones.getArrayColumnasGlobalesVendedorZona(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVendedorZona(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VendedorZonaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VendedorZonaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VendedorZonaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VendedorZonaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVendedorZona(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VendedorZona> vendedorzonas,VendedorZona vendedorzona,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VendedorZona vendedorzonaAux: vendedorzonas) {
			if(vendedorzonaAux!=null && vendedorzona!=null) {
				if((vendedorzonaAux.getId()==null && vendedorzona.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(vendedorzonaAux.getId()!=null && vendedorzona.getId()!=null){
					if(vendedorzonaAux.getId().equals(vendedorzona.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVendedorZona(List<VendedorZona> vendedorzonas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(VendedorZona vendedorzona: vendedorzonas) {			
			if(vendedorzona.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVendedorZona() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VendedorZonaConstantesFunciones.LABEL_ID, VendedorZonaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorZonaConstantesFunciones.LABEL_VERSIONROW, VendedorZonaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorZonaConstantesFunciones.LABEL_IDEMPRESA, VendedorZonaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorZonaConstantesFunciones.LABEL_IDSUCURSAL, VendedorZonaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorZonaConstantesFunciones.LABEL_IDVENDEDOR, VendedorZonaConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorZonaConstantesFunciones.LABEL_IDZONA, VendedorZonaConstantesFunciones.IDZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VendedorZonaConstantesFunciones.LABEL_OBSERVACION, VendedorZonaConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVendedorZona() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VendedorZonaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorZonaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorZonaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorZonaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorZonaConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorZonaConstantesFunciones.IDZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VendedorZonaConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVendedorZona() throws Exception  {
		return VendedorZonaConstantesFunciones.getTiposSeleccionarVendedorZona(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVendedorZona(Boolean conFk) throws Exception  {
		return VendedorZonaConstantesFunciones.getTiposSeleccionarVendedorZona(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVendedorZona(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorZonaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VendedorZonaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorZonaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(VendedorZonaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorZonaConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(VendedorZonaConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorZonaConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(VendedorZonaConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VendedorZonaConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(VendedorZonaConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVendedorZona(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVendedorZona(VendedorZona vendedorzonaAux) throws Exception {
		
			vendedorzonaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(vendedorzonaAux.getEmpresa()));
			vendedorzonaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(vendedorzonaAux.getSucursal()));
			vendedorzonaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(vendedorzonaAux.getVendedor()));
			vendedorzonaAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(vendedorzonaAux.getZona()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVendedorZona(List<VendedorZona> vendedorzonasTemp) throws Exception {
		for(VendedorZona vendedorzonaAux:vendedorzonasTemp) {
			
			vendedorzonaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(vendedorzonaAux.getEmpresa()));
			vendedorzonaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(vendedorzonaAux.getSucursal()));
			vendedorzonaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(vendedorzonaAux.getVendedor()));
			vendedorzonaAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(vendedorzonaAux.getZona()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVendedorZona(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Zona.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Zona.class)) {
						classes.add(new Classe(Zona.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVendedorZona(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVendedorZona(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VendedorZonaConstantesFunciones.getClassesRelationshipsOfVendedorZona(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVendedorZona(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVendedorZona(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VendedorZonaConstantesFunciones.getClassesRelationshipsFromStringsOfVendedorZona(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVendedorZona(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VendedorZona vendedorzona,List<VendedorZona> vendedorzonas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			VendedorZona vendedorzonaEncontrado=null;
			
			for(VendedorZona vendedorzonaLocal:vendedorzonas) {
				if(vendedorzonaLocal.getId().equals(vendedorzona.getId())) {
					vendedorzonaEncontrado=vendedorzonaLocal;
					
					vendedorzonaLocal.setIsChanged(vendedorzona.getIsChanged());
					vendedorzonaLocal.setIsNew(vendedorzona.getIsNew());
					vendedorzonaLocal.setIsDeleted(vendedorzona.getIsDeleted());
					
					vendedorzonaLocal.setGeneralEntityOriginal(vendedorzona.getGeneralEntityOriginal());
					
					vendedorzonaLocal.setId(vendedorzona.getId());	
					vendedorzonaLocal.setVersionRow(vendedorzona.getVersionRow());	
					vendedorzonaLocal.setid_empresa(vendedorzona.getid_empresa());	
					vendedorzonaLocal.setid_sucursal(vendedorzona.getid_sucursal());	
					vendedorzonaLocal.setid_vendedor(vendedorzona.getid_vendedor());	
					vendedorzonaLocal.setid_zona(vendedorzona.getid_zona());	
					vendedorzonaLocal.setobservacion(vendedorzona.getobservacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!vendedorzona.getIsDeleted()) {
				if(!existe) {
					vendedorzonas.add(vendedorzona);
				}
			} else {
				if(vendedorzonaEncontrado!=null && permiteQuitar)  {
					vendedorzonas.remove(vendedorzonaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(VendedorZona vendedorzona,List<VendedorZona> vendedorzonas) throws Exception {
		try	{			
			for(VendedorZona vendedorzonaLocal:vendedorzonas) {
				if(vendedorzonaLocal.getId().equals(vendedorzona.getId())) {
					vendedorzonaLocal.setIsSelected(vendedorzona.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVendedorZona(List<VendedorZona> vendedorzonasAux) throws Exception {
		//this.vendedorzonasAux=vendedorzonasAux;
		
		for(VendedorZona vendedorzonaAux:vendedorzonasAux) {
			if(vendedorzonaAux.getIsChanged()) {
				vendedorzonaAux.setIsChanged(false);
			}		
			
			if(vendedorzonaAux.getIsNew()) {
				vendedorzonaAux.setIsNew(false);
			}	
			
			if(vendedorzonaAux.getIsDeleted()) {
				vendedorzonaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVendedorZona(VendedorZona vendedorzonaAux) throws Exception {
		//this.vendedorzonaAux=vendedorzonaAux;
		
			if(vendedorzonaAux.getIsChanged()) {
				vendedorzonaAux.setIsChanged(false);
			}		
			
			if(vendedorzonaAux.getIsNew()) {
				vendedorzonaAux.setIsNew(false);
			}	
			
			if(vendedorzonaAux.getIsDeleted()) {
				vendedorzonaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VendedorZona vendedorzonaAsignar,VendedorZona vendedorzona) throws Exception {
		vendedorzonaAsignar.setId(vendedorzona.getId());	
		vendedorzonaAsignar.setVersionRow(vendedorzona.getVersionRow());	
		vendedorzonaAsignar.setid_empresa(vendedorzona.getid_empresa());
		vendedorzonaAsignar.setempresa_descripcion(vendedorzona.getempresa_descripcion());	
		vendedorzonaAsignar.setid_sucursal(vendedorzona.getid_sucursal());
		vendedorzonaAsignar.setsucursal_descripcion(vendedorzona.getsucursal_descripcion());	
		vendedorzonaAsignar.setid_vendedor(vendedorzona.getid_vendedor());
		vendedorzonaAsignar.setvendedor_descripcion(vendedorzona.getvendedor_descripcion());	
		vendedorzonaAsignar.setid_zona(vendedorzona.getid_zona());
		vendedorzonaAsignar.setzona_descripcion(vendedorzona.getzona_descripcion());	
		vendedorzonaAsignar.setobservacion(vendedorzona.getobservacion());	
	}
	
	public static void inicializarVendedorZona(VendedorZona vendedorzona) throws Exception {
		try {
				vendedorzona.setId(0L);	
					
				vendedorzona.setid_empresa(-1L);	
				vendedorzona.setid_sucursal(-1L);	
				vendedorzona.setid_vendedor(-1L);	
				vendedorzona.setid_zona(-1L);	
				vendedorzona.setobservacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVendedorZona(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorZonaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorZonaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorZonaConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorZonaConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VendedorZonaConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVendedorZona(String sTipo,Row row,Workbook workbook,VendedorZona vendedorzona,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedorzona.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedorzona.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedorzona.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedorzona.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(vendedorzona.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVendedorZona=Constantes.SFINALQUERY;
	
	public String getsFinalQueryVendedorZona() {
		return this.sFinalQueryVendedorZona;
	}
	
	public void setsFinalQueryVendedorZona(String sFinalQueryVendedorZona) {
		this.sFinalQueryVendedorZona= sFinalQueryVendedorZona;
	}
	
	public Border resaltarSeleccionarVendedorZona=null;
	
	public Border setResaltarSeleccionarVendedorZona(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorZonaBeanSwingJInternalFrame vendedorzonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//vendedorzonaBeanSwingJInternalFrame.jTtoolBarVendedorZona.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVendedorZona= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVendedorZona() {
		return this.resaltarSeleccionarVendedorZona;
	}
	
	public void setResaltarSeleccionarVendedorZona(Border borderResaltarSeleccionarVendedorZona) {
		this.resaltarSeleccionarVendedorZona= borderResaltarSeleccionarVendedorZona;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVendedorZona=null;
	public Boolean mostraridVendedorZona=true;
	public Boolean activaridVendedorZona=true;

	public Border resaltarid_empresaVendedorZona=null;
	public Boolean mostrarid_empresaVendedorZona=true;
	public Boolean activarid_empresaVendedorZona=true;
	public Boolean cargarid_empresaVendedorZona=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVendedorZona=false;//ConEventDepend=true

	public Border resaltarid_sucursalVendedorZona=null;
	public Boolean mostrarid_sucursalVendedorZona=true;
	public Boolean activarid_sucursalVendedorZona=true;
	public Boolean cargarid_sucursalVendedorZona=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalVendedorZona=false;//ConEventDepend=true

	public Border resaltarid_vendedorVendedorZona=null;
	public Boolean mostrarid_vendedorVendedorZona=true;
	public Boolean activarid_vendedorVendedorZona=true;
	public Boolean cargarid_vendedorVendedorZona=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorVendedorZona=false;//ConEventDepend=true

	public Border resaltarid_zonaVendedorZona=null;
	public Boolean mostrarid_zonaVendedorZona=true;
	public Boolean activarid_zonaVendedorZona=true;
	public Boolean cargarid_zonaVendedorZona=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaVendedorZona=false;//ConEventDepend=true

	public Border resaltarobservacionVendedorZona=null;
	public Boolean mostrarobservacionVendedorZona=true;
	public Boolean activarobservacionVendedorZona=true;

	
	

	public Border setResaltaridVendedorZona(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorZonaBeanSwingJInternalFrame vendedorzonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorzonaBeanSwingJInternalFrame.jTtoolBarVendedorZona.setBorder(borderResaltar);
		
		this.resaltaridVendedorZona= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVendedorZona() {
		return this.resaltaridVendedorZona;
	}

	public void setResaltaridVendedorZona(Border borderResaltar) {
		this.resaltaridVendedorZona= borderResaltar;
	}

	public Boolean getMostraridVendedorZona() {
		return this.mostraridVendedorZona;
	}

	public void setMostraridVendedorZona(Boolean mostraridVendedorZona) {
		this.mostraridVendedorZona= mostraridVendedorZona;
	}

	public Boolean getActivaridVendedorZona() {
		return this.activaridVendedorZona;
	}

	public void setActivaridVendedorZona(Boolean activaridVendedorZona) {
		this.activaridVendedorZona= activaridVendedorZona;
	}

	public Border setResaltarid_empresaVendedorZona(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorZonaBeanSwingJInternalFrame vendedorzonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorzonaBeanSwingJInternalFrame.jTtoolBarVendedorZona.setBorder(borderResaltar);
		
		this.resaltarid_empresaVendedorZona= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVendedorZona() {
		return this.resaltarid_empresaVendedorZona;
	}

	public void setResaltarid_empresaVendedorZona(Border borderResaltar) {
		this.resaltarid_empresaVendedorZona= borderResaltar;
	}

	public Boolean getMostrarid_empresaVendedorZona() {
		return this.mostrarid_empresaVendedorZona;
	}

	public void setMostrarid_empresaVendedorZona(Boolean mostrarid_empresaVendedorZona) {
		this.mostrarid_empresaVendedorZona= mostrarid_empresaVendedorZona;
	}

	public Boolean getActivarid_empresaVendedorZona() {
		return this.activarid_empresaVendedorZona;
	}

	public void setActivarid_empresaVendedorZona(Boolean activarid_empresaVendedorZona) {
		this.activarid_empresaVendedorZona= activarid_empresaVendedorZona;
	}

	public Boolean getCargarid_empresaVendedorZona() {
		return this.cargarid_empresaVendedorZona;
	}

	public void setCargarid_empresaVendedorZona(Boolean cargarid_empresaVendedorZona) {
		this.cargarid_empresaVendedorZona= cargarid_empresaVendedorZona;
	}

	public Border setResaltarid_sucursalVendedorZona(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorZonaBeanSwingJInternalFrame vendedorzonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorzonaBeanSwingJInternalFrame.jTtoolBarVendedorZona.setBorder(borderResaltar);
		
		this.resaltarid_sucursalVendedorZona= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalVendedorZona() {
		return this.resaltarid_sucursalVendedorZona;
	}

	public void setResaltarid_sucursalVendedorZona(Border borderResaltar) {
		this.resaltarid_sucursalVendedorZona= borderResaltar;
	}

	public Boolean getMostrarid_sucursalVendedorZona() {
		return this.mostrarid_sucursalVendedorZona;
	}

	public void setMostrarid_sucursalVendedorZona(Boolean mostrarid_sucursalVendedorZona) {
		this.mostrarid_sucursalVendedorZona= mostrarid_sucursalVendedorZona;
	}

	public Boolean getActivarid_sucursalVendedorZona() {
		return this.activarid_sucursalVendedorZona;
	}

	public void setActivarid_sucursalVendedorZona(Boolean activarid_sucursalVendedorZona) {
		this.activarid_sucursalVendedorZona= activarid_sucursalVendedorZona;
	}

	public Boolean getCargarid_sucursalVendedorZona() {
		return this.cargarid_sucursalVendedorZona;
	}

	public void setCargarid_sucursalVendedorZona(Boolean cargarid_sucursalVendedorZona) {
		this.cargarid_sucursalVendedorZona= cargarid_sucursalVendedorZona;
	}

	public Border setResaltarid_vendedorVendedorZona(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorZonaBeanSwingJInternalFrame vendedorzonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorzonaBeanSwingJInternalFrame.jTtoolBarVendedorZona.setBorder(borderResaltar);
		
		this.resaltarid_vendedorVendedorZona= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorVendedorZona() {
		return this.resaltarid_vendedorVendedorZona;
	}

	public void setResaltarid_vendedorVendedorZona(Border borderResaltar) {
		this.resaltarid_vendedorVendedorZona= borderResaltar;
	}

	public Boolean getMostrarid_vendedorVendedorZona() {
		return this.mostrarid_vendedorVendedorZona;
	}

	public void setMostrarid_vendedorVendedorZona(Boolean mostrarid_vendedorVendedorZona) {
		this.mostrarid_vendedorVendedorZona= mostrarid_vendedorVendedorZona;
	}

	public Boolean getActivarid_vendedorVendedorZona() {
		return this.activarid_vendedorVendedorZona;
	}

	public void setActivarid_vendedorVendedorZona(Boolean activarid_vendedorVendedorZona) {
		this.activarid_vendedorVendedorZona= activarid_vendedorVendedorZona;
	}

	public Boolean getCargarid_vendedorVendedorZona() {
		return this.cargarid_vendedorVendedorZona;
	}

	public void setCargarid_vendedorVendedorZona(Boolean cargarid_vendedorVendedorZona) {
		this.cargarid_vendedorVendedorZona= cargarid_vendedorVendedorZona;
	}

	public Border setResaltarid_zonaVendedorZona(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorZonaBeanSwingJInternalFrame vendedorzonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorzonaBeanSwingJInternalFrame.jTtoolBarVendedorZona.setBorder(borderResaltar);
		
		this.resaltarid_zonaVendedorZona= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaVendedorZona() {
		return this.resaltarid_zonaVendedorZona;
	}

	public void setResaltarid_zonaVendedorZona(Border borderResaltar) {
		this.resaltarid_zonaVendedorZona= borderResaltar;
	}

	public Boolean getMostrarid_zonaVendedorZona() {
		return this.mostrarid_zonaVendedorZona;
	}

	public void setMostrarid_zonaVendedorZona(Boolean mostrarid_zonaVendedorZona) {
		this.mostrarid_zonaVendedorZona= mostrarid_zonaVendedorZona;
	}

	public Boolean getActivarid_zonaVendedorZona() {
		return this.activarid_zonaVendedorZona;
	}

	public void setActivarid_zonaVendedorZona(Boolean activarid_zonaVendedorZona) {
		this.activarid_zonaVendedorZona= activarid_zonaVendedorZona;
	}

	public Boolean getCargarid_zonaVendedorZona() {
		return this.cargarid_zonaVendedorZona;
	}

	public void setCargarid_zonaVendedorZona(Boolean cargarid_zonaVendedorZona) {
		this.cargarid_zonaVendedorZona= cargarid_zonaVendedorZona;
	}

	public Border setResaltarobservacionVendedorZona(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorZonaBeanSwingJInternalFrame vendedorzonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//vendedorzonaBeanSwingJInternalFrame.jTtoolBarVendedorZona.setBorder(borderResaltar);
		
		this.resaltarobservacionVendedorZona= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionVendedorZona() {
		return this.resaltarobservacionVendedorZona;
	}

	public void setResaltarobservacionVendedorZona(Border borderResaltar) {
		this.resaltarobservacionVendedorZona= borderResaltar;
	}

	public Boolean getMostrarobservacionVendedorZona() {
		return this.mostrarobservacionVendedorZona;
	}

	public void setMostrarobservacionVendedorZona(Boolean mostrarobservacionVendedorZona) {
		this.mostrarobservacionVendedorZona= mostrarobservacionVendedorZona;
	}

	public Boolean getActivarobservacionVendedorZona() {
		return this.activarobservacionVendedorZona;
	}

	public void setActivarobservacionVendedorZona(Boolean activarobservacionVendedorZona) {
		this.activarobservacionVendedorZona= activarobservacionVendedorZona;
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
		
		
		this.setMostraridVendedorZona(esInicial);
		this.setMostrarid_empresaVendedorZona(esInicial);
		this.setMostrarid_sucursalVendedorZona(esInicial);
		this.setMostrarid_vendedorVendedorZona(esInicial);
		this.setMostrarid_zonaVendedorZona(esInicial);
		this.setMostrarobservacionVendedorZona(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VendedorZonaConstantesFunciones.ID)) {
				this.setMostraridVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionVendedorZona(esAsigna);
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
		
		
		this.setActivaridVendedorZona(esInicial);
		this.setActivarid_empresaVendedorZona(esInicial);
		this.setActivarid_sucursalVendedorZona(esInicial);
		this.setActivarid_vendedorVendedorZona(esInicial);
		this.setActivarid_zonaVendedorZona(esInicial);
		this.setActivarobservacionVendedorZona(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VendedorZonaConstantesFunciones.ID)) {
				this.setActivaridVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionVendedorZona(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VendedorZonaBeanSwingJInternalFrame vendedorzonaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVendedorZona(esInicial);
		this.setResaltarid_empresaVendedorZona(esInicial);
		this.setResaltarid_sucursalVendedorZona(esInicial);
		this.setResaltarid_vendedorVendedorZona(esInicial);
		this.setResaltarid_zonaVendedorZona(esInicial);
		this.setResaltarobservacionVendedorZona(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VendedorZonaConstantesFunciones.ID)) {
				this.setResaltaridVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaVendedorZona(esAsigna);
				continue;
			}

			if(campo.clase.equals(VendedorZonaConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionVendedorZona(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VendedorZonaBeanSwingJInternalFrame vendedorzonaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaVendedorZona=true;

	public Boolean getMostrarFK_IdEmpresaVendedorZona() {
		return this.mostrarFK_IdEmpresaVendedorZona;
	}

	public void setMostrarFK_IdEmpresaVendedorZona(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaVendedorZona= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalVendedorZona=true;

	public Boolean getMostrarFK_IdSucursalVendedorZona() {
		return this.mostrarFK_IdSucursalVendedorZona;
	}

	public void setMostrarFK_IdSucursalVendedorZona(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalVendedorZona= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorVendedorZona=true;

	public Boolean getMostrarFK_IdVendedorVendedorZona() {
		return this.mostrarFK_IdVendedorVendedorZona;
	}

	public void setMostrarFK_IdVendedorVendedorZona(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorVendedorZona= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdZonaVendedorZona=true;

	public Boolean getMostrarFK_IdZonaVendedorZona() {
		return this.mostrarFK_IdZonaVendedorZona;
	}

	public void setMostrarFK_IdZonaVendedorZona(Boolean visibilidadResaltar) {
		this.mostrarFK_IdZonaVendedorZona= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaVendedorZona=true;

	public Boolean getActivarFK_IdEmpresaVendedorZona() {
		return this.activarFK_IdEmpresaVendedorZona;
	}

	public void setActivarFK_IdEmpresaVendedorZona(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaVendedorZona= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalVendedorZona=true;

	public Boolean getActivarFK_IdSucursalVendedorZona() {
		return this.activarFK_IdSucursalVendedorZona;
	}

	public void setActivarFK_IdSucursalVendedorZona(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalVendedorZona= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorVendedorZona=true;

	public Boolean getActivarFK_IdVendedorVendedorZona() {
		return this.activarFK_IdVendedorVendedorZona;
	}

	public void setActivarFK_IdVendedorVendedorZona(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorVendedorZona= habilitarResaltar;
	}

	public Boolean activarFK_IdZonaVendedorZona=true;

	public Boolean getActivarFK_IdZonaVendedorZona() {
		return this.activarFK_IdZonaVendedorZona;
	}

	public void setActivarFK_IdZonaVendedorZona(Boolean habilitarResaltar) {
		this.activarFK_IdZonaVendedorZona= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaVendedorZona=null;

	public Border getResaltarFK_IdEmpresaVendedorZona() {
		return this.resaltarFK_IdEmpresaVendedorZona;
	}

	public void setResaltarFK_IdEmpresaVendedorZona(Border borderResaltar) {
		this.resaltarFK_IdEmpresaVendedorZona= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaVendedorZona(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorZonaBeanSwingJInternalFrame vendedorzonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaVendedorZona= borderResaltar;
	}

	public Border resaltarFK_IdSucursalVendedorZona=null;

	public Border getResaltarFK_IdSucursalVendedorZona() {
		return this.resaltarFK_IdSucursalVendedorZona;
	}

	public void setResaltarFK_IdSucursalVendedorZona(Border borderResaltar) {
		this.resaltarFK_IdSucursalVendedorZona= borderResaltar;
	}

	public void setResaltarFK_IdSucursalVendedorZona(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorZonaBeanSwingJInternalFrame vendedorzonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalVendedorZona= borderResaltar;
	}

	public Border resaltarFK_IdVendedorVendedorZona=null;

	public Border getResaltarFK_IdVendedorVendedorZona() {
		return this.resaltarFK_IdVendedorVendedorZona;
	}

	public void setResaltarFK_IdVendedorVendedorZona(Border borderResaltar) {
		this.resaltarFK_IdVendedorVendedorZona= borderResaltar;
	}

	public void setResaltarFK_IdVendedorVendedorZona(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorZonaBeanSwingJInternalFrame vendedorzonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorVendedorZona= borderResaltar;
	}

	public Border resaltarFK_IdZonaVendedorZona=null;

	public Border getResaltarFK_IdZonaVendedorZona() {
		return this.resaltarFK_IdZonaVendedorZona;
	}

	public void setResaltarFK_IdZonaVendedorZona(Border borderResaltar) {
		this.resaltarFK_IdZonaVendedorZona= borderResaltar;
	}

	public void setResaltarFK_IdZonaVendedorZona(ParametroGeneralUsuario parametroGeneralUsuario/*VendedorZonaBeanSwingJInternalFrame vendedorzonaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdZonaVendedorZona= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}