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


import com.bydan.erp.facturacion.util.PoliticaFactuConstantesFunciones;
import com.bydan.erp.facturacion.util.PoliticaFactuParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.PoliticaFactuParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PoliticaFactuConstantesFunciones extends PoliticaFactuConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PoliticaFactu";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PoliticaFactu"+PoliticaFactuConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PoliticaFactuHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PoliticaFactuHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PoliticaFactuConstantesFunciones.SCHEMA+"_"+PoliticaFactuConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PoliticaFactuHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PoliticaFactuConstantesFunciones.SCHEMA+"_"+PoliticaFactuConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PoliticaFactuConstantesFunciones.SCHEMA+"_"+PoliticaFactuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PoliticaFactuHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PoliticaFactuConstantesFunciones.SCHEMA+"_"+PoliticaFactuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticaFactuConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PoliticaFactuHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticaFactuConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticaFactuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PoliticaFactuHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticaFactuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PoliticaFactuConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PoliticaFactuConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PoliticaFactuConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PoliticaFactuConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Politica Factus";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Politica Factu";
	public static final String SCLASSWEBTITULO_LOWER="Politica Factu";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PoliticaFactu";
	public static final String OBJECTNAME="politicafactu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="politica_factu";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select politicafactu from "+PoliticaFactuConstantesFunciones.SPERSISTENCENAME+" politicafactu";
	public static String QUERYSELECTNATIVE="select "+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".id,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".version_row,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".id_empresa,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".id_sucursal,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".id_producto,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".id_grupo_cliente,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".nombre,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".fecha_desde,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".fecha_hasta,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".porcentaje,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".valor,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".con_banco_cliente,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".con_banco_producto,"+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME+".es_activo from "+PoliticaFactuConstantesFunciones.SCHEMA+"."+PoliticaFactuConstantesFunciones.TABLENAME;//+" as "+PoliticaFactuConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PoliticaFactuConstantesFuncionesAdditional politicafactuConstantesFuncionesAdditional=null;
	
	public PoliticaFactuConstantesFuncionesAdditional getPoliticaFactuConstantesFuncionesAdditional() {
		return this.politicafactuConstantesFuncionesAdditional;
	}
	
	public void setPoliticaFactuConstantesFuncionesAdditional(PoliticaFactuConstantesFuncionesAdditional politicafactuConstantesFuncionesAdditional) {
		try {
			this.politicafactuConstantesFuncionesAdditional=politicafactuConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDGRUPOCLIENTE= "id_grupo_cliente";
    public static final String NOMBRE= "nombre";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALOR= "valor";
    public static final String CONBANCOCLIENTE= "con_banco_cliente";
    public static final String CONBANCOPRODUCTO= "con_banco_producto";
    public static final String ESACTIVO= "es_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDGRUPOCLIENTE= "Grupo Cliente";
		public static final String LABEL_IDGRUPOCLIENTE_LOWER= "Grupo Cliente";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_CONBANCOCLIENTE= "Con Banco Cliente";
		public static final String LABEL_CONBANCOCLIENTE_LOWER= "Con Banco Cliente";
    	public static final String LABEL_CONBANCOPRODUCTO= "Con Banco Producto";
		public static final String LABEL_CONBANCOPRODUCTO_LOWER= "Con Banco Producto";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	
	public static String getPoliticaFactuLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PoliticaFactuConstantesFunciones.IDEMPRESA)) {sLabelColumna=PoliticaFactuConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PoliticaFactuConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PoliticaFactuConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PoliticaFactuConstantesFunciones.IDPRODUCTO)) {sLabelColumna=PoliticaFactuConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(PoliticaFactuConstantesFunciones.IDGRUPOCLIENTE)) {sLabelColumna=PoliticaFactuConstantesFunciones.LABEL_IDGRUPOCLIENTE;}
		if(sNombreColumna.equals(PoliticaFactuConstantesFunciones.NOMBRE)) {sLabelColumna=PoliticaFactuConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(PoliticaFactuConstantesFunciones.FECHADESDE)) {sLabelColumna=PoliticaFactuConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(PoliticaFactuConstantesFunciones.FECHAHASTA)) {sLabelColumna=PoliticaFactuConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(PoliticaFactuConstantesFunciones.PORCENTAJE)) {sLabelColumna=PoliticaFactuConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(PoliticaFactuConstantesFunciones.VALOR)) {sLabelColumna=PoliticaFactuConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(PoliticaFactuConstantesFunciones.CONBANCOCLIENTE)) {sLabelColumna=PoliticaFactuConstantesFunciones.LABEL_CONBANCOCLIENTE;}
		if(sNombreColumna.equals(PoliticaFactuConstantesFunciones.CONBANCOPRODUCTO)) {sLabelColumna=PoliticaFactuConstantesFunciones.LABEL_CONBANCOPRODUCTO;}
		if(sNombreColumna.equals(PoliticaFactuConstantesFunciones.ESACTIVO)) {sLabelColumna=PoliticaFactuConstantesFunciones.LABEL_ESACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_banco_clienteDescripcion(PoliticaFactu politicafactu) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!politicafactu.getcon_banco_cliente()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_banco_clienteHtmlDescripcion(PoliticaFactu politicafactu) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(politicafactu.getId(),politicafactu.getcon_banco_cliente());

		return sDescripcion;
	}	
		
	public static String getcon_banco_productoDescripcion(PoliticaFactu politicafactu) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!politicafactu.getcon_banco_producto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_banco_productoHtmlDescripcion(PoliticaFactu politicafactu) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(politicafactu.getId(),politicafactu.getcon_banco_producto());

		return sDescripcion;
	}	
		
	public static String getes_activoDescripcion(PoliticaFactu politicafactu) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!politicafactu.getes_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_activoHtmlDescripcion(PoliticaFactu politicafactu) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(politicafactu.getId(),politicafactu.getes_activo());

		return sDescripcion;
	}	
	
	public static String getPoliticaFactuDescripcion(PoliticaFactu politicafactu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(politicafactu !=null/* && politicafactu.getId()!=0*/) {
			sDescripcion=politicafactu.getnombre();//politicafactupoliticafactu.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPoliticaFactuDescripcionDetallado(PoliticaFactu politicafactu) {
		String sDescripcion="";
			
		sDescripcion+=PoliticaFactuConstantesFunciones.ID+"=";
		sDescripcion+=politicafactu.getId().toString()+",";
		sDescripcion+=PoliticaFactuConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=politicafactu.getVersionRow().toString()+",";
		sDescripcion+=PoliticaFactuConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=politicafactu.getid_empresa().toString()+",";
		sDescripcion+=PoliticaFactuConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=politicafactu.getid_sucursal().toString()+",";
		sDescripcion+=PoliticaFactuConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=politicafactu.getid_producto().toString()+",";
		sDescripcion+=PoliticaFactuConstantesFunciones.IDGRUPOCLIENTE+"=";
		sDescripcion+=politicafactu.getid_grupo_cliente().toString()+",";
		sDescripcion+=PoliticaFactuConstantesFunciones.NOMBRE+"=";
		sDescripcion+=politicafactu.getnombre()+",";
		sDescripcion+=PoliticaFactuConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=politicafactu.getfecha_desde().toString()+",";
		sDescripcion+=PoliticaFactuConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=politicafactu.getfecha_hasta().toString()+",";
		sDescripcion+=PoliticaFactuConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=politicafactu.getporcentaje().toString()+",";
		sDescripcion+=PoliticaFactuConstantesFunciones.VALOR+"=";
		sDescripcion+=politicafactu.getvalor().toString()+",";
		sDescripcion+=PoliticaFactuConstantesFunciones.CONBANCOCLIENTE+"=";
		sDescripcion+=politicafactu.getcon_banco_cliente().toString()+",";
		sDescripcion+=PoliticaFactuConstantesFunciones.CONBANCOPRODUCTO+"=";
		sDescripcion+=politicafactu.getcon_banco_producto().toString()+",";
		sDescripcion+=PoliticaFactuConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=politicafactu.getes_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPoliticaFactuDescripcion(PoliticaFactu politicafactu,String sValor) throws Exception {			
		if(politicafactu !=null) {
			politicafactu.setnombre(sValor);;//politicafactupoliticafactu.getnombre().trim();
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

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}

	public static String getGrupoClienteDescripcion(GrupoCliente grupocliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupocliente!=null/*&&grupocliente.getId()>0*/) {
			sDescripcion=GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(grupocliente);
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
		} else if(sNombreIndice.equals("FK_IdGrupoCliente")) {
			sNombreIndice="Tipo=  Por Grupo Cliente";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdGrupoCliente(Long id_grupo_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPoliticaFactu(PoliticaFactu politicafactu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		politicafactu.setnombre(politicafactu.getnombre().trim());
	}
	
	public static void quitarEspaciosPoliticaFactus(List<PoliticaFactu> politicafactus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PoliticaFactu politicafactu: politicafactus) {
			politicafactu.setnombre(politicafactu.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPoliticaFactu(PoliticaFactu politicafactu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && politicafactu.getConCambioAuxiliar()) {
			politicafactu.setIsDeleted(politicafactu.getIsDeletedAuxiliar());	
			politicafactu.setIsNew(politicafactu.getIsNewAuxiliar());	
			politicafactu.setIsChanged(politicafactu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			politicafactu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			politicafactu.setIsDeletedAuxiliar(false);	
			politicafactu.setIsNewAuxiliar(false);	
			politicafactu.setIsChangedAuxiliar(false);
			
			politicafactu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPoliticaFactus(List<PoliticaFactu> politicafactus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PoliticaFactu politicafactu : politicafactus) {
			if(conAsignarBase && politicafactu.getConCambioAuxiliar()) {
				politicafactu.setIsDeleted(politicafactu.getIsDeletedAuxiliar());	
				politicafactu.setIsNew(politicafactu.getIsNewAuxiliar());	
				politicafactu.setIsChanged(politicafactu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				politicafactu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				politicafactu.setIsDeletedAuxiliar(false);	
				politicafactu.setIsNewAuxiliar(false);	
				politicafactu.setIsChangedAuxiliar(false);
				
				politicafactu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPoliticaFactu(PoliticaFactu politicafactu,Boolean conEnteros) throws Exception  {
		politicafactu.setporcentaje(0.0);
		politicafactu.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPoliticaFactus(List<PoliticaFactu> politicafactus,Boolean conEnteros) throws Exception  {
		
		for(PoliticaFactu politicafactu: politicafactus) {
			politicafactu.setporcentaje(0.0);
			politicafactu.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPoliticaFactu(List<PoliticaFactu> politicafactus,PoliticaFactu politicafactuAux) throws Exception  {
		PoliticaFactuConstantesFunciones.InicializarValoresPoliticaFactu(politicafactuAux,true);
		
		for(PoliticaFactu politicafactu: politicafactus) {
			if(politicafactu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			politicafactuAux.setporcentaje(politicafactuAux.getporcentaje()+politicafactu.getporcentaje());			
			politicafactuAux.setvalor(politicafactuAux.getvalor()+politicafactu.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPoliticaFactu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PoliticaFactuConstantesFunciones.getArrayColumnasGlobalesPoliticaFactu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPoliticaFactu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PoliticaFactuConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PoliticaFactuConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PoliticaFactuConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PoliticaFactuConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPoliticaFactu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PoliticaFactu> politicafactus,PoliticaFactu politicafactu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PoliticaFactu politicafactuAux: politicafactus) {
			if(politicafactuAux!=null && politicafactu!=null) {
				if((politicafactuAux.getId()==null && politicafactu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(politicafactuAux.getId()!=null && politicafactu.getId()!=null){
					if(politicafactuAux.getId().equals(politicafactu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPoliticaFactu(List<PoliticaFactu> politicafactus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
	
		for(PoliticaFactu politicafactu: politicafactus) {			
			if(politicafactu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=politicafactu.getporcentaje();
			valorTotal+=politicafactu.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PoliticaFactuConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(PoliticaFactuConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PoliticaFactuConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(PoliticaFactuConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPoliticaFactu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PoliticaFactuConstantesFunciones.LABEL_ID, PoliticaFactuConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaFactuConstantesFunciones.LABEL_VERSIONROW, PoliticaFactuConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaFactuConstantesFunciones.LABEL_IDEMPRESA, PoliticaFactuConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaFactuConstantesFunciones.LABEL_IDSUCURSAL, PoliticaFactuConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaFactuConstantesFunciones.LABEL_IDPRODUCTO, PoliticaFactuConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaFactuConstantesFunciones.LABEL_IDGRUPOCLIENTE, PoliticaFactuConstantesFunciones.IDGRUPOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaFactuConstantesFunciones.LABEL_NOMBRE, PoliticaFactuConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaFactuConstantesFunciones.LABEL_FECHADESDE, PoliticaFactuConstantesFunciones.FECHADESDE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaFactuConstantesFunciones.LABEL_FECHAHASTA, PoliticaFactuConstantesFunciones.FECHAHASTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaFactuConstantesFunciones.LABEL_PORCENTAJE, PoliticaFactuConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaFactuConstantesFunciones.LABEL_VALOR, PoliticaFactuConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaFactuConstantesFunciones.LABEL_CONBANCOCLIENTE, PoliticaFactuConstantesFunciones.CONBANCOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaFactuConstantesFunciones.LABEL_CONBANCOPRODUCTO, PoliticaFactuConstantesFunciones.CONBANCOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticaFactuConstantesFunciones.LABEL_ESACTIVO, PoliticaFactuConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPoliticaFactu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PoliticaFactuConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaFactuConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaFactuConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaFactuConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaFactuConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaFactuConstantesFunciones.IDGRUPOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaFactuConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaFactuConstantesFunciones.FECHADESDE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaFactuConstantesFunciones.FECHAHASTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaFactuConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaFactuConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaFactuConstantesFunciones.CONBANCOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaFactuConstantesFunciones.CONBANCOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticaFactuConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPoliticaFactu() throws Exception  {
		return PoliticaFactuConstantesFunciones.getTiposSeleccionarPoliticaFactu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPoliticaFactu(Boolean conFk) throws Exception  {
		return PoliticaFactuConstantesFunciones.getTiposSeleccionarPoliticaFactu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPoliticaFactu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaFactuConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PoliticaFactuConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaFactuConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PoliticaFactuConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaFactuConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(PoliticaFactuConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaFactuConstantesFunciones.LABEL_IDGRUPOCLIENTE);
			reporte.setsDescripcion(PoliticaFactuConstantesFunciones.LABEL_IDGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaFactuConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PoliticaFactuConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaFactuConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(PoliticaFactuConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaFactuConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(PoliticaFactuConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaFactuConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(PoliticaFactuConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaFactuConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(PoliticaFactuConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaFactuConstantesFunciones.LABEL_CONBANCOCLIENTE);
			reporte.setsDescripcion(PoliticaFactuConstantesFunciones.LABEL_CONBANCOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaFactuConstantesFunciones.LABEL_CONBANCOPRODUCTO);
			reporte.setsDescripcion(PoliticaFactuConstantesFunciones.LABEL_CONBANCOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticaFactuConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(PoliticaFactuConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPoliticaFactu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPoliticaFactu(PoliticaFactu politicafactuAux) throws Exception {
		
			politicafactuAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(politicafactuAux.getEmpresa()));
			politicafactuAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(politicafactuAux.getSucursal()));
			politicafactuAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(politicafactuAux.getProducto()));
			politicafactuAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(politicafactuAux.getGrupoCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPoliticaFactu(List<PoliticaFactu> politicafactusTemp) throws Exception {
		for(PoliticaFactu politicafactuAux:politicafactusTemp) {
			
			politicafactuAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(politicafactuAux.getEmpresa()));
			politicafactuAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(politicafactuAux.getSucursal()));
			politicafactuAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(politicafactuAux.getProducto()));
			politicafactuAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(politicafactuAux.getGrupoCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPoliticaFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(GrupoCliente.class));
				
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
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoCliente.class)) {
						classes.add(new Classe(GrupoCliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPoliticaFactu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
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

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPoliticaFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PoliticaFactuConstantesFunciones.getClassesRelationshipsOfPoliticaFactu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPoliticaFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPoliticaFactu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PoliticaFactuConstantesFunciones.getClassesRelationshipsFromStringsOfPoliticaFactu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPoliticaFactu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PoliticaFactu politicafactu,List<PoliticaFactu> politicafactus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PoliticaFactu politicafactuEncontrado=null;
			
			for(PoliticaFactu politicafactuLocal:politicafactus) {
				if(politicafactuLocal.getId().equals(politicafactu.getId())) {
					politicafactuEncontrado=politicafactuLocal;
					
					politicafactuLocal.setIsChanged(politicafactu.getIsChanged());
					politicafactuLocal.setIsNew(politicafactu.getIsNew());
					politicafactuLocal.setIsDeleted(politicafactu.getIsDeleted());
					
					politicafactuLocal.setGeneralEntityOriginal(politicafactu.getGeneralEntityOriginal());
					
					politicafactuLocal.setId(politicafactu.getId());	
					politicafactuLocal.setVersionRow(politicafactu.getVersionRow());	
					politicafactuLocal.setid_empresa(politicafactu.getid_empresa());	
					politicafactuLocal.setid_sucursal(politicafactu.getid_sucursal());	
					politicafactuLocal.setid_producto(politicafactu.getid_producto());	
					politicafactuLocal.setid_grupo_cliente(politicafactu.getid_grupo_cliente());	
					politicafactuLocal.setnombre(politicafactu.getnombre());	
					politicafactuLocal.setfecha_desde(politicafactu.getfecha_desde());	
					politicafactuLocal.setfecha_hasta(politicafactu.getfecha_hasta());	
					politicafactuLocal.setporcentaje(politicafactu.getporcentaje());	
					politicafactuLocal.setvalor(politicafactu.getvalor());	
					politicafactuLocal.setcon_banco_cliente(politicafactu.getcon_banco_cliente());	
					politicafactuLocal.setcon_banco_producto(politicafactu.getcon_banco_producto());	
					politicafactuLocal.setes_activo(politicafactu.getes_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!politicafactu.getIsDeleted()) {
				if(!existe) {
					politicafactus.add(politicafactu);
				}
			} else {
				if(politicafactuEncontrado!=null && permiteQuitar)  {
					politicafactus.remove(politicafactuEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PoliticaFactu politicafactu,List<PoliticaFactu> politicafactus) throws Exception {
		try	{			
			for(PoliticaFactu politicafactuLocal:politicafactus) {
				if(politicafactuLocal.getId().equals(politicafactu.getId())) {
					politicafactuLocal.setIsSelected(politicafactu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPoliticaFactu(List<PoliticaFactu> politicafactusAux) throws Exception {
		//this.politicafactusAux=politicafactusAux;
		
		for(PoliticaFactu politicafactuAux:politicafactusAux) {
			if(politicafactuAux.getIsChanged()) {
				politicafactuAux.setIsChanged(false);
			}		
			
			if(politicafactuAux.getIsNew()) {
				politicafactuAux.setIsNew(false);
			}	
			
			if(politicafactuAux.getIsDeleted()) {
				politicafactuAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPoliticaFactu(PoliticaFactu politicafactuAux) throws Exception {
		//this.politicafactuAux=politicafactuAux;
		
			if(politicafactuAux.getIsChanged()) {
				politicafactuAux.setIsChanged(false);
			}		
			
			if(politicafactuAux.getIsNew()) {
				politicafactuAux.setIsNew(false);
			}	
			
			if(politicafactuAux.getIsDeleted()) {
				politicafactuAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PoliticaFactu politicafactuAsignar,PoliticaFactu politicafactu) throws Exception {
		politicafactuAsignar.setId(politicafactu.getId());	
		politicafactuAsignar.setVersionRow(politicafactu.getVersionRow());	
		politicafactuAsignar.setid_empresa(politicafactu.getid_empresa());
		politicafactuAsignar.setempresa_descripcion(politicafactu.getempresa_descripcion());	
		politicafactuAsignar.setid_sucursal(politicafactu.getid_sucursal());
		politicafactuAsignar.setsucursal_descripcion(politicafactu.getsucursal_descripcion());	
		politicafactuAsignar.setid_producto(politicafactu.getid_producto());
		politicafactuAsignar.setproducto_descripcion(politicafactu.getproducto_descripcion());	
		politicafactuAsignar.setid_grupo_cliente(politicafactu.getid_grupo_cliente());
		politicafactuAsignar.setgrupocliente_descripcion(politicafactu.getgrupocliente_descripcion());	
		politicafactuAsignar.setnombre(politicafactu.getnombre());	
		politicafactuAsignar.setfecha_desde(politicafactu.getfecha_desde());	
		politicafactuAsignar.setfecha_hasta(politicafactu.getfecha_hasta());	
		politicafactuAsignar.setporcentaje(politicafactu.getporcentaje());	
		politicafactuAsignar.setvalor(politicafactu.getvalor());	
		politicafactuAsignar.setcon_banco_cliente(politicafactu.getcon_banco_cliente());	
		politicafactuAsignar.setcon_banco_producto(politicafactu.getcon_banco_producto());	
		politicafactuAsignar.setes_activo(politicafactu.getes_activo());	
	}
	
	public static void inicializarPoliticaFactu(PoliticaFactu politicafactu) throws Exception {
		try {
				politicafactu.setId(0L);	
					
				politicafactu.setid_empresa(-1L);	
				politicafactu.setid_sucursal(-1L);	
				politicafactu.setid_producto(-1L);	
				politicafactu.setid_grupo_cliente(-1L);	
				politicafactu.setnombre("");	
				politicafactu.setfecha_desde(new Date());	
				politicafactu.setfecha_hasta(new Date());	
				politicafactu.setporcentaje(0.0);	
				politicafactu.setvalor(0.0);	
				politicafactu.setcon_banco_cliente(false);	
				politicafactu.setcon_banco_producto(false);	
				politicafactu.setes_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPoliticaFactu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaFactuConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaFactuConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaFactuConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaFactuConstantesFunciones.LABEL_IDGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaFactuConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaFactuConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaFactuConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaFactuConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaFactuConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaFactuConstantesFunciones.LABEL_CONBANCOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaFactuConstantesFunciones.LABEL_CONBANCOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticaFactuConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPoliticaFactu(String sTipo,Row row,Workbook workbook,PoliticaFactu politicafactu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(politicafactu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicafactu.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicafactu.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicafactu.getgrupocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicafactu.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicafactu.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicafactu.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicafactu.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicafactu.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(politicafactu.getcon_banco_cliente()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(politicafactu.getcon_banco_producto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(politicafactu.getes_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPoliticaFactu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPoliticaFactu() {
		return this.sFinalQueryPoliticaFactu;
	}
	
	public void setsFinalQueryPoliticaFactu(String sFinalQueryPoliticaFactu) {
		this.sFinalQueryPoliticaFactu= sFinalQueryPoliticaFactu;
	}
	
	public Border resaltarSeleccionarPoliticaFactu=null;
	
	public Border setResaltarSeleccionarPoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//politicafactuBeanSwingJInternalFrame.jTtoolBarPoliticaFactu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPoliticaFactu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPoliticaFactu() {
		return this.resaltarSeleccionarPoliticaFactu;
	}
	
	public void setResaltarSeleccionarPoliticaFactu(Border borderResaltarSeleccionarPoliticaFactu) {
		this.resaltarSeleccionarPoliticaFactu= borderResaltarSeleccionarPoliticaFactu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPoliticaFactu=null;
	public Boolean mostraridPoliticaFactu=true;
	public Boolean activaridPoliticaFactu=true;

	public Border resaltarid_empresaPoliticaFactu=null;
	public Boolean mostrarid_empresaPoliticaFactu=true;
	public Boolean activarid_empresaPoliticaFactu=true;
	public Boolean cargarid_empresaPoliticaFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPoliticaFactu=false;//ConEventDepend=true

	public Border resaltarid_sucursalPoliticaFactu=null;
	public Boolean mostrarid_sucursalPoliticaFactu=true;
	public Boolean activarid_sucursalPoliticaFactu=true;
	public Boolean cargarid_sucursalPoliticaFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPoliticaFactu=false;//ConEventDepend=true

	public Border resaltarid_productoPoliticaFactu=null;
	public Boolean mostrarid_productoPoliticaFactu=true;
	public Boolean activarid_productoPoliticaFactu=true;
	public Boolean cargarid_productoPoliticaFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoPoliticaFactu=false;//ConEventDepend=true

	public Border resaltarid_grupo_clientePoliticaFactu=null;
	public Boolean mostrarid_grupo_clientePoliticaFactu=true;
	public Boolean activarid_grupo_clientePoliticaFactu=true;
	public Boolean cargarid_grupo_clientePoliticaFactu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_clientePoliticaFactu=false;//ConEventDepend=true

	public Border resaltarnombrePoliticaFactu=null;
	public Boolean mostrarnombrePoliticaFactu=true;
	public Boolean activarnombrePoliticaFactu=true;

	public Border resaltarfecha_desdePoliticaFactu=null;
	public Boolean mostrarfecha_desdePoliticaFactu=true;
	public Boolean activarfecha_desdePoliticaFactu=false;

	public Border resaltarfecha_hastaPoliticaFactu=null;
	public Boolean mostrarfecha_hastaPoliticaFactu=true;
	public Boolean activarfecha_hastaPoliticaFactu=false;

	public Border resaltarporcentajePoliticaFactu=null;
	public Boolean mostrarporcentajePoliticaFactu=true;
	public Boolean activarporcentajePoliticaFactu=true;

	public Border resaltarvalorPoliticaFactu=null;
	public Boolean mostrarvalorPoliticaFactu=true;
	public Boolean activarvalorPoliticaFactu=true;

	public Border resaltarcon_banco_clientePoliticaFactu=null;
	public Boolean mostrarcon_banco_clientePoliticaFactu=true;
	public Boolean activarcon_banco_clientePoliticaFactu=true;

	public Border resaltarcon_banco_productoPoliticaFactu=null;
	public Boolean mostrarcon_banco_productoPoliticaFactu=true;
	public Boolean activarcon_banco_productoPoliticaFactu=true;

	public Border resaltares_activoPoliticaFactu=null;
	public Boolean mostrares_activoPoliticaFactu=true;
	public Boolean activares_activoPoliticaFactu=true;

	
	

	public Border setResaltaridPoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicafactuBeanSwingJInternalFrame.jTtoolBarPoliticaFactu.setBorder(borderResaltar);
		
		this.resaltaridPoliticaFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPoliticaFactu() {
		return this.resaltaridPoliticaFactu;
	}

	public void setResaltaridPoliticaFactu(Border borderResaltar) {
		this.resaltaridPoliticaFactu= borderResaltar;
	}

	public Boolean getMostraridPoliticaFactu() {
		return this.mostraridPoliticaFactu;
	}

	public void setMostraridPoliticaFactu(Boolean mostraridPoliticaFactu) {
		this.mostraridPoliticaFactu= mostraridPoliticaFactu;
	}

	public Boolean getActivaridPoliticaFactu() {
		return this.activaridPoliticaFactu;
	}

	public void setActivaridPoliticaFactu(Boolean activaridPoliticaFactu) {
		this.activaridPoliticaFactu= activaridPoliticaFactu;
	}

	public Border setResaltarid_empresaPoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicafactuBeanSwingJInternalFrame.jTtoolBarPoliticaFactu.setBorder(borderResaltar);
		
		this.resaltarid_empresaPoliticaFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPoliticaFactu() {
		return this.resaltarid_empresaPoliticaFactu;
	}

	public void setResaltarid_empresaPoliticaFactu(Border borderResaltar) {
		this.resaltarid_empresaPoliticaFactu= borderResaltar;
	}

	public Boolean getMostrarid_empresaPoliticaFactu() {
		return this.mostrarid_empresaPoliticaFactu;
	}

	public void setMostrarid_empresaPoliticaFactu(Boolean mostrarid_empresaPoliticaFactu) {
		this.mostrarid_empresaPoliticaFactu= mostrarid_empresaPoliticaFactu;
	}

	public Boolean getActivarid_empresaPoliticaFactu() {
		return this.activarid_empresaPoliticaFactu;
	}

	public void setActivarid_empresaPoliticaFactu(Boolean activarid_empresaPoliticaFactu) {
		this.activarid_empresaPoliticaFactu= activarid_empresaPoliticaFactu;
	}

	public Boolean getCargarid_empresaPoliticaFactu() {
		return this.cargarid_empresaPoliticaFactu;
	}

	public void setCargarid_empresaPoliticaFactu(Boolean cargarid_empresaPoliticaFactu) {
		this.cargarid_empresaPoliticaFactu= cargarid_empresaPoliticaFactu;
	}

	public Border setResaltarid_sucursalPoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicafactuBeanSwingJInternalFrame.jTtoolBarPoliticaFactu.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPoliticaFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPoliticaFactu() {
		return this.resaltarid_sucursalPoliticaFactu;
	}

	public void setResaltarid_sucursalPoliticaFactu(Border borderResaltar) {
		this.resaltarid_sucursalPoliticaFactu= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPoliticaFactu() {
		return this.mostrarid_sucursalPoliticaFactu;
	}

	public void setMostrarid_sucursalPoliticaFactu(Boolean mostrarid_sucursalPoliticaFactu) {
		this.mostrarid_sucursalPoliticaFactu= mostrarid_sucursalPoliticaFactu;
	}

	public Boolean getActivarid_sucursalPoliticaFactu() {
		return this.activarid_sucursalPoliticaFactu;
	}

	public void setActivarid_sucursalPoliticaFactu(Boolean activarid_sucursalPoliticaFactu) {
		this.activarid_sucursalPoliticaFactu= activarid_sucursalPoliticaFactu;
	}

	public Boolean getCargarid_sucursalPoliticaFactu() {
		return this.cargarid_sucursalPoliticaFactu;
	}

	public void setCargarid_sucursalPoliticaFactu(Boolean cargarid_sucursalPoliticaFactu) {
		this.cargarid_sucursalPoliticaFactu= cargarid_sucursalPoliticaFactu;
	}

	public Border setResaltarid_productoPoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicafactuBeanSwingJInternalFrame.jTtoolBarPoliticaFactu.setBorder(borderResaltar);
		
		this.resaltarid_productoPoliticaFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoPoliticaFactu() {
		return this.resaltarid_productoPoliticaFactu;
	}

	public void setResaltarid_productoPoliticaFactu(Border borderResaltar) {
		this.resaltarid_productoPoliticaFactu= borderResaltar;
	}

	public Boolean getMostrarid_productoPoliticaFactu() {
		return this.mostrarid_productoPoliticaFactu;
	}

	public void setMostrarid_productoPoliticaFactu(Boolean mostrarid_productoPoliticaFactu) {
		this.mostrarid_productoPoliticaFactu= mostrarid_productoPoliticaFactu;
	}

	public Boolean getActivarid_productoPoliticaFactu() {
		return this.activarid_productoPoliticaFactu;
	}

	public void setActivarid_productoPoliticaFactu(Boolean activarid_productoPoliticaFactu) {
		this.activarid_productoPoliticaFactu= activarid_productoPoliticaFactu;
	}

	public Boolean getCargarid_productoPoliticaFactu() {
		return this.cargarid_productoPoliticaFactu;
	}

	public void setCargarid_productoPoliticaFactu(Boolean cargarid_productoPoliticaFactu) {
		this.cargarid_productoPoliticaFactu= cargarid_productoPoliticaFactu;
	}

	public Border setResaltarid_grupo_clientePoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicafactuBeanSwingJInternalFrame.jTtoolBarPoliticaFactu.setBorder(borderResaltar);
		
		this.resaltarid_grupo_clientePoliticaFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_clientePoliticaFactu() {
		return this.resaltarid_grupo_clientePoliticaFactu;
	}

	public void setResaltarid_grupo_clientePoliticaFactu(Border borderResaltar) {
		this.resaltarid_grupo_clientePoliticaFactu= borderResaltar;
	}

	public Boolean getMostrarid_grupo_clientePoliticaFactu() {
		return this.mostrarid_grupo_clientePoliticaFactu;
	}

	public void setMostrarid_grupo_clientePoliticaFactu(Boolean mostrarid_grupo_clientePoliticaFactu) {
		this.mostrarid_grupo_clientePoliticaFactu= mostrarid_grupo_clientePoliticaFactu;
	}

	public Boolean getActivarid_grupo_clientePoliticaFactu() {
		return this.activarid_grupo_clientePoliticaFactu;
	}

	public void setActivarid_grupo_clientePoliticaFactu(Boolean activarid_grupo_clientePoliticaFactu) {
		this.activarid_grupo_clientePoliticaFactu= activarid_grupo_clientePoliticaFactu;
	}

	public Boolean getCargarid_grupo_clientePoliticaFactu() {
		return this.cargarid_grupo_clientePoliticaFactu;
	}

	public void setCargarid_grupo_clientePoliticaFactu(Boolean cargarid_grupo_clientePoliticaFactu) {
		this.cargarid_grupo_clientePoliticaFactu= cargarid_grupo_clientePoliticaFactu;
	}

	public Border setResaltarnombrePoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicafactuBeanSwingJInternalFrame.jTtoolBarPoliticaFactu.setBorder(borderResaltar);
		
		this.resaltarnombrePoliticaFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePoliticaFactu() {
		return this.resaltarnombrePoliticaFactu;
	}

	public void setResaltarnombrePoliticaFactu(Border borderResaltar) {
		this.resaltarnombrePoliticaFactu= borderResaltar;
	}

	public Boolean getMostrarnombrePoliticaFactu() {
		return this.mostrarnombrePoliticaFactu;
	}

	public void setMostrarnombrePoliticaFactu(Boolean mostrarnombrePoliticaFactu) {
		this.mostrarnombrePoliticaFactu= mostrarnombrePoliticaFactu;
	}

	public Boolean getActivarnombrePoliticaFactu() {
		return this.activarnombrePoliticaFactu;
	}

	public void setActivarnombrePoliticaFactu(Boolean activarnombrePoliticaFactu) {
		this.activarnombrePoliticaFactu= activarnombrePoliticaFactu;
	}

	public Border setResaltarfecha_desdePoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicafactuBeanSwingJInternalFrame.jTtoolBarPoliticaFactu.setBorder(borderResaltar);
		
		this.resaltarfecha_desdePoliticaFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdePoliticaFactu() {
		return this.resaltarfecha_desdePoliticaFactu;
	}

	public void setResaltarfecha_desdePoliticaFactu(Border borderResaltar) {
		this.resaltarfecha_desdePoliticaFactu= borderResaltar;
	}

	public Boolean getMostrarfecha_desdePoliticaFactu() {
		return this.mostrarfecha_desdePoliticaFactu;
	}

	public void setMostrarfecha_desdePoliticaFactu(Boolean mostrarfecha_desdePoliticaFactu) {
		this.mostrarfecha_desdePoliticaFactu= mostrarfecha_desdePoliticaFactu;
	}

	public Boolean getActivarfecha_desdePoliticaFactu() {
		return this.activarfecha_desdePoliticaFactu;
	}

	public void setActivarfecha_desdePoliticaFactu(Boolean activarfecha_desdePoliticaFactu) {
		this.activarfecha_desdePoliticaFactu= activarfecha_desdePoliticaFactu;
	}

	public Border setResaltarfecha_hastaPoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicafactuBeanSwingJInternalFrame.jTtoolBarPoliticaFactu.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaPoliticaFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaPoliticaFactu() {
		return this.resaltarfecha_hastaPoliticaFactu;
	}

	public void setResaltarfecha_hastaPoliticaFactu(Border borderResaltar) {
		this.resaltarfecha_hastaPoliticaFactu= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaPoliticaFactu() {
		return this.mostrarfecha_hastaPoliticaFactu;
	}

	public void setMostrarfecha_hastaPoliticaFactu(Boolean mostrarfecha_hastaPoliticaFactu) {
		this.mostrarfecha_hastaPoliticaFactu= mostrarfecha_hastaPoliticaFactu;
	}

	public Boolean getActivarfecha_hastaPoliticaFactu() {
		return this.activarfecha_hastaPoliticaFactu;
	}

	public void setActivarfecha_hastaPoliticaFactu(Boolean activarfecha_hastaPoliticaFactu) {
		this.activarfecha_hastaPoliticaFactu= activarfecha_hastaPoliticaFactu;
	}

	public Border setResaltarporcentajePoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicafactuBeanSwingJInternalFrame.jTtoolBarPoliticaFactu.setBorder(borderResaltar);
		
		this.resaltarporcentajePoliticaFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajePoliticaFactu() {
		return this.resaltarporcentajePoliticaFactu;
	}

	public void setResaltarporcentajePoliticaFactu(Border borderResaltar) {
		this.resaltarporcentajePoliticaFactu= borderResaltar;
	}

	public Boolean getMostrarporcentajePoliticaFactu() {
		return this.mostrarporcentajePoliticaFactu;
	}

	public void setMostrarporcentajePoliticaFactu(Boolean mostrarporcentajePoliticaFactu) {
		this.mostrarporcentajePoliticaFactu= mostrarporcentajePoliticaFactu;
	}

	public Boolean getActivarporcentajePoliticaFactu() {
		return this.activarporcentajePoliticaFactu;
	}

	public void setActivarporcentajePoliticaFactu(Boolean activarporcentajePoliticaFactu) {
		this.activarporcentajePoliticaFactu= activarporcentajePoliticaFactu;
	}

	public Border setResaltarvalorPoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicafactuBeanSwingJInternalFrame.jTtoolBarPoliticaFactu.setBorder(borderResaltar);
		
		this.resaltarvalorPoliticaFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorPoliticaFactu() {
		return this.resaltarvalorPoliticaFactu;
	}

	public void setResaltarvalorPoliticaFactu(Border borderResaltar) {
		this.resaltarvalorPoliticaFactu= borderResaltar;
	}

	public Boolean getMostrarvalorPoliticaFactu() {
		return this.mostrarvalorPoliticaFactu;
	}

	public void setMostrarvalorPoliticaFactu(Boolean mostrarvalorPoliticaFactu) {
		this.mostrarvalorPoliticaFactu= mostrarvalorPoliticaFactu;
	}

	public Boolean getActivarvalorPoliticaFactu() {
		return this.activarvalorPoliticaFactu;
	}

	public void setActivarvalorPoliticaFactu(Boolean activarvalorPoliticaFactu) {
		this.activarvalorPoliticaFactu= activarvalorPoliticaFactu;
	}

	public Border setResaltarcon_banco_clientePoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicafactuBeanSwingJInternalFrame.jTtoolBarPoliticaFactu.setBorder(borderResaltar);
		
		this.resaltarcon_banco_clientePoliticaFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_banco_clientePoliticaFactu() {
		return this.resaltarcon_banco_clientePoliticaFactu;
	}

	public void setResaltarcon_banco_clientePoliticaFactu(Border borderResaltar) {
		this.resaltarcon_banco_clientePoliticaFactu= borderResaltar;
	}

	public Boolean getMostrarcon_banco_clientePoliticaFactu() {
		return this.mostrarcon_banco_clientePoliticaFactu;
	}

	public void setMostrarcon_banco_clientePoliticaFactu(Boolean mostrarcon_banco_clientePoliticaFactu) {
		this.mostrarcon_banco_clientePoliticaFactu= mostrarcon_banco_clientePoliticaFactu;
	}

	public Boolean getActivarcon_banco_clientePoliticaFactu() {
		return this.activarcon_banco_clientePoliticaFactu;
	}

	public void setActivarcon_banco_clientePoliticaFactu(Boolean activarcon_banco_clientePoliticaFactu) {
		this.activarcon_banco_clientePoliticaFactu= activarcon_banco_clientePoliticaFactu;
	}

	public Border setResaltarcon_banco_productoPoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicafactuBeanSwingJInternalFrame.jTtoolBarPoliticaFactu.setBorder(borderResaltar);
		
		this.resaltarcon_banco_productoPoliticaFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_banco_productoPoliticaFactu() {
		return this.resaltarcon_banco_productoPoliticaFactu;
	}

	public void setResaltarcon_banco_productoPoliticaFactu(Border borderResaltar) {
		this.resaltarcon_banco_productoPoliticaFactu= borderResaltar;
	}

	public Boolean getMostrarcon_banco_productoPoliticaFactu() {
		return this.mostrarcon_banco_productoPoliticaFactu;
	}

	public void setMostrarcon_banco_productoPoliticaFactu(Boolean mostrarcon_banco_productoPoliticaFactu) {
		this.mostrarcon_banco_productoPoliticaFactu= mostrarcon_banco_productoPoliticaFactu;
	}

	public Boolean getActivarcon_banco_productoPoliticaFactu() {
		return this.activarcon_banco_productoPoliticaFactu;
	}

	public void setActivarcon_banco_productoPoliticaFactu(Boolean activarcon_banco_productoPoliticaFactu) {
		this.activarcon_banco_productoPoliticaFactu= activarcon_banco_productoPoliticaFactu;
	}

	public Border setResaltares_activoPoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicafactuBeanSwingJInternalFrame.jTtoolBarPoliticaFactu.setBorder(borderResaltar);
		
		this.resaltares_activoPoliticaFactu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_activoPoliticaFactu() {
		return this.resaltares_activoPoliticaFactu;
	}

	public void setResaltares_activoPoliticaFactu(Border borderResaltar) {
		this.resaltares_activoPoliticaFactu= borderResaltar;
	}

	public Boolean getMostrares_activoPoliticaFactu() {
		return this.mostrares_activoPoliticaFactu;
	}

	public void setMostrares_activoPoliticaFactu(Boolean mostrares_activoPoliticaFactu) {
		this.mostrares_activoPoliticaFactu= mostrares_activoPoliticaFactu;
	}

	public Boolean getActivares_activoPoliticaFactu() {
		return this.activares_activoPoliticaFactu;
	}

	public void setActivares_activoPoliticaFactu(Boolean activares_activoPoliticaFactu) {
		this.activares_activoPoliticaFactu= activares_activoPoliticaFactu;
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
		
		
		this.setMostraridPoliticaFactu(esInicial);
		this.setMostrarid_empresaPoliticaFactu(esInicial);
		this.setMostrarid_sucursalPoliticaFactu(esInicial);
		this.setMostrarid_productoPoliticaFactu(esInicial);
		this.setMostrarid_grupo_clientePoliticaFactu(esInicial);
		this.setMostrarnombrePoliticaFactu(esInicial);
		this.setMostrarfecha_desdePoliticaFactu(esInicial);
		this.setMostrarfecha_hastaPoliticaFactu(esInicial);
		this.setMostrarporcentajePoliticaFactu(esInicial);
		this.setMostrarvalorPoliticaFactu(esInicial);
		this.setMostrarcon_banco_clientePoliticaFactu(esInicial);
		this.setMostrarcon_banco_productoPoliticaFactu(esInicial);
		this.setMostrares_activoPoliticaFactu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.ID)) {
				this.setMostraridPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setMostrarid_grupo_clientePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.VALOR)) {
				this.setMostrarvalorPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.CONBANCOCLIENTE)) {
				this.setMostrarcon_banco_clientePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.CONBANCOPRODUCTO)) {
				this.setMostrarcon_banco_productoPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.ESACTIVO)) {
				this.setMostrares_activoPoliticaFactu(esAsigna);
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
		
		
		this.setActivaridPoliticaFactu(esInicial);
		this.setActivarid_empresaPoliticaFactu(esInicial);
		this.setActivarid_sucursalPoliticaFactu(esInicial);
		this.setActivarid_productoPoliticaFactu(esInicial);
		this.setActivarid_grupo_clientePoliticaFactu(esInicial);
		this.setActivarnombrePoliticaFactu(esInicial);
		this.setActivarfecha_desdePoliticaFactu(esInicial);
		this.setActivarfecha_hastaPoliticaFactu(esInicial);
		this.setActivarporcentajePoliticaFactu(esInicial);
		this.setActivarvalorPoliticaFactu(esInicial);
		this.setActivarcon_banco_clientePoliticaFactu(esInicial);
		this.setActivarcon_banco_productoPoliticaFactu(esInicial);
		this.setActivares_activoPoliticaFactu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.ID)) {
				this.setActivaridPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setActivarid_grupo_clientePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.VALOR)) {
				this.setActivarvalorPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.CONBANCOCLIENTE)) {
				this.setActivarcon_banco_clientePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.CONBANCOPRODUCTO)) {
				this.setActivarcon_banco_productoPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.ESACTIVO)) {
				this.setActivares_activoPoliticaFactu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPoliticaFactu(esInicial);
		this.setResaltarid_empresaPoliticaFactu(esInicial);
		this.setResaltarid_sucursalPoliticaFactu(esInicial);
		this.setResaltarid_productoPoliticaFactu(esInicial);
		this.setResaltarid_grupo_clientePoliticaFactu(esInicial);
		this.setResaltarnombrePoliticaFactu(esInicial);
		this.setResaltarfecha_desdePoliticaFactu(esInicial);
		this.setResaltarfecha_hastaPoliticaFactu(esInicial);
		this.setResaltarporcentajePoliticaFactu(esInicial);
		this.setResaltarvalorPoliticaFactu(esInicial);
		this.setResaltarcon_banco_clientePoliticaFactu(esInicial);
		this.setResaltarcon_banco_productoPoliticaFactu(esInicial);
		this.setResaltares_activoPoliticaFactu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.ID)) {
				this.setResaltaridPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setResaltarid_grupo_clientePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.VALOR)) {
				this.setResaltarvalorPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.CONBANCOCLIENTE)) {
				this.setResaltarcon_banco_clientePoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.CONBANCOPRODUCTO)) {
				this.setResaltarcon_banco_productoPoliticaFactu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticaFactuConstantesFunciones.ESACTIVO)) {
				this.setResaltares_activoPoliticaFactu(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaPoliticaFactu=true;

	public Boolean getMostrarFK_IdEmpresaPoliticaFactu() {
		return this.mostrarFK_IdEmpresaPoliticaFactu;
	}

	public void setMostrarFK_IdEmpresaPoliticaFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPoliticaFactu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdGrupoClientePoliticaFactu=true;

	public Boolean getMostrarFK_IdGrupoClientePoliticaFactu() {
		return this.mostrarFK_IdGrupoClientePoliticaFactu;
	}

	public void setMostrarFK_IdGrupoClientePoliticaFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdGrupoClientePoliticaFactu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoPoliticaFactu=true;

	public Boolean getMostrarFK_IdProductoPoliticaFactu() {
		return this.mostrarFK_IdProductoPoliticaFactu;
	}

	public void setMostrarFK_IdProductoPoliticaFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoPoliticaFactu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPoliticaFactu=true;

	public Boolean getMostrarFK_IdSucursalPoliticaFactu() {
		return this.mostrarFK_IdSucursalPoliticaFactu;
	}

	public void setMostrarFK_IdSucursalPoliticaFactu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPoliticaFactu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaPoliticaFactu=true;

	public Boolean getActivarFK_IdEmpresaPoliticaFactu() {
		return this.activarFK_IdEmpresaPoliticaFactu;
	}

	public void setActivarFK_IdEmpresaPoliticaFactu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPoliticaFactu= habilitarResaltar;
	}

	public Boolean activarFK_IdGrupoClientePoliticaFactu=true;

	public Boolean getActivarFK_IdGrupoClientePoliticaFactu() {
		return this.activarFK_IdGrupoClientePoliticaFactu;
	}

	public void setActivarFK_IdGrupoClientePoliticaFactu(Boolean habilitarResaltar) {
		this.activarFK_IdGrupoClientePoliticaFactu= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoPoliticaFactu=true;

	public Boolean getActivarFK_IdProductoPoliticaFactu() {
		return this.activarFK_IdProductoPoliticaFactu;
	}

	public void setActivarFK_IdProductoPoliticaFactu(Boolean habilitarResaltar) {
		this.activarFK_IdProductoPoliticaFactu= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPoliticaFactu=true;

	public Boolean getActivarFK_IdSucursalPoliticaFactu() {
		return this.activarFK_IdSucursalPoliticaFactu;
	}

	public void setActivarFK_IdSucursalPoliticaFactu(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPoliticaFactu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaPoliticaFactu=null;

	public Border getResaltarFK_IdEmpresaPoliticaFactu() {
		return this.resaltarFK_IdEmpresaPoliticaFactu;
	}

	public void setResaltarFK_IdEmpresaPoliticaFactu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPoliticaFactu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPoliticaFactu= borderResaltar;
	}

	public Border resaltarFK_IdGrupoClientePoliticaFactu=null;

	public Border getResaltarFK_IdGrupoClientePoliticaFactu() {
		return this.resaltarFK_IdGrupoClientePoliticaFactu;
	}

	public void setResaltarFK_IdGrupoClientePoliticaFactu(Border borderResaltar) {
		this.resaltarFK_IdGrupoClientePoliticaFactu= borderResaltar;
	}

	public void setResaltarFK_IdGrupoClientePoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdGrupoClientePoliticaFactu= borderResaltar;
	}

	public Border resaltarFK_IdProductoPoliticaFactu=null;

	public Border getResaltarFK_IdProductoPoliticaFactu() {
		return this.resaltarFK_IdProductoPoliticaFactu;
	}

	public void setResaltarFK_IdProductoPoliticaFactu(Border borderResaltar) {
		this.resaltarFK_IdProductoPoliticaFactu= borderResaltar;
	}

	public void setResaltarFK_IdProductoPoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoPoliticaFactu= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPoliticaFactu=null;

	public Border getResaltarFK_IdSucursalPoliticaFactu() {
		return this.resaltarFK_IdSucursalPoliticaFactu;
	}

	public void setResaltarFK_IdSucursalPoliticaFactu(Border borderResaltar) {
		this.resaltarFK_IdSucursalPoliticaFactu= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPoliticaFactu(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticaFactuBeanSwingJInternalFrame politicafactuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPoliticaFactu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}